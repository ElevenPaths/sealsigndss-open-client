package es.uji.security.ui.applet;

//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.net.URL;
//import java.net.URLConnection;
//import java.security.MessageDigest;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Properties;

//import javax.net.ssl.HttpsURLConnection;
//import javax.net.ssl.SSLContext;
//import javax.net.ssl.SSLSocketFactory;
//import javax.net.ssl.TrustManager;
//import javax.net.ssl.X509TrustManager;

import netscape.javascript.JSObject;

import javax.xml.bind.JAXBElement;

import org.apache.log4j.Logger;
import org.datacontract.schemas._2004._07.SealSignDSSTypes.ObjectFactory;

import es.uji.security.crypto.SupportedBrowser;
import es.uji.security.crypto.SupportedOS;
//import es.uji.security.crypto.SupportedDataEncoding;
//import es.uji.security.crypto.SupportedSignatureFormat;
//import es.uji.security.crypto.config.ConfigManager;
//import es.uji.security.crypto.config.OS;
//import es.uji.security.keystore.X509CertificateHandler;
import es.uji.security.ui.applet.io.InputParams;
import es.uji.security.ui.applet.io.OutputParams;
//import es.uji.security.util.HexDump;
//import es.uji.security.util.i18n.LabelManager;

/**
 * Handles all the applet singularities such as applet parameters, applet installation, host
 * navigator and keystore list
 */

public class AppHandler
{
    private static Logger log = Logger.getLogger(AppHandler.class);

    /* The singleton applet object */
    private static AppHandler singleton;

    /* The Applet or Application Main window who is referencing to */
    private MainWindow _mw = null;

    // This object interacts with the signature thread and wraps all the multisignature complexity
    public SignatureHandler sigh = null;

    // JavaScript Functions
    private String jsSignOk = "onSignOk";
    private String jsSignError = "onSignError";
    private String jsSignCancel = "onSignCancel";
    private String jsWindowShow = "onWindowShow";
    
    // Funciones adicionales para el tratamiento de multiples firmas
    private String jsSignElementOk = "onSignElementOk";
    private String jsSignElementError = "onSignElementError";
    
    // Funciones adicionales para la seleccion del certificado
    private String jsSelectOk = "onSelectOk";
    
    private String user = "";
    private String password = "";
    private String signatureWSUrl = "";
    private String serverSignatureWSUrl = "";
    
    // Host OS
    private SupportedOS os = SupportedOS.WINDOWS;
    
    // Host navigator
    private SupportedBrowser navigator = SupportedBrowser.IEXPLORER;

    // Input/Output Data handling
    private InputParams input;
    private OutputParams output;

    private String downloadURL;
    
    private boolean useNativeTransport = false;
    private boolean showSignatureOkDialog = true;
    private boolean addSubject = false;
    private org.datacontract.schemas._2004._07.SealSignDSSTypes.RemoteProviderConfiguration remoteProviderConfiguration;


    private String[] acceptedIssuers = null;
    private String certificateHashFilter = null;
    private String certificateSerialFilter = null;
    
    private int screen = 0;
    
    static 
    {
    	try
        {
    			// Si estamos en un SO Windows inicializamos las DLLs nativas
    			if (System.getProperty("os.name").toLowerCase().indexOf("win") >= 0)
    			{
                log.debug("Windows OS detected");

                try
                {
                    System.loadLibrary("SealSignDSSHTTP_0_4");
                }
                catch (Throwable e)
                {
                    log.error("Error installing or loading the DLL file", e);
                }
                
                try
                {
                		System.loadLibrary("SealSignDSSCAPI_0_3");
                }
                catch (Throwable e)
                {
                    log.error("Error installing or loading the DLL file", e);
                }
            }
        }
        catch (Exception exc)
        {
            log.error("Error accesing OS properties", exc);
        }
	}
    
    public AppHandler() throws SignatureAppletException
    {
        this(null);
        
        log.debug("Running in desktop application mode");
    }

