package es.uji.security.keystore.pkcs11;

import java.io.ByteArrayInputStream;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.Security;
//import java.security.Signature;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Vector;

import org.apache.log4j.Logger;

import es.smartaccess.sealsigndss.AsyncStateManager;
import es.uji.security.crypto.SupportedKeystore;
import es.uji.security.keystore.IKeyStore;

public class PKCS11KeyStore implements IKeyStore
{
    InputStream _isP11Config = null;
    char[] _pin = null;
    PKCS11Helper pk11h;
    String _name, _tokenName;

    private Provider _pk11provider = null;
    private KeyStore _p11KeyStore = null;
    private boolean helper = true;

    boolean privateInitialize = false;
    
    private Logger log = Logger.getLogger(PKCS11KeyStore.class);
    
    private ArrayList<String> duplicateElements = new ArrayList<String>();

    public PKCS11KeyStore(String p11LibPath) throws PKCS11HelperException
    {
        pk11h = new PKCS11Helper(p11LibPath);
        _name = pk11h.getName();

        _isP11Config = new ByteArrayInputStream(("name = USER-PKCS11\r" + "library = " + p11LibPath + "\r").getBytes());
    }

    public PKCS11KeyStore(InputStream isP11Config, String p11LibPath, boolean helper)
            throws PKCS11HelperException
    {
        this.helper = helper;
        if (helper == true)
        {
            pk11h = new PKCS11Helper(p11LibPath);
            _name = pk11h.getName();
        }
        _isP11Config = isP11Config;
    }

    public PKCS11KeyStore(InputStream isP11Config, String p11LibPath) throws PKCS11HelperException
    {
        pk11h = new PKCS11Helper(p11LibPath);
        _name = pk11h.getName();
        _isP11Config = isP11Config;
    }

    public PKCS11KeyStore(InputStream isP11Config, String p11LibPath, String initArgs)
            throws PKCS11HelperException
    {
        pk11h = new PKCS11Helper(p11LibPath, initArgs);
        _tokenName = pk11h.getName();
        _isP11Config = isP11Config;
    }

    public void load(char[] pin) throws KeyStoreException, NoSuchAlgorithmException, IOException,
            CertificateException, Exception
    {
        if (!privateInitialize)
        {
            if (pin != null)
            {
                if (_isP11Config != null)
                    load(_isP11Config, pin);
                else
                    throw new Exception("Must use load(InputStream in, char[] pin) to initialize this kind of store");
            }
        }
    }

    public void load(InputStream in, char[] pin) throws KeyStoreException,
            NoSuchAlgorithmException, IOException, CertificateException, Exception
    {
        if (!privateInitialize)
        {
            if (pin != null && in != null)
        	{
                if (_pk11provider == null)
                {
                		if (System.getProperty("os.name").toLowerCase().indexOf("mac") >= 0)
                		{
                			_p11KeyStore = KeyStore.getInstance("KeychainStore");
                		}else{
                			_pk11provider = new sun.security.pkcs11.SunPKCS11(in);
                         Security.addProvider(_pk11provider);
                			_p11KeyStore = KeyStore.getInstance("PKCS11", _pk11provider);
                			if (!helper)
                        	 	_name = _pk11provider.getName();
                		}
                    
                }
                _p11KeyStore.load(null, pin);
                privateInitialize = true;
            }
        }
    }

    public void load(String in, char[] pin) throws KeyStoreException, NoSuchAlgorithmException,
            IOException, CertificateException, Exception
    {
        ByteArrayInputStream inStream = new ByteArrayInputStream(in.getBytes());
        load(inStream, pin);
    }

    public Enumeration<String> aliases() throws KeyStoreException, Exception
    {
    		log.debug("Loading aliases from keystore");
    	
        if (!privateInitialize)
            throw (new Exception("UninitializedKeyStore"));
        
        log.debug(_p11KeyStore.size() + " aliases loaded");

        return _p11KeyStore.aliases();
    }

    public Certificate getCertificate(String alias) throws KeyStoreException, Exception
    {
    		log.debug("Loading certificate with alias " + alias);
    	
        if (!privateInitialize)
            throw (new Exception("UninitializedKeyStore"));

        return _p11KeyStore.getCertificate(alias);
    }

    public Certificate[] getUserCertificates() throws KeyStoreException, Exception
    {
    		log.debug("Loading user certificates from keystore " + getName());
    		log.debug("pre update certificates");

        if (helper) {
        		if (System.getProperty("os.name").toLowerCase().indexOf("mac") >= 0) {
        			log.debug("update certificates");
        			this.updateCertificates();
        		}
        	
            return pk11h.getCertificates();
        }else{
            Vector<Certificate> certs = new Vector<Certificate>();
            Certificate tmp_cert;

            for (Enumeration<String> e = this.aliases(); e.hasMoreElements();)
            {
            		String alias = (String) e.nextElement();
            	
            		log.debug("Found certificate whith alias " + alias);
            	
                tmp_cert = this.getCertificate(alias);
                certs.add(tmp_cert);
            }

            Certificate[] res = new Certificate[certs.size()];
            certs.toArray(res);

            return res;
        }
    }

