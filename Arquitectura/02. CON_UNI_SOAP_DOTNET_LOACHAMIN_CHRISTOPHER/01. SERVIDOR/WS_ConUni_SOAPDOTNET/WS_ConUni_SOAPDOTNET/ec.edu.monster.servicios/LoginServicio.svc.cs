using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Security.Cryptography;
using System.ServiceModel;
using System.Text;
using WS_ConUni_SOAPDOTNET.ec.edu.monster.modelos;

namespace WS_ConUni_SOAPDOTNET.ec.edu.monster.servicios
{
    // NOTA: puede usar el comando "Rename" del menú "Refactorizar" para cambiar el nombre de clase "LoginServicio" en el código, en svc y en el archivo de configuración a la vez.
    // NOTA: para iniciar el Cliente de prueba WCF para probar este servicio, seleccione LoginServicio.svc o LoginServicio.svc.cs en el Explorador de soluciones e inicie la depuración.
    public class LoginServicio : ILoginServicio
    {
        // Usuario quemado con contraseña encriptada
        private static readonly Usuario UsuarioValido = new Usuario("MONSTER", "MONSTER9");

        public bool Login(string username, string password)
        {
            // Validar que el usuario y la contraseña sean correctos
            return UsuarioValido.Username.Equals(username, StringComparison.OrdinalIgnoreCase) &&
                   UsuarioValido.ValidatePassword(password);
        }
    }
}
