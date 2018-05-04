
package org.datacontract.schemas._2004._07.SealSignDSSTypes;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para RemoteProviderConfiguration complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="RemoteProviderConfiguration">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="providerDomain" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="providerPassword" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="providerUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="providerUser" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RemoteProviderConfiguration", propOrder = {
    "providerDomain",
    "providerPassword",
    "providerUrl",
    "providerUser"
})
public class RemoteProviderConfiguration {

    @XmlElementRef(name = "providerDomain", namespace = "http://schemas.datacontract.org/2004/07/SealSignDSSTypes", type = JAXBElement.class, required = false)
    protected JAXBElement<String> providerDomain;
    @XmlElementRef(name = "providerPassword", namespace = "http://schemas.datacontract.org/2004/07/SealSignDSSTypes", type = JAXBElement.class, required = false)
    protected JAXBElement<String> providerPassword;
    @XmlElementRef(name = "providerUrl", namespace = "http://schemas.datacontract.org/2004/07/SealSignDSSTypes", type = JAXBElement.class, required = false)
    protected JAXBElement<String> providerUrl;
    @XmlElementRef(name = "providerUser", namespace = "http://schemas.datacontract.org/2004/07/SealSignDSSTypes", type = JAXBElement.class, required = false)
    protected JAXBElement<String> providerUser;

    /**
     * Obtiene el valor de la propiedad providerDomain.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getProviderDomain() {
        return providerDomain;
    }

    /**
     * Define el valor de la propiedad providerDomain.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setProviderDomain(JAXBElement<String> value) {
        this.providerDomain = value;
    }

    /**
     * Obtiene el valor de la propiedad providerPassword.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getProviderPassword() {
        return providerPassword;
    }

    /**
     * Define el valor de la propiedad providerPassword.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setProviderPassword(JAXBElement<String> value) {
        this.providerPassword = value;
    }

    /**
     * Obtiene el valor de la propiedad providerUrl.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getProviderUrl() {
        return providerUrl;
    }

    /**
     * Define el valor de la propiedad providerUrl.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setProviderUrl(JAXBElement<String> value) {
        this.providerUrl = value;
    }

    /**
     * Obtiene el valor de la propiedad providerUser.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getProviderUser() {
        return providerUser;
    }

    /**
     * Define el valor de la propiedad providerUser.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setProviderUser(JAXBElement<String> value) {
        this.providerUser = value;
    }

}
