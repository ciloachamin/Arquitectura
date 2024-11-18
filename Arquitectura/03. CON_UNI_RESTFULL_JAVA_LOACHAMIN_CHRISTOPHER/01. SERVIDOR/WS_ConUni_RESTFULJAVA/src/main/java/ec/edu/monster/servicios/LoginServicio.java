/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package ec.edu.monster.servicios;

import ec.edu.monster.utils.PasswordUtil;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Path;
import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.io.StringReader;

/**
 * REST Web Service
 *
 * @author chris
 */
@Path("auth")
public class LoginServicio {

    private static final String USER = "MONSTER";
    private static final String HASHED_PASSWORD = "26591d262ae2c3d2320ff92ad90864d78e067022532041e8304688db882e7c69"; // Contraseña "password" en SHA-256

    @POST
    @Path("login")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(String requestBody) {
        System.out.println("Request recibido: " + requestBody);
        JsonReader jsonReader = Json.createReader(new StringReader(requestBody));
        JsonObject requestJson = jsonReader.readObject();
        String username = requestJson.getString("username", "");
        String password = requestJson.getString("password", "");

        if (USER.equals(username) && PasswordUtil.validatePassword(password, HASHED_PASSWORD)) {
            return Response.ok("Login exitoso").build();
        }
        return Response.status(Response.Status.UNAUTHORIZED).entity("Credenciales inválidas").build();
    }
}
