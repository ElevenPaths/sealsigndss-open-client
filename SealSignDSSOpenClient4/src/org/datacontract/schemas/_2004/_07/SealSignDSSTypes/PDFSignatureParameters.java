
package org.datacontract.schemas._2004._07.SealSignDSSTypes;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para PDFSignatureParameters complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="PDFSignatureParameters">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PDFPassword" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PDFSignatureBackground" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="PDFSignatureBackgroundHeight" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="PDFSignatureBackgroundStretch" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="PDFSignatureBackgroundWidth" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="PDFSignatureFieldName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PDFSignatureFilterOnlyDocSignatures" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="PDFSignatureVisible" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="PDFSignatureWidgetAutoPos" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="PDFSignatureWidgetAutoSize" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="PDFSignatureWidgetDateCaptionFormat" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PDFSignatureWidgetDateOffsetX" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="PDFSignatureWidgetDateOffsetY" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="PDFSignatureWidgetHeight" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="PDFSignatureWidgetHideText" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="PDFSignatureWidgetImageTokenText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PDFSignatureWidgetOffsetX" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="PDFSignatureWidgetOffsetY" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="PDFSignatureWidgetOnAllPages" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="PDFSignatureWidgetOnLastPage" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="PDFSignatureWidgetOnPage" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="PDFSignatureWidgetPageOffset" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="PDFSignatureWidgetRotate" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="PDFSignatureWidgetWidth" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PDFSignatureParameters", propOrder = {
    "pdfPassword",
    "pdfSignatureBackground",
    "pdfSignatureBackgroundHeight",
    "pdfSignatureBackgroundStretch",
    "pdfSignatureBackgroundWidth",
    "pdfSignatureFieldName",
    "pdfSignatureFilterOnlyDocSignatures",
    "pdfSignatureVisible",
    "pdfSignatureWidgetAutoPos",
    "pdfSignatureWidgetAutoSize",
    "pdfSignatureWidgetDateCaptionFormat",
    "pdfSignatureWidgetDateOffsetX",
    "pdfSignatureWidgetDateOffsetY",
    "pdfSignatureWidgetHeight",
    "pdfSignatureWidgetHideText",
    "pdfSignatureWidgetImageTokenText",
    "pdfSignatureWidgetOffsetX",
    "pdfSignatureWidgetOffsetY",
    "pdfSignatureWidgetOnAllPages",
    "pdfSignatureWidgetOnLastPage",
    "pdfSignatureWidgetOnPage",
    "pdfSignatureWidgetPageOffset",
    "pdfSignatureWidgetRotate",
    "pdfSignatureWidgetWidth"
})
public class PDFSignatureParameters {

