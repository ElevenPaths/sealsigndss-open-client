
package org.datacontract.schemas._2004._07.SealSignDSSService;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.datacontract.schemas._2004._07.sealsigndssservice package. 
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

    private final static QName _DistributedSignatureBeginResponseBasic_QNAME = new QName("http://schemas.datacontract.org/2004/07/SealSignDSSService", "DistributedSignatureBeginResponseBasic");
    private final static QName _SealSignDSSFaultContract_QNAME = new QName("http://schemas.datacontract.org/2004/07/SealSignDSSService", "SealSignDSSFaultContract");
    private final static QName _SealSignDSSFaultContractStackTrace_QNAME = new QName("http://schemas.datacontract.org/2004/07/SealSignDSSService", "stackTrace");
    private final static QName _SealSignDSSFaultContractMessage_QNAME = new QName("http://schemas.datacontract.org/2004/07/SealSignDSSService", "message");
    private final static QName _DistributedSignatureBeginResponseBasicAsyncState_QNAME = new QName("http://schemas.datacontract.org/2004/07/SealSignDSSService", "asyncState");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.datacontract.schemas._2004._07.sealsigndssservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DistributedSignatureBeginResponseBasic }
     * 
     */
    public DistributedSignatureBeginResponseBasic createDistributedSignatureBeginResponseBasic() {
        return new DistributedSignatureBeginResponseBasic();
    }

    /**
     * Create an instance of {@link SealSignDSSFaultContract }
     * 
     */
    public SealSignDSSFaultContract createSealSignDSSFaultContract() {
        return new SealSignDSSFaultContract();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DistributedSignatureBeginResponseBasic }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/SealSignDSSService", name = "DistributedSignatureBeginResponseBasic")
    public JAXBElement<DistributedSignatureBeginResponseBasic> createDistributedSignatureBeginResponseBasic(DistributedSignatureBeginResponseBasic value) {
        return new JAXBElement<DistributedSignatureBeginResponseBasic>(_DistributedSignatureBeginResponseBasic_QNAME, DistributedSignatureBeginResponseBasic.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SealSignDSSFaultContract }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/SealSignDSSService", name = "SealSignDSSFaultContract")
    public JAXBElement<SealSignDSSFaultContract> createSealSignDSSFaultContract(SealSignDSSFaultContract value) {
        return new JAXBElement<SealSignDSSFaultContract>(_SealSignDSSFaultContract_QNAME, SealSignDSSFaultContract.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/SealSignDSSService", name = "stackTrace", scope = SealSignDSSFaultContract.class)
    public JAXBElement<String> createSealSignDSSFaultContractStackTrace(String value) {
        return new JAXBElement<String>(_SealSignDSSFaultContractStackTrace_QNAME, String.class, SealSignDSSFaultContract.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/SealSignDSSService", name = "message", scope = SealSignDSSFaultContract.class)
    public JAXBElement<String> createSealSignDSSFaultContractMessage(String value) {
        return new JAXBElement<String>(_SealSignDSSFaultContractMessage_QNAME, String.class, SealSignDSSFaultContract.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/SealSignDSSService", name = "asyncState", scope = DistributedSignatureBeginResponseBasic.class)
    public JAXBElement<byte[]> createDistributedSignatureBeginResponseBasicAsyncState(byte[] value) {
        return new JAXBElement<byte[]>(_DistributedSignatureBeginResponseBasicAsyncState_QNAME, byte[].class, DistributedSignatureBeginResponseBasic.class, ((byte[]) value));
    }

}
