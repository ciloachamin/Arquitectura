<%-- 
    Document   : index
    Created on : 3 nov. 2024, 14:33:34
    Author     : chris
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Conversor de Longitud</title>
</head>
<body>
    <h1>Conversor de Longitud</h1>
    <form action="ConversorLongitudController" method="get">
        <input type="hidden" name="accion" value="convertir"/>
        <label for="valor">Valor:</label>
        <input type="text" id="valor" name="valor" required/><br/><br/>
        
        <label for="unidadOrigen">Unidad de Origen:</label>
        <select id="unidadOrigen" name="unidadOrigen" required>
            <option value="metro">Metros</option>
            <option value="kilometro">Kilómetros</option>
            <option value="milla">Millas</option>
            <option value="pie">Pies</option>
            <!-- Agrega más unidades según sea necesario -->
        </select><br/><br/>
        
        <label for="unidadDestino">Unidad de Destino:</label>
        <select id="unidadDestino" name="unidadDestino" required>
            <option value="metro">Metros</option>
            <option value="kilometro">Kilómetros</option>
            <option value="milla">Millas</option>
            <option value="pie">Pies</option>
            <!-- Agrega más unidades según sea necesario -->
        </select><br/><br/>
        
        <button type="submit">Convertir</button>
    </form>

    <c:if test="${not empty error}">
        <div style="color: red;">${error}</div>
    </c:if>
</body>
</html>
