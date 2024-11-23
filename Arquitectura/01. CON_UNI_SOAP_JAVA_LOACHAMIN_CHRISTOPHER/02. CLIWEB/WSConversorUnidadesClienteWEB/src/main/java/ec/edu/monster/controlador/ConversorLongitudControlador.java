package ec.edu.monster.controlador;

import ec.edu.monster.modelos.dtos.ConversionRequest;
import ec.edu.monster.modelos.dtos.ConversionResponse;
import ec.edu.monster.servicios.ConversorLongitudServicio;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/convertirLongitud")
public class ConversorLongitudControlador extends HttpServlet {
    private final ConversorLongitudServicio conversorLongitudServicio = new ConversorLongitudServicio();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Obtener los parámetros del formulario
            double valor = Double.parseDouble(request.getParameter("valor"));
            String unidadOrigen = request.getParameter("unidadOrigen");
            String unidadDestino = request.getParameter("unidadDestino");

            // Crear la solicitud de conversión
            ConversionRequest conversionRequest = new ConversionRequest();
            conversionRequest.setValor(valor);
            conversionRequest.setUnidadOrigen(unidadOrigen);
            conversionRequest.setUnidadDestino(unidadDestino);

            // Realizar la conversión
            ConversionResponse conversionResponse = conversorLongitudServicio.convertirLongitud(conversionRequest);

            // Agregar el resultado al atributo de la solicitud
            request.setAttribute("resultado", conversionResponse.getResultado());
        } catch (NumberFormatException e) {
            request.setAttribute("error", "Por favor ingrese un valor válido.");
        }

        // Redirigir a la página de resultados
        request.getRequestDispatcher("convertirLongitud.jsp").forward(request, response);
    }
}
