
package org.tempuri;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.datacontract.schemas._2004._07.SealSignDSSService.DistributedSignatureBeginResponseBasic;


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
 *         &lt;element name="BeginCounterSignatureProviderResult" type="{http://schemas.datacontract.org/2004/07/SealSignDSSService}DistributedSignatureBeginResponseBasic" minOccurs="0"/>
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
    "beginCounterSignatureProviderResult"
})
@XmlRootElement(name = "BeginCounterSignatureProviderResponse")
public class BeginCounterSignatureProviderResponse {

    @XmlElementRef(name = "BeginCounterSignatureProviderResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<DistributedSignatureBeginResponseBasic> beginCounterSignatureProviderResult;

    /**
     * Obtiene el valor de la propiedad beginCounterSignatureProviderResult.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link DistributedSignatureBeginResponseBasic }{@code >}
     *     
     */
    public JAXBElement<DistributedSignatureBeginResponseBasic> getBeginCounterSignatureProviderResult() {
        return beginCounterSignatureProviderResult;
    }

    /**
     * Define el valor de la propiedad beginCounterSignatureProviderResult.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link DistributedSignatureBeginResponseBasic }{@code >}
     *     
     */
    public void setBeginCounterSignatureProviderResult(JAXBElement<DistributedSignatureBeginResponseBasic> value) {
        this.beginCounterSignatureProviderResult = value;
    }

}
