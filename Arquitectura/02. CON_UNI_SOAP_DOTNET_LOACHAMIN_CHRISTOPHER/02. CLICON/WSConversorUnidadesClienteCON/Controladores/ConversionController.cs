using ConversorLongitudServicioReferencia;
using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using WSConversorUnidadesClienteCON.Vistas;

namespace WSConversorUnidadesClienteCON.Controladores
{
    public class ConversionController
    {
        private readonly ConsoleView _view;
        private readonly ConversorLongitudServicioClient _serviceClient;

        public ConversionController(ConsoleView view, ConversorLongitudServicioClient serviceClient)
        {
            _view = view;
            _serviceClient = serviceClient;
        }

        public ConversorLongitudServicioClient Get_serviceClient()
        {
            return _serviceClient;
        }

        public async Task ConvertLength()
        {
            while (true)
            {
                // Solicitar valor para convertir
                double value = _view.GetConversionValue();

                // Solicitar unidades
                string unitFrom = _view.GetConversionUnit("From unit");
                string unitTo = _view.GetConversionUnit("To unit");

                // Verificar si el usuario quiere salir
                if (unitFrom.ToLower() == "salir" || unitTo.ToLower() == "salir")
                {
                    Console.WriteLine("Saliendo de la conversión.");
                    break; // Termina el ciclo y sale
                }

                // Verificar si el servicio es accesible y la respuesta es válida
                try
                {
                    Console.WriteLine($"Convirtiendo {value} de {unitFrom} a {unitTo}...");

                    // Crear el objeto de solicitud
                    ConvertirLongitudRequest request = new ConvertirLongitudRequest(value, unitFrom, unitTo);

                    ConvertirLongitudResponse response = _serviceClient.ConvertirLongitud(request);
                    double resultadoConvertido = response.ConvertirLongitudResult;

                    // Verificar si el resultado es válido
                    if (resultadoConvertido != 0)
                    {
                        _view.ShowConversionResult(resultadoConvertido);
                    }
                    else
                    {
                        Console.WriteLine("No se pudo realizar la conversión. Revise las unidades o el servicio.");
                    }
                }
                catch (Exception ex)
                {
                    Console.WriteLine($"Error al llamar al servicio: {ex.Message}");
                }
            }
        }
    }

}