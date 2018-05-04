
package org.datacontract.schemas._2004._07.SealSignDSSTypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para SignatureType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="SignatureType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Default"/>
 *     &lt;enumeration value="Enveloped"/>
 *     &lt;enumeration value="Enveloping"/>
 *     &lt;enumeration value="Detached"/>
 *     &lt;enumeration value="DetachedInternal"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SignatureType")
@XmlEnum
public enum SignatureType {

    @XmlEnumValue("Default")
    DEFAULT("Default"),
    @XmlEnumValue("Enveloped")
    ENVELOPED("Enveloped"),
    @XmlEnumValue("Enveloping")
    ENVELOPING("Enveloping"),
    @XmlEnumValue("Detached")
    DETACHED("Detached"),
    @XmlEnumValue("DetachedInternal")
    DETACHED_INTERNAL("DetachedInternal");
    private final String value;

    SignatureType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SignatureType fromValue(String v) {
        for (SignatureType c: SignatureType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
