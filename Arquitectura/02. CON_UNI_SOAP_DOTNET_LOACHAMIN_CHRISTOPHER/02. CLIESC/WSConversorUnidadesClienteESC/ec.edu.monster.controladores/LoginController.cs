using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using WSConversorUnidadesClienteESC.ec.edu.monster.modelos;
using WSConversorUnidadesClienteESC.Vista;
using WSConversorUnidadesClienteESC.LoginServicioReferencia;

namespace WSConversorUnidadesClienteESC.ec.edu.monster.controladores
{
    public class LoginController
    {
        private LoginForm _vista;
        private LoginServicioClient _servicioLogin;

        public LoginController(LoginForm vista)
        {
            _vista = vista;
            _servicioLogin = new LoginServicioClient();
        }

        public void IniciarSesion(string username, string password)
        {
            try
            {
                if (string.IsNullOrEmpty(username) || string.IsNullOrEmpty(password))
                {
                    MessageBox.Show("Ingrese usuario y contraseña", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
                    return;
                }

                bool resultado = _servicioLogin.Login(username, password);

                if (resultado)
                {
                    MessageBox.Show("Inicio de sesión exitoso", "Éxito", MessageBoxButtons.OK, MessageBoxIcon.Information);
                    _vista.DialogResult = DialogResult.OK; // Configura el resultado como OK
                    _vista.Close(); // Cierra el formulario de inicio de sesión
                }

                else
                {
                    MessageBox.Show("Credenciales incorrectas", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show($"Error de servicio: {ex.Message}", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
        }
    }

}
