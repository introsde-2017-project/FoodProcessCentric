package introsde.project.process.food.rest.resources;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.StringTokenizer;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import introsde.project.adopter.recombee.soap.Evaluation;
import introsde.project.data.local.soap.Person;
import introsde.project.process.food.rest.model.BusinessService;

@Path("/secure")
public class FoodResource {
	
	//get 5 food recommendation for a user
	 @Path("/recom/f/{quantity}")
	    @GET
	    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	    public Response getFoodRec(@Context HttpHeaders headers,@PathParam("quantity") int quantity){
	    	try {
	        	System.out.println("getting all user feedbacks");
	        	
	        	String authString = headers.getRequestHeader("authorization").get(0);
	        	String token = authString.substring("Bearer".length()).trim();
	        	
	        	Person u=getAuthenticationToken(token);
	        	if(!token.equals(u.getToken()))
	        		throw new Exception();
	        	return Response.ok(BusinessService.getFoodRecom(u,quantity)).build();
	    	}
	    	catch (Exception e){
	    		return Response.status(Response.Status.UNAUTHORIZED).build();
	    	}
	    }
	    
	 
	  //adding a new person in local, food recombee and movie recombee DATABASE
	    @Path("/get/myratings/f")
	    @GET
	    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON}) 
	    public Response getfoodRatings(@Context HttpHeaders headers) {
	    	try {
	        	System.out.println("getting all user feedbacks");
	        	
	        	String authString = headers.getRequestHeader("authorization").get(0);
	        	String token = authString.substring("Bearer".length()).trim();
	        	
	        	Person u=getAuthenticationToken(token);
	        	if(!token.equals(u.getToken()))
	        		throw new Exception();
	        	return Response.ok(BusinessService.getUserRatings(u)).build();
	    	}
	    	catch (Exception e){
	    		return Response.status(Response.Status.UNAUTHORIZED).build();
	    	}
	    }
	    
	    @Path("/add/rating/f/{itemId}/{rating}")
	    @GET
	    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	    public Response addFoodRatings(@Context HttpHeaders headers,@PathParam("itemId") String itemId,@PathParam("rating") int rating) {
	    	try {
	        	System.out.println("adding feedback " +(double) (rating-3)/2);
	        	
	        	String authString = headers.getRequestHeader("authorization").get(0);
	        	String token = authString.substring("Bearer".length()).trim();
	        	
	        	Person u=getAuthenticationToken(token);
	        	if(!token.equals(u.getToken()))
	        		throw new Exception();
	        	if(!BusinessService.addUserRatings(u,((double) (rating-3)/2),itemId)) {
	        		return Response.status(Response.Status.METHOD_NOT_ALLOWED).build();
	        	}
	        	return Response.ok().build();
	        	
	    	}
	    	catch (Exception e){
	    		return Response.status(Response.Status.BAD_REQUEST).build();
	    	}
	    }
	    
	    @Path("/getbytype/f/{foodType}")
	    @GET
	    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	    public Response getFoodByType(@Context HttpHeaders headers, @PathParam("foodType") String foodType){
	    	try {
	        	System.out.println("search Food by given Types: "+ foodType);
	        	
	        	String authString = headers.getRequestHeader("authorization").get(0);
	        	String token = authString.substring("Bearer".length()).trim();
	        	
	        	Person u=getAuthenticationToken(token);
	        	if(!token.equals(u.getToken()))
	        		throw new Exception();
	        	return Response.ok(BusinessService.getFoodByType(foodType)).build();
	    	}
	    	catch (Exception e){
	    		return Response.status(Response.Status.UNAUTHORIZED).build();
	    	}
	    }
	    
    
	//TODO not used
    @Path("/modifyrating/f")
    @PUT
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public boolean modifyRatings(Evaluation rating, @HeaderParam("authorization") String authString){
		Person person= getAuthentication(authString);
        if(person==null || BusinessService.getFood(rating.getItemId())==null)
        	return false;
        else
        	return BusinessService.modifyRating(person, rating);
    }
    
    //TODO not used
    @Path("/getratings/f/{foodName}")
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Evaluation> getFoodRatings(@PathParam("foodName") String foodName, @HeaderParam("authorization") String authString){
		Person person= getAuthentication(authString);
        if(person==null || BusinessService.getFood(foodName)==null)
        	return null;
        else
        	return BusinessService.getFoodRatings(foodName);
    }
   
    
    
    private Person getAuthenticationToken(String token) throws Exception {
		Person u=BusinessService.getPersonByToken(token);
    	if(u == null) 
    		throw new Exception();
    	return u;
	}
    
    
    //TODO: not used, to be removed 
    private Person getAuthentication(String authCredentials) {
    	if (null == authCredentials)
			return null;
		// header value format will be "Basic encodedstring" for Basic
		// authentication. Example "Basic YWRtaW46YWRtaW4="
		final String encodedUserPassword = authCredentials.replaceFirst("Basic"
				+ " ", "");
		String usernameAndPassword = null;
		try {
			byte[] decodedBytes = Base64.getDecoder().decode(
					encodedUserPassword);
			usernameAndPassword = new String(decodedBytes, "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
		final StringTokenizer tokenizer = new StringTokenizer(
				usernameAndPassword, ":");
		final String username = tokenizer.nextToken();
		final String password = tokenizer.nextToken();

		Person p=BusinessService.getPersonByU(username);
		if(p.getPassword().equals(password))
			return p;
		else
			return null;
	}

}
