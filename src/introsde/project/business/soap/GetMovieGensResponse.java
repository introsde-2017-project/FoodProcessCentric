
package introsde.project.business.soap;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import introsde.project.data.local.soap.MovieGen;


/**
 * <p>Java class for getMovieGensResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getMovieGensResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MovieGenList" type="{http://soap.local.data.project.introsde/}movieGen" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getMovieGensResponse", propOrder = {
    "movieGenList"
})
public class GetMovieGensResponse {

    @XmlElement(name = "MovieGenList")
    @XmlSchemaType(name = "string")
    protected List<MovieGen> movieGenList;

    /**
     * Gets the value of the movieGenList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the movieGenList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMovieGenList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MovieGen }
     * 
     * 
     */
    public List<MovieGen> getMovieGenList() {
        if (movieGenList == null) {
            movieGenList = new ArrayList<MovieGen>();
        }
        return this.movieGenList;
    }

}
