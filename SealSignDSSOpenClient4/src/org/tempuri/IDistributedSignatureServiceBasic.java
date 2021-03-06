
package org.tempuri;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import org.datacontract.schemas._2004._07.SealSignDSSService.DistributedSignatureBeginResponseBasic;
import org.datacontract.schemas._2004._07.SealSignDSSTypes.HashAlgorithm;
import org.datacontract.schemas._2004._07.SealSignDSSTypes.RemoteProviderConfiguration;
import org.datacontract.schemas._2004._07.SealSignDSSTypes.SignatureParameters;
import org.datacontract.schemas._2004._07.SealSignDSSTypes.SignatureProfile;
import org.datacontract.schemas._2004._07.SealSignDSSTypes.SignatureType;

/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "IDistributedSignatureServiceBasic", targetNamespace = "http://tempuri.org/")

public interface IDistributedSignatureServiceBasic {


    /**
     * 
     * @throws IDistributedSignatureServiceBasicHeartBeatSealSignDSSFaultContractFaultFaultMessage
     */
    @WebMethod(operationName = "HeartBeat", action = "http://tempuri.org/IDistributedSignatureServiceBasic/HeartBeat")
    @RequestWrapper(localName = "HeartBeat", targetNamespace = "http://tempuri.org/", className = "org.tempuri.HeartBeat")
    @ResponseWrapper(localName = "HeartBeatResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.HeartBeatResponse")
    public void heartBeat()
        throws IDistributedSignatureServiceBasicHeartBeatSealSignDSSFaultContractFaultFaultMessage
    ;

