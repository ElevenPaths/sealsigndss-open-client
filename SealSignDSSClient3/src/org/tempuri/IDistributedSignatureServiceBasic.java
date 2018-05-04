package org.tempuri;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

public final class IDistributedSignatureServiceBasic {
    public  org.datacontract.schemas._2004._07.SealSignDSSFrontend.SignatureContext beginSignature(byte[] certificate, java.lang.String uri, java.lang.String providerParameter) throws Exception {
        SoapObject _client = new SoapObject("http://tempuri.org/", "BeginSignature");
        _client.addProperty("certificate", new org.ksoap2.serialization.SoapPrimitive(SoapEnvelope.ENC, "base64", org.kobjects.base64.Base64.encode(certificate)));
        _client.addProperty("uri", uri);
        _client.addProperty("providerParameter", providerParameter);
        
        SoapSerializationEnvelope _envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        _envelope.dotNet = true;
        _envelope.bodyOut = _client;
        
        HttpTransportSE _ht = new HttpTransportSE(Configuration.getWsUrl());
        _ht.useNativeTransport = Configuration.getUseNativeTransport();
        _ht.call("http://tempuri.org/IDistributedSignatureServiceBasic/BeginSignature", _envelope);
        
        SoapObject _ret = (SoapObject) _envelope.getResponse();
        int _len = _ret.getPropertyCount();
        
        org.datacontract.schemas._2004._07.SealSignDSSFrontend.SignatureContext _returned = new org.datacontract.schemas._2004._07.SealSignDSSFrontend.SignatureContext();
        
        for (int _i = 0; _i < _len; _i++) {
            _returned.setProperty(_i, _ret.getProperty(_i));        
        }
        
        return _returned;
    }

    public  void endSignature(java.lang.String instance, byte[] asyncState, java.lang.String uri, java.lang.String providerParameter) throws Exception {
        SoapObject _client = new SoapObject("http://tempuri.org/", "EndSignature");
        _client.addProperty("instance", instance);
        _client.addProperty("asyncState", new org.ksoap2.serialization.SoapPrimitive(SoapEnvelope.ENC, "base64", org.kobjects.base64.Base64.encode(asyncState)));
        _client.addProperty("uri", uri);
        _client.addProperty("providerParameter", providerParameter);
        
        SoapSerializationEnvelope _envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        _envelope.dotNet = true;
        _envelope.bodyOut = _client;
        
        HttpTransportSE _ht = new HttpTransportSE(Configuration.getWsUrl());
        _ht.useNativeTransport = Configuration.getUseNativeTransport();
        _ht.call("http://tempuri.org/IDistributedSignatureServiceBasic/EndSignature", _envelope);
        
        SoapObject _ret = (SoapObject) _envelope.getResponse();
    }
}