    public String getAliasFromCertificate(Certificate cer) throws KeyStoreException
    {
        X509Certificate xcer = (X509Certificate) cer, auxCer = null;
        String auxAlias = null;

        if (privateInitialize)
        {
            Enumeration<String> e = _p11KeyStore.aliases();
            
            while (e.hasMoreElements())
            {
                auxAlias = (String) e.nextElement();
                auxCer = (X509Certificate) _p11KeyStore.getCertificate(auxAlias);
                if ((auxCer.getIssuerDN().equals(xcer.getIssuerDN()))
                        && (auxCer.getSerialNumber().equals(xcer.getSerialNumber())))
                {
                    return auxAlias;
                }
            }

        }

        return null;
    }

    public Key getKey(String alias) throws KeyStoreException, Exception
    {
    		log.debug("getKey: " + alias);
    	    	
        return _p11KeyStore.getKey(alias, _pin);
    }

    public Provider getProvider()
    {
        return _pk11provider;
    }

    public void setProvider(Provider provider) throws Exception
    {
        //Does nothing, seems non sense by this time.
    	throw new Exception("Method not implemented");
    }

    public SupportedKeystore getName()
    {
        return SupportedKeystore.PKCS11;
    }

    public String getTokenName()
    {
        return _tokenName;
    }

    public byte[] signHash(byte[] toSign, String alias) throws Exception
    {
    		byte[] res = null;
		PrivateKey privKey = (PrivateKey)getKey(alias);
		
		if (privKey == null)
		{	
			if (System.getProperty("os.name").toLowerCase().indexOf("mac") >= 0) {
				String newAlias = removeNumber(alias);
				if (existDuplicate(newAlias)) {
					privKey = (PrivateKey)getKey(newAlias);
				}
				
				if (privKey == null)
				{
					return null;
				}
			}else{
				return null;
			}
			
		}
		
		AsyncStateManager manager = new AsyncStateManager(toSign);
		if (System.getProperty("os.name").toLowerCase().indexOf("mac") >= 0) {
			res = manager.doFinal(privKey);
		}else{
			res = manager.doFinal(privKey, _pk11provider);
		}
		
		return res;
    }
    
    private String removeNumber(String s) {
    		String returnValue = "";
		String[] parts = s.split(" ");
		
		if (parts.length > 1) {
			returnValue = parts[0];
			for (int i = 1; i < parts.length - 1; i++) {
				returnValue = returnValue.concat(" ");
				returnValue = returnValue.concat(parts[i]);
			}
		}
		
		return returnValue;
    }
    
    private boolean existDuplicate(String element) {
    		boolean returnValue = false;
    		
    		for (int i = 0; i < this.duplicateElements.size(); i++) {
    			String temp = this.duplicateElements.get(i);
    			if (element.equals(temp)) {
    				returnValue = true;
    				break;
    			}
    		}
    		
    		return returnValue;
    }

    public void cleanUp()
    {
        _pin = null;
    }
    
    private void updateCertificates() throws KeyStoreException, Exception
    {
    		KeyStore ks = KeyStore.getInstance("KeychainStore");
        ks.load(null, null);
        Enumeration<String> en = ks.aliases();
        
        	Vector<X509Certificate> certificates = new Vector<X509Certificate>();
        	
        	ArrayList<X509Certificate> elementsInserted = new ArrayList<X509Certificate>();
        	
        while (en.hasMoreElements()) {
            String aliasKey = en.nextElement();
            X509Certificate newCert = (X509Certificate) ks.getCertificate(aliasKey);
			if (System.getProperty("os.name").toLowerCase().indexOf("mac") >= 0) {
				X509Certificate oldCert = existElement(elementsInserted, newCert);
	            if (oldCert == null) {
	                certificates.add(newCert);
	            }else{
	            		this.duplicateElements.add(aliasKey);
	            }
			}else{
				certificates.add(newCert);
			}
        }
        
        pk11h.certificates = certificates;
    }
    
    private X509Certificate existElement(ArrayList<X509Certificate> myArray, X509Certificate cert)
    {
    	X509Certificate returnValue = null;
    		
    		for (int i=0; i < myArray.size(); i++) {
    			X509Certificate c = myArray.get(i);
    			if (c.getSerialNumber() == cert.getSerialNumber()) {
    				returnValue = c;
    				break;
    			}
    		}
    		
    		if (returnValue == null) {
    			myArray.add(cert);
    		}
    		
    		return returnValue;
    }
}