    /**
     * 
     * @param signingDocument
     * @param signatureProfile
     * @param certificate
     * @param signatureType
     * @param options
     * @param detachedSignature
     * @param parameters
     * @param hashAlgorithm
     * @return
     *     returns org.datacontract.schemas._2004._07.sealsigndssservice.DistributedSignatureBeginResponseBasic
     * @throws IDistributedSignatureServiceBasicBeginSignatureSealSignDSSFaultContractFaultFaultMessage
     */
    @WebMethod(operationName = "BeginSignature", action = "http://tempuri.org/IDistributedSignatureServiceBasic/BeginSignature")
    @WebResult(name = "BeginSignatureResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "BeginSignature", targetNamespace = "http://tempuri.org/", className = "org.tempuri.BeginSignature")
    @ResponseWrapper(localName = "BeginSignatureResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.BeginSignatureResponse")
    public DistributedSignatureBeginResponseBasic beginSignature(
        @WebParam(name = "certificate", targetNamespace = "http://tempuri.org/")
        byte[] certificate,
        @WebParam(name = "signatureProfile", targetNamespace = "http://tempuri.org/")
        SignatureProfile signatureProfile,
        @WebParam(name = "signatureType", targetNamespace = "http://tempuri.org/")
        SignatureType signatureType,
        @WebParam(name = "hashAlgorithm", targetNamespace = "http://tempuri.org/")
        HashAlgorithm hashAlgorithm,
        @WebParam(name = "options", targetNamespace = "http://tempuri.org/")
        List<String> options,
        @WebParam(name = "parameters", targetNamespace = "http://tempuri.org/")
        SignatureParameters parameters,
        @WebParam(name = "detachedSignature", targetNamespace = "http://tempuri.org/")
        byte[] detachedSignature,
        @WebParam(name = "signingDocument", targetNamespace = "http://tempuri.org/")
        byte[] signingDocument)
        throws IDistributedSignatureServiceBasicBeginSignatureSealSignDSSFaultContractFaultFaultMessage
    ;

    /**
     * 
     * @param signingDocument
     * @param signatureProfile
     * @param certificate
     * @param signatureType
     * @param options
     * @param signatureId
     * @param detachedSignature
     * @param parameters
     * @param hashAlgorithm
     * @return
     *     returns org.datacontract.schemas._2004._07.sealsigndssservice.DistributedSignatureBeginResponseBasic
     * @throws IDistributedSignatureServiceBasicBeginCounterSignatureSealSignDSSFaultContractFaultFaultMessage
     */
    @WebMethod(operationName = "BeginCounterSignature", action = "http://tempuri.org/IDistributedSignatureServiceBasic/BeginCounterSignature")
    @WebResult(name = "BeginCounterSignatureResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "BeginCounterSignature", targetNamespace = "http://tempuri.org/", className = "org.tempuri.BeginCounterSignature")
    @ResponseWrapper(localName = "BeginCounterSignatureResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.BeginCounterSignatureResponse")
    public DistributedSignatureBeginResponseBasic beginCounterSignature(
        @WebParam(name = "certificate", targetNamespace = "http://tempuri.org/")
        byte[] certificate,
        @WebParam(name = "signatureProfile", targetNamespace = "http://tempuri.org/")
        SignatureProfile signatureProfile,
        @WebParam(name = "signatureType", targetNamespace = "http://tempuri.org/")
        SignatureType signatureType,
        @WebParam(name = "hashAlgorithm", targetNamespace = "http://tempuri.org/")
        HashAlgorithm hashAlgorithm,
        @WebParam(name = "options", targetNamespace = "http://tempuri.org/")
        List<String> options,
        @WebParam(name = "parameters", targetNamespace = "http://tempuri.org/")
        SignatureParameters parameters,
        @WebParam(name = "detachedSignature", targetNamespace = "http://tempuri.org/")
        byte[] detachedSignature,
        @WebParam(name = "signingDocument", targetNamespace = "http://tempuri.org/")
        byte[] signingDocument,
        @WebParam(name = "signatureId", targetNamespace = "http://tempuri.org/")
        String signatureId)
        throws IDistributedSignatureServiceBasicBeginCounterSignatureSealSignDSSFaultContractFaultFaultMessage
    ;

    /**
     * 
     * @param remoteProviderConfiguration
     * @param document
     * @param certificate
     * @param uri
     * @param providerParameter
     * @return
     *     returns org.datacontract.schemas._2004._07.sealsigndssservice.DistributedSignatureBeginResponseBasic
     * @throws IDistributedSignatureServiceBasicBeginSignatureProviderSealSignDSSFaultContractFaultFaultMessage
     */
    @WebMethod(operationName = "BeginSignatureProvider", action = "http://tempuri.org/IDistributedSignatureServiceBasic/BeginSignatureProvider")
    @WebResult(name = "BeginSignatureProviderResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "BeginSignatureProvider", targetNamespace = "http://tempuri.org/", className = "org.tempuri.BeginSignatureProvider")
    @ResponseWrapper(localName = "BeginSignatureProviderResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.BeginSignatureProviderResponse")
    public DistributedSignatureBeginResponseBasic beginSignatureProvider(
        @WebParam(name = "certificate", targetNamespace = "http://tempuri.org/")
        byte[] certificate,
        @WebParam(name = "uri", targetNamespace = "http://tempuri.org/")
        String uri,
        @WebParam(name = "providerParameter", targetNamespace = "http://tempuri.org/")
        String providerParameter,
        @WebParam(name = "document", targetNamespace = "http://tempuri.org/")
        byte[] document,
        @WebParam(name = "remoteProviderConfiguration", targetNamespace = "http://tempuri.org/")
        RemoteProviderConfiguration remoteProviderConfiguration)
        throws IDistributedSignatureServiceBasicBeginSignatureProviderSealSignDSSFaultContractFaultFaultMessage
    ;

    /**
     * 
     * @param remoteProviderConfiguration
     * @param document
     * @param certificate
     * @param signatureId
     * @param uri
     * @param providerParameter
     * @return
     *     returns org.datacontract.schemas._2004._07.sealsigndssservice.DistributedSignatureBeginResponseBasic
     * @throws IDistributedSignatureServiceBasicBeginCounterSignatureProviderSealSignDSSFaultContractFaultFaultMessage
     */
    @WebMethod(operationName = "BeginCounterSignatureProvider", action = "http://tempuri.org/IDistributedSignatureServiceBasic/BeginCounterSignatureProvider")
    @WebResult(name = "BeginCounterSignatureProviderResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "BeginCounterSignatureProvider", targetNamespace = "http://tempuri.org/", className = "org.tempuri.BeginCounterSignatureProvider")
    @ResponseWrapper(localName = "BeginCounterSignatureProviderResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.BeginCounterSignatureProviderResponse")
    public DistributedSignatureBeginResponseBasic beginCounterSignatureProvider(
        @WebParam(name = "certificate", targetNamespace = "http://tempuri.org/")
        byte[] certificate,
        @WebParam(name = "uri", targetNamespace = "http://tempuri.org/")
        String uri,
        @WebParam(name = "providerParameter", targetNamespace = "http://tempuri.org/")
        String providerParameter,
        @WebParam(name = "document", targetNamespace = "http://tempuri.org/")
        byte[] document,
        @WebParam(name = "signatureId", targetNamespace = "http://tempuri.org/")
        String signatureId,
        @WebParam(name = "remoteProviderConfiguration", targetNamespace = "http://tempuri.org/")
        RemoteProviderConfiguration remoteProviderConfiguration)
        throws IDistributedSignatureServiceBasicBeginCounterSignatureProviderSealSignDSSFaultContractFaultFaultMessage
    ;

    /**
     * 
     * @param asyncState
     * @param instance
     * @return
     *     returns byte[]
     * @throws IDistributedSignatureServiceBasicEndSignatureSealSignDSSFaultContractFaultFaultMessage
     */
    @WebMethod(operationName = "EndSignature", action = "http://tempuri.org/IDistributedSignatureServiceBasic/EndSignature")
    @WebResult(name = "EndSignatureResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "EndSignature", targetNamespace = "http://tempuri.org/", className = "org.tempuri.EndSignature")
    @ResponseWrapper(localName = "EndSignatureResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.EndSignatureResponse")
    public byte[] endSignature(
        @WebParam(name = "instance", targetNamespace = "http://tempuri.org/")
        String instance,
        @WebParam(name = "asyncState", targetNamespace = "http://tempuri.org/")
        byte[] asyncState)
        throws IDistributedSignatureServiceBasicEndSignatureSealSignDSSFaultContractFaultFaultMessage
    ;

    /**
     * 
     * @param asyncState
     * @param instance
     * @return
     *     returns byte[]
     * @throws IDistributedSignatureServiceBasicEndCounterSignatureSealSignDSSFaultContractFaultFaultMessage
     */
    @WebMethod(operationName = "EndCounterSignature", action = "http://tempuri.org/IDistributedSignatureServiceBasic/EndCounterSignature")
    @WebResult(name = "EndCounterSignatureResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "EndCounterSignature", targetNamespace = "http://tempuri.org/", className = "org.tempuri.EndCounterSignature")
    @ResponseWrapper(localName = "EndCounterSignatureResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.EndCounterSignatureResponse")
    public byte[] endCounterSignature(
        @WebParam(name = "instance", targetNamespace = "http://tempuri.org/")
        String instance,
        @WebParam(name = "asyncState", targetNamespace = "http://tempuri.org/")
        byte[] asyncState)
        throws IDistributedSignatureServiceBasicEndCounterSignatureSealSignDSSFaultContractFaultFaultMessage
    ;

    /**
     * 
     * @param asyncState
     * @param instance
     * @param returnSignedDocument
     * @param remoteProviderConfiguration
     * @param uri
     * @param providerParameter
     * @return
     *     returns byte[]
     * @throws IDistributedSignatureServiceBasicEndSignatureProviderSealSignDSSFaultContractFaultFaultMessage
     */
    @WebMethod(operationName = "EndSignatureProvider", action = "http://tempuri.org/IDistributedSignatureServiceBasic/EndSignatureProvider")
    @WebResult(name = "EndSignatureProviderResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "EndSignatureProvider", targetNamespace = "http://tempuri.org/", className = "org.tempuri.EndSignatureProvider")
    @ResponseWrapper(localName = "EndSignatureProviderResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.EndSignatureProviderResponse")
    public byte[] endSignatureProvider(
        @WebParam(name = "instance", targetNamespace = "http://tempuri.org/")
        String instance,
        @WebParam(name = "asyncState", targetNamespace = "http://tempuri.org/")
        byte[] asyncState,
        @WebParam(name = "uri", targetNamespace = "http://tempuri.org/")
        String uri,
        @WebParam(name = "providerParameter", targetNamespace = "http://tempuri.org/")
        String providerParameter,
        @WebParam(name = "returnSignedDocument", targetNamespace = "http://tempuri.org/")
        Boolean returnSignedDocument,
        @WebParam(name = "remoteProviderConfiguration", targetNamespace = "http://tempuri.org/")
        RemoteProviderConfiguration remoteProviderConfiguration)
        throws IDistributedSignatureServiceBasicEndSignatureProviderSealSignDSSFaultContractFaultFaultMessage
    ;

    /**
     * 
     * @param asyncState
     * @param instance
     * @param returnSignedDocument
     * @param remoteProviderConfiguration
     * @param uri
     * @param providerParameter
     * @return
     *     returns byte[]
     * @throws IDistributedSignatureServiceBasicEndCounterSignatureProviderSealSignDSSFaultContractFaultFaultMessage
     */
    @WebMethod(operationName = "EndCounterSignatureProvider", action = "http://tempuri.org/IDistributedSignatureServiceBasic/EndCounterSignatureProvider")
    @WebResult(name = "EndCounterSignatureProviderResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "EndCounterSignatureProvider", targetNamespace = "http://tempuri.org/", className = "org.tempuri.EndCounterSignatureProvider")
    @ResponseWrapper(localName = "EndCounterSignatureProviderResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.EndCounterSignatureProviderResponse")
    public byte[] endCounterSignatureProvider(
        @WebParam(name = "instance", targetNamespace = "http://tempuri.org/")
        String instance,
        @WebParam(name = "asyncState", targetNamespace = "http://tempuri.org/")
        byte[] asyncState,
        @WebParam(name = "uri", targetNamespace = "http://tempuri.org/")
        String uri,
        @WebParam(name = "providerParameter", targetNamespace = "http://tempuri.org/")
        String providerParameter,
        @WebParam(name = "returnSignedDocument", targetNamespace = "http://tempuri.org/")
        Boolean returnSignedDocument,
        @WebParam(name = "remoteProviderConfiguration", targetNamespace = "http://tempuri.org/")
        RemoteProviderConfiguration remoteProviderConfiguration)
        throws IDistributedSignatureServiceBasicEndCounterSignatureProviderSealSignDSSFaultContractFaultFaultMessage
    ;
}
