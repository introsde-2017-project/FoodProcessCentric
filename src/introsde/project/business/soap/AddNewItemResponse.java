
package introsde.project.business.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import introsde.project.adopter.recombee.soap.ItemObject;


/**
 * <p>Java class for addNewItemResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="addNewItemResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="StringId" type="{http://soap.recombee.adopter.project.introsde/}itemObject" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addNewItemResponse", propOrder = {
    "stringId"
})
public class AddNewItemResponse {

    @XmlElement(name = "StringId")
    protected ItemObject stringId;

    /**
     * Gets the value of the stringId property.
     * 
     * @return
     *     possible object is
     *     {@link ItemObject }
     *     
     */
    public ItemObject getStringId() {
        return stringId;
    }

    /**
     * Sets the value of the stringId property.
     * 
     * @param value
     *     allowed object is
     *     {@link ItemObject }
     *     
     */
    public void setStringId(ItemObject value) {
        this.stringId = value;
    }

}
