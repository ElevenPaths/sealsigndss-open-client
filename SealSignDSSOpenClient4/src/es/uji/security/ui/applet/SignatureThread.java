package es.uji.security.ui.applet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.xml.ws.BindingProvider;

import org.apache.log4j.Logger;
import org.ksoap2.SoapFault;
import org.tempuri.IDistributedSignatureServiceBasicBeginSignatureProviderSealSignDSSFaultContractFaultFaultMessage;
import org.tempuri.IDistributedSignatureServiceBasicEndSignatureProviderSealSignDSSFaultContractFaultFaultMessage;
import org.datacontract.schemas._2004._07.SealSignDSSService.DistributedSignatureBeginResponseBasic;

import es.uji.security.crypto.SupportedKeystore;
import es.uji.security.crypto.config.OS;
import es.uji.security.keystore.IKeyStore;
import es.uji.security.keystore.X509CertificateHandler;
import es.uji.security.ui.applet.io.InputParams;
import es.uji.security.ui.applet.io.OutputParams;
import es.uji.security.ui.applet.io.StateInputParams;
import es.uji.security.ui.applet.io.URIInputParams;
import es.uji.security.util.Base64;
import es.uji.security.util.i18n.LabelManager;

public class SignatureThread extends Thread
{
	private Logger log = Logger.getLogger(SignatureThread.class);
	
    private MainWindow _mw = null;
    private int _end_percent = 0;
    private int _ini_percent = 0;
    private int _step = 0;
    private boolean hideWindow;
    private Method callback;
    private boolean showSignatureOk;
    
    public SignatureThread(String str)
    {
        super(str);
    }

    public void setPercentRange(int ini_percent, int end_percent, int step)
    {
        this._step = step;
        this._ini_percent = ini_percent;
        this._end_percent = end_percent;
    }

    public void setHideWindowOnEnd(boolean hideWindow)
    {
        this.hideWindow = hideWindow;
    }

    public void setCallbackMethod(Method m)
    {
        callback = m;
    }

