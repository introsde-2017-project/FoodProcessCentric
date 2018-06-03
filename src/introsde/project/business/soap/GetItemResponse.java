
package introsde.project.business.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import introsde.project.adopter.recombee.soap.ItemObject;


/**
 * <p>Java class for getItemResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getItemResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ItemObject" type="{http://soap.recombee.adopter.project.introsde/}itemObject" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getItemResponse", propOrder = {
    "itemObject"
})
public class GetItemResponse {

    @XmlElement(name = "ItemObject")
    protected ItemObject itemObject;

    /**
     * Gets the value of the itemObject property.
     * 
     * @return
     *     possible object is
     *     {@link ItemObject }
     *     
     */
    public ItemObject getItemObject() {
        return itemObject;
    }

    /**
     * Sets the value of the itemObject property.
     * 
     * @param value
     *     allowed object is
     *     {@link ItemObject }
     *     
     */
    public void setItemObject(ItemObject value) {
        this.itemObject = value;
    }

}
