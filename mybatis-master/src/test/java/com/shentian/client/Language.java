
package com.shentian.client;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Language的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <p>
 * <pre>
 * &lt;simpleType name="Language">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Chinese"/>
 *     &lt;enumeration value="English"/>
 *     &lt;enumeration value="Japan"/>
 *     &lt;enumeration value="Korean"/>
 *     &lt;enumeration value="Cht"/>
 *     &lt;enumeration value="German"/>
 *     &lt;enumeration value="French"/>
 *     &lt;enumeration value="Spanish"/>
 *     &lt;enumeration value="Thai"/>
 *     &lt;enumeration value="other"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Language")
@XmlEnum
public enum Language {

    @XmlEnumValue("Chinese")
    CHINESE("Chinese"),
    @XmlEnumValue("English")
    ENGLISH("English"),
    @XmlEnumValue("Japan")
    JAPAN("Japan"),
    @XmlEnumValue("Korean")
    KOREAN("Korean"),
    @XmlEnumValue("Cht")
    CHT("Cht"),
    @XmlEnumValue("German")
    GERMAN("German"),
    @XmlEnumValue("French")
    FRENCH("French"),
    @XmlEnumValue("Spanish")
    SPANISH("Spanish"),
    @XmlEnumValue("Thai")
    THAI("Thai"),
    @XmlEnumValue("other")
    OTHER("other");
    private final String value;

    Language(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Language fromValue(String v) {
        for (Language c: Language.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
