package org.tempuri;

import org.datacontract.schemas._2004._07.SealSignDSSTypes.CertificateReference;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

public final class ISignatureServiceBasic 
{
	public org.datacontract.schemas._2004._07.SealSignDSSTypes.CertificateReference[] getCertificateReferences(java.lang.String ownerName, java.lang.Boolean includeEncoded) throws Exception 
	{
        SoapObject _client = new SoapObject("http://tempuri.org/", "GetCertificateReferences");
        
        if (ownerName != null)
        {
        	_client.addProperty("ownerName", ownerName);
        }
        
        _client.addProperty("includeEncoded", includeEncoded);
        
        SoapSerializationEnvelope _envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        _envelope.dotNet = true;
        _envelope.bodyOut = _client;
        
        HttpTransportSE _ht = new HttpTransportSE(Configuration.getWsUrl());
        _ht.useNativeTransport = Configuration.getUseNativeTransport();
        _ht.debug = true;
        _ht.call("http://tempuri.org/ISignatureServiceBasic/GetCertificateReferences", _envelope);
        
        CertificateReference[] _returned = null;
        
        SoapObject certificates = (SoapObject)_envelope.getResponse();
        if (certificates != null && certificates.getPropertyCount() > 0)
        {
        	int certificatesCount = certificates.getPropertyCount();
        	
        	_returned = new CertificateReference[certificatesCount];
        	
        	for (int certificateIndex = 0; certificateIndex < certificatesCount; certificateIndex++) 
        	{
        		SoapObject certificate = (SoapObject)certificates.getProperty(certificateIndex);
        		
        		CertificateReference certificateReference = new CertificateReference();
        		
        		int propertyCount = certificate.getPropertyCount();
        		
        		for (int propertyIndex = 0; propertyIndex < propertyCount; propertyIndex++) 
        		{
        			try
        			{
        				certificateReference.setProperty(propertyIndex, certificate.getProperty(propertyIndex));
        			}
        			catch (Exception ex)
        			{
        				ex.printStackTrace();
        			}
                }
        		
        		_returned[certificateIndex] = certificateReference;
            }
        }
        
        return _returned;
    }


    public byte[] signProvider(java.lang.Integer idCertificate, java.lang.String password, java.lang.String passwordSealSign, java.lang.String uri, java.lang.String providerParameter, byte[] signingDocument) throws Exception 
    {
        SoapObject _client = new SoapObject("http://tempuri.org/", "SignProvider");
        
        _client.addProperty("idCertificate", idCertificate);
        
        if (password != null)
        {
        	_client.addProperty("password", password);
        }
        
        if (passwordSealSign != null)
        {
        	_client.addProperty("passwordSealSign", passwordSealSign);
        }
        
        _client.addProperty("uri", uri);
        
        if (providerParameter != null)
        {
        	_client.addProperty("providerParameter", providerParameter);
        }
        
        if (signingDocument != null)
        {
        	_client.addProperty("signingDocument", new org.ksoap2.serialization.SoapPrimitive(SoapEnvelope.ENC, "base64", org.kobjects.base64.Base64.encode(signingDocument)));
        }
        
        SoapSerializationEnvelope _envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        _envelope.dotNet = true;
        _envelope.bodyOut = _client;
        
        HttpTransportSE _ht = new HttpTransportSE(Configuration.getWsUrl());
        _ht.useNativeTransport = Configuration.getUseNativeTransport();
        _ht.debug = true;
        _ht.call("http://tempuri.org/ISignatureServiceBasic/SignProvider", _envelope);
        
        _envelope.getResponse();
        
        return null;
    }
}
