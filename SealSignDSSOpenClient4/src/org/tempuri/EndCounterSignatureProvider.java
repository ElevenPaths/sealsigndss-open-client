
package org.tempuri;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.datacontract.schemas._2004._07.SealSignDSSTypes.RemoteProviderConfiguration;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="instance" type="{http://schemas.microsoft.com/2003/10/Serialization/}guid" minOccurs="0"/>
 *         &lt;element name="asyncState" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="uri" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="providerParameter" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="returnSignedDocument" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="remoteProviderConfiguration" type="{http://schemas.datacontract.org/2004/07/SealSignDSSTypes}RemoteProviderConfiguration" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "instance",
    "asyncState",
    "uri",
    "providerParameter",
    "returnSignedDocument",
    "remoteProviderConfiguration"
})
@XmlRootElement(name = "EndCounterSignatureProvider")
public class EndCounterSignatureProvider {

    protected String instance;
    @XmlElementRef(name = "asyncState", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<byte[]> asyncState;
    @XmlElementRef(name = "uri", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> uri;
    @XmlElementRef(name = "providerParameter", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> providerParameter;
    protected Boolean returnSignedDocument;
    @XmlElementRef(name = "remoteProviderConfiguration", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<RemoteProviderConfiguration> remoteProviderConfiguration;

    /**
     * Obtiene el valor de la propiedad instance.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInstance() {
        return instance;
    }

    /**
     * Define el valor de la propiedad instance.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInstance(String value) {
        this.instance = value;
    }

    /**
     * Obtiene el valor de la propiedad asyncState.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link byte[]}{@code >}
     *     
     */
    public JAXBElement<byte[]> getAsyncState() {
        return asyncState;
    }

    /**
     * Define el valor de la propiedad asyncState.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link byte[]}{@code >}
     *     
     */
    public void setAsyncState(JAXBElement<byte[]> value) {
        this.asyncState = value;
    }

    /**
     * Obtiene el valor de la propiedad uri.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getUri() {
        return uri;
    }

    /**
     * Define el valor de la propiedad uri.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setUri(JAXBElement<String> value) {
        this.uri = value;
    }

    /**
     * Obtiene el valor de la propiedad providerParameter.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getProviderParameter() {
        return providerParameter;
    }

    /**
     * Define el valor de la propiedad providerParameter.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setProviderParameter(JAXBElement<String> value) {
        this.providerParameter = value;
    }

    /**
     * Obtiene el valor de la propiedad returnSignedDocument.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isReturnSignedDocument() {
        return returnSignedDocument;
    }

    /**
     * Define el valor de la propiedad returnSignedDocument.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setReturnSignedDocument(Boolean value) {
        this.returnSignedDocument = value;
    }

    /**
     * Obtiene el valor de la propiedad remoteProviderConfiguration.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link RemoteProviderConfiguration }{@code >}
     *     
     */
    public JAXBElement<RemoteProviderConfiguration> getRemoteProviderConfiguration() {
        return remoteProviderConfiguration;
    }

    /**
     * Define el valor de la propiedad remoteProviderConfiguration.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link RemoteProviderConfiguration }{@code >}
     *     
     */
    public void setRemoteProviderConfiguration(JAXBElement<RemoteProviderConfiguration> value) {
        this.remoteProviderConfiguration = value;
    }

}
