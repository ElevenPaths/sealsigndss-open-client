
package org.datacontract.schemas._2004._07.SealSignDSSTypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para HashAlgorithm.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="HashAlgorithm">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Default"/>
 *     &lt;enumeration value="RIPEMD160"/>
 *     &lt;enumeration value="MD5"/>
 *     &lt;enumeration value="SHA1"/>
 *     &lt;enumeration value="SHA256"/>
 *     &lt;enumeration value="SHA384"/>
 *     &lt;enumeration value="SHA512"/>
 *     &lt;enumeration value="SSL3"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "HashAlgorithm")
@XmlEnum
public enum HashAlgorithm {

    @XmlEnumValue("Default")
    DEFAULT("Default"),
    @XmlEnumValue("RIPEMD160")
    RIPEMD_160("RIPEMD160"),
    @XmlEnumValue("MD5")
    MD_5("MD5"),
    @XmlEnumValue("SHA1")
    SHA_1("SHA1"),
    @XmlEnumValue("SHA256")
    SHA_256("SHA256"),
    @XmlEnumValue("SHA384")
    SHA_384("SHA384"),
    @XmlEnumValue("SHA512")
    SHA_512("SHA512"),
    @XmlEnumValue("SSL3")
    SSL_3("SSL3");
    private final String value;

    HashAlgorithm(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static HashAlgorithm fromValue(String v) {
        for (HashAlgorithm c: HashAlgorithm.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
