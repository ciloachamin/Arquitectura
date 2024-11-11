using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;

namespace WS_ConUni_SOAPDOTNET
{
    // NOTA: puede usar el comando "Rename" del menú "Refactorizar" para cambiar el nombre de clase "ConversorLongitudServicio" en el código, en svc y en el archivo de configuración a la vez.
    // NOTA: para iniciar el Cliente de prueba WCF para probar este servicio, seleccione ConversorLongitudServicio.svc o ConversorLongitudServicio.svc.cs en el Explorador de soluciones e inicie la depuración.
    public class ConversorLongitudServicio : IConversorLongitudServicio
    {
        private static readonly Dictionary<string, double> Unidades = new Dictionary<string, double>
    {
        { "metro", 1.0 },
        { "kilometro", 1000.0 },
        { "centimetro", 0.01 },
        { "milla", 1609.34 }
    };

        public double ConvertirLongitud(double valor, string unidadOrigen, string unidadDestino)
        {
            if (!Unidades.ContainsKey(unidadOrigen) || !Unidades.ContainsKey(unidadDestino))
                throw new ArgumentException($"Unidad no válida: {unidadOrigen} a {unidadDestino}");

            double valorEnMetros = valor * Unidades[unidadOrigen];
            return valorEnMetros / Unidades[unidadDestino];
        }
    }
}