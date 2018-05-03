package es.uji.security.ui.applet;

//import java.io.InputStream;
//import java.net.URL;
//import java.net.URLConnection;
import java.security.AccessController;
import java.security.PrivilegedAction;
//import java.util.Map;

import javax.swing.JApplet;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.tree.DefaultMutableTreeNode;

import netscape.javascript.JSException;

import org.apache.log4j.Appender;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Layout;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

import es.uji.security.crypto.SupportedBrowser;
import es.uji.security.crypto.SupportedOS;
//import es.uji.security.crypto.SupportedDataEncoding;
//import es.uji.security.crypto.SupportedSignatureFormat;
//import es.uji.security.crypto.VerificationResult;
import es.uji.security.crypto.config.ConfigManager;
import es.uji.security.crypto.config.Device;
//import es.uji.security.crypto.config.OS;
// import es.uji.security.crypto.openxades.OpenXAdESSignatureVerifier;
import es.uji.security.keystore.DeviceInitializationException;
import es.uji.security.keystore.KeyStoreManager;
//import es.uji.security.keystore.X509CertificateHandler;
//import es.uji.security.ui.applet.io.ConsoleOutputParams;
//import es.uji.security.ui.applet.io.FileInputParams;
//import es.uji.security.ui.applet.io.FuncOutputParams;
//import es.uji.security.ui.applet.io.ParamInputData;
import es.uji.security.ui.applet.io.StateInputParams;
import es.uji.security.ui.applet.io.StateOutputParams;
import es.uji.security.ui.applet.io.URIInputParams;
import es.uji.security.ui.applet.io.URIOutputParams;
//import es.uji.security.ui.applet.io.URLInputParams;
//import es.uji.security.ui.applet.io.URLOutputParams;
import es.uji.security.util.i18n.LabelManager;

/**
 * This is the main applet class, it handles the web-to-java interaction by exporting some method to
 * JavaScript for being invoked within a web page.
 * 
 * The instantiation inside a web page must be in this way:
 * 
 * <applet id="CryptoApplet" name="CryptoApplet" code="es.uji.dsign.applet.SignatureApplet"
 * width="0" height="0" codebase="path" archive="archive and deps mayscript> </applet>
 * 
 * Each method below related to setup or signature forgery can be invoked from JavaScript
 */

@SuppressWarnings("serial")
public class SignatureApplet extends JApplet
{
    private Logger log = Logger.getLogger(SignatureApplet.class);

    private AppHandler apph;
    private MainWindow window;
    private String _separator = "\\|";
//    private String appletTag;
//    private String appletInput;
//    private String appletOutput;

    private KeyStoreManager keyStoreManager;

    /**
     * Init method. Installs the applet on client side. Downloads MicrosoftCryptoApi dll and loads
     * it in case of Internet Explorer
     */

    static
    {
        // Para evitar que pida cosas del log4j
        System.setProperty("log4j.defaultInitOverride", "true");

        BasicConfigurator.resetConfiguration();

        Layout layout = new PatternLayout("%p %t %c [%d{HH:mm:ss,SSS}] - %m%n");
        Appender appender = new ConsoleAppender(layout);
        BasicConfigurator.configure(appender);

        Logger.getRootLogger().setLevel(Level.DEBUG);

        // Para evitar que pida .class varios
        System.setProperty("javax.xml.parsers.SAXParserFactory", "com.sun.org.apache.xerces.internal.jaxp.SAXParserFactoryImpl");
        System.setProperty("javax.xml.parsers.DocumentBuilderFactory", "com.sun.org.apache.xerces.internal.jaxp.DocumentBuilderFactoryImpl");
        System.setProperty("javax.xml.transform.TransformerFactory", "com.sun.org.apache.xalan.internal.xsltc.trax.TransformerFactoryImpl");
        System.setProperty("org.apache.xml.dtm.DTMManager", "org.apache.xml.dtm.ref.DTMManagerDefault");
    }

