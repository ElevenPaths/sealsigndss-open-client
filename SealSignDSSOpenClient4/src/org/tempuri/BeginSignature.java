
package org.tempuri;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.datacontract.schemas._2004._07.SealSignDSSTypes.HashAlgorithm;
import org.datacontract.schemas._2004._07.SealSignDSSTypes.SignatureParameters;
import org.datacontract.schemas._2004._07.SealSignDSSTypes.SignatureProfile;
import org.datacontract.schemas._2004._07.SealSignDSSTypes.SignatureType;


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
 *         &lt;element name="signatureProfile" type="{http://schemas.datacontract.org/2004/07/SealSignDSSTypes}SignatureProfile" minOccurs="0"/>
 *         &lt;element name="signatureType" type="{http://schemas.datacontract.org/2004/07/SealSignDSSTypes}SignatureType" minOccurs="0"/>
 *         &lt;element name="hashAlgorithm" type="{http://schemas.datacontract.org/2004/07/SealSignDSSTypes}HashAlgorithm" minOccurs="0"/>
 *         &lt;element name="options" type="{http://schemas.datacontract.org/2004/07/SealSignDSSTypes}SignatureFlags" minOccurs="0"/>
 *         &lt;element name="parameters" type="{http://schemas.datacontract.org/2004/07/SealSignDSSTypes}SignatureParameters" minOccurs="0"/>
 *         &lt;element name="detachedSignature" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="signingDocument" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
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
    "signatureProfile",
    "signatureType",
    "hashAlgorithm",
    "options",
    "parameters",
    "detachedSignature",
    "signingDocument"
})
@XmlRootElement(name = "BeginSignature")
public class BeginSignature {

    @XmlElementRef(name = "certificate", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<byte[]> certificate;
    protected SignatureProfile signatureProfile;
    protected SignatureType signatureType;
    protected HashAlgorithm hashAlgorithm;
    @XmlList
    protected List<String> options;
    @XmlElementRef(name = "parameters", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<SignatureParameters> parameters;
    @XmlElementRef(name = "detachedSignature", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<byte[]> detachedSignature;
    @XmlElementRef(name = "signingDocument", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<byte[]> signingDocument;

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
     * Obtiene el valor de la propiedad signatureProfile.
     * 
     * @return
     *     possible object is
     *     {@link SignatureProfile }
     *     
     */
    public SignatureProfile getSignatureProfile() {
        return signatureProfile;
    }

    /**
     * Define el valor de la propiedad signatureProfile.
     * 
     * @param value
     *     allowed object is
     *     {@link SignatureProfile }
     *     
     */
    public void setSignatureProfile(SignatureProfile value) {
        this.signatureProfile = value;
    }

    /**
     * Obtiene el valor de la propiedad signatureType.
     * 
     * @return
     *     possible object is
     *     {@link SignatureType }
     *     
     */
    public SignatureType getSignatureType() {
        return signatureType;
    }

    /**
     * Define el valor de la propiedad signatureType.
     * 
     * @param value
     *     allowed object is
     *     {@link SignatureType }
     *     
     */
    public void setSignatureType(SignatureType value) {
        this.signatureType = value;
    }

    /**
     * Obtiene el valor de la propiedad hashAlgorithm.
     * 
     * @return
     *     possible object is
     *     {@link HashAlgorithm }
     *     
     */
    public HashAlgorithm getHashAlgorithm() {
        return hashAlgorithm;
    }

    /**
     * Define el valor de la propiedad hashAlgorithm.
     * 
     * @param value
     *     allowed object is
     *     {@link HashAlgorithm }
     *     
     */
    public void setHashAlgorithm(HashAlgorithm value) {
        this.hashAlgorithm = value;
    }

    /**
     * Gets the value of the options property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the options property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOptions().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getOptions() {
        if (options == null) {
            options = new ArrayList<String>();
        }
        return this.options;
    }

    /**
     * Obtiene el valor de la propiedad parameters.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link SignatureParameters }{@code >}
     *     
     */
    public JAXBElement<SignatureParameters> getParameters() {
        return parameters;
    }

    /**
     * Define el valor de la propiedad parameters.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link SignatureParameters }{@code >}
     *     
     */
    public void setParameters(JAXBElement<SignatureParameters> value) {
        this.parameters = value;
    }

    /**
     * Obtiene el valor de la propiedad detachedSignature.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link byte[]}{@code >}
     *     
     */
    public JAXBElement<byte[]> getDetachedSignature() {
        return detachedSignature;
    }

    /**
     * Define el valor de la propiedad detachedSignature.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link byte[]}{@code >}
     *     
     */
    public void setDetachedSignature(JAXBElement<byte[]> value) {
        this.detachedSignature = value;
    }

    /**
     * Obtiene el valor de la propiedad signingDocument.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link byte[]}{@code >}
     *     
     */
    public JAXBElement<byte[]> getSigningDocument() {
        return signingDocument;
    }

    /**
     * Define el valor de la propiedad signingDocument.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link byte[]}{@code >}
     *     
     */
    public void setSigningDocument(JAXBElement<byte[]> value) {
        this.signingDocument = value;
    }

}
