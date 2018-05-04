
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
 *         &lt;element name="BeginSignatureProviderResult" type="{http://schemas.datacontract.org/2004/07/SealSignDSSService}DistributedSignatureBeginResponseBasic" minOccurs="0"/>
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
    "beginSignatureProviderResult"
})
@XmlRootElement(name = "BeginSignatureProviderResponse")
public class BeginSignatureProviderResponse {

    @XmlElementRef(name = "BeginSignatureProviderResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<DistributedSignatureBeginResponseBasic> beginSignatureProviderResult;

    /**
     * Obtiene el valor de la propiedad beginSignatureProviderResult.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link DistributedSignatureBeginResponseBasic }{@code >}
     *     
     */
    public JAXBElement<DistributedSignatureBeginResponseBasic> getBeginSignatureProviderResult() {
        return beginSignatureProviderResult;
    }

    /**
     * Define el valor de la propiedad beginSignatureProviderResult.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link DistributedSignatureBeginResponseBasic }{@code >}
     *     
     */
    public void setBeginSignatureProviderResult(JAXBElement<DistributedSignatureBeginResponseBasic> value) {
        this.beginSignatureProviderResult = value;
    }

}
