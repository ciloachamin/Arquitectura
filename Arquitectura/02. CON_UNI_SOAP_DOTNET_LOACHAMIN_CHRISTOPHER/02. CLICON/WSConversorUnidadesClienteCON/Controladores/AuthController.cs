using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using WSConversorUnidadesClienteCON.Modelos;
using WSConversorUnidadesClienteCON.Vistas;

namespace WSConversorUnidadesClienteCON.Controladores
{
    public class AuthController
    {
        private readonly User _validUser = new User("admin", "123456"); // Datos quemados
        private readonly ConsoleView _view;

        public AuthController(ConsoleView view)
        {
            _view = view;
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

                if (username == _validUser.Username && password == _validUser.Password)
                {
                    _view.ShowLoginSuccess();
                    isAuthenticated = true;
                }
                else
                {
                    _view.ShowLoginError();
                }
            }
            return isAuthenticated;
        }
    }

}