    /**
     * Base constructor, instantiates an AppHandler object, setting up the target navigator and
     * creating an available keystore mapping.
     * 
     * That class should be used as a Sigleton so you must use getInstance in order to get this
     * class object.
     **/

    public AppHandler(String downloadURL) throws SignatureAppletException
    {
        this.downloadURL = downloadURL;

        try
        {
        	log.debug("Get JavaScript member: OS");
        	if (System.getProperty("os.name").toLowerCase().indexOf("win") >= 0)
    		{
        		this.os = SupportedOS.WINDOWS;
    		}
        	else
        	{
        		this.os = SupportedOS.OTHERS;
        	}
        	
        	log.debug("Get JavaScript member: navigator");
            JSObject document = (JSObject) JSCommands.getWindow().getMember("navigator");

            log.debug("Get JavaScript member: userAgent");
            String userAgent = (String) document.getMember("userAgent");

            if (userAgent != null)
            {
                userAgent = userAgent.toLowerCase();

                log.debug("Detected user agent " + userAgent);

                if (userAgent.indexOf("explorer") > -1 || userAgent.indexOf("msie") > -1)
                {
                    this.navigator = SupportedBrowser.IEXPLORER;
                }
                else if (userAgent.indexOf("firefox") > -1 || userAgent.indexOf("iceweasel") > -1
                        || userAgent.indexOf("seamonkey") > -1 || userAgent.indexOf("gecko") > -1
                        || userAgent.indexOf("netscape") > -1)
                {
                    this.navigator = SupportedBrowser.MOZILLA;
                }
            }
        }
        catch (Exception exc)
        {
            log.error("Error accesing web browser window", exc);
        }

        log.debug("OS variable set to " + this.os);
        log.debug("Navigator variable set to " + this.navigator);
    }

    /**
     * 
     * That method instantiates this Singleton class or returns the Object.
     * 
     * @param parent
     *            the main applet object
     * 
     * @return AppHandler The application handler object.
     **/
    public static AppHandler getInstance(String downloadURL) throws SignatureAppletException
    {
        if (singleton == null)
        {
            singleton = new AppHandler(downloadURL);
        }

        return singleton;
    }

    /**
     * 
     * That method returns the appHandler object, the object must be previously instantiated.
     * 
     * @return AppHandler The application handler object.
     **/
    public static AppHandler getInstance() throws SignatureAppletException
    {
        if (singleton == null)
        {
            singleton = new AppHandler();
        }

        return singleton;
    }

    /**
     * Returns the Application invoker's main window for deal with him.
     * 
     * @return MainWindow The MainWindow application object
     **/
    public MainWindow getMainWindow()
    {
        return _mw;
    }

    /**
     * A method to obtain the selected inputParams depending on the input way (JS exported method)
     * 
     * @return InputParams The inputParam class representing the input method.
     **/
    public InputParams getInputParams()
    {
        return input;
    }

    /**
     * A method to obtain the selected outputParams depending on the output way (JS exported method)
     * 
     * @return OutputParams The outputparam class representing the input method.
     **/
    public OutputParams getOutputParams()
    {
        return output;
    }

    /**
     * Returns a string representing the host browser over the applet is running
     * 
     * @return string representing the browser
     **/
    public SupportedBrowser getNavigator()
    {
        return this.navigator;
    }

    public SupportedOS getOs() 
    {
		return os;
	}

