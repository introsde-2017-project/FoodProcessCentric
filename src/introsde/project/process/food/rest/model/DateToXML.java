package introsde.project.process.food.rest.model;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class DateToXML {
	public DateToXML(Date parse) {
		// TODO Auto-generated constructor stub
	}

	public static XMLGregorianCalendar GregorianCalendar(Date date
			//, TimeZone zone
			) {
	    XMLGregorianCalendar xmlGregorianCalendar = null;
	    GregorianCalendar gregorianCalendar = new GregorianCalendar();
	    gregorianCalendar.setTime(date);
	    //gregorianCalendar.setTimeZone(zone);
	    try {
	      DatatypeFactory dataTypeFactory = DatatypeFactory.newInstance();
	      xmlGregorianCalendar = dataTypeFactory.newXMLGregorianCalendar(gregorianCalendar);
	    }
	    catch (Exception e) {
	      System.out.println("Exception in conversion of Date to XMLGregorianCalendar" + e);
	    }
	    
	    return xmlGregorianCalendar;
	  }

}
