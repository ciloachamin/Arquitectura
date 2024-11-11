using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;

namespace WS_ConUni_SOAPDOTNET
{
    // NOTA: puede usar el comando "Rename" del menú "Refactorizar" para cambiar el nombre de interfaz "IConversorLongitudServicio" en el código y en el archivo de configuración a la vez.
    [ServiceContract]
    public interface IConversorLongitudServicio
    {
        [OperationContract]
        double ConvertirLongitud(double valor, string unidadOrigen, string unidadDestino);
    }
}
