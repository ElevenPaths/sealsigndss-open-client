
package org.datacontract.schemas._2004._07.SealSignDSSTypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para SignatureProfile.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="SignatureProfile">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Default"/>
 *     &lt;enumeration value="CMS"/>
 *     &lt;enumeration value="CAdESBES"/>
 *     &lt;enumeration value="CAdEST"/>
 *     &lt;enumeration value="CAdESC"/>
 *     &lt;enumeration value="CAdESX"/>
 *     &lt;enumeration value="CAdESXL"/>
 *     &lt;enumeration value="CAdESA"/>
 *     &lt;enumeration value="XMLDigSig"/>
 *     &lt;enumeration value="XAdESBES"/>
 *     &lt;enumeration value="XAdEST"/>
 *     &lt;enumeration value="XAdESC"/>
 *     &lt;enumeration value="XAdESX"/>
 *     &lt;enumeration value="XAdESXL"/>
 *     &lt;enumeration value="XAdESA"/>
 *     &lt;enumeration value="PDF"/>
 *     &lt;enumeration value="PAdESBasic"/>
 *     &lt;enumeration value="PAdESBES"/>
 *     &lt;enumeration value="PAdESLTV"/>
 *     &lt;enumeration value="PAdESXML"/>
 *     &lt;enumeration value="Office"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SignatureProfile")
@XmlEnum
public enum SignatureProfile {

    @XmlEnumValue("Default")
    DEFAULT("Default"),
    CMS("CMS"),
    @XmlEnumValue("CAdESBES")
    C_AD_ESBES("CAdESBES"),
    @XmlEnumValue("CAdEST")
    C_AD_EST("CAdEST"),
    @XmlEnumValue("CAdESC")
    C_AD_ESC("CAdESC"),
    @XmlEnumValue("CAdESX")
    C_AD_ESX("CAdESX"),
    @XmlEnumValue("CAdESXL")
    C_AD_ESXL("CAdESXL"),
    @XmlEnumValue("CAdESA")
    C_AD_ESA("CAdESA"),
    @XmlEnumValue("XMLDigSig")
    XML_DIG_SIG("XMLDigSig"),
    @XmlEnumValue("XAdESBES")
    X_AD_ESBES("XAdESBES"),
    @XmlEnumValue("XAdEST")
    X_AD_EST("XAdEST"),
    @XmlEnumValue("XAdESC")
    X_AD_ESC("XAdESC"),
    @XmlEnumValue("XAdESX")
    X_AD_ESX("XAdESX"),
    @XmlEnumValue("XAdESXL")
    X_AD_ESXL("XAdESXL"),
    @XmlEnumValue("XAdESA")
    X_AD_ESA("XAdESA"),
    PDF("PDF"),
    @XmlEnumValue("PAdESBasic")
    P_AD_ES_BASIC("PAdESBasic"),
    @XmlEnumValue("PAdESBES")
    P_AD_ESBES("PAdESBES"),
    @XmlEnumValue("PAdESLTV")
    P_AD_ESLTV("PAdESLTV"),
    @XmlEnumValue("PAdESXML")
    P_AD_ESXML("PAdESXML"),
    @XmlEnumValue("Office")
    OFFICE("Office");
    private final String value;

    SignatureProfile(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SignatureProfile fromValue(String v) {
        for (SignatureProfile c: SignatureProfile.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
