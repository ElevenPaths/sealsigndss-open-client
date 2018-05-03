package es.uji.security.keystore.ckc;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.Key;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Vector;

import org.apache.log4j.Logger;
import org.datacontract.schemas._2004._07.SealSignDSSTypes.CertificateReference;
import org.tempuri.Configuration;
import org.tempuri.ISignatureServiceBasic;

import es.uji.security.crypto.SupportedKeystore;
import es.uji.security.keystore.IKeyStore;

public class CKCKeyStore implements IKeyStore
{
	boolean _initialized;
	
	String _serverSignatureWSUrl = null;
	boolean _useNativeTransport = false;
	
	CertificateReference[] _certificates = null;
	 
	private Logger log = Logger.getLogger(CKCKeyStore.class);

    public CKCKeyStore(String serverSignatureWSUrl, boolean useNativeTransport) 
    {
    	_serverSignatureWSUrl = serverSignatureWSUrl;
    	_useNativeTransport = useNativeTransport;
    }

    public void load(char[] pin) throws KeyStoreException, NoSuchAlgorithmException, IOException, CertificateException, Exception
    {
    	if (_serverSignatureWSUrl != null && _serverSignatureWSUrl.length() > 0)
    	{
	    	Configuration.setConfiguration(_serverSignatureWSUrl);
	        Configuration.setUseNativeTransport(_useNativeTransport);
	         
	        ISignatureServiceBasic service = new ISignatureServiceBasic();
	        		 
	        _certificates = service.getCertificateReferences(null,  true);
	        	 
	        _initialized = true;
    	}
    }

    public Enumeration<String> aliases() throws KeyStoreException, Exception
    {
    	log.debug("Loading aliases from keystore");
    	
        if (!_initialized)
        {
            throw (new Exception("UninitializedKeyStore"));
        }
        
        ArrayList<String> _aliases = new ArrayList<String>();
        
        for (CertificateReference _certificate : _certificates)
        {
        	_aliases.add(_certificate.getId(null).toString());
        	
        	System.out.println("Alias: " + _certificate.getId(null));
        }
        
        return Collections.enumeration(_aliases);
    }

    public String getAliasFromCertificate(Certificate cer) throws Exception
    {
    	if (!_initialized)
        {
            throw (new Exception("UninitializedKeyStore"));
        }
    	
    	X509Certificate xcer = (X509Certificate) cer, auxCer = null;
        
        for (CertificateReference _certificate : _certificates)
        {
        	CertificateFactory certFactory = CertificateFactory.getInstance("X.509");
          
        	InputStream in = new ByteArrayInputStream(_certificate.getEncoded(null));
        	auxCer = (X509Certificate)certFactory.generateCertificate(in);
        	
        	if ((auxCer.getIssuerDN().equals(xcer.getIssuerDN())) && (auxCer.getSerialNumber().equals(xcer.getSerialNumber())))
            {
                return _certificate.getId(null).toString();
            }
        }
    	
        return null;
    }

    public Certificate getCertificate(String alias) throws KeyStoreException, Exception
    {
    	 for (CertificateReference _certificate : _certificates)
         {
    		 if (_certificate.getId(null).toString().equals(alias))
             {
    			 X509Certificate auxCer = null;
    			 
    			 CertificateFactory certFactory = CertificateFactory.getInstance("X.509");
    	          
    			 InputStream in = new ByteArrayInputStream(_certificate.getEncoded(null));
    			 auxCer = (X509Certificate)certFactory.generateCertificate(in);
    	        	
                 return auxCer;
             }
         }
    	 
    	 return null;
    }

    public Certificate[] getUserCertificates() throws KeyStoreException, Exception
    {
    	log.debug("Loading user certificates from keystore CKC");
    	
    	Vector<Certificate> certs = new Vector<Certificate>();
    	Certificate tmp_cert;

    	for (CertificateReference _certificate : _certificates)
        {
          	log.debug("Found certificate whith alias " + _certificate.getId(null));
          	
          	CertificateFactory certFactory = CertificateFactory.getInstance("X.509");
          	
          	InputStream in = new ByteArrayInputStream(_certificate.getEncoded(null));
          	tmp_cert = (X509Certificate)certFactory.generateCertificate(in);
            certs.add(tmp_cert);
        }

        Certificate[] res = new Certificate[certs.size()];
        certs.toArray(res);

        return res;
    }

    public Key getKey(String alias) throws KeyStoreException, Exception
    {
    	throw new Exception("Method not implemented");
    }

    public byte[] signHash(byte[] toSign, String alias) throws Exception
	{
    	throw new Exception("Method not implemented");
	}

    public SupportedKeystore getName()
    {
        return SupportedKeystore.CKC;
    }

    public String getTokenName()
    {
        return "CKC";
    }

    public Provider getProvider()
    {
    	return null;
    }
    
    public void setProvider(Provider provider) throws Exception
    {
        //Does nothing, seems non sense by this time.
    	throw new Exception("Method not implemented");
    }

    public void cleanUp()
    {
    }    
}