package es.uji.security.keystore;

import java.io.ByteArrayInputStream;
//import java.io.File;
//import java.net.ConnectException;
//import java.security.KeyStore;
//import java.security.KeyStoreException;
//import java.security.Provider;
import java.security.Security;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;

import javax.swing.JOptionPane;

import org.apache.log4j.Logger;

import es.uji.security.crypto.SupportedBrowser;
import es.uji.security.crypto.SupportedKeystore;
import es.uji.security.crypto.SupportedOS;
//import es.uji.security.crypto.config.ConfigManager;
import es.uji.security.crypto.config.Device;
import es.uji.security.keystore.ckc.CKCKeyStore;
//import es.uji.security.crypto.config.OS;
import es.uji.security.keystore.mozilla.Mozilla;
import es.uji.security.keystore.mscapi.MSCAPIProvider;
import es.uji.security.keystore.mscapi.MsCapiKeyStore;
import es.uji.security.keystore.pkcs11.PKCS11KeyStore;
import es.uji.security.util.i18n.LabelManager;

public class KeyStoreManager
{
    private Logger log = Logger.getLogger(KeyStoreManager.class);
    
    public Hashtable<SupportedKeystore, IKeyStore> keystores = new Hashtable<SupportedKeystore, IKeyStore>();

    /**
     * Flushes the KeyStore Hashtable
     * 
     *@throws SignatureAppletException
     */

    public void flushKeyStoresTable()
    {
        keystores.clear();
    }

    public void initCKCDevice(String serverSignatureWSUrl, boolean useNativeTransport, char[] password) throws DeviceInitializationException
    {
    	if (serverSignatureWSUrl != null && serverSignatureWSUrl.length() > 0)
    	{
			IKeyStore keystore = null;
			
			try
			{
				keystore = (IKeyStore)new CKCKeyStore(serverSignatureWSUrl, useNativeTransport);
				keystore.load(password);
	            
				ArrayList<String> aliases = Collections.list(keystore.aliases());						
				log.debug("Keystore available aliases: " + aliases);
			}
			catch (Exception e)
			{
				log.debug("Device CKC initialization error");
				
				throw new DeviceInitializationException(e);
			}
			
			keystores.put(SupportedKeystore.CKC, keystore);
    	}
    }
    
    public void initPKCS11Device(Device device, char[] password) throws DeviceInitializationException
    {
		byte[] config = device.toString().getBytes();
				            
//		try
//		{
////			            
////			            IKeyStore key = (IKeyStore) new PKCS11KeyStore(pkcs11ConfigStream, 
////						keystore.load(null, password);
//		}
//		catch (Exception e)
//		{
//			log.error("Could not initialize " + device.getName() + " in slot "
//					+ device.getSlot() + " loading " + device.getLibrary());
//		}

        IKeyStore keystore = null;
		
		try
		{
			keystore = (IKeyStore) new PKCS11KeyStore(new ByteArrayInputStream(config), null, false);
			keystore.load(password);
            
			ArrayList<String> aliases = Collections.list(keystore.aliases());						
			log.debug("Keystore available aliases: " + aliases);
		}
		catch (Exception e)
		{
			log.debug("Device " + device.getName() + " initialization error. Try to reload the device with the pin");
			
			throw new DeviceInitializationException(e);
		}
		
		keystores.put(SupportedKeystore.PKCS11, keystore);
    }
    
    public void initBrowserStores(SupportedOS os, SupportedBrowser navigator)
    {    
    	// Mostraremos el proveedor CAPI siempre que estemos en Windows independientemente del browser
//        if (navigator.equals(SupportedBrowser.IEXPLORER))
    	if (os.equals(SupportedOS.WINDOWS))
        {        	
        	IKeyStore keystore = (IKeyStore) new MsCapiKeyStore();

            try
            {
                keystore.load("".toCharArray());
                keystores.put(SupportedKeystore.MSCAPI, keystore);
                
                Security.addProvider(new MSCAPIProvider());
            }
            catch (Exception ex)
            {
                String error = LabelManager.get("ERR_MS_KEYSTORE_LOAD");
                
                log.error(error, ex);
                JOptionPane.showMessageDialog(null, ex.getMessage(), error, JOptionPane.WARNING_MESSAGE);
            }
        }    
    	
    	// Adicionalmente si el browser es Firefox a�adiremos el store propio
        if (navigator.equals(SupportedBrowser.MOZILLA))
        {
            try
            {
                Mozilla mozilla = new Mozilla();

                if (mozilla.isInitialized())
                {
                    IKeyStore p11mozillaks = (IKeyStore) new PKCS11KeyStore(mozilla.getPkcs11ConfigInputStream(), mozilla.getPkcs11FilePath(), mozilla.getPkcs11InitArgsString());
                    
                    p11mozillaks.load(null);
                    
                    keystores.put(SupportedKeystore.MOZILLA, p11mozillaks);
                }
                // We have to look here for spanish dnie and ask for the password.

            }
            catch (Exception ex)
            {
                System.out.println("ERR_MOZ_KEYSTORE_LOAD");
                ex.printStackTrace();
                //JOptionPane.showMessageDialog(null, ex.getMessage(), LabelManager
                //        .get("ERR_MOZ_KEYSTORE_LOAD"), JOptionPane.WARNING_MESSAGE);
                // throw new SignatureAppletException(LabelManager.get("ERR_MOZ_KEYSTORE_LOAD"));
            }
        }
    }
    
        /**
     * Returns the IKeyStoreHelper object that represents the store
     * 
     * @param ksName
     *            posible input values are: explorer,mozilla,clauer
     * @return the IkeyStoreHelper object
     */

    public IKeyStore getKeyStore(SupportedKeystore keystore)
    {
        return this.keystores.get(keystore);
    }

    /**
     * Returns the IKeyStoreHelper object that represents the store
     * 
     * @param ksName
     *            posible input values are: explorer,mozilla,clauer
     * @return the IkeyStoreHelper object
     */

    public Hashtable<SupportedKeystore, IKeyStore> getKeyStoreTable()
    {
        return this.keystores;
    }

    /**
     * Add a new loaded and authenticated PKCS12 keyStore to the hash table
     */

    public void addP12KeyStore(IKeyStore pkcs12Store)
    {
        keystores.put(SupportedKeystore.PKCS12, pkcs12Store);
    }

    /**
     * Add a new loaded and authenticated PKCS11 keyStore to the hash table. That function will be
     * implemented in a near future, a Load PKCS#11 entry will appear to the applets main window
     * that will allow to load pkcs#11
     */

    public void addP11KeyStore(IKeyStore pkcs11Store)
    {
        keystores.put(SupportedKeystore.PKCS11, pkcs11Store);
    }
}