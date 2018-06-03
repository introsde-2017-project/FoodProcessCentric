
package introsde.project.business.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for addNewRatingResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="addNewRatingResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="boolean" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addNewRatingResponse", propOrder = {
    "_boolean"
})
public class AddNewRatingResponse {

    @XmlElement(name = "boolean")
    protected boolean _boolean;

    /**
     * Gets the value of the boolean property.
     * 
     */
    public boolean isBoolean() {
        return _boolean;
    }

    /**
     * Sets the value of the boolean property.
     * 
     */
    public void setBoolean(boolean value) {
        this._boolean = value;
    }

}
