/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package ec.edu.monster.mavenproject2.resources;

import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author chris
 */
@Path("generic")
public class GenericResource {
    @GET
    @Path("convert")
    public Response convertMetersToKilometers(@QueryParam("meters") double meters) {
        // Realiza la conversión
        double kilometers = meters / 1000;

        // Devuelve la respuesta
        return Response
                .ok("Meters: " + meters + " -> Kilometers: " + kilometers)
                .build();
    }

    @GET
    @Path("/inchesToCm")
    @Produces(MediaType.TEXT_PLAIN)
    public double inchesToCm(@QueryParam("meters") double inches) {
        return inches * 2.54;
    }
}
