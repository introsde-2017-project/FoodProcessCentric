
package introsde.project.business.soap;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import introsde.project.data.local.soap.FoodType;


/**
 * <p>Java class for getFoodTypesResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getFoodTypesResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FoodTypeList" type="{http://soap.local.data.project.introsde/}foodType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getFoodTypesResponse", propOrder = {
    "foodTypeList"
})
public class GetFoodTypesResponse {

    @XmlElement(name = "FoodTypeList")
    @XmlSchemaType(name = "string")
    protected List<FoodType> foodTypeList;

    /**
     * Gets the value of the foodTypeList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the foodTypeList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFoodTypeList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FoodType }
     * 
     * 
     */
    public List<FoodType> getFoodTypeList() {
        if (foodTypeList == null) {
            foodTypeList = new ArrayList<FoodType>();
        }
        return this.foodTypeList;
    }

}
