<?php
// Información de la base de datos
$dsn = 'mysql:host=localhost;dbname=eurekabank';
$username = 'pardosv';
$password = 'sandoval21';

// URL del servicio web WSDL
$wsdl = "http://localhost:8080/WS_Eureka/WSEureka?wsdl";

// Inicializar variables
$accountNumber = '';
$movements = [];
$errorMessage = '';

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $accountNumber = $_POST['accountNumber'];

    try {
        // Crear cliente SOAP
        $client = new SoapClient($wsdl);

        // Parámetros de la solicitud SOAP
        $params = [
            'numeroCuenta' => $accountNumber
        ];

        // Mostrar los parámetros enviados al servicio web
        echo "<script>console.log('SOAP Request Parameters: " . json_encode($params) . "');</script>";

        // Realizar la solicitud SOAP
        $response = $client->traerMovimientos($params);

        // Mostrar la respuesta recibida del servicio web
        echo "<script>console.log('SOAP Response: " . json_encode($response) . "');</script>";

        // Procesar la respuesta SOAP
        if (isset($response->return) && !empty($response->return)) {
            $movements = is_array($response->return) ? $response->return : [$response->return];
        }
    } catch (SoapFault $e) {
        $errorMessage = "Error al conectarse al servicio web: " . $e->getMessage();
    }

    try {
        // Conexión a la base de datos
        $db = new PDO($dsn, $username, $password);
        $db->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

        // Consulta para obtener los movimientos de la cuenta
        $query = "SELECT dtt_movifecha AS fecha, chr_tipocodigo AS tipo, dec_moviimporte AS monto 
                  FROM movimiento 
                  WHERE chr_cuencodigo = :accountNumber";
        $stmt = $db->prepare($query);
        $stmt->bindParam(':accountNumber', $accountNumber, PDO::PARAM_STR);

        // Mostrar la consulta SQL y los parámetros
        echo "<script>console.log('SQL Query: " . $query . "');</script>";
        echo "<script>console.log('SQL Parameters: " . json_encode(['accountNumber' => $accountNumber]) . "');</script>";

        $stmt->execute();

        // Obtener resultados
        $dbMovements = $stmt->fetchAll(PDO::FETCH_ASSOC);

        // Mostrar los resultados obtenidos de la base de datos
        echo "<script>console.log('Database Movements: " . json_encode($dbMovements) . "');</script>";

        // Merge movimientos from database with movimientos from SOAP
        if (!empty($dbMovements)) {
            foreach ($dbMovements as $dbMovement) {
                $movements[] = (object) $dbMovement;
            }
        }
    } catch (PDOException $e) {
        $errorMessage = "Error en la conexión a la base de datos: " . $e->getMessage();
    }
}
?>

<!DOCTYPE html>
<html>

<head>
    <title>Consultar Movimientos</title>
    <style>
        body {
            background-image: url('https://cdn.wallpapersafari.com/93/68/A1lEJ5.jpg');
            background-size: cover;
            /* Ajusta la imagen para que cubra todo el fondo */
            background-repeat: no-repeat;
            /* Evita que la imagen se repita */
            font-family:'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif; /* Fuente */
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }

        .container {
            width: 100%;
            max-width: 600px;
            margin: 50px auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
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

        form {
            text-align: center;
        }

        input[type="text"] {
            width: calc(100% - 20px);
            padding: 10px;
            margin: 10px 0;
            border-radius: 4px;
            border: 1px solid #ccc;
            box-sizing: border-box;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th,
        td {
            padding: 10px;
            border: 1px solid #ddd;
            text-align: left;
        }

        th {
            background-color: #f4f4f4;
        }

        h1,
        h2 {
            text-align: center;
        }

        .error-message {
            color: red;
            text-align: center;
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
    </style>
</head>

<body>
    <nav>
        <a href="../index.php">Inicio</a>
        <a href="realizarDeposito.php">Realizar Depósito</a>
    </nav>
    <div class="container">
        <h1>Consultar Movimientos</h1>
        <form method="post" action="">
            <label for="accountNumber">Número de Cuenta:</label>
            <input type="text" id="accountNumber" name="accountNumber" value="<?php echo htmlspecialchars($accountNumber); ?>" required>
            <input type="submit" value="Consultar" class="button">
        </form>

        <?php if ($errorMessage) : ?>
            <p class="error-message"><?php echo htmlspecialchars($errorMessage); ?></p>
        <?php endif; ?>

        <?php if (!empty($movements)) : ?>
            <h2>Movimientos</h2>
            <table>
                <tr>
                    <th>Fecha</th>
                    <th>Tipo</th>
                    <th>Monto</th>
                </tr>
                <?php foreach ($movements as $movement) : ?>
                    <tr>
                        <td><?php echo htmlspecialchars($movement->fecha); ?></td>
                        <td><?php echo htmlspecialchars($movement->tipo); ?></td>
                        <td><?php echo htmlspecialchars($movement->monto); ?></td>
                    </tr>
                <?php endforeach; ?>
            </table>
        <?php elseif ($_SERVER['REQUEST_METHOD'] === 'POST' && empty($movements) && !$errorMessage) : ?>
            <p>No se encontraron movimientos para el número de cuenta ingresado.</p>
        <?php endif; ?>
    </div>
</body>

</html>