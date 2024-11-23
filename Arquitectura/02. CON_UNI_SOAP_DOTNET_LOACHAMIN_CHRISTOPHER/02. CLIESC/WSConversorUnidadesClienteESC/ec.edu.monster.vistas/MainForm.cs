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
using WSConversorUnidadesClienteESC.ec.edu.monster.controladores;

namespace WSConversorUnidadesClienteESC.Vista
{
    public partial class MainForm : Form
    {
        private ConversionController _controlador;

        public MainForm()
        {
            InitializeComponent();
            // Añadir el evento de clic al botón
            btnConvertir.Click += btnConvertir_Click;
            _controlador = new ConversionController(this);
        }

        private void MainForm_Load_1(object sender, EventArgs e)
        {
            // Cargar unidades en los combos
            string[] unidades = { "metro", "kilometro", "centimetro", "pulgadas", "millas" };
            cmbUnidadEntrada.Items.AddRange(unidades);
            cmbUnidadSalida.Items.AddRange(unidades);
        }

        private void MainForm_Load(object sender, EventArgs e)
        {

            this.Text = "Convertidor de Unidades";
            this.FormBorderStyle = FormBorderStyle.FixedDialog;
            this.MaximizeBox = false;
            this.StartPosition = FormStartPosition.CenterScreen;
            _controlador.InicializarUnidades();
        }


        private void btnConvertir_Click(object sender, EventArgs e)
        {
            _controlador.RealizarConversion();
        }

   
        private void lblResultado_Click(object sender, EventArgs e)
        {

        }

        private void lblTitulo_Click(object sender, EventArgs e)
        {

        }
    }
}
