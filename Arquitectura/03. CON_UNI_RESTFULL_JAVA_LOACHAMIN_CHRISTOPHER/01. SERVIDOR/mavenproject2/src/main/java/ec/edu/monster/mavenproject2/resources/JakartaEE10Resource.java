package ec.edu.monster.mavenproject2.resources;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

/**
 *
 * @author
 */
@Path("jakartaee10")
public class JakartaEE10Resource {

    @GET
    public Response ping() {
        return Response
                .ok("ping Jakarta EE")
                .build();
    }

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

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(UserLogin credentials) {
        // Datos de usuario "quemados" (hard-coded)
        String validUsername = "MONSTER";
        String validPassword = "MONSTER9";

        // Validación de usuario y contraseña
        if (credentials.getUsername().equals(validUsername) && credentials.getPassword().equals(validPassword)) {
            return Response.ok("{\"message\": \"Login successful\"}")
                    .type(MediaType.APPLICATION_JSON)
                    .build();
        }
        // Respuesta en caso de credenciales inválidas
        return Response.status(Response.Status.UNAUTHORIZED)
                .entity("{\"message\": \"Invalid username or password\"}")
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}
