using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using WSConversorUnidadesClienteESC.ec.edu.monster.controladores;

namespace WSConversorUnidadesClienteESC.Vista
{
    public partial class LoginForm : Form
    {
        private LoginController _controlador;

        public LoginForm()
        {
            InitializeComponent();
            _controlador = new LoginController(this);
        }

        private void LoginForm_Load(object sender, EventArgs e)
        {
            this.FormBorderStyle = FormBorderStyle.FixedDialog;
            this.MaximizeBox = false;
            this.StartPosition = FormStartPosition.CenterScreen;
            this.Text = "Iniciar Sesión";
        }

        private void btnLogin_Click(object sender, EventArgs e)
        {
            _controlador.IniciarSesion(txtUsuario.Text, txtPassword.Text);
        }

        public void IniciarSesionExitosa()
        {
            this.DialogResult = DialogResult.OK; // Marca el formulario como éxito
            this.Close(); // Cierra la ventana de inicio de sesión
        }

        private void LoginForm_FormClosing(object sender, FormClosingEventArgs e)
        {
            if (this.DialogResult != DialogResult.OK)
            {
                Application.Exit(); // Asegura que la aplicación termine si no se inicia sesión correctamente
            }
        }

        private void logoLabel_Click(object sender, EventArgs e)
        {

        }

        private void lblUsuario_Click(object sender, EventArgs e)
        {

        }
    }
}
