package introsde.project.process.food.rest.resources;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import introsde.project.data.local.soap.Person;
import introsde.project.process.food.rest.model.BusinessService;

@Path("/quotes")
public class QuoteResource {
	
	@Path("/get")
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response getFoodRec(@Context HttpHeaders headers){
    	try {
    		System.out.println("getting all user feedbacks");
        	
        	String authString = headers.getRequestHeader("authorization").get(0);
        	String token = authString.substring("Bearer".length()).trim();
        	
        	Person u=getAuthenticationToken(token);
        	if(!token.equals(u.getToken()))
        		throw new Exception();
        	
        	HttpURLConnection conn=getConnection();
    		
    		return Response.ok(getStringJSON(conn)).build();
    	}
    	catch (Exception e){
    		return Response.status(Response.Status.UNAUTHORIZED).build();
    	}
    }
    	
    private static HttpURLConnection getConnection() throws IOException {
   		URL url= new URL("https://talaikis.com/api/quotes/random/");
   		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
   		return conn;
   	}
    	
   	private static String getStringJSON(HttpURLConnection conn) throws IOException {
   		String body=null;
   		conn.setRequestMethod("GET");
   		conn.setRequestProperty("Accept", "application/json");
   		conn.setDoOutput(true);
   		conn.setDoInput(true);
    		
    	if (conn.getResponseCode() != 200) {
   			if(conn.getResponseCode()== 404)
   				return null;
   			throw new RuntimeException("Failed : HTTP error code : "
   					+ conn.getResponseCode());
   		}
   		else {
   			InputStream stream= conn.getInputStream();
   			BufferedReader br = new BufferedReader(new InputStreamReader((stream)));
   			body= br.readLine();
   		}
    	conn.disconnect();
    	return body;
    	}
    	
    private Person getAuthenticationToken(String token) throws Exception {
   		Person u=BusinessService.getPersonByToken(token);
       	if(u == null) 
       		throw new Exception();
       	return u;
   	}

}
