$(document).ready(function() {
    // Capturar el envío del formulario
    $('#consultaMovimientosForm').submit(function(event) {
        // Evitar el comportamiento por defecto de enviar el formulario
        event.preventDefault();

        console.log('Formulario enviado');

        // Obtener el número de cuenta ingresado por el usuario
        var cuenta = $('#cuentaInput').val();
        console.log('Número de cuenta ingresado:', cuenta);

        // URL del servicio SOAP para obtener movimientos
        var url = 'http://localhost:8080/WS_Eureka/WSEureka';
        console.log('URL del servicio SOAP:', url);

        // Construir el cuerpo de la solicitud SOAP
        var soapRequest =
            '<?xml version="1.0" encoding="utf-8"?>' +
            '<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:ws="http://ws.monster.edu.ec/">' +
                '<soapenv:Header/>' +
                '<soapenv:Body>' +
                    '<ws:traerMovimientos>' +
                        '<numeroCuenta>' + cuenta + '</numeroCuenta>' +
                    '</ws:traerMovimientos>' +
                '</soapenv:Body>' +
            '</soapenv:Envelope>';

        console.log('Solicitud SOAP enviada:', soapRequest);

        // Realizar la petición AJAX SOAP
        $.ajax({
            type: 'POST',
            url: url,
            contentType: 'text/xml',
            dataType: 'xml',
            data: soapRequest,
            success: function(response) {
                console.log('Respuesta SOAP recibida:', response);

                // Limpiar tabla antes de agregar nuevos datos
                $('#movimientosTableBody').empty();

                // Parsear la respuesta XML y procesar los movimientos
                $(response).find('movimiento').each(function() {
                    var movimiento = $(this);
                    var row = '<tr>' +
                        '<td>' + movimiento.find('nromov').text() + '</td>' +
                        '<td>' + movimiento.find('fecha').text() + '</td>' +
                        '<td>' + movimiento.find('tipo').text() + '</td>' +
                        '<td>' + movimiento.find('accion').text() + '</td>' +
                        '<td>' + movimiento.find('importe').text() + '</td>' +
                        '<td>' + movimiento.find('referencia').text() + '</td>' +
                        '</tr>';
                    $('#movimientosTableBody').append(row);
                });
            },
            error: function(xhr, status, error) {
                console.error('Error al obtener movimientos:', status, error);
                alert('Error al obtener movimientos. Verifique la consola para más detalles.');
            }
        });
    });
});