	/**
     * This method sets a reference to the MainWindow's object.
     * 
     * @param mw
     *            MainWindow application object
     */
    public void setMainWindow(MainWindow mw)
    {
        _mw = mw;
    }

//    /**
//     * Help method for install(), it downloads the dll and writes it down to the filesystem
//     * 
//     * @param input
//     *            URL where get the data from.
//     * @param output
//     *            Destination path of the dll.
//     */
//    private void dumpFile(String input, String output) throws IOException
//    {
//        URL url = new URL(input);
//        URLConnection uc = url.openConnection();
//        uc.setDefaultUseCaches(false);
//        uc.setUseCaches(false);
//        uc.setRequestProperty("Cache-Control", "no-store,max-age=0,no-cache");
//        uc.setRequestProperty("Expires", "0");
//        uc.setRequestProperty("Pragma", "no-cache");
//        uc.connect();
//        InputStream in = uc.getInputStream();
//
//        FileOutputStream fos = new FileOutputStream(output);
//        fos.write(OS.inputStreamToByteArray(in));
//        fos.close();
//        in.close();
//    }
//
//    /**
//     * Installs the applet on the client, basically downloads and loads MicrosoftCryptoApi dll
//     * 
//     * @throws SignatureAppletException
//     *             with the message
//     * @throws
//     */
//    public void installDLL(String downloadUrl, String completeDllPath)
//            throws SignatureAppletException
//    {
//        try
//        {
//            log.debug("Downloading " + downloadUrl + ". Complete DLL path is " + completeDllPath);
//            dumpFile(downloadUrl + "SealSignDSSCAPI_0_3.dll", completeDllPath);
//        }
//        catch (Throwable e)
//        {
//            log.error(LabelManager.get("ERROR_CAPI_DLL_INSTALL"), e);
//            throw new SignatureAppletException(LabelManager.get("ERROR_CAPI_DLL_INSTALL"));
//        }
//    }
//    
//    /**
//     * Installs the applet on the client, basically downloads and loads WinHTTP transport dll
//     * 
//     * @throws SignatureAppletException
//     *             with the message
//     * @throws
//     */
//    public void installDLLTransport(String downloadUrl, String completeDllPath)
//            throws SignatureAppletException
//    {
//        try
//        {
//            log.debug("Downloading " + downloadUrl + ". Complete DLL path is " + completeDllPath);
//            dumpFile(downloadUrl + "SealSignDSSHTTP_0_1.dll", completeDllPath);
//        }
//        catch (Throwable e)
//        {
//            log.error(LabelManager.get("ERROR_CAPI_DLL_INSTALL"), e);
//            throw new SignatureAppletException(LabelManager.get("ERROR_CAPI_DLL_INSTALL"));
//        }
//    }
//
//    /**
//     * Installs the applet on the client, basically downloads and loads WinHTTP transport dll
//     * 
//     * @throws SignatureAppletException
//     *             with the message
//     * @throws
//     */
//    public void installTransport() throws SignatureAppletException
//    {
//        String destAbsolutePath = System.getenv("TEMP");
//
//        String completeDLLPath = destAbsolutePath + File.separator + "SealSignDSSHTTP_0_1.dll";
//        File dllFile = new File(completeDLLPath);
//        
//        if (!dllFile.exists())
//        {
//            log.info("SealSignDSSHTTP_0_1.dll not found. Downloading DLL file");
//
//            installDLLTransport(this.downloadURL, completeDLLPath);
//        }
//        else
//        {
//            log.info("SealSignDSSHTTP_0_1.dll already exists. Verifying existing DLL file");
//
//            try
//            {
//                byte[] originalDLLHash = { 
//                		(byte)0x07, (byte)0x9E, (byte)0x8F, (byte)0x29, (byte)0x59, (byte)0xB8, 
//                        (byte)0x00, (byte)0x0C, (byte)0x37, (byte)0xA1, (byte)0xF1, (byte)0x80, 
//                        (byte)0x56, (byte)0x2D, (byte)0x50, (byte)0x63, (byte)0x08, (byte)0x7A, 
//                        (byte)0xF6, (byte)0x44
//                };
//                
//                FileInputStream dllFileStream = new FileInputStream(dllFile);
//
//                MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
//                byte[] readed = new byte[dllFileStream.available()];
//
//                dllFileStream.read(readed);
//                messageDigest.update(readed);
//
//                byte[] currentDLLHash = messageDigest.digest();
//
//                log.debug("Original DLL digest: " + HexDump.xdump(originalDLLHash));
//                log.debug("Current DLL digest: " + HexDump.xdump(currentDLLHash));
//
//                // Compare original and current hash
//
//                for (int i = 0; i < currentDLLHash.length; i++)
//                {
//                    if (currentDLLHash[i] != originalDLLHash[i])
//                    {
//                        log.info("DLL not valid. Downloading orginal DLL file");
//
//                        installDLL(this.downloadURL, completeDLLPath);
//                        break;
//                    }
//                }
//            }
//            catch (Exception e)
//            {
//                throw new SignatureAppletException(e.getMessage(), false);
//            }
//        }
//        
//        try
//        {
//            log.debug("Loading DLL with System.load " + completeDLLPath);
//
//            System.load(completeDLLPath);
//        }
//        catch (Throwable e)
//        {
//            log.error("Error loading " + completeDLLPath, e);
//        }
//    }
//
//    /**
//     * Installs the applet on the client, basically downloads and loads MicrosoftCryptoApi dll
//     * 
//     * @throws SignatureAppletException
//     *             with the message
//     * @throws
//     */
//    public void install() throws SignatureAppletException
//    {
//        String destAbsolutePath = System.getenv("TEMP");
//
//        String completeDLLPath = destAbsolutePath + File.separator + "SealSignDSSCAPI_0_3.dll";
//        File dllFile = new File(completeDLLPath);
//        
//        if (!dllFile.exists())
//        {
//            log.info("SealSignDSSCAPI_0_3.dll not found. Downloading DLL file");
//
//            installDLL(this.downloadURL, completeDLLPath);
//        }
//        else
//        {
//            log.info("SealSignDSSCAPI_0_3.dll already exists. Verifying existing DLL file");
//
//            try
//            {
//                byte[] originalDLLHash = { 
//                		(byte)0xca, (byte)0xc0, (byte)0xa4, (byte)0x1f, (byte)0xb5, (byte)0x8e, 
//                        (byte)0xae, (byte)0x33, (byte)0xd, (byte)0xa1, (byte)0xc4, (byte)0xb6, 
//                        (byte)0x9b, (byte)0x70, (byte)0x69, (byte)0xbc, (byte)0xf4, (byte)0x21, 
//                        (byte)0xae, (byte)0xaa	
//                };
//                
//                FileInputStream dllFileStream = new FileInputStream(dllFile);
//
//                MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
//                byte[] readed = new byte[dllFileStream.available()];
//
//                dllFileStream.read(readed);
//                messageDigest.update(readed);
//
//                byte[] currentDLLHash = messageDigest.digest();
//
//                log.debug("Original DLL digest: " + HexDump.xdump(originalDLLHash));
//                log.debug("Current DLL digest: " + HexDump.xdump(currentDLLHash));
//
//                // Compare original and current hash
//
//                for (int i = 0; i < currentDLLHash.length; i++)
//                {
//                    if (currentDLLHash[i] != originalDLLHash[i])
//                    {
//                        log.info("DLL not valid. Downloading orginal DLL file");
//
//                        installDLL(this.downloadURL, completeDLLPath);
//                        break;
//                    }
//                }
//            }
//            catch (Exception e)
//            {
//                throw new SignatureAppletException(e.getMessage(), false);
//            }
//        }
//        
//        try
//        {
//            log.debug("Loading DLL with System.load " + completeDLLPath);
//
//            System.load(completeDLLPath);
//        }
//        catch (Throwable e)
//        {
//            log.error("Error loading " + completeDLLPath, e);
//        }
//    }
    
