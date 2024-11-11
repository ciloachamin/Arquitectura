<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Conversión de Longitud</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }
        h1 {
            text-align: center;
            color: #333;
        }
        .form-container {
            width: 50%;
            margin: 50px auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.1);
        }
        label {
            display: block;
            margin-bottom: 8px;
            font-size: 14px;
        }
        input[type="number"], select {
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
            font-size: 16px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        button {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            font-size: 16px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        button:hover {
            background-color: #45a049;
        }
        a {
            color: #333;
            text-decoration: none;
            font-size: 14px;
        }
        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <h1>Conversor de Longitud</h1>
    <div class="form-container">
        <form action="convertirLongitud" method="post">
            <label for="valor">Ingrese el valor:</label>
            <input type="number" id="valor" name="valor" min="0" required><br>

            <label for="unidadOrigen">Unidad de Origen:</label>
            <select id="unidadOrigen" name="unidadOrigen" required>
                <option value="metro">Metros</option>
                <option value="kilometro">Kilómetros</option>
                <option value="centimetro">Centímetros</option>
            </select><br>

            <label for="unidadDestino">Unidad de Destino:</label>
            <select id="unidadDestino" name="unidadDestino" required>
                <option value="metro">Metros</option>
                <option value="kilometro">Kilómetros</option>
                <option value="centimetro">Centímetros</option>
            </select><br>

            <button type="submit">Convertir</button>
        </form>
    </div>
</body>
</html>
