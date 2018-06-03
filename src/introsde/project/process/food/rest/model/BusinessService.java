package introsde.project.process.food.rest.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import introsde.project.adopter.recombee.soap.Evaluation;
import introsde.project.adopter.recombee.soap.ItemObject;
import introsde.project.adopter.recombee.soap.RecombeeDBType;
import introsde.project.business.soap.BusinessImplService;
import introsde.project.business.soap.BusinessInterface;
import introsde.project.data.local.soap.FoodType;
import introsde.project.data.local.soap.Person;

public class BusinessService {
	private static BusinessImplService serviceImp =  new BusinessImplService();
	private static BusinessInterface serviceInt = serviceImp.getBusinessImplPort();
	private static RecombeeDBType dbName= RecombeeDBType.FOOD_DB;
	
	/////////LOCAL DB
	public static Person getPersonByU(String userName) {
		return serviceInt.getUser(userName);
	}

	public static Person addPerson(Person person) {
		return serviceInt.addNewUser(person);
	}
	
	//////////FOOD RECOMBEE DB
	public static List<ItemObject> getFoodRecom(Person person, int quantity) {
		return serviceInt.getRecommendations(dbName, person, quantity);
	}

	public static boolean addFoodRating(Person person, Evaluation rating) {
		return serviceInt.addNewRating(dbName, rating);
	}

	@SuppressWarnings("unchecked")
	public static Map<String,Object> getFood(String foodName) {
		return (Map<String, Object>) serviceInt.getItem(dbName, foodName);
	}

	public static List<Evaluation> getUserRatings(Person u) {
		List<Evaluation> e= new LinkedList<Evaluation>();
		for(Evaluation ev:serviceInt.getUserRatings(dbName, u)) {
			System.out.println(ev.getItemId());
			double r=ev.getRating();
			ev.setRating((r*2)+3);
			e.add(ev);
		}
		return e;
	}

	//TODO not used
	public static boolean modifyRating(Person person, Evaluation rating) {
		return serviceInt.modifyRating(dbName, rating);
	}

	//TODO not used
	public static List<Evaluation> getFoodRatings(String foodName) {
		return serviceInt.getItemRatings(dbName, foodName);
	}

	//TODO not used
	public static List<Person> getAllUsers() {
		return serviceInt.getAllUser();
	}

	//TODO not used
	public static List<ItemObject> getAllFoods() {
		return serviceInt.getAllItem(dbName);
	}

	public static List<ItemObject> getFoodByType(String foodType) {
		return serviceInt.getItemsByType(dbName, foodType);
	}

	public static Person getPersonByToken(String token) {
		return serviceInt.getPersonByToken(token);
	}

	public static void updatePerson(Person u) {
		serviceInt.updateUser(u);
	}

	public static List<FoodType> getFoodTypes() {
		return serviceInt.getFoodTypes();
	}

	public static boolean addUserRatings(Person u, double d, String itemId) throws ParseException {
		Evaluation e= new Evaluation();
		e.setUserId(Integer.toString(u.getIdPerson()));
		e.setRating(d);
		e.setTime(DateToXML.GregorianCalendar(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(LocalDateTime.now().toString())));
		e.setItemId(itemId);
		return serviceInt.addNewRating(dbName, e);
	}


}