    public void init()
    {
        // Init JavaScript interface

        try
        {
            JSCommands.clearInstance();
            JSCommands.getInstance(this);
        }
        catch (Exception e)
        {
            log.error("Error with JSCommands init", e);
        }

        // Init Nimbus Look&Feel if available (JDK1.6u10 or higher)

        try
        {
            log.debug("Looking for suitable Look&Feels");

            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    UIManager.setLookAndFeel(info.getClassName());
                    log.debug("Nimbus Look&Feel loaded");

                    break;
                }
            }
        }
        catch (Exception e)
        {
            log.error("Nimbus Look&Feel is not present. Using default Look&Feel");
        }

        try
        {
            String downloadURL = "";

            if (this.getParameter("downloadUrl") != null)
            {
                downloadURL = this.getParameter("downloadUrl");
            }
            else
            {
                downloadURL = this.getCodeBase().toString();
            }

            this.apph = AppHandler.getInstance(downloadURL);
            this.keyStoreManager = new KeyStoreManager();

            // Init config (try to load ujiCrypto.conf from server)

            // AppHandler.initConfig(downloadURL);

            // Init keystores

            this.initKeystores(this.apph.getOs(), this.apph.getNavigator());

            // Call onInitOk

            try
            {
            	log.debug("Call JavaScript method: onInitOk");
            	JSCommands.getWindow().call("onInitOk", new String[] {});
            }
            catch (Exception e)
            {
            	log.error("Error with JSCommands onInitOk", e);
            }
        }
        catch (Exception e)
        {
            log.error(e);
            JOptionPane.showMessageDialog(null, e.getMessage(), "", JOptionPane.ERROR_MESSAGE);

            log.debug("Call JavaScript method: onSignError");
            JSCommands.getWindow().call("onSignError", new String[] {});
        }
    }

    /**
     * Try to load storege devices: Navigator store, Clauer UJI store and PKCS11 configured stores
     * 
     * @param supportedBrowser
     */

    private void initKeystores(SupportedOS supportedOS, SupportedBrowser supportedBrowser)
    {
        this.keyStoreManager.flushKeyStoresTable();
        this.keyStoreManager.initBrowserStores(apph.getOs(), apph.getNavigator());
        
        // this.keyStoreManager.initClauer();

        // Solo mostraremos el soporte PKCS11 para sistemas operativos no Windows
//        if (!supportedBrowser.equals(SupportedBrowser.IEXPLORER))
        if (!supportedOS.equals(SupportedOS.WINDOWS))
        {
            ConfigManager conf = ConfigManager.getInstance();

            for (Device device : conf.getDeviceConfig())
            {
                try
                {
                    keyStoreManager.initPKCS11Device(device, null);
                }
                catch (DeviceInitializationException die)
                {
                    for (int i = 0; i < 3; i++)
                    {
                        PasswordPrompt passwordPrompt = new PasswordPrompt(null, device.getName(), "Pin:");
                        
                        if (passwordPrompt.getPassword() == null)
                        {
                        	break;
                        }
                        
                        try
                        {
                            this.keyStoreManager.initPKCS11Device(device, passwordPrompt.getPassword());
                            break;
                        }
                        catch (Exception e)
                        {
                            JOptionPane.showMessageDialog(null, LabelManager.get("ERROR_INCORRECT_DNIE_PWD"), "", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }
        }
    }

    private void initExtendedStores()
    { 
    	try
        {
        	this.keyStoreManager.initCKCDevice(apph.getServerSignatureWSUrl(), apph.getUseNativeTransport(), null);
        }
        catch (Exception ex)
        {
        	String error = LabelManager.get("ERR_CKC_KEYSTORE_LOAD");
            
            log.error(error, ex);
//            JOptionPane.showMessageDialog(null, ex.getMessage(), error, JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public KeyStoreManager getKeyStoreManager()
    {
        return this.keyStoreManager;
    }

    private void initializeWindow(boolean forSigning)
    {
        log.debug("Init window");

        try
        {
            if (window == null)
            {
            	this.initExtendedStores();
            	
                window = new MainWindow(this.keyStoreManager, this.apph, forSigning);
            }
            else
            {
                window.getPasswordTextField().setText("");
                window.getGlobalProgressBar().setValue(0);
                window.getInformationLabelField().setText(LabelManager.get("SELECT_A_CERTIFICATE"));

                this.initKeystores(this.apph.getOs(), this.apph.getNavigator());
                this.initExtendedStores();

                window.reloadCertificateJTree();
                window.getMainFrame().setVisible(true);
                window.getShowSignatureCheckBox().setVisible(true);
            }
        }
        catch (Exception ex)
        {
            log.error(ex);
            JOptionPane.showMessageDialog(null, ex.getMessage(), "", JOptionPane.ERROR_MESSAGE);

            try
            {
                log.debug("Call JavaScript method: " + apph.getJsSignError());
                JSCommands.getWindow().call(apph.getJsSignError(), new String[] { "" });
            }
            catch (JSException e)
            {
                log.error("Error calling " + apph.getJsSignError(), e);
            }
        }

        try
        {
            log.debug("Call JavaScript method: " + apph.getJsWindowShow());
            JSCommands.getWindow().call(apph.getJsWindowShow(), new String[] { "" });
        }
        catch (JSException e)
        {
            log.error("Error calling " + apph.getJsWindowShow(), e);
        }
    }

    public void showOnScreen(final int screen)
    {
        // We grant to JavaScript the same privileges as the core applet

        AccessController.doPrivileged(new PrivilegedAction<Object>()
        {
            public Object run()
            {
            	apph.setScreen(screen);
            	return null;
            }
        });
    }
    
    public void setSignatureWSUrl(final String url)
    {
        // We grant to JavaScript the same privileges as the core applet

        AccessController.doPrivileged(new PrivilegedAction<Object>()
        {
            public Object run()
            {
            	apph.setSignatureWSUrl(url);
            	return null;
            }
        });
    }
    
    public void setServerSignatureWSUrl(final String url)
    {
        // We grant to JavaScript the same privileges as the core applet

        AccessController.doPrivileged(new PrivilegedAction<Object>()
        {
            public Object run()
            {
            	apph.setServerSignatureWSUrl(url);
            	return null;
            }
        });
    }
        
    public void setUseNativeTransport(final boolean useNative)
    {
        // We grant to JavaScript the same privileges as the core applet

        AccessController.doPrivileged(new PrivilegedAction<Object>()
        {
            public Object run()
            {
            	apph.setUseNativeTransport(useNative);
            	return null;
            }
        });
    }
    
    public void setAddSubjectInProviderParameter(final boolean addSubject)
    {
        // We grant to JavaScript the same privileges as the core applet

        AccessController.doPrivileged(new PrivilegedAction<Object>()
        {
            public Object run()
            {
            	apph.setAddSubjectInProviderParameter(addSubject);
            	return null;
            }
        });
    }
    
    /**
     * This method sets up the applet language, possible values are: ES_es for spanish CA_ca for
     * EN_en
     * 
     * @param lang
     *            true means ask for it, false means keep the last correct config.
     */

    public void setLanguage(final String lang)
    {
        // We grant to JavaScript the same privileges as the core applet

        AccessController.doPrivileged(new PrivilegedAction<Object>()
        {
            public Object run()
            {
                LabelManager.setLang(lang);
                return null;
            }
        });
    }

    /**
     * Allow override the default three JavaScript functions OnSignOk, OnSignCancel and OnSignError
     * those functions are called when the process was success, user cancelled or an error happened
     * respectively
     * 
     * @param ok
     *            The name of the JavaSript function will be called on success
     * @param cancel
     *            The name of the JavaSript function will be called on user cancel
     * @param error
     *            The name of the JavaSript function will be called on error
     */
    public void setJavaScriptCallbackFunctions(final String ok, 
    		final String error,
            final String cancel, 
            final String windowShow)
    {
        AccessController.doPrivileged(new PrivilegedAction<Object>()
        {
            public Object run()
            {
                apph.setJavaScriptCallbackFunctions(ok, error, cancel, windowShow);
                return null;
            }
        });
    }
    
    public void setJavaScriptElementCallbackFunctions(final String okElement, final String errorElement)
    {
        AccessController.doPrivileged(new PrivilegedAction<Object>()
        {
            public Object run()
            {
                apph.setJavaScriptElementCallbackFunctions(okElement, errorElement);
                return null;
            }
        });
    }
    
    public void setJavaScriptSelectCallbackFunctions(final String ok)
    {
        AccessController.doPrivileged(new PrivilegedAction<Object>()
        {
            public Object run()
            {
                apph.setJavaScriptSelectCallbackFunctions(ok);
                return null;
            }
        });
    }

    public void signHashUri(final String inputURIs, final String providerParameter)
    {
        AccessController.doPrivileged(new PrivilegedAction<Object>()
              {
              public Object run()
              {
                  String[] in = inputURIs.split(_separator);
                  
                  URIInputParams input = new URIInputParams(in, providerParameter);
                  URIOutputParams output = new URIOutputParams();
                  
                  apph.setInput(input);
                  apph.setOutput(output);
                  
                  initializeWindow(true);
                  
                  return null;
              }
          });
    }
    
    public void selectSigningCertificate()
    {
    	AccessController.doPrivileged(new PrivilegedAction<Object>()
                {
                public Object run()
                {
                	initializeWindow(false);
                	
                	return null;
                }
            });
    }
    
    public void signHashState(final String inputStates)
    {
        AccessController.doPrivileged(new PrivilegedAction<Object>()
              {
              public Object run()
              {
            	  String[] in = inputStates.split(_separator);
            	  
                  StateInputParams input = new StateInputParams(in);
                  StateOutputParams output = new StateOutputParams();
                  
                  try
                  {
                	  ((DefaultMutableTreeNode)apph.getMainWindow().jTree.getLastSelectedPathComponent()).getUserObject();
                	  
                	  apph.setInput(input);
                      apph.setOutput(output);
                      apph.doSign();
                  }
                  catch (Exception ex)
                  {
                	  ex.printStackTrace();
                	  
                	  try
                      {
                          log.debug("Call JavaScript method: " + apph.getJsSignError());
                          JSCommands.getWindow().call(apph.getJsSignError(), new String[] { "Signing certificate not selected" });
                      }
                      catch (JSException e)
                      {
                          log.error("Error calling " + apph.getJsSignError(), e);
                      }
                  }
                  
                  return null;
              }
          });
    }

    public void setShowSignatureOkDialog(final boolean showSignatureOkDialog)
    {
    	AccessController.doPrivileged(new PrivilegedAction<Object>()
                {
                public Object run()
                {
                	apph.setShowSignatureOkDialog(showSignatureOkDialog);
                	
                	return null;
                }
            });
    }
    
    public void setIssuerFilter(final String issuerFilter)
    {
    	AccessController.doPrivileged(new PrivilegedAction<Object>()
                {
                public Object run()
                {
                	if (issuerFilter == null)
                	{
                		apph.setAcceptedIssuers(null);
                	}
                	else
                	{
                		apph.setAcceptedIssuers(issuerFilter.split(_separator));
                	}
                	
                	return null;
                }
            });
    }
    
    public void setCertificateHashFilter(final String certificateHashFilter)
    {
    	AccessController.doPrivileged(new PrivilegedAction<Object>()
                {
                public Object run()
                {
                	// Se eliminan todos los caracteres no ASCII para los de control Unicode
                	apph.setCertificateHashFilter(certificateHashFilter.replaceAll("[^\\x00-\\x7F]", ""));
                	
                	return null;
                }
            });
    }
    
    public void setCertificateSerialFilter(final String certificateSerialFilter)
    {
    	AccessController.doPrivileged(new PrivilegedAction<Object>()
                {
                public Object run()
                {
                	// Se eliminan todos los caracteres no ASCII para los de control Unicode
                	apph.setCertificateSerialFilter(certificateSerialFilter.replaceAll("[^\\x00-\\x7F]", ""));
                	
                	return null;
                }
            });
    }
    
    public void destroy()
    {
        super.destroy();
        Runtime.getRuntime().gc();

        log.debug("Applet destoy called. Executing garbage collection");
    }

    public String getAppletInfo()
    {
        return "SealSign DSS: CryptoApplet for distributed digital signature generation";
    }

    public String getAppletVersion()
    {
        return "1.0.7";
    }

    public String getJavaVersion()
    {
        return System.getProperty("java.version");
    }
}