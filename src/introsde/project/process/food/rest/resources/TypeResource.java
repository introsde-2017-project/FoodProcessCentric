package introsde.project.process.food.rest.resources;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import introsde.project.process.food.rest.model.BusinessService;


@Path("/types")
public class TypeResource {
	
	@Path("/f")
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response getFoodTypes(){
         
		return Response.ok(BusinessService.getFoodTypes()).build();
    }

}
