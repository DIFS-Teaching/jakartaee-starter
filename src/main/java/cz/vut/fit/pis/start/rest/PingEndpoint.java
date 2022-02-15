package cz.vut.fit.pis.start.rest;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

/*
 * TEST URL:
 * http://localhost:8080/jakartaee-starter/rest/ping
 */
@Stateless
@Path("/ping")
public class PingEndpoint 
{

    /**
     * Default constructor. 
     */
    public PingEndpoint() 
    {
    }

    @Path("/")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String ping() 
    {
        return "ok";
    }

    @Path("/json")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public DataBean getJson() 
    {
        return new DataBean("ok", "Everything works!");
    }

    @Path("/json/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson(@PathParam("id") int id) 
    {
        if (id <= 10) {
            return Response.ok(new DataBean("ok", "Code " + id + " is ok!")).build();
        } else {
            return Response.status(Status.NOT_FOUND)
                    .entity(new DataBean("error", "Code " + id + " not found!"))
                    .build();
        }
    }


}