    private DistributedSignatureBeginResponseBasic beginSignatureProvider(byte[] certificate, java.lang.String uri, java.lang.String providerParameter, byte[] document, org.datacontract.schemas._2004._07.SealSignDSSTypes.RemoteProviderConfiguration remoteProviderConfiguration) throws IDistributedSignatureServiceBasicBeginSignatureProviderSealSignDSSFaultContractFaultFaultMessage {
		String wsdl;
		String wsUrl = _mw.getAppHandler().getSignatureWSUrl();
        String user = _mw.getAppHandler().getCredentialsUser();
        String password = _mw.getAppHandler().getCredentialsPassword();
        
        	String[] partsWSDL = wsUrl.split("SealSignDSSService/DistributedSignatureServiceBasic.svc");
        	wsdl = partsWSDL[0] + "SealSignDSSService/DistributedSignatureServiceBasic.svc?wsdl";
    	
    		org.tempuri.DistributedSignatureServiceBasic service = null;
			try {
				service = new org.tempuri.DistributedSignatureServiceBasic(wsdl);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
        org.tempuri.IDistributedSignatureServiceBasic port = service.getBasicHttpBindingIDistributedSignatureServiceBasic1();
        
        BindingProvider prov = (BindingProvider)port;
        prov.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, wsUrl);
        if (user!=null && !user.equals("") && password!=null && !password.equals("")) {
        		prov.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, user);
        		prov.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, password);
        }
        
        return port.beginSignatureProvider(certificate, uri, providerParameter, document, remoteProviderConfiguration);
    }
    
    private byte[] endSignatureProvider(java.lang.String instance, byte[] asyncState, java.lang.String uri, java.lang.String providerParameter, java.lang.Boolean returnSignedDocument, org.datacontract.schemas._2004._07.SealSignDSSTypes.RemoteProviderConfiguration remoteProviderConfiguration) throws IDistributedSignatureServiceBasicEndSignatureProviderSealSignDSSFaultContractFaultFaultMessage {
    		String wsdl;
		String wsUrl = _mw.getAppHandler().getSignatureWSUrl();
        String user = _mw.getAppHandler().getCredentialsUser();
        String password = _mw.getAppHandler().getCredentialsPassword();
        
        	String[] partsWSDL = wsUrl.split("SealSignDSSService/DistributedSignatureServiceBasic.svc");
        	wsdl = partsWSDL[0] + "SealSignDSSService/DistributedSignatureServiceBasic.svc?wsdl";
    	
    		org.tempuri.DistributedSignatureServiceBasic service = null;
			try {
				service = new org.tempuri.DistributedSignatureServiceBasic(wsdl);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
        org.tempuri.IDistributedSignatureServiceBasic port = service.getBasicHttpBindingIDistributedSignatureServiceBasic1();
        
        BindingProvider prov = (BindingProvider)port;
        prov.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, wsUrl);
        if (user!=null && !user.equals("") && password!=null && !password.equals("")) {
        		prov.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, user);
        		prov.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, password);
        }

        return port.endSignatureProvider(instance, asyncState, uri, providerParameter, returnSignedDocument, remoteProviderConfiguration);
    }

    public void run()
    {
        IKeyStore iksh;
        
        guiInitialize();
        
        JLabel infoLabelField = _mw.getInformationLabelField();
        
        infoLabelField.setText(LabelManager.get("COMPUTING_SIGNATURE"));

        int inc = (this._end_percent - this._ini_percent) / 10;

        try
        {
            X509CertificateHandler selectedNode;

            log.debug("Getting selected certificate");
            
            try
            {
                selectedNode = (X509CertificateHandler)((DefaultMutableTreeNode)_mw.jTree.getLastSelectedPathComponent()).getUserObject();
                
                log.debug("Selected certificate:" + selectedNode.getCertificate().getSubjectDN());
            }
            catch (NullPointerException e)
            {
                throw new SignatureAppletException("ERROR_CERTIFICATE_NOT_SELECTED");
            }

            if (!selectedNode.isDigitalSignatureCertificate() && !selectedNode.isNonRepudiationCertificate())
            {
                showSignatureOk = false;
                guiFinalize(false);
                throw new SignatureAppletException("ERROR_CERTIFICATE_USE");
            }
            
            log.debug("Validating certificate");
            
            try
            {
                selectedNode.getCertificate().checkValidity();
                
                log.debug("The certificate is valid");
            }
            catch (CertificateException cex)
            {
                int selection = JOptionPane.showOptionDialog(_mw.getMainFrame(), 
                		LabelManager.get("LABEL_CERTIFICATE_EXPIRED"), 
                		LabelManager.get("LABEL_CERTIFICATE_EXPIRED_TITLE"), 
                		JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE, 
                        null, 
                        new String[] { "Yes", "No" }, 
                        "No");
                if (selection == JOptionPane.NO_OPTION)
                {
                    showSignatureOk = false;
                    guiFinalize(false);
                    throw new SignatureAppletException("ERROR_CERTIFICATE_EXPIRED");
                }
            }

            iksh = selectedNode.getKeyStore();
            
            if (iksh != null)
            {
                log.debug("Loading certificate store");
            	
                try
                {
                	// CKC should not be reloaded as the certificates are already in memory. Additional checks will be done online.
                	if (iksh.getName().equals(SupportedKeystore.CKC) == false)
                	{
                		iksh.load(_mw.getPasswordTextField().getText().toCharArray());
                	}

                    log.debug("Certificate store loaded");
                    
                    // TODO: Research: Some problems of codification with 1.6 jvm and
                    // JPasswordField.
                    // iksh.load(_mw.getPasswordField().getPassword());
                }
                catch (Exception e)
                {
                    ByteArrayOutputStream os = new ByteArrayOutputStream();
                    PrintStream ps = new PrintStream(os);
                    e.printStackTrace(ps);
                    String stk = new String(os.toByteArray()).toLowerCase();
                    if (stk.indexOf("incorrect") > -1)
                    {
                        showSignatureOk = false;
                        guiFinalize(false);
                        throw new SignatureAppletException("ERROR_INCORRECT_PWD");
                    }
                    else
                        infoLabelField.setText("Unexpected error!!!");
                    
                    e.printStackTrace();
                }
                
                System.out.println("Certificate Alias: " + iksh.getAliasFromCertificate(selectedNode.getCertificate()));
            }
            else
            {
                showSignatureOk = false;
                guiFinalize(false);
                throw new SignatureAppletException("ERR_GET_KEYSTORE");
            }

            _mw.getGlobalProgressBar().setValue(_ini_percent + inc);

            InputParams inputParams = (InputParams) _mw._aph.getInput();
            
            _mw.getGlobalProgressBar().setValue(_ini_percent + 2 * inc);

            OutputParams outputParams = (OutputParams) _mw.getAppHandler().getOutputParams();

            _mw.getGlobalProgressBar().setValue(_ini_percent + 3 * inc);

            if (_mw.jTree.getLastSelectedPathComponent() != null)
            {
                X509CertificateHandler xcert;
                
                try
                {
                    xcert = (X509CertificateHandler)((DefaultMutableTreeNode) _mw.jTree.getLastSelectedPathComponent()).getUserObject();
                }
                catch (NullPointerException e)
                {
                    showSignatureOk = false;
                    guiFinalize(false);
                    throw new SignatureAppletException("ERROR_CERTIFICATE_NOT_SELECTED");
                }
                
            	if (xcert.isDigitalSignatureCertificate() || xcert.isNonRepudiationCertificate() || xcert.isEmailProtectionCertificate())                
            	{
            		_mw.getGlobalProgressBar().setValue(_ini_percent + 3 * inc);
            		
            		X509Certificate certificate = xcert.getCertificate();
            		
            		_mw.getGlobalProgressBar().setValue(_ini_percent + 4 * inc);
                    
                    // if (_mw.isShowSignatureEnabled() && ! _mw.getAppHandler().getIsBigFile())
//                  if (_mw.isShowSignatureEnabled())
//                  {
//                      int sel = JOptionPane.showConfirmDialog(_mw.getMainFrame(), _mw
//                              .getShowDataScrollPane(OS.inputStreamToByteArray(in)), LabelManager
//                              .get("LABEL_SHOW_DATA_WINDOW"), JOptionPane.OK_CANCEL_OPTION);
//                      if (sel != JOptionPane.OK_OPTION)
//                      {
//                          _mw.getAppHandler().callJavaScriptCallbackFunction(
//                                  _mw.getAppHandler().getJsSignCancel(), new String[] {});
//                          showSignatureOk = false;
//                          guiFinalize(true);
//                          return;
//                      }
//                  }
            		
            		InputStream in = inputParams.getSignData();
            		
            		_mw.getGlobalProgressBar().setValue(_ini_percent + 5 * inc);
            		
            		if (inputParams.getClass().equals(StateInputParams.class))
                    {
            			try
                        {
            				_mw.getGlobalProgressBar().setValue(_ini_percent + 6 * inc);
            				
                        	byte[] asyncState = iksh.signHash(Base64.decode(OS.inputStreamToByteArray(in)), iksh.getAliasFromCertificate(certificate));
		                    if (asyncState == null) 
		                    {
		                    	throw new SignatureAppletException("ERROR_HASH_NOT_SIGNED");
		                    }
		                    
		                    _mw.getGlobalProgressBar().setValue(_ini_percent + 7 * inc);
		                    
		                    try
    	                    {
    	                    	// Llamamos al evento de gestion de elementos en caso de exito
    	        	            _mw.getAppHandler().callJavaScriptCallbackFunction(_mw.getAppHandler().getJsSignElementOk(), new String[] { Base64.encodeBytes(asyncState) });
    	                    }
    	                    catch (Exception e)
    	                    {
    	                    	log.error("Exception getJsSignElementOk", e);
    	                  	}
                        }
            			catch (Exception e)
                        {
                            log.error(LabelManager.get("ERROR_COMPUTING_SIGNATURE"), e);
                            
                            try
                            {
                            	// Llamamos al evento de gestion de elementos en caso de exito
                            	_mw.getAppHandler().callJavaScriptCallbackFunction(_mw.getAppHandler().getJsSignElementError(), 
                            			new String[] {LabelManager.get("ERROR_COMPUTING_SIGNATURE") + ":" + e.getMessage() });
                            }
                            catch (Exception e1)
                            {
                            	log.error("Exception getJsSignElementError", e1);
                          	}
                            
                            throw new SignatureAppletException("ERROR_COMPUTING_SIGNATURE");
                        }
                    }
            		else if (inputParams.getClass().equals(URIInputParams.class))
                    {
                		String uri = new String(OS.inputStreamToByteArray(in), "UTF8");
                        String parameter = inputParams.getParameter();

                        try
                        {
	                        if (_mw.getAppHandler().getAddSubjectInProviderParameter() == true)
	                        {
	                        	parameter = parameter + "&subject=" + certificate.getSubjectDN().getName();
	                        }
                        }
                        catch (Exception ex)
                        {
                        	ex.printStackTrace();
                        }
                        
                        try
                        {
                        	if (iksh.getName().equals(SupportedKeystore.CKC))
                            {
                        		X509Certificate localCertificate = xcert.getCertificate();
                            	this.beginSignatureProvider(localCertificate.getEncoded(), uri, null, null, null);
                            }
                            else
                            {
                            	X509Certificate localCertificate = xcert.getCertificate();
                            	DistributedSignatureBeginResponseBasic signatureContext = this.beginSignatureProvider(localCertificate.getEncoded(), uri, parameter, null, _mw.getAppHandler().getRemoteProviderConfiguration());
	                            	                            
	                        if (signatureContext == null || signatureContext.getAsyncState() == null) 
	    		                {
	    		                	throw new SignatureAppletException("ERROR_HASH_NOT_RECEIVED");
	    		                }
	    		                	
	    		                _mw.getGlobalProgressBar().setValue(_ini_percent + 5 * inc);
	    		                
	    		                byte[] asyncState = iksh.signHash(signatureContext.getAsyncState().getValue(), iksh.getAliasFromCertificate(certificate));
	    	                    if (asyncState == null) 
	    	                    {
	    	                    	throw new SignatureAppletException("ERROR_HASH_NOT_SIGNED");
	    	                    }
	    	                    
	    	                    _mw.getGlobalProgressBar().setValue(_ini_percent + 6 * inc);
	    	                    
	    	                    this.endSignatureProvider(signatureContext.getInstance(), asyncState, uri, parameter, false, _mw.getAppHandler().getRemoteProviderConfiguration());
                            }
    	                    
    	                    _mw.getGlobalProgressBar().setValue(_ini_percent + 7 * inc);
    	                    
    	                    try
    	                    {
    	                    	// Llamamos al evento de gestion de elementos en caso de exito
    	        	            _mw.getAppHandler().callJavaScriptCallbackFunction(_mw.getAppHandler().getJsSignElementOk(), new String[] { uri });
    	                    }
    	                    catch (Exception e)
    	                    {
    	                    	log.error("Exception getJsSignElementOk", e);
    	                  	}
                        }
                        catch (SoapFault e)
                        {
                        	log.error(LabelManager.get("ERROR_COMPUTING_SIGNATURE"), e);

                            try
                            {
                            	// Llamamos al evento de gestion de elementos en caso de exito
                            	_mw.getAppHandler().callJavaScriptCallbackFunction(_mw.getAppHandler().getJsSignElementError(), new String[] { e.faultstring, uri });
                            }
                            catch (Exception e1)
                            {
                            	log.error("Exception getJsSignElementError", e1);
                          	}
                            
                            throw new SignatureAppletException("ERROR_COMPUTING_SIGNATURE");
                        }
                        catch (Exception e)
                        {
                            log.error(LabelManager.get("ERROR_COMPUTING_SIGNATURE"), e);
                            
                            try
                            {
                            	// Llamamos al evento de gestion de elementos en caso de exito
                            	_mw.getAppHandler().callJavaScriptCallbackFunction(_mw.getAppHandler().getJsSignElementError(),
                            			new String[] {LabelManager.get("ERROR_COMPUTING_SIGNATURE") + ":" + e.getMessage(), uri });
                            }
                            catch (Exception e1)
                            {
                            	log.error("Exception getJsSignElementError", e1);
                          	}
                            
                            throw new SignatureAppletException("ERROR_COMPUTING_SIGNATURE");
                        }
                    }
                    else
                    {
                    	throw new SignatureAppletException("ERROR_INVALID_INPUTPARAMS");
                    }
                    
                    _mw.getGlobalProgressBar().setValue(_ini_percent + 8 * inc);
                }
                
                _mw.getGlobalProgressBar().setValue(_ini_percent + 9 * inc);
            }
            
            _mw.getGlobalProgressBar().setValue(_ini_percent + 10 * inc);
            
            guiFinalize(hideWindow);
            callback.invoke(null, (Object [])null);
        }
        catch (ClassCastException e)
        {
            e.printStackTrace();
            infoLabelField.setText(LabelManager.get("ERROR_CERTIFICATE_NOT_SELECTED"));
            try
            {
                showSignatureOk = false;
                guiFinalize(false);
                callback.invoke(null, (Object [])null);
            }
            catch (Exception e1)
            {
                infoLabelField.setText(LabelManager.get("ERROR_CANNOT_CLOSE_WINDOW"));
            }
        }
        catch (NullPointerException e)
        {
            e.printStackTrace();
            infoLabelField.setText(LabelManager.get("ERROR_COMPUTING_SIGNATURE") + ": " + e.getMessage());
            try
            {
                showSignatureOk = false;
                guiFinalize(false);
                callback.invoke(null, (Object [])null);
            }
            catch (Exception e1)
            {
                infoLabelField.setText(LabelManager.get("ERROR_CANNOT_CLOSE_WINDOW"));
            }
        }
        catch (IOException e)
        {
        	e.printStackTrace();
            infoLabelField.setText(LabelManager.get("ERROR_INPUT_SOURCE"));
            try
            {
            	showSignatureOk = false;
                guiFinalize(false);
                callback.invoke(null, (Object [])null);
            }
            catch (Exception e1)
            {
                infoLabelField.setText(LabelManager.get("ERROR_CANNOT_CLOSE_WINDOW"));
                e1.printStackTrace();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            infoLabelField.setText(e.getMessage());
            try
            {
            	showSignatureOk = false;
                guiFinalize(false);
                callback.invoke(null, (Object [])null);
            }
            catch (Exception e1)
            {
                infoLabelField.setText(LabelManager.get("ERROR_CANNOT_CLOSE_WINDOW"));
                e1.printStackTrace();
            }
        }
    }
    
    private static byte[] removeMSZero(byte[] data) 
    {
        byte[] data1 ;
       
        int len = data.length;
       
        if (data[0] == 0) 
        {
            data1 = new byte[data.length-1];
            System.arraycopy(data, 1, data1, 0, len-1);
        }
        else
        {
            data1 = data;
        }
        
        return data1;
    }

    private void guiInitialize()
    {

        if (_mw != null)
        {
            _mw.getInformationLabelField().setText(LabelManager.get("COMPUTING_SIGNATURE"));
            _mw.SignButton.setEnabled(false);
            _mw.jTree.setEnabled(false);

            _mw.getGlobalProgressBar().setIndeterminate(false);
            _mw.getGlobalProgressBar().setVisible(true);
            _mw.getGlobalProgressBar().setStringPainted(true);
        }
    }

    private void guiFinalize(boolean hideWindow) throws Exception
    {
        if (_mw != null)
        {
            if (showSignatureOk && hideWindow == true )
            {
            	if (_mw.getAppHandler().isShowSignatureOkDialog() == true)
            	{
            		JOptionPane.showMessageDialog(_mw.getMainFrame(), LabelManager.get("SIGN_PROCESS_OK"), "", JOptionPane.INFORMATION_MESSAGE);
            	}
                
                _mw.getAppHandler().getOutputParams().signOk();
            }
            _mw.getGlobalProgressBar().setVisible(false);
            _mw.jTree.setEnabled(true);
            _mw.SignButton.setEnabled(true);

            if (hideWindow)
                _mw.mainFrame.setVisible(false);
            else
                _mw.getShowSignatureCheckBox().setVisible(true);

        }
        this._ini_percent = 0;
        this._end_percent = 100;

        if (showSignatureOk && hideWindow == false)
        {
            _mw.getAppHandler().getOutputParams().signOk();
        }
    }

    public void setMainWindow(MainWindow mw)
    {
        _mw = mw;
    }

    public void setShowSignatureOk(boolean b)
    {
        showSignatureOk = b;
    }
}
