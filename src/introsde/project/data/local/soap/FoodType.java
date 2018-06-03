
package introsde.project.data.local.soap;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for foodType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="foodType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Indian"/>
 *     &lt;enumeration value="Italian"/>
 *     &lt;enumeration value="Chinese"/>
 *     &lt;enumeration value="Thai"/>
 *     &lt;enumeration value="Mexican"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "foodType")
@XmlEnum
public enum FoodType {

    @XmlEnumValue("Indian")
    INDIAN("Indian"),
    @XmlEnumValue("Italian")
    ITALIAN("Italian"),
    @XmlEnumValue("Chinese")
    CHINESE("Chinese"),
    @XmlEnumValue("Thai")
    THAI("Thai"),
    @XmlEnumValue("Mexican")
    MEXICAN("Mexican");
    private final String value;

    FoodType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static FoodType fromValue(String v) {
        for (FoodType c: FoodType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
