using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WSConversorUnidadesClienteESC.Vista
{
    public partial class LoginForm : Form
    {
        public LoginForm()
        {
            InitializeComponent();
        }

        private void btnLogin_Click(object sender, EventArgs e)
        {
            // Simulación de login, en un caso real consultarías a un servicio de autenticación
            if (txtUsuario.Text == "admin" && txtPassword.Text == "admin123")
            {
                this.DialogResult = DialogResult.OK;
                this.Close();
            }
            else
            {
                MessageBox.Show("Credenciales incorrectas.");
            }
        }

        private void LoginForm_Load(object sender, EventArgs e)
        {

        }
    }
}
