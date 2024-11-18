/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package ec.edu.monster.servicios;

/**
 * REST Web Service
 *
 * @author chris
 */
import ec.edu.monster.modelos.UserLogin;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("conversion")
public class ConversorLongitudServicio {

    @GET
    @Path("/inchesToCm/{inches}")
    @Produces(MediaType.TEXT_PLAIN)
    public double inchesToCm(@PathParam("inches") double inches) {
        return inches * 2.54;
    }

    @GET
    @Path("/cmToInches/{cm}")
    @Produces(MediaType.TEXT_PLAIN)
    public double cmToInches(@PathParam("cm") double cm) {
        return cm / 2.54;
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