    /**
     * Calls the javascript function indicated as func with params arguments
     * 
     * @param func
     *            The function that must be invoked
     * @param params
     *            The parameters that must be passed to that function
     */
    public void callJavaScriptCallbackFunction(String func, String[] params)
    {
        log.debug("Call JavaScript method: " + func);
        JSCommands.getWindow().call(func, params);
    }
    
    /*public void setCredentials(String user, String password)
    {
    		this.user = user;
    		this.password = password;
    }*/
    
    public void setSignatureWSUrl(String url)
    {
    	signatureWSUrl = url;
    }

    public void setServerSignatureWSUrl(String url)
    {
    	serverSignatureWSUrl = url;
    }
    
    public void setCredentials(String user, String password) {
    		this.user = user;
    		this.password = password;
    }
    
    public String getCredentialsUser()
    {
    	
    	return user;
    }
    
    public String getCredentialsPassword()
    {
    	return password;
    }
    
    public String getSignatureWSUrl()
    {
    	return signatureWSUrl;
    }
    
    public String getServerSignatureWSUrl()
    {
    	return serverSignatureWSUrl;
    }
    
    public void setUseNativeTransport(boolean useNative)
    {
    	// Solo establecemos el uso del transporte nativo para clientes Windows 
    	if (useNative == true && this.os == SupportedOS.WINDOWS)
        {
    		log.debug("Using NativeTransport for OS Windows");
    		
        	useNativeTransport = useNative;
        }
    }

