using System;
using WSConversorUnidadesClienteCON.Controladores;
using WSConversorUnidadesClienteCON.Vistas;
using WSConversorUnidadesClienteCON.Modelos;
using ConversorLongitudServicioReferencia;

namespace WSConversorUnidadesClienteCON
{
    class Program
    {
        static void Main(string[] args)
        {
            var view = new ConsoleView();
            var authController = new AuthController(view);
            var serviceClient = new ConversorLongitudServicioClient();
            var conversionController = new ConversionController(view, serviceClient);



            // Se repetirá hasta que el usuario ingrese el login correctamente
            if (authController.Login())
            {
                Console.Clear();
                // Realiza la conversión hasta que el usuario decida salir
                conversionController.ConvertLength();
            }
            else
            {
                Console.WriteLine("Acceso denegado. Cerrando la aplicación.");
            }

            serviceClient.Close();
            Console.WriteLine("Presiona cualquier tecla para salir...");
            Console.ReadKey();
        }
    }

}
