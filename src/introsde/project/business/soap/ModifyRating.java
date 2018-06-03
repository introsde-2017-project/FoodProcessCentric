
package introsde.project.business.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import introsde.project.adopter.recombee.soap.Evaluation;
import introsde.project.adopter.recombee.soap.RecombeeDBType;


/**
 * <p>Java class for modifyRating complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="modifyRating">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dbName" type="{http://soap.recombee.adopter.project.introsde/}recombeeDBType" minOccurs="0"/>
 *         &lt;element name="rating" type="{http://soap.recombee.adopter.project.introsde/}evaluation" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "modifyRating", propOrder = {
    "dbName",
    "rating"
})
public class ModifyRating {

    @XmlSchemaType(name = "string")
    protected RecombeeDBType dbName;
    protected Evaluation rating;

    /**
     * Gets the value of the dbName property.
     * 
     * @return
     *     possible object is
     *     {@link RecombeeDBType }
     *     
     */
    public RecombeeDBType getDbName() {
        return dbName;
    }

    /**
     * Sets the value of the dbName property.
     * 
     * @param value
     *     allowed object is
     *     {@link RecombeeDBType }
     *     
     */
    public void setDbName(RecombeeDBType value) {
        this.dbName = value;
    }

    /**
     * Gets the value of the rating property.
     * 
     * @return
     *     possible object is
     *     {@link Evaluation }
     *     
     */
    public Evaluation getRating() {
        return rating;
    }

    /**
     * Sets the value of the rating property.
     * 
     * @param value
     *     allowed object is
     *     {@link Evaluation }
     *     
     */
    public void setRating(Evaluation value) {
        this.rating = value;
    }

}
