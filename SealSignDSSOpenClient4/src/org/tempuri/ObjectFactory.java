
package org.tempuri;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import org.datacontract.schemas._2004._07.SealSignDSSService.DistributedSignatureBeginResponseBasic;
import org.datacontract.schemas._2004._07.SealSignDSSTypes.RemoteProviderConfiguration;
import org.datacontract.schemas._2004._07.SealSignDSSTypes.SignatureParameters;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.tempuri package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _BeginSignatureSigningDocument_QNAME = new QName("http://tempuri.org/", "signingDocument");
    private final static QName _BeginSignatureDetachedSignature_QNAME = new QName("http://tempuri.org/", "detachedSignature");
    private final static QName _BeginSignatureCertificate_QNAME = new QName("http://tempuri.org/", "certificate");
    private final static QName _BeginSignatureParameters_QNAME = new QName("http://tempuri.org/", "parameters");
    private final static QName _EndSignatureResponseEndSignatureResult_QNAME = new QName("http://tempuri.org/", "EndSignatureResult");
    private final static QName _BeginCounterSignatureProviderDocument_QNAME = new QName("http://tempuri.org/", "document");
    private final static QName _BeginCounterSignatureProviderRemoteProviderConfiguration_QNAME = new QName("http://tempuri.org/", "remoteProviderConfiguration");
    private final static QName _BeginCounterSignatureProviderSignatureId_QNAME = new QName("http://tempuri.org/", "signatureId");
    private final static QName _BeginCounterSignatureProviderUri_QNAME = new QName("http://tempuri.org/", "uri");
    private final static QName _BeginCounterSignatureProviderProviderParameter_QNAME = new QName("http://tempuri.org/", "providerParameter");
    private final static QName _BeginSignatureResponseBeginSignatureResult_QNAME = new QName("http://tempuri.org/", "BeginSignatureResult");
    private final static QName _EndSignatureAsyncState_QNAME = new QName("http://tempuri.org/", "asyncState");
    private final static QName _EndCounterSignatureResponseEndCounterSignatureResult_QNAME = new QName("http://tempuri.org/", "EndCounterSignatureResult");
    private final static QName _EndCounterSignatureProviderResponseEndCounterSignatureProviderResult_QNAME = new QName("http://tempuri.org/", "EndCounterSignatureProviderResult");
    private final static QName _BeginSignatureProviderResponseBeginSignatureProviderResult_QNAME = new QName("http://tempuri.org/", "BeginSignatureProviderResult");
    private final static QName _BeginCounterSignatureResponseBeginCounterSignatureResult_QNAME = new QName("http://tempuri.org/", "BeginCounterSignatureResult");
    private final static QName _BeginCounterSignatureProviderResponseBeginCounterSignatureProviderResult_QNAME = new QName("http://tempuri.org/", "BeginCounterSignatureProviderResult");
    private final static QName _EndSignatureProviderResponseEndSignatureProviderResult_QNAME = new QName("http://tempuri.org/", "EndSignatureProviderResult");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.tempuri
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link HeartBeat }
     * 
     */
    public HeartBeat createHeartBeat() {
        return new HeartBeat();
    }

    /**
     * Create an instance of {@link EndSignatureResponse }
     * 
     */
    public EndSignatureResponse createEndSignatureResponse() {
        return new EndSignatureResponse();
    }

    /**
     * Create an instance of {@link BeginCounterSignature }
     * 
     */
    public BeginCounterSignature createBeginCounterSignature() {
        return new BeginCounterSignature();
    }

    /**
     * Create an instance of {@link BeginCounterSignatureResponse }
     * 
     */
    public BeginCounterSignatureResponse createBeginCounterSignatureResponse() {
        return new BeginCounterSignatureResponse();
    }

    /**
     * Create an instance of {@link EndCounterSignatureProviderResponse }
     * 
     */
    public EndCounterSignatureProviderResponse createEndCounterSignatureProviderResponse() {
        return new EndCounterSignatureProviderResponse();
    }

    /**
     * Create an instance of {@link BeginCounterSignatureProvider }
     * 
     */
    public BeginCounterSignatureProvider createBeginCounterSignatureProvider() {
        return new BeginCounterSignatureProvider();
    }

    /**
     * Create an instance of {@link EndSignatureProvider }
     * 
     */
    public EndSignatureProvider createEndSignatureProvider() {
        return new EndSignatureProvider();
    }

    /**
     * Create an instance of {@link BeginSignature }
     * 
     */
    public BeginSignature createBeginSignature() {
        return new BeginSignature();
    }

    /**
     * Create an instance of {@link BeginCounterSignatureProviderResponse }
     * 
     */
    public BeginCounterSignatureProviderResponse createBeginCounterSignatureProviderResponse() {
        return new BeginCounterSignatureProviderResponse();
    }

    /**
     * Create an instance of {@link BeginSignatureProviderResponse }
     * 
     */
    public BeginSignatureProviderResponse createBeginSignatureProviderResponse() {
        return new BeginSignatureProviderResponse();
    }

    /**
     * Create an instance of {@link EndCounterSignatureResponse }
     * 
     */
    public EndCounterSignatureResponse createEndCounterSignatureResponse() {
        return new EndCounterSignatureResponse();
    }

    /**
     * Create an instance of {@link EndSignatureProviderResponse }
     * 
     */
    public EndSignatureProviderResponse createEndSignatureProviderResponse() {
        return new EndSignatureProviderResponse();
    }

    /**
     * Create an instance of {@link BeginSignatureProvider }
     * 
     */
    public BeginSignatureProvider createBeginSignatureProvider() {
        return new BeginSignatureProvider();
    }

    /**
     * Create an instance of {@link HeartBeatResponse }
     * 
     */
    public HeartBeatResponse createHeartBeatResponse() {
        return new HeartBeatResponse();
    }

    /**
     * Create an instance of {@link EndCounterSignature }
     * 
     */
    public EndCounterSignature createEndCounterSignature() {
        return new EndCounterSignature();
    }

    /**
     * Create an instance of {@link EndSignature }
     * 
     */
    public EndSignature createEndSignature() {
        return new EndSignature();
    }

    /**
     * Create an instance of {@link BeginSignatureResponse }
     * 
     */
    public BeginSignatureResponse createBeginSignatureResponse() {
        return new BeginSignatureResponse();
    }

    /**
     * Create an instance of {@link EndCounterSignatureProvider }
     * 
     */
    public EndCounterSignatureProvider createEndCounterSignatureProvider() {
        return new EndCounterSignatureProvider();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "signingDocument", scope = BeginSignature.class)
    public JAXBElement<byte[]> createBeginSignatureSigningDocument(byte[] value) {
        return new JAXBElement<byte[]>(_BeginSignatureSigningDocument_QNAME, byte[].class, BeginSignature.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "detachedSignature", scope = BeginSignature.class)
    public JAXBElement<byte[]> createBeginSignatureDetachedSignature(byte[] value) {
        return new JAXBElement<byte[]>(_BeginSignatureDetachedSignature_QNAME, byte[].class, BeginSignature.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "certificate", scope = BeginSignature.class)
    public JAXBElement<byte[]> createBeginSignatureCertificate(byte[] value) {
        return new JAXBElement<byte[]>(_BeginSignatureCertificate_QNAME, byte[].class, BeginSignature.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SignatureParameters }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "parameters", scope = BeginSignature.class)
    public JAXBElement<SignatureParameters> createBeginSignatureParameters(SignatureParameters value) {
        return new JAXBElement<SignatureParameters>(_BeginSignatureParameters_QNAME, SignatureParameters.class, BeginSignature.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "EndSignatureResult", scope = EndSignatureResponse.class)
    public JAXBElement<byte[]> createEndSignatureResponseEndSignatureResult(byte[] value) {
        return new JAXBElement<byte[]>(_EndSignatureResponseEndSignatureResult_QNAME, byte[].class, EndSignatureResponse.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "document", scope = BeginCounterSignatureProvider.class)
    public JAXBElement<byte[]> createBeginCounterSignatureProviderDocument(byte[] value) {
        return new JAXBElement<byte[]>(_BeginCounterSignatureProviderDocument_QNAME, byte[].class, BeginCounterSignatureProvider.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoteProviderConfiguration }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "remoteProviderConfiguration", scope = BeginCounterSignatureProvider.class)
    public JAXBElement<RemoteProviderConfiguration> createBeginCounterSignatureProviderRemoteProviderConfiguration(RemoteProviderConfiguration value) {
        return new JAXBElement<RemoteProviderConfiguration>(_BeginCounterSignatureProviderRemoteProviderConfiguration_QNAME, RemoteProviderConfiguration.class, BeginCounterSignatureProvider.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "signatureId", scope = BeginCounterSignatureProvider.class)
    public JAXBElement<String> createBeginCounterSignatureProviderSignatureId(String value) {
        return new JAXBElement<String>(_BeginCounterSignatureProviderSignatureId_QNAME, String.class, BeginCounterSignatureProvider.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "certificate", scope = BeginCounterSignatureProvider.class)
    public JAXBElement<byte[]> createBeginCounterSignatureProviderCertificate(byte[] value) {
        return new JAXBElement<byte[]>(_BeginSignatureCertificate_QNAME, byte[].class, BeginCounterSignatureProvider.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "uri", scope = BeginCounterSignatureProvider.class)
    public JAXBElement<String> createBeginCounterSignatureProviderUri(String value) {
        return new JAXBElement<String>(_BeginCounterSignatureProviderUri_QNAME, String.class, BeginCounterSignatureProvider.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "providerParameter", scope = BeginCounterSignatureProvider.class)
    public JAXBElement<String> createBeginCounterSignatureProviderProviderParameter(String value) {
        return new JAXBElement<String>(_BeginCounterSignatureProviderProviderParameter_QNAME, String.class, BeginCounterSignatureProvider.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DistributedSignatureBeginResponseBasic }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "BeginSignatureResult", scope = BeginSignatureResponse.class)
    public JAXBElement<DistributedSignatureBeginResponseBasic> createBeginSignatureResponseBeginSignatureResult(DistributedSignatureBeginResponseBasic value) {
        return new JAXBElement<DistributedSignatureBeginResponseBasic>(_BeginSignatureResponseBeginSignatureResult_QNAME, DistributedSignatureBeginResponseBasic.class, BeginSignatureResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "document", scope = BeginSignatureProvider.class)
    public JAXBElement<byte[]> createBeginSignatureProviderDocument(byte[] value) {
        return new JAXBElement<byte[]>(_BeginCounterSignatureProviderDocument_QNAME, byte[].class, BeginSignatureProvider.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoteProviderConfiguration }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "remoteProviderConfiguration", scope = BeginSignatureProvider.class)
    public JAXBElement<RemoteProviderConfiguration> createBeginSignatureProviderRemoteProviderConfiguration(RemoteProviderConfiguration value) {
        return new JAXBElement<RemoteProviderConfiguration>(_BeginCounterSignatureProviderRemoteProviderConfiguration_QNAME, RemoteProviderConfiguration.class, BeginSignatureProvider.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "certificate", scope = BeginSignatureProvider.class)
    public JAXBElement<byte[]> createBeginSignatureProviderCertificate(byte[] value) {
        return new JAXBElement<byte[]>(_BeginSignatureCertificate_QNAME, byte[].class, BeginSignatureProvider.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "uri", scope = BeginSignatureProvider.class)
    public JAXBElement<String> createBeginSignatureProviderUri(String value) {
        return new JAXBElement<String>(_BeginCounterSignatureProviderUri_QNAME, String.class, BeginSignatureProvider.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "providerParameter", scope = BeginSignatureProvider.class)
    public JAXBElement<String> createBeginSignatureProviderProviderParameter(String value) {
        return new JAXBElement<String>(_BeginCounterSignatureProviderProviderParameter_QNAME, String.class, BeginSignatureProvider.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "asyncState", scope = EndSignature.class)
    public JAXBElement<byte[]> createEndSignatureAsyncState(byte[] value) {
        return new JAXBElement<byte[]>(_EndSignatureAsyncState_QNAME, byte[].class, EndSignature.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "EndCounterSignatureResult", scope = EndCounterSignatureResponse.class)
    public JAXBElement<byte[]> createEndCounterSignatureResponseEndCounterSignatureResult(byte[] value) {
        return new JAXBElement<byte[]>(_EndCounterSignatureResponseEndCounterSignatureResult_QNAME, byte[].class, EndCounterSignatureResponse.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "asyncState", scope = EndCounterSignature.class)
    public JAXBElement<byte[]> createEndCounterSignatureAsyncState(byte[] value) {
        return new JAXBElement<byte[]>(_EndSignatureAsyncState_QNAME, byte[].class, EndCounterSignature.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "EndCounterSignatureProviderResult", scope = EndCounterSignatureProviderResponse.class)
    public JAXBElement<byte[]> createEndCounterSignatureProviderResponseEndCounterSignatureProviderResult(byte[] value) {
        return new JAXBElement<byte[]>(_EndCounterSignatureProviderResponseEndCounterSignatureProviderResult_QNAME, byte[].class, EndCounterSignatureProviderResponse.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "signingDocument", scope = BeginCounterSignature.class)
    public JAXBElement<byte[]> createBeginCounterSignatureSigningDocument(byte[] value) {
        return new JAXBElement<byte[]>(_BeginSignatureSigningDocument_QNAME, byte[].class, BeginCounterSignature.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "detachedSignature", scope = BeginCounterSignature.class)
    public JAXBElement<byte[]> createBeginCounterSignatureDetachedSignature(byte[] value) {
        return new JAXBElement<byte[]>(_BeginSignatureDetachedSignature_QNAME, byte[].class, BeginCounterSignature.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "signatureId", scope = BeginCounterSignature.class)
    public JAXBElement<String> createBeginCounterSignatureSignatureId(String value) {
        return new JAXBElement<String>(_BeginCounterSignatureProviderSignatureId_QNAME, String.class, BeginCounterSignature.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "certificate", scope = BeginCounterSignature.class)
    public JAXBElement<byte[]> createBeginCounterSignatureCertificate(byte[] value) {
        return new JAXBElement<byte[]>(_BeginSignatureCertificate_QNAME, byte[].class, BeginCounterSignature.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SignatureParameters }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "parameters", scope = BeginCounterSignature.class)
    public JAXBElement<SignatureParameters> createBeginCounterSignatureParameters(SignatureParameters value) {
        return new JAXBElement<SignatureParameters>(_BeginSignatureParameters_QNAME, SignatureParameters.class, BeginCounterSignature.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "asyncState", scope = EndSignatureProvider.class)
    public JAXBElement<byte[]> createEndSignatureProviderAsyncState(byte[] value) {
        return new JAXBElement<byte[]>(_EndSignatureAsyncState_QNAME, byte[].class, EndSignatureProvider.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoteProviderConfiguration }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "remoteProviderConfiguration", scope = EndSignatureProvider.class)
    public JAXBElement<RemoteProviderConfiguration> createEndSignatureProviderRemoteProviderConfiguration(RemoteProviderConfiguration value) {
        return new JAXBElement<RemoteProviderConfiguration>(_BeginCounterSignatureProviderRemoteProviderConfiguration_QNAME, RemoteProviderConfiguration.class, EndSignatureProvider.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "uri", scope = EndSignatureProvider.class)
    public JAXBElement<String> createEndSignatureProviderUri(String value) {
        return new JAXBElement<String>(_BeginCounterSignatureProviderUri_QNAME, String.class, EndSignatureProvider.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "providerParameter", scope = EndSignatureProvider.class)
    public JAXBElement<String> createEndSignatureProviderProviderParameter(String value) {
        return new JAXBElement<String>(_BeginCounterSignatureProviderProviderParameter_QNAME, String.class, EndSignatureProvider.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "asyncState", scope = EndCounterSignatureProvider.class)
    public JAXBElement<byte[]> createEndCounterSignatureProviderAsyncState(byte[] value) {
        return new JAXBElement<byte[]>(_EndSignatureAsyncState_QNAME, byte[].class, EndCounterSignatureProvider.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoteProviderConfiguration }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "remoteProviderConfiguration", scope = EndCounterSignatureProvider.class)
    public JAXBElement<RemoteProviderConfiguration> createEndCounterSignatureProviderRemoteProviderConfiguration(RemoteProviderConfiguration value) {
        return new JAXBElement<RemoteProviderConfiguration>(_BeginCounterSignatureProviderRemoteProviderConfiguration_QNAME, RemoteProviderConfiguration.class, EndCounterSignatureProvider.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "uri", scope = EndCounterSignatureProvider.class)
    public JAXBElement<String> createEndCounterSignatureProviderUri(String value) {
        return new JAXBElement<String>(_BeginCounterSignatureProviderUri_QNAME, String.class, EndCounterSignatureProvider.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "providerParameter", scope = EndCounterSignatureProvider.class)
    public JAXBElement<String> createEndCounterSignatureProviderProviderParameter(String value) {
        return new JAXBElement<String>(_BeginCounterSignatureProviderProviderParameter_QNAME, String.class, EndCounterSignatureProvider.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DistributedSignatureBeginResponseBasic }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "BeginSignatureProviderResult", scope = BeginSignatureProviderResponse.class)
    public JAXBElement<DistributedSignatureBeginResponseBasic> createBeginSignatureProviderResponseBeginSignatureProviderResult(DistributedSignatureBeginResponseBasic value) {
        return new JAXBElement<DistributedSignatureBeginResponseBasic>(_BeginSignatureProviderResponseBeginSignatureProviderResult_QNAME, DistributedSignatureBeginResponseBasic.class, BeginSignatureProviderResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DistributedSignatureBeginResponseBasic }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "BeginCounterSignatureResult", scope = BeginCounterSignatureResponse.class)
    public JAXBElement<DistributedSignatureBeginResponseBasic> createBeginCounterSignatureResponseBeginCounterSignatureResult(DistributedSignatureBeginResponseBasic value) {
        return new JAXBElement<DistributedSignatureBeginResponseBasic>(_BeginCounterSignatureResponseBeginCounterSignatureResult_QNAME, DistributedSignatureBeginResponseBasic.class, BeginCounterSignatureResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DistributedSignatureBeginResponseBasic }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "BeginCounterSignatureProviderResult", scope = BeginCounterSignatureProviderResponse.class)
    public JAXBElement<DistributedSignatureBeginResponseBasic> createBeginCounterSignatureProviderResponseBeginCounterSignatureProviderResult(DistributedSignatureBeginResponseBasic value) {
        return new JAXBElement<DistributedSignatureBeginResponseBasic>(_BeginCounterSignatureProviderResponseBeginCounterSignatureProviderResult_QNAME, DistributedSignatureBeginResponseBasic.class, BeginCounterSignatureProviderResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "EndSignatureProviderResult", scope = EndSignatureProviderResponse.class)
    public JAXBElement<byte[]> createEndSignatureProviderResponseEndSignatureProviderResult(byte[] value) {
        return new JAXBElement<byte[]>(_EndSignatureProviderResponseEndSignatureProviderResult_QNAME, byte[].class, EndSignatureProviderResponse.class, ((byte[]) value));
    }

}
