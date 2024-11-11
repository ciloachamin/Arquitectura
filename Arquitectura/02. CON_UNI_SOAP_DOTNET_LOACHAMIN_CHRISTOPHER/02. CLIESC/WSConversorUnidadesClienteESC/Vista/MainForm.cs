using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using WSConversorUnidadesClienteESC.ConversorLongitudServicioReferencia;

namespace WSConversorUnidadesClienteESC.Vista
{
    public partial class MainForm : Form
    {
        public MainForm()
        {
            InitializeComponent();
        }

        private void MainForm_Load(object sender, EventArgs e)
        {
            cmbUnidadEntrada.Items.Add("metro");
            cmbUnidadEntrada.Items.Add("kilometro");
            cmbUnidadEntrada.Items.Add("milla");

            cmbUnidadSalida.Items.Add("metro");
            cmbUnidadSalida.Items.Add("kilometro");
            cmbUnidadSalida.Items.Add("milla");
        }

        private void btnConvertir_Click(object sender, EventArgs e)
        {
            try
            {
                double valor = Convert.ToDouble(txtLongitud.Text);
                string unidadEntrada = cmbUnidadEntrada.SelectedItem.ToString();
                string unidadSalida = cmbUnidadSalida.SelectedItem.ToString();

                // Crear el cliente del servicio
                ConversorLongitudServicioClient client = new ConversorLongitudServicioClient();

                // Llamar al servicio para convertir la longitud
                double resultado = client.ConvertirLongitud(valor, unidadEntrada, unidadSalida);

                // Mostrar el resultado en el Label
                lblResultado.Text = $"Resultado: {resultado} {unidadSalida}";

                // Cerrar el cliente
                client.Close();
            }
            catch (Exception ex)
            {
                MessageBox.Show($"Error: {ex.Message}");
            }
        }
    }
}
