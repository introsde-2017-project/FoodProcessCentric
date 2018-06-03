package introsde.project.process.food.rest.resources;


import javax.persistence.EntityExistsException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import introsde.project.data.local.soap.Person;
import introsde.project.process.food.rest.model.BusinessService;
import introsde.project.process.food.rest.model.Credentials;
import introsde.project.process.food.rest.model.randomStringGenerator;

//import java.util.Base64;
//import java.util.List;

@Path("/user")
public class UserResource {
	
    //adding a new person in local, food recombee and movie recombee DATABASE
    @Path("/signup")
    @POST
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON}) 
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response newPerson(Person person) {
    	try {
        System.out.println("Creating new person...");
        if(BusinessService.getPersonByU(person.getUserName())!=null)
        	throw new EntityExistsException();
        if(BusinessService.addPerson(person)==null) 
        	throw new Exception();
        
       	return Response.ok().build();
    	}catch (EntityExistsException e) {
            return Response.status(Response.Status.CONFLICT)
            		.build();
        } catch (Exception e) {
        	return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
            		.build();
		}
    }
    
  //adding a new person in local, food recombee and movie recombee DATABASE
    @Path("/auth")
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response getAuth(@Context HttpHeaders headers) {
    	try {
        	System.out.println("search Food by given Types: ");
        	
        	String authString = headers.getRequestHeader("authorization").get(0);
        	String token = authString.substring("Bearer".length()).trim();
        	
        	Person u=getAuthPerson(token);
        	if(!token.equals(u.getToken()))
        		throw new Exception();
        	return Response.ok(true).build();
    	}
    	catch (Exception e){
    		return Response.ok(false).build();
    	}
    }
    
    //adding a new person in local, food recombee and movie recombee DATABASE
    @Path("/detail")
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response getPerson(@Context HttpHeaders headers) {
    	try {
        	System.out.println("search Food by given Types: ");
        	
        	String authString = headers.getRequestHeader("authorization").get(0);
        	String token = authString.substring("Bearer".length()).trim();
        	
        	Person u=getAuthPerson(token);
        	if(!token.equals(u.getToken()))
        		throw new Exception();
        	u.setPassword(null);
        	u.setToken(null);
        	return Response.ok(u).build();
    	}
    	catch (Exception e){
    		return Response.status(Response.Status.UNAUTHORIZED).build();
    	}
    }
    
    //get a person object in return when passing valid username and password
    @Path("/login")
    @POST
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response getUser(Credentials credentials){
    	System.out.println("Getting User by username and password...");

        String username = credentials.getUsername();
        String password = credentials.getPassword();
        
        try {

            // Authenticate the user using the credentials provided
            Person u=getAuthentication(username, password);
//            if(u.getToken()!=null)
//            	throw new Exception();

            // Issue a token for the user
            String token = "{ \"token\" : \""+issueToken(u) +"\" }";

            // Return the token on the response
            return Response.ok(token)
        			.build();

        } catch (Exception e) {
            return Response.status(Response.Status.UNAUTHORIZED)
            		.build();
        }
    }
    
    //TODO to be removed
    //this returns the list of usernames of all the user saved in user DATABASE
    @Path("/getallusers")
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response getAll(){
        	return Response.ok(BusinessService.getAllUsers()).build();
    }
    
    //TODO to be removed
    //this returns the list of usernames of all the user saved in user DATABASE
    @Path("/getallfoods")
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response getAllFoods(){
        	return Response.ok(BusinessService.getAllFoods()).build();
    }
    
   
    
//    //get all the ratings evaluated by a user, by user's username
//    @Path("/getratings/u/{userName}")
//    @GET
//    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public List<Evaluation> getFoodRatings(@PathParam("userName") String userName, @HeaderParam("authorization") String authString){
//		Person person= getAuthentication(authString);
//        if(person==null)
//        	return null;
//        else
//        	return BusinessService.getUserRatings(userName);
//    }
    
    private Person getAuthentication(String username, String password) throws Exception{
		Person p=BusinessService.getPersonByU(username);
		if(p.getPassword().equals(password))
			return p;
		else
			throw new Exception(" invalid username password");
		
	}
    
//    //admin can add new food in the Recombee DataBase
//    @Path("/admin/add/f/{foodName}/{foodType}/{location}")
//    @POST
//    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public ItemObject addNewFood(@HeaderParam("authorization") String authString, 
//    		@PathParam("foodName") String foodName, 
//    		@PathParam("foodType") String foodType,
//    		@PathParam("location") String location){
//		if(!admin(authString))
//			return null;
//        else
//        	return BusinessService.addNewFood(foodName,foodType,location);
//    }
    

	private String issueToken(Person u) throws Exception {
		String token = randomStringGenerator.generateString();
		
		u.setToken(token);
		BusinessService.updatePerson(u);
		return token;
	}
	
	private Person getAuthPerson(String token) throws Exception {
		Person u=BusinessService.getPersonByToken(token);
    	if(u == null) 
    		throw new Exception();
    	return u;
	}
    
//    private boolean admin(String authCredentials) {
//    	if (null == authCredentials)
//			return false;
//		// header value format will be "Basic encodedstring" for Basic
//		// authentication. Example "Basic YWRtaW46YWRtaW4="
//		final String encodedUserPassword = authCredentials.replaceFirst("Basic"
//				+ " ", "");
//		String usernameAndPassword = null;
//		try {
//			byte[] decodedBytes = Base64.getDecoder().decode(
//					encodedUserPassword);
//			usernameAndPassword = new String(decodedBytes, "UTF-8");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		final StringTokenizer tokenizer = new StringTokenizer(
//				usernameAndPassword, ":");
//		final String username = tokenizer.nextToken();
//		final String password = tokenizer.nextToken();
//
//		if(username.equals("admin") && password.equals("password"))
//			return true;
//		else
//			return false;
//	}
    
//    private Person getAuthentication(String authCredentials) {
//    	if (null == authCredentials)
//			return null;
//		// header value format will be "Basic encodedstring" for Basic
//		// authentication. Example "Basic YWRtaW46YWRtaW4="
//		final String encodedUserPassword = authCredentials.replaceFirst("Basic"
//				+ " ", "");
//		String usernameAndPassword = null;
//		try {
//			byte[] decodedBytes = Base64.getDecoder().decode(
//					encodedUserPassword);
//			usernameAndPassword = new String(decodedBytes, "UTF-8");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		final StringTokenizer tokenizer = new StringTokenizer(
//				usernameAndPassword, ":");
//		final String username = tokenizer.nextToken();
//		final String password = tokenizer.nextToken();
//
//		Person p=BusinessService.getPersonByU(username);
//		if(p.getPassword().equals(password))
//			return p;
//		else
//			return null;
//	}


}
