
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
 *         &lt;element name="certificate" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="uri" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="providerParameter" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="document" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="signatureId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "certificate",
    "uri",
    "providerParameter",
    "document",
    "signatureId",
    "remoteProviderConfiguration"
})
@XmlRootElement(name = "BeginCounterSignatureProvider")
public class BeginCounterSignatureProvider {

    @XmlElementRef(name = "certificate", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<byte[]> certificate;
    @XmlElementRef(name = "uri", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> uri;
    @XmlElementRef(name = "providerParameter", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> providerParameter;
    @XmlElementRef(name = "document", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<byte[]> document;
    @XmlElementRef(name = "signatureId", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> signatureId;
    @XmlElementRef(name = "remoteProviderConfiguration", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<RemoteProviderConfiguration> remoteProviderConfiguration;

    /**
     * Obtiene el valor de la propiedad certificate.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link byte[]}{@code >}
     *     
     */
    public JAXBElement<byte[]> getCertificate() {
        return certificate;
    }

    /**
     * Define el valor de la propiedad certificate.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link byte[]}{@code >}
     *     
     */
    public void setCertificate(JAXBElement<byte[]> value) {
        this.certificate = value;
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
     * Obtiene el valor de la propiedad document.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link byte[]}{@code >}
     *     
     */
    public JAXBElement<byte[]> getDocument() {
        return document;
    }

    /**
     * Define el valor de la propiedad document.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link byte[]}{@code >}
     *     
     */
    public void setDocument(JAXBElement<byte[]> value) {
        this.document = value;
    }

    /**
     * Obtiene el valor de la propiedad signatureId.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSignatureId() {
        return signatureId;
    }

    /**
     * Define el valor de la propiedad signatureId.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSignatureId(JAXBElement<String> value) {
        this.signatureId = value;
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