    public boolean getUseNativeTransport()
    {
    	return useNativeTransport;
    }
    
    public void setAddSubjectInProviderParameter(boolean addSubject)
    {
    	this.addSubject = addSubject;
    }
    
    public void setAddRemoteProviderParameter(String userName, String password, String domain, String providerURL)
    {
    		ObjectFactory factory = new ObjectFactory();
        JAXBElement<String> userNameProvider = factory.createRemoteProviderConfigurationProviderUser(userName);
        JAXBElement<String> passw0rdProvider = factory.createRemoteProviderConfigurationProviderPassword(password);
        JAXBElement<String> domainProvider = factory.createRemoteProviderConfigurationProviderDomain(domain);
        JAXBElement<String> urlRemoteDocumentProvider = factory.createRemoteProviderConfigurationProviderUrl(providerURL);
        
        org.datacontract.schemas._2004._07.SealSignDSSTypes.RemoteProviderConfiguration localRemoteProviderConfiguration = new org.datacontract.schemas._2004._07.SealSignDSSTypes.RemoteProviderConfiguration();
        localRemoteProviderConfiguration.setProviderUser(userNameProvider);
        localRemoteProviderConfiguration.setProviderPassword(passw0rdProvider);
        localRemoteProviderConfiguration.setProviderDomain(domainProvider);
        localRemoteProviderConfiguration.setProviderUrl(urlRemoteDocumentProvider);
        
    		this.remoteProviderConfiguration = localRemoteProviderConfiguration;
    }
    
    public org.datacontract.schemas._2004._07.SealSignDSSTypes.RemoteProviderConfiguration getRemoteProviderConfiguration() {
    		return this.remoteProviderConfiguration;
    }

    public boolean getAddSubjectInProviderParameter()
    {
    	return addSubject;
    }
    
    public boolean isShowSignatureOkDialog() 
    {
		return showSignatureOkDialog;
	}

	public void setShowSignatureOkDialog(boolean showSignatureOkDialog) 
	{
		this.showSignatureOkDialog = showSignatureOkDialog;
	}

	public String[] getAcceptedIssuers() 
	{
		return acceptedIssuers;
	}

	public void setAcceptedIssuers(String[] acceptedIssuers) 
	{
		this.acceptedIssuers = acceptedIssuers;
	}

	public String getCertificateHashFilter() 
	{
		return certificateHashFilter;
	}

	public void setCertificateHashFilter(String certificateHashFilter) 
	{
		this.certificateHashFilter = certificateHashFilter;
	}

	public String getCertificateSerialFilter() 
	{
		return certificateSerialFilter;
	}

	public void setCertificateSerialFilter(String certificateSerialFilter) 
	{
		this.certificateSerialFilter = certificateSerialFilter;
	}
	
	public int getScreen() 
	{
		return screen;
	}

	public void setScreen(int screen) 
	{
		this.screen = screen;
	}

