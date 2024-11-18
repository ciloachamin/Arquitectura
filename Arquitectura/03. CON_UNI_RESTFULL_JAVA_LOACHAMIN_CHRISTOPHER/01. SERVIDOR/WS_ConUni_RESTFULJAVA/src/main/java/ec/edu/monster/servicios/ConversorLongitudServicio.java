package ec.edu.monster.servicios;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

/**
 *
 * @author
 */
@Path("conversion")
public class ConversorLongitudServicio {

    @GET
    public Response ping() {
        return Response
                .ok("ping Jakarta EE")
                .build();
    }

    @GET
    @Path("/inchesToCm/{inches}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response inchesToCm(@PathParam("inches") double inches) {
        double centimeters = inches * 2.54;
        return Response.ok(centimeters + " cm").build();
    }

    @GET
    @Path("/cmToInches/{cm}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response cmToInches(@PathParam("cm") double cm) {
        double inches = cm / 2.54;
        return Response.ok(inches + " inches").build();
    }

}
