
package org.datacontract.schemas._2004._07.SealSignDSSTypes;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para SignatureParameters complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="SignatureParameters">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="algorithmCaption" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="algorithmInfo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="city" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="country" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="documentPassword" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="header" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pdfParameters" type="{http://schemas.datacontract.org/2004/07/SealSignDSSTypes}PDFSignatureParameters" minOccurs="0"/>
 *         &lt;element name="policyCMSQualifierURI" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="policyDigest" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="policyIdentifier" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="postalCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="reason" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="reference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="signerCaption" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="signerInfo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="signerRole" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="state" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="timestampBackupServerId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="timestampServerId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SignatureParameters", propOrder = {
    "algorithmCaption",
    "algorithmInfo",
    "city",
    "country",
    "documentPassword",
    "header",
    "pdfParameters",
    "policyCMSQualifierURI",
    "policyDigest",
    "policyIdentifier",
    "postalCode",
    "reason",
    "reference",
    "signerCaption",
    "signerInfo",
    "signerRole",
    "state",
    "timestampBackupServerId",
    "timestampServerId"
})
public class SignatureParameters {

    @XmlElementRef(name = "algorithmCaption", namespace = "http://schemas.datacontract.org/2004/07/SealSignDSSTypes", type = JAXBElement.class, required = false)
    protected JAXBElement<String> algorithmCaption;
    @XmlElementRef(name = "algorithmInfo", namespace = "http://schemas.datacontract.org/2004/07/SealSignDSSTypes", type = JAXBElement.class, required = false)
    protected JAXBElement<String> algorithmInfo;
    @XmlElementRef(name = "city", namespace = "http://schemas.datacontract.org/2004/07/SealSignDSSTypes", type = JAXBElement.class, required = false)
    protected JAXBElement<String> city;
    @XmlElementRef(name = "country", namespace = "http://schemas.datacontract.org/2004/07/SealSignDSSTypes", type = JAXBElement.class, required = false)
    protected JAXBElement<String> country;
    @XmlElementRef(name = "documentPassword", namespace = "http://schemas.datacontract.org/2004/07/SealSignDSSTypes", type = JAXBElement.class, required = false)
    protected JAXBElement<String> documentPassword;
    @XmlElementRef(name = "header", namespace = "http://schemas.datacontract.org/2004/07/SealSignDSSTypes", type = JAXBElement.class, required = false)
    protected JAXBElement<String> header;
    @XmlElementRef(name = "pdfParameters", namespace = "http://schemas.datacontract.org/2004/07/SealSignDSSTypes", type = JAXBElement.class, required = false)
    protected JAXBElement<PDFSignatureParameters> pdfParameters;
    @XmlElementRef(name = "policyCMSQualifierURI", namespace = "http://schemas.datacontract.org/2004/07/SealSignDSSTypes", type = JAXBElement.class, required = false)
    protected JAXBElement<String> policyCMSQualifierURI;
    @XmlElementRef(name = "policyDigest", namespace = "http://schemas.datacontract.org/2004/07/SealSignDSSTypes", type = JAXBElement.class, required = false)
    protected JAXBElement<String> policyDigest;
    @XmlElementRef(name = "policyIdentifier", namespace = "http://schemas.datacontract.org/2004/07/SealSignDSSTypes", type = JAXBElement.class, required = false)
    protected JAXBElement<String> policyIdentifier;
    @XmlElementRef(name = "postalCode", namespace = "http://schemas.datacontract.org/2004/07/SealSignDSSTypes", type = JAXBElement.class, required = false)
    protected JAXBElement<String> postalCode;
    @XmlElementRef(name = "reason", namespace = "http://schemas.datacontract.org/2004/07/SealSignDSSTypes", type = JAXBElement.class, required = false)
    protected JAXBElement<String> reason;
    @XmlElementRef(name = "reference", namespace = "http://schemas.datacontract.org/2004/07/SealSignDSSTypes", type = JAXBElement.class, required = false)
    protected JAXBElement<String> reference;
    @XmlElementRef(name = "signerCaption", namespace = "http://schemas.datacontract.org/2004/07/SealSignDSSTypes", type = JAXBElement.class, required = false)
    protected JAXBElement<String> signerCaption;
    @XmlElementRef(name = "signerInfo", namespace = "http://schemas.datacontract.org/2004/07/SealSignDSSTypes", type = JAXBElement.class, required = false)
    protected JAXBElement<String> signerInfo;
    @XmlElementRef(name = "signerRole", namespace = "http://schemas.datacontract.org/2004/07/SealSignDSSTypes", type = JAXBElement.class, required = false)
    protected JAXBElement<String> signerRole;
    @XmlElementRef(name = "state", namespace = "http://schemas.datacontract.org/2004/07/SealSignDSSTypes", type = JAXBElement.class, required = false)
    protected JAXBElement<String> state;
    protected Integer timestampBackupServerId;
    protected Integer timestampServerId;

