
package introsde.project.data.local.soap;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for movieGen.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="movieGen">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Drama"/>
 *     &lt;enumeration value="Comedy"/>
 *     &lt;enumeration value="Romance"/>
 *     &lt;enumeration value="Action"/>
 *     &lt;enumeration value="Adventure"/>
 *     &lt;enumeration value="Thriller"/>
 *     &lt;enumeration value="Fiction"/>
 *     &lt;enumeration value="Animation"/>
 *     &lt;enumeration value="Horror"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "movieGen")
@XmlEnum
public enum MovieGen {

    @XmlEnumValue("Drama")
    DRAMA("Drama"),
    @XmlEnumValue("Comedy")
    COMEDY("Comedy"),
    @XmlEnumValue("Romance")
    ROMANCE("Romance"),
    @XmlEnumValue("Action")
    ACTION("Action"),
    @XmlEnumValue("Adventure")
    ADVENTURE("Adventure"),
    @XmlEnumValue("Thriller")
    THRILLER("Thriller"),
    @XmlEnumValue("Fiction")
    FICTION("Fiction"),
    @XmlEnumValue("Animation")
    ANIMATION("Animation"),
    @XmlEnumValue("Horror")
    HORROR("Horror");
    private final String value;

    MovieGen(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static MovieGen fromValue(String v) {
        for (MovieGen c: MovieGen.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
