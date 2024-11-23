using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using WSConversorUnidadesClienteESC.ec.edu.monster.modelos;
using WSConversorUnidadesClienteESC.Vista;
using WSConversorUnidadesClienteESC.ConversorLongitudServicioReferencia;


namespace WSConversorUnidadesClienteESC.ec.edu.monster.controladores
{
    public class ConversionController
    {
        private MainForm _vista;
        private ConversorLongitudServicioClient _servicioConversion;

        public ConversionController(MainForm vista)
        {
            _vista = vista;
            _servicioConversion = new ConversorLongitudServicioClient();
        }

        public void InicializarUnidades()
        {
            string[] unidades = { "metro", "kilometro", "centimetro", "milla" };
            _vista.cmbUnidadEntrada.Items.AddRange(unidades);
            _vista.cmbUnidadSalida.Items.AddRange(unidades);
        }

        public void RealizarConversion()
        {
            try
            {
                // Validaciones
                if (_vista.cmbUnidadEntrada.SelectedItem == null ||
                    _vista.cmbUnidadSalida.SelectedItem == null)
                {
                    MessageBox.Show("Seleccione unidades", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
                    return;
                }

                double valor;
                if (!double.TryParse(_vista.txtLongitud.Text, out valor))
                {
                    MessageBox.Show("Valor inválido", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
                    return;
                }

                // Realizar conversión
                string unidadOrigen = _vista.cmbUnidadEntrada.SelectedItem.ToString();
                string unidadDestino = _vista.cmbUnidadSalida.SelectedItem.ToString();

                double resultado = _servicioConversion.ConvertirLongitud(valor, unidadOrigen, unidadDestino);

                // Mostrar resultado
                _vista.lblResultado.Text = resultado.ToString();
            }
            catch (Exception ex)
            {
                MessageBox.Show($"Error de conversión: {ex.Message}", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
        }
    }

}