    /**
     * Obtiene el valor de la propiedad algorithmCaption.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAlgorithmCaption() {
        return algorithmCaption;
    }

    /**
     * Define el valor de la propiedad algorithmCaption.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAlgorithmCaption(JAXBElement<String> value) {
        this.algorithmCaption = value;
    }

    /**
     * Obtiene el valor de la propiedad algorithmInfo.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAlgorithmInfo() {
        return algorithmInfo;
    }

    /**
     * Define el valor de la propiedad algorithmInfo.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAlgorithmInfo(JAXBElement<String> value) {
        this.algorithmInfo = value;
    }

    /**
     * Obtiene el valor de la propiedad city.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCity() {
        return city;
    }

    /**
     * Define el valor de la propiedad city.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCity(JAXBElement<String> value) {
        this.city = value;
    }

    /**
     * Obtiene el valor de la propiedad country.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCountry() {
        return country;
    }

    /**
     * Define el valor de la propiedad country.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCountry(JAXBElement<String> value) {
        this.country = value;
    }

    /**
     * Obtiene el valor de la propiedad documentPassword.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDocumentPassword() {
        return documentPassword;
    }

    /**
     * Define el valor de la propiedad documentPassword.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDocumentPassword(JAXBElement<String> value) {
        this.documentPassword = value;
    }

    /**
     * Obtiene el valor de la propiedad header.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getHeader() {
        return header;
    }

    /**
     * Define el valor de la propiedad header.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setHeader(JAXBElement<String> value) {
        this.header = value;
    }

    /**
     * Obtiene el valor de la propiedad pdfParameters.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link PDFSignatureParameters }{@code >}
     *     
     */
    public JAXBElement<PDFSignatureParameters> getPdfParameters() {
        return pdfParameters;
    }

    /**
     * Define el valor de la propiedad pdfParameters.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link PDFSignatureParameters }{@code >}
     *     
     */
    public void setPdfParameters(JAXBElement<PDFSignatureParameters> value) {
        this.pdfParameters = value;
    }

    /**
     * Obtiene el valor de la propiedad policyCMSQualifierURI.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPolicyCMSQualifierURI() {
        return policyCMSQualifierURI;
    }

    /**
     * Define el valor de la propiedad policyCMSQualifierURI.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPolicyCMSQualifierURI(JAXBElement<String> value) {
        this.policyCMSQualifierURI = value;
    }

    /**
     * Obtiene el valor de la propiedad policyDigest.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPolicyDigest() {
        return policyDigest;
    }

    /**
     * Define el valor de la propiedad policyDigest.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPolicyDigest(JAXBElement<String> value) {
        this.policyDigest = value;
    }

    /**
     * Obtiene el valor de la propiedad policyIdentifier.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPolicyIdentifier() {
        return policyIdentifier;
    }

    /**
     * Define el valor de la propiedad policyIdentifier.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPolicyIdentifier(JAXBElement<String> value) {
        this.policyIdentifier = value;
    }

    /**
     * Obtiene el valor de la propiedad postalCode.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPostalCode() {
        return postalCode;
    }

    /**
     * Define el valor de la propiedad postalCode.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPostalCode(JAXBElement<String> value) {
        this.postalCode = value;
    }

    /**
     * Obtiene el valor de la propiedad reason.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getReason() {
        return reason;
    }

    /**
     * Define el valor de la propiedad reason.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setReason(JAXBElement<String> value) {
        this.reason = value;
    }

    /**
     * Obtiene el valor de la propiedad reference.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getReference() {
        return reference;
    }

    /**
     * Define el valor de la propiedad reference.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setReference(JAXBElement<String> value) {
        this.reference = value;
    }

    /**
     * Obtiene el valor de la propiedad signerCaption.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSignerCaption() {
        return signerCaption;
    }

    /**
     * Define el valor de la propiedad signerCaption.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSignerCaption(JAXBElement<String> value) {
        this.signerCaption = value;
    }

    /**
     * Obtiene el valor de la propiedad signerInfo.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSignerInfo() {
        return signerInfo;
    }

    /**
     * Define el valor de la propiedad signerInfo.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSignerInfo(JAXBElement<String> value) {
        this.signerInfo = value;
    }

    /**
     * Obtiene el valor de la propiedad signerRole.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSignerRole() {
        return signerRole;
    }

    /**
     * Define el valor de la propiedad signerRole.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSignerRole(JAXBElement<String> value) {
        this.signerRole = value;
    }

    /**
     * Obtiene el valor de la propiedad state.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getState() {
        return state;
    }

    /**
     * Define el valor de la propiedad state.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setState(JAXBElement<String> value) {
        this.state = value;
    }

    /**
     * Obtiene el valor de la propiedad timestampBackupServerId.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTimestampBackupServerId() {
        return timestampBackupServerId;
    }

    /**
     * Define el valor de la propiedad timestampBackupServerId.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTimestampBackupServerId(Integer value) {
        this.timestampBackupServerId = value;
    }

    /**
     * Obtiene el valor de la propiedad timestampServerId.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTimestampServerId() {
        return timestampServerId;
    }

    /**
     * Define el valor de la propiedad timestampServerId.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTimestampServerId(Integer value) {
        this.timestampServerId = value;
    }

}
