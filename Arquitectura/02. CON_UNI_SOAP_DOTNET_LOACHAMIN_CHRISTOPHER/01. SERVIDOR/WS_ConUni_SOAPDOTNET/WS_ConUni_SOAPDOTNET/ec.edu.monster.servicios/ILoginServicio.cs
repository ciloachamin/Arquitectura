using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;

namespace WS_ConUni_SOAPDOTNET.ec.edu.monster.servicios
{
    // NOTA: puede usar el comando "Rename" del menú "Refactorizar" para cambiar el nombre de interfaz "ILoginServicio" en el código y en el archivo de configuración a la vez.
    [ServiceContract]
    public interface ILoginServicio
    {
        [OperationContract]
        bool Login(string username, string password);
    }
}
