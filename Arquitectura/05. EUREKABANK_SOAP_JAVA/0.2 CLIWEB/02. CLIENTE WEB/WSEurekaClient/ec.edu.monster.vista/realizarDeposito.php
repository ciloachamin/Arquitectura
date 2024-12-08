<?php
// Información de la base de datos
$dsn = 'mysql:host=localhost;dbname=eurekabank';
$username = 'pardosv';
$password = 'sandoval21';

// URL del servicio web WSDL
$wsdl = "http://localhost:8080/WS_Eureka/WSEureka?wsdl";

// Obtener los valores ingresados por el usuario
$accountNumber = isset($_POST['accountNumber']) ? $_POST['accountNumber'] : '';
$amount = isset($_POST['amount']) ? $_POST['amount'] : '';
$employeeCode = isset($_POST['employeeCode']) ? $_POST['employeeCode'] : '';

// Crear la solicitud SOAP para el servicio regDeposito
$request = "
<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ser=\"http://ws.monster.edu.ec/\">
    <soapenv:Header/>
    <soapenv:Body>
        <ser:regDeposito>
            <cuenta>{$accountNumber}</cuenta>
            <monto>{$amount}</monto>
            <empleado>{$employeeCode}</empleado>
        </ser:regDeposito>
    </soapenv:Body>
</soapenv:Envelope>
";

// Configuración de la solicitud CURL
$ch = curl_init($wsdl);
curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
curl_setopt($ch, CURLOPT_POST, true);
curl_setopt($ch, CURLOPT_POSTFIELDS, $request);
curl_setopt($ch, CURLOPT_HTTPHEADER, array(
    'Content-Type: text/xml; charset=utf-8',
    'Content-Length: ' . strlen($request)
));
curl_setopt($ch, CURLOPT_TIMEOUT, 5); // Tiempo de espera en segundos

// Ejecutar la solicitud CURL y obtener la respuesta
$response = curl_exec($ch);

// Verificar si hubo algún error
if ($response === false) {
    die('Error al realizar la solicitud SOAP: ' . curl_error($ch));
}

// Procesar la respuesta SOAP
$xml = simplexml_load_string($response);

// Verificar si el depósito se realizó correctamente
if (isset($xml->xpath('//codigo')[0]) && $xml->xpath('//codigo')[0] == 1) {
    echo 'Depósito realizado exitosamente.';
}

// Cerrar la conexión CURL
curl_close($ch);
?>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Realizar Depósito</title>
    <style>
        body {
            background-image: url('https://cdn.wallpapersafari.com/93/68/A1lEJ5.jpg');
            background-size: cover;
            /* Ajusta la imagen para que cubra todo el fondo */
            background-repeat: no-repeat;
            /* Evita que la imagen se repita */
            font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
            /* Fuente */
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }

        .container {
            max-width: 600px;
            margin: 50px auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        label {
            display: block;
            margin-bottom: 10px;
        }

        input[type="text"],
        input[type="submit"] {
            width: 100%;
            padding: 10px;
            border-radius: 4px;
            border: 1px solid #ccc;
            box-sizing: border-box;
            margin-bottom: 10px;
        }

        input[type="submit"] {
            background-color: #1a4d6e;
            /* Celeste oscuro */
            color: white;
            border: none;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #135e86;
            /* Celeste oscuro más oscuro */
        }

        nav {
            padding: 10px 0;
            background-color: #1a4d6e;
            /* Celeste oscuro */
            text-align: center;
        }

        nav a {
            color: white;
            text-decoration: none;
            margin: 0 10px;
        }

        .button {
            display: block;
            width: 100%;
            padding: 10px;
            background-color: #1a4d6e;
            /* Celeste oscuro */
            color: white;
            text-decoration: none;
            border-radius: 4px;
            font-size: 16px;
            margin-top: 10px;
            border: none;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
    </style>
</head>

<body>
    <nav>
        <a href="../index.php">Inicio</a>
        <a href="realizarConsultas.php9">Realizar Consulta</a>
    </nav>
    <div class="container">
        <h2>Realizar Depósito</h2>
        <form method="post" action="realizarDeposito.php">
            <label for="accountNumber">Número de Cuenta:</label>
            <input type="text" id="accountNumber" name="accountNumber" required>
            <label for="amount">Monto:</label>
            <input type="text" id="amount" name="amount" required>
            <label for="employeeCode">Código de Empleado:</label>
            <input type="text" id="employeeCode" name="employeeCode" required>
            <input type="submit" value="Realizar Depósito">
        </form>
    </div>
</body>

</html>