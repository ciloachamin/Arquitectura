using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using WSConversorUnidadesClienteCON.Modelos;
using WSConversorUnidadesClienteCON.Vistas;
using LoginServicioReferencia;
using ConversorLongitudServicioReferencia;

namespace WSConversorUnidadesClienteCON.Controladores
{
    public class AuthController
    {
        private readonly ConsoleView _view;
        private readonly LoginServicioClient _loginService; // Cliente generado para el servicio SOAP

        public AuthController(ConsoleView view)
        {
            _view = view;
            _loginService = new LoginServicioClient(); // Inicializa el cliente SOAP
        }

        public bool Login()
        {
            bool isAuthenticated = false;

            // Repetir el login hasta que sea exitoso
            while (!isAuthenticated)
            {
                _view.ShowLogin();
                string username = _view.GetUsername();
                string password = _view.GetPassword();

                try
                {

                    // Crear el objeto de solicitud
                   LoginRequest request = new LoginRequest(username,password);

                    LoginResponse response = _loginService.Login(request);
                    bool resultadoConvertido = response.LoginResult;
                   
                    if (resultadoConvertido)
                    {
                        _view.ShowLoginSuccess();
                        isAuthenticated = true;
                    }
                    else
                    {
                        _view.ShowLoginError();
                    }
                }
                catch (Exception ex)
                {
                    Console.WriteLine($"Error al conectar con el servicio: {ex.Message}");
                }
            }
            return isAuthenticated;
        }
    }

}