    @XmlElementRef(name = "PDFPassword", namespace = "http://schemas.datacontract.org/2004/07/SealSignDSSTypes", type = JAXBElement.class, required = false)
    protected JAXBElement<String> pdfPassword;
    @XmlElementRef(name = "PDFSignatureBackground", namespace = "http://schemas.datacontract.org/2004/07/SealSignDSSTypes", type = JAXBElement.class, required = false)
    protected JAXBElement<byte[]> pdfSignatureBackground;
    @XmlElement(name = "PDFSignatureBackgroundHeight")
    protected Integer pdfSignatureBackgroundHeight;
    @XmlElement(name = "PDFSignatureBackgroundStretch")
    protected Boolean pdfSignatureBackgroundStretch;
    @XmlElement(name = "PDFSignatureBackgroundWidth")
    protected Integer pdfSignatureBackgroundWidth;
    @XmlElementRef(name = "PDFSignatureFieldName", namespace = "http://schemas.datacontract.org/2004/07/SealSignDSSTypes", type = JAXBElement.class, required = false)
    protected JAXBElement<String> pdfSignatureFieldName;
    @XmlElement(name = "PDFSignatureFilterOnlyDocSignatures")
    protected Boolean pdfSignatureFilterOnlyDocSignatures;
    @XmlElement(name = "PDFSignatureVisible")
    protected Boolean pdfSignatureVisible;
    @XmlElement(name = "PDFSignatureWidgetAutoPos")
    protected Boolean pdfSignatureWidgetAutoPos;
    @XmlElement(name = "PDFSignatureWidgetAutoSize")
    protected Boolean pdfSignatureWidgetAutoSize;
    @XmlElementRef(name = "PDFSignatureWidgetDateCaptionFormat", namespace = "http://schemas.datacontract.org/2004/07/SealSignDSSTypes", type = JAXBElement.class, required = false)
    protected JAXBElement<String> pdfSignatureWidgetDateCaptionFormat;
    @XmlElement(name = "PDFSignatureWidgetDateOffsetX")
    protected Integer pdfSignatureWidgetDateOffsetX;
    @XmlElement(name = "PDFSignatureWidgetDateOffsetY")
    protected Integer pdfSignatureWidgetDateOffsetY;
    @XmlElement(name = "PDFSignatureWidgetHeight")
    protected Integer pdfSignatureWidgetHeight;
    @XmlElement(name = "PDFSignatureWidgetHideText")
    protected Boolean pdfSignatureWidgetHideText;
    @XmlElementRef(name = "PDFSignatureWidgetImageTokenText", namespace = "http://schemas.datacontract.org/2004/07/SealSignDSSTypes", type = JAXBElement.class, required = false)
    protected JAXBElement<String> pdfSignatureWidgetImageTokenText;
    @XmlElement(name = "PDFSignatureWidgetOffsetX")
    protected Integer pdfSignatureWidgetOffsetX;
    @XmlElement(name = "PDFSignatureWidgetOffsetY")
    protected Integer pdfSignatureWidgetOffsetY;
    @XmlElement(name = "PDFSignatureWidgetOnAllPages")
    protected Boolean pdfSignatureWidgetOnAllPages;
    @XmlElement(name = "PDFSignatureWidgetOnLastPage")
    protected Boolean pdfSignatureWidgetOnLastPage;
    @XmlElement(name = "PDFSignatureWidgetOnPage")
    protected Integer pdfSignatureWidgetOnPage;
    @XmlElement(name = "PDFSignatureWidgetPageOffset")
    protected Integer pdfSignatureWidgetPageOffset;
    @XmlElement(name = "PDFSignatureWidgetRotate")
    protected Integer pdfSignatureWidgetRotate;
    @XmlElement(name = "PDFSignatureWidgetWidth")
    protected Integer pdfSignatureWidgetWidth;

    /**
     * Obtiene el valor de la propiedad pdfPassword.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPDFPassword() {
        return pdfPassword;
    }

    /**
     * Define el valor de la propiedad pdfPassword.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPDFPassword(JAXBElement<String> value) {
        this.pdfPassword = value;
    }

    /**
     * Obtiene el valor de la propiedad pdfSignatureBackground.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link byte[]}{@code >}
     *     
     */
    public JAXBElement<byte[]> getPDFSignatureBackground() {
        return pdfSignatureBackground;
    }

    /**
     * Define el valor de la propiedad pdfSignatureBackground.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link byte[]}{@code >}
     *     
     */
    public void setPDFSignatureBackground(JAXBElement<byte[]> value) {
        this.pdfSignatureBackground = value;
    }

