
package introsde.project.business.soap;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import introsde.project.adopter.recombee.soap.Evaluation;


/**
 * <p>Java class for getItemRatingsResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getItemRatingsResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ratingList" type="{http://soap.recombee.adopter.project.introsde/}evaluation" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getItemRatingsResponse", propOrder = {
    "ratingList"
})
public class GetItemRatingsResponse {

    protected List<Evaluation> ratingList;

    /**
     * Gets the value of the ratingList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ratingList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRatingList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Evaluation }
     * 
     * 
     */
    public List<Evaluation> getRatingList() {
        if (ratingList == null) {
            ratingList = new ArrayList<Evaluation>();
        }
        return this.ratingList;
    }

}
