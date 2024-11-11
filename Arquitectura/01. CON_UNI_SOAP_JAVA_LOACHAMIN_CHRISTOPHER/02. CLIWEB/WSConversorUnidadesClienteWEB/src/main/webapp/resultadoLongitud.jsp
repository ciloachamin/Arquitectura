<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Resultado de la Conversión</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        .container {
            width: 50%;
            margin: 50px auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.1);
        }

        h1 {
            text-align: center;
            color: #333;
        }

        p {
            font-size: 16px;
            line-height: 1.6;
        }

        .error {
            color: red;
            font-weight: bold;
        }

        a {
            display: inline-block;
            margin-top: 20px;
            text-align: center;
            font-size: 16px;
            color: #007bff;
            text-decoration: none;
            padding: 8px 16px;
            border: 1px solid #007bff;
            border-radius: 4px;
            transition: background-color 0.3s, color 0.3s;
        }

        a:hover {
            background-color: #007bff;
            color: #fff;
        }

    </style>
</head>
<body>
    <div class="container">
        <h1>Resultado de la Conversión</h1>

        <c:if test="${not empty resultado}">
            <p>El resultado de la conversión es: <strong>${resultado}</strong></p>
        </c:if>

        <c:if test="${not empty error}">
            <p class="error">${error}</p>
        </c:if>

        <a href="index.jsp">Volver</a>
    </div>
</body>
</html>
