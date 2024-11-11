<%-- 
    Document   : resultado
    Created on : 3 nov. 2024, 14:34:03
    Author     : chris
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Resultado de la Conversión</title>
</head>
<body>
    <h1>Resultado de la Conversión</h1>

    <c:if test="${not empty resultado}">
        <p>El resultado de la conversión es: ${resultado}</p>
    </c:if>

    <c:if test="${not empty error}">
        <p style="color: red;">${error}</p>
    </c:if>

    <a href="convertirLongitud.jsp">Volver</a>
</body>
</html>

