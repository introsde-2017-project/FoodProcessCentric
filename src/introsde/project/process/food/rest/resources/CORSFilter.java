package introsde.project.process.food.rest.resources;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;

@Provider
public class CORSFilter implements ContainerResponseFilter {

   @Override
   public void filter(final ContainerRequestContext requestContext,
                      final ContainerResponseContext cres
                      ) throws IOException {
	   MultivaluedMap<String, Object> responseHeaders = cres.getHeaders();
       String origin = requestContext.getHeaderString("Origin");
       if (null != origin ) {

           responseHeaders.putSingle("Access-Control-Allow-Origin", origin);
           responseHeaders.putSingle("Access-Control-Allow-Methods", 
               "GET, POST, OPTIONS, PUT, DELETE, HEAD");

           String reqHead = requestContext.getHeaderString(
               "Access-Control-Request-Headers");

           if (null != reqHead && !reqHead.equals("")) {
               responseHeaders.putSingle("Access-Control-Allow-Headers", reqHead);
           }
       }
   }
}