    /**
     * Obtiene el valor de la propiedad pdfSignatureBackgroundHeight.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPDFSignatureBackgroundHeight() {
        return pdfSignatureBackgroundHeight;
    }

    /**
     * Define el valor de la propiedad pdfSignatureBackgroundHeight.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPDFSignatureBackgroundHeight(Integer value) {
        this.pdfSignatureBackgroundHeight = value;
    }

    /**
     * Obtiene el valor de la propiedad pdfSignatureBackgroundStretch.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPDFSignatureBackgroundStretch() {
        return pdfSignatureBackgroundStretch;
    }

    /**
     * Define el valor de la propiedad pdfSignatureBackgroundStretch.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPDFSignatureBackgroundStretch(Boolean value) {
        this.pdfSignatureBackgroundStretch = value;
    }

    /**
     * Obtiene el valor de la propiedad pdfSignatureBackgroundWidth.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPDFSignatureBackgroundWidth() {
        return pdfSignatureBackgroundWidth;
    }

    /**
     * Define el valor de la propiedad pdfSignatureBackgroundWidth.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPDFSignatureBackgroundWidth(Integer value) {
        this.pdfSignatureBackgroundWidth = value;
    }

    /**
     * Obtiene el valor de la propiedad pdfSignatureFieldName.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPDFSignatureFieldName() {
        return pdfSignatureFieldName;
    }

    /**
     * Define el valor de la propiedad pdfSignatureFieldName.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPDFSignatureFieldName(JAXBElement<String> value) {
        this.pdfSignatureFieldName = value;
    }

    /**
     * Obtiene el valor de la propiedad pdfSignatureFilterOnlyDocSignatures.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPDFSignatureFilterOnlyDocSignatures() {
        return pdfSignatureFilterOnlyDocSignatures;
    }

    /**
     * Define el valor de la propiedad pdfSignatureFilterOnlyDocSignatures.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPDFSignatureFilterOnlyDocSignatures(Boolean value) {
        this.pdfSignatureFilterOnlyDocSignatures = value;
    }

    /**
     * Obtiene el valor de la propiedad pdfSignatureVisible.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPDFSignatureVisible() {
        return pdfSignatureVisible;
    }

    /**
     * Define el valor de la propiedad pdfSignatureVisible.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPDFSignatureVisible(Boolean value) {
        this.pdfSignatureVisible = value;
    }

    /**
     * Obtiene el valor de la propiedad pdfSignatureWidgetAutoPos.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPDFSignatureWidgetAutoPos() {
        return pdfSignatureWidgetAutoPos;
    }

    /**
     * Define el valor de la propiedad pdfSignatureWidgetAutoPos.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPDFSignatureWidgetAutoPos(Boolean value) {
        this.pdfSignatureWidgetAutoPos = value;
    }

    /**
     * Obtiene el valor de la propiedad pdfSignatureWidgetAutoSize.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPDFSignatureWidgetAutoSize() {
        return pdfSignatureWidgetAutoSize;
    }

    /**
     * Define el valor de la propiedad pdfSignatureWidgetAutoSize.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPDFSignatureWidgetAutoSize(Boolean value) {
        this.pdfSignatureWidgetAutoSize = value;
    }

    /**
     * Obtiene el valor de la propiedad pdfSignatureWidgetDateCaptionFormat.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPDFSignatureWidgetDateCaptionFormat() {
        return pdfSignatureWidgetDateCaptionFormat;
    }

    /**
     * Define el valor de la propiedad pdfSignatureWidgetDateCaptionFormat.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPDFSignatureWidgetDateCaptionFormat(JAXBElement<String> value) {
        this.pdfSignatureWidgetDateCaptionFormat = value;
    }

    /**
     * Obtiene el valor de la propiedad pdfSignatureWidgetDateOffsetX.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPDFSignatureWidgetDateOffsetX() {
        return pdfSignatureWidgetDateOffsetX;
    }

    /**
     * Define el valor de la propiedad pdfSignatureWidgetDateOffsetX.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPDFSignatureWidgetDateOffsetX(Integer value) {
        this.pdfSignatureWidgetDateOffsetX = value;
    }

    /**
     * Obtiene el valor de la propiedad pdfSignatureWidgetDateOffsetY.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPDFSignatureWidgetDateOffsetY() {
        return pdfSignatureWidgetDateOffsetY;
    }

    /**
     * Define el valor de la propiedad pdfSignatureWidgetDateOffsetY.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPDFSignatureWidgetDateOffsetY(Integer value) {
        this.pdfSignatureWidgetDateOffsetY = value;
    }

    /**
     * Obtiene el valor de la propiedad pdfSignatureWidgetHeight.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPDFSignatureWidgetHeight() {
        return pdfSignatureWidgetHeight;
    }

    /**
     * Define el valor de la propiedad pdfSignatureWidgetHeight.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPDFSignatureWidgetHeight(Integer value) {
        this.pdfSignatureWidgetHeight = value;
    }

    /**
     * Obtiene el valor de la propiedad pdfSignatureWidgetHideText.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPDFSignatureWidgetHideText() {
        return pdfSignatureWidgetHideText;
    }

    /**
     * Define el valor de la propiedad pdfSignatureWidgetHideText.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPDFSignatureWidgetHideText(Boolean value) {
        this.pdfSignatureWidgetHideText = value;
    }

    /**
     * Obtiene el valor de la propiedad pdfSignatureWidgetImageTokenText.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPDFSignatureWidgetImageTokenText() {
        return pdfSignatureWidgetImageTokenText;
    }

    /**
     * Define el valor de la propiedad pdfSignatureWidgetImageTokenText.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPDFSignatureWidgetImageTokenText(JAXBElement<String> value) {
        this.pdfSignatureWidgetImageTokenText = value;
    }

    /**
     * Obtiene el valor de la propiedad pdfSignatureWidgetOffsetX.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPDFSignatureWidgetOffsetX() {
        return pdfSignatureWidgetOffsetX;
    }

    /**
     * Define el valor de la propiedad pdfSignatureWidgetOffsetX.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPDFSignatureWidgetOffsetX(Integer value) {
        this.pdfSignatureWidgetOffsetX = value;
    }

    /**
     * Obtiene el valor de la propiedad pdfSignatureWidgetOffsetY.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPDFSignatureWidgetOffsetY() {
        return pdfSignatureWidgetOffsetY;
    }

    /**
     * Define el valor de la propiedad pdfSignatureWidgetOffsetY.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPDFSignatureWidgetOffsetY(Integer value) {
        this.pdfSignatureWidgetOffsetY = value;
    }

    /**
     * Obtiene el valor de la propiedad pdfSignatureWidgetOnAllPages.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPDFSignatureWidgetOnAllPages() {
        return pdfSignatureWidgetOnAllPages;
    }

    /**
     * Define el valor de la propiedad pdfSignatureWidgetOnAllPages.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPDFSignatureWidgetOnAllPages(Boolean value) {
        this.pdfSignatureWidgetOnAllPages = value;
    }

    /**
     * Obtiene el valor de la propiedad pdfSignatureWidgetOnLastPage.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPDFSignatureWidgetOnLastPage() {
        return pdfSignatureWidgetOnLastPage;
    }

    /**
     * Define el valor de la propiedad pdfSignatureWidgetOnLastPage.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPDFSignatureWidgetOnLastPage(Boolean value) {
        this.pdfSignatureWidgetOnLastPage = value;
    }

    /**
     * Obtiene el valor de la propiedad pdfSignatureWidgetOnPage.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPDFSignatureWidgetOnPage() {
        return pdfSignatureWidgetOnPage;
    }

    /**
     * Define el valor de la propiedad pdfSignatureWidgetOnPage.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPDFSignatureWidgetOnPage(Integer value) {
        this.pdfSignatureWidgetOnPage = value;
    }

    /**
     * Obtiene el valor de la propiedad pdfSignatureWidgetPageOffset.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPDFSignatureWidgetPageOffset() {
        return pdfSignatureWidgetPageOffset;
    }

    /**
     * Define el valor de la propiedad pdfSignatureWidgetPageOffset.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPDFSignatureWidgetPageOffset(Integer value) {
        this.pdfSignatureWidgetPageOffset = value;
    }

    /**
     * Obtiene el valor de la propiedad pdfSignatureWidgetRotate.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPDFSignatureWidgetRotate() {
        return pdfSignatureWidgetRotate;
    }

    /**
     * Define el valor de la propiedad pdfSignatureWidgetRotate.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPDFSignatureWidgetRotate(Integer value) {
        this.pdfSignatureWidgetRotate = value;
    }

    /**
     * Obtiene el valor de la propiedad pdfSignatureWidgetWidth.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPDFSignatureWidgetWidth() {
        return pdfSignatureWidgetWidth;
    }

    /**
     * Define el valor de la propiedad pdfSignatureWidgetWidth.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPDFSignatureWidgetWidth(Integer value) {
        this.pdfSignatureWidgetWidth = value;
    }

}
