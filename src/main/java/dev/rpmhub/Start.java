package dev.rpmhub;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/api")
public class Start {

    private static final double MILES = 0.621;
    private static final double KNOT = 1.852;

    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from RESTEasy";
    }

    @POST
    @Path("/kmh2mih")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes("application/x-www-form-urlencoded")
    public double convertKmh2Mih(@FormParam("kmh") double kmh) {
        if(isZero(kmh))
            return kmh;
        
        return kmh * MILES;
    } 

    @GET
    @Path("/no2kmh/{value}")
    @Produces(MediaType.APPLICATION_JSON)
    public double convertNo2Kmh(@PathParam("value") double value) {
        if(isZero((value)))
            return value;

        return value * KNOT;
    }

    private boolean isZero(double value) {
        return value == 0;
    }
}
