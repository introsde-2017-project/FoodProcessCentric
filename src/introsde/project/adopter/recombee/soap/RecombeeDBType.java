
package introsde.project.adopter.recombee.soap;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for recombeeDBType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="recombeeDBType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="foodDB"/>
 *     &lt;enumeration value="movieDB"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "recombeeDBType")
@XmlEnum
public enum RecombeeDBType {

    @XmlEnumValue("foodDB")
    FOOD_DB("foodDB"),
    @XmlEnumValue("movieDB")
    MOVIE_DB("movieDB");
    private final String value;

    RecombeeDBType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static RecombeeDBType fromValue(String v) {
        for (RecombeeDBType c: RecombeeDBType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
