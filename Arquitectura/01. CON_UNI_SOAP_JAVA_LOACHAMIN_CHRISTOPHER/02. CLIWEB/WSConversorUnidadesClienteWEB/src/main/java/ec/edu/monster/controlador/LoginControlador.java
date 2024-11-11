/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.controlador;

/**
 *
 * @author chris
 */
import ec.edu.monster.servicios.LoginServicio;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginControlador extends HttpServlet {
    private final LoginServicio loginServicio = new LoginServicio();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtener los parámetros del formulario de login
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Llamar al servicio de login para validar las credenciales
        boolean isValid = loginServicio.validarCredenciales(username, password);

        if (isValid) {
            // Si las credenciales son correctas, redirigir a la página de conversión
            response.sendRedirect("convertirLongitud.jsp");
        } else {
            // Si las credenciales son incorrectas, mostrar un mensaje de error
            request.setAttribute("error", "Usuario o contraseña incorrectos.");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}