	/**
     * Select the functions that must be called on signature ok, error and cancel
     * 
     * @param onSignOk
     *            The name of the function to be called on signature ok
     * @param onSignCancel
     *            The name of the function to be called on signature cancel
     * @param onSignError
     *            The name of the function to be called on signature Error
     */
    public void setJavaScriptCallbackFunctions(String onSignOk, String onSignError,
            String onSignCancel, String onWindowShow)
    {
        jsSignOk = onSignOk;
        jsSignError = onSignError;
        jsSignCancel = onSignCancel;
        jsWindowShow = onWindowShow;
    }
    
    public void setJavaScriptElementCallbackFunctions(String onSignElementOk, String onSignElementError)
    {
        jsSignElementOk = onSignElementOk;
        jsSignElementError = onSignElementError;
    }
    
    public void setJavaScriptSelectCallbackFunctions(String ok)
    {
        jsSelectOk = ok;
    }

    /**
     * Get method for the customized SignCancel method call
     * 
     * @return jsSignCancel The name of the function to be called at DOM
     */
    public String getJsSignCancel()
    {
        return jsSignCancel;
    }

    /**
     * Method that allows to set the signCancel function
     * 
     * @param jsSignCancel
     *            the name of the function to be called on cancel at DOM
     */
    public void setJsSignCancel(String jsSignCancel)
    {
        if (jsSignCancel == null || jsSignCancel.length() == 0)
        {
            throw new IllegalArgumentException("Cancel javascript function can't be null or empty");
        }

        this.jsSignCancel = jsSignCancel;
    }

    /**
     * Get the selected name for signature error function at DOM
     * 
     * @return jsSignError The name of the function
     */
    public String getJsSignError()
    {
        return jsSignError;
    }
    
    public String getJsSignElementError()
    {
        return jsSignElementError;
    }

    /**
     * Set the name of the function to be called on signature error
     * 
     * @param jsSignError
     *            The name of the error function
     */
    public void setJsSignError(String jsSignError)
    {
        if (jsSignError == null || jsSignError.length() == 0)
        {
            throw new IllegalArgumentException("Error javascript function can't be null or empty");
        }

        this.jsSignError = jsSignError;
    }

    /**
     * Get the selected name for signature ok function at DOM
     * 
     * @return jsSignOk The name of the function
     */
    public String getJsSignOk()
    {
        return jsSignOk;
    }
    
    public String getJsSignElementOk()
    {
        return jsSignElementOk;
    }
    
    
    public String getJsSelectOk()
    {
        return jsSelectOk;
    }
    
    /**
     * Get the selected name for signature ok function at DOM
     * 
     * @return jsSignOk The name of the function
     */
    public String getJsWindowShow()
    {
        return jsWindowShow;
    }

    /**
     * Set the Sign ok javascript method to be called on signature ok.
     * 
     * @param jsSignOk
     *            The name of the function
     */
    public void setJsSignOk(String jsSignOk)
    {
        if (jsSignOk == null || jsSignOk.length() == 0)
        {
            throw new IllegalArgumentException("Ok javascript function can't be null or empty");
        }

        this.jsSignOk = jsSignOk;
    }

    /**
     * A method for get the InputParams class
     * 
     * @return input the InputParams implementation class
     */
    public InputParams getInput()
    {
        return this.input;
    }

    /**
     * Sets the InputParams for this signature
     * 
     * @param input
     *            the InputParams implementation class
     */
    public void setInput(InputParams input)
    {
        this.input = input;
    }

    /**
     * Sets the OutputParams for this signature
     * 
     * @param output
     *            the OutputParams implementation class
     */
    public void setOutput(OutputParams output)
    {
        this.output = output;
    }
    
    	/**
     * This method computes the signature, that should be done by a thread
     * 
     */
    public void doSign()
    {
        _mw.getShowSignatureCheckBox().setVisible(false);
        sigh = new SignatureHandler(this);
        sigh.doSign();
    }

    protected SignatureHandler getSignatureHandler()
    {
        return sigh;
    }
}