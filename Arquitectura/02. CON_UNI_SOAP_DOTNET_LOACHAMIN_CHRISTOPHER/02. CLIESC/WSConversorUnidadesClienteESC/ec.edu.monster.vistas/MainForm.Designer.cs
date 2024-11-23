using System.Drawing;
using System.Windows.Forms;
using System;

namespace WSConversorUnidadesClienteESC.Vista
{
    public partial class MainForm : Form
    {
        // Declarar campos como campos de clase
        public TextBox txtLongitud;
        public ComboBox cmbUnidadEntrada;
        public ComboBox cmbUnidadSalida;
        public Button btnConvertir;
        public Label lblResultado;


        private void InitializeComponent()
        {
            this.txtLongitud = new System.Windows.Forms.TextBox();
            this.cmbUnidadEntrada = new System.Windows.Forms.ComboBox();
            this.cmbUnidadSalida = new System.Windows.Forms.ComboBox();
            this.btnConvertir = new System.Windows.Forms.Button();
            this.lblResultado = new System.Windows.Forms.Label();
            this.lblTitulo = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // txtLongitud
            // 
            this.txtLongitud.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.txtLongitud.Font = new System.Drawing.Font("Segoe UI", 12F);
            this.txtLongitud.Location = new System.Drawing.Point(20, 80);
            this.txtLongitud.Name = "txtLongitud";
            this.txtLongitud.Size = new System.Drawing.Size(360, 34);
            this.txtLongitud.TabIndex = 1;
            this.txtLongitud.TextAlign = System.Windows.Forms.HorizontalAlignment.Center;
            // 
            // cmbUnidadEntrada
            // 
            this.cmbUnidadEntrada.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.cmbUnidadEntrada.Font = new System.Drawing.Font("Segoe UI", 10F);
            this.cmbUnidadEntrada.Location = new System.Drawing.Point(20, 120);
            this.cmbUnidadEntrada.Name = "cmbUnidadEntrada";
            this.cmbUnidadEntrada.Size = new System.Drawing.Size(170, 31);
            this.cmbUnidadEntrada.TabIndex = 2;
            // 
            // cmbUnidadSalida
            // 
            this.cmbUnidadSalida.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.cmbUnidadSalida.Font = new System.Drawing.Font("Segoe UI", 10F);
            this.cmbUnidadSalida.Location = new System.Drawing.Point(210, 120);
            this.cmbUnidadSalida.Name = "cmbUnidadSalida";
            this.cmbUnidadSalida.Size = new System.Drawing.Size(170, 31);
            this.cmbUnidadSalida.TabIndex = 3;
            // 
            // btnConvertir
            // 
            this.btnConvertir.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(52)))), ((int)(((byte)(152)))), ((int)(((byte)(219)))));
            this.btnConvertir.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnConvertir.Font = new System.Drawing.Font("Segoe UI", 12F, System.Drawing.FontStyle.Bold);
            this.btnConvertir.ForeColor = System.Drawing.Color.White;
            this.btnConvertir.Location = new System.Drawing.Point(20, 180);
            this.btnConvertir.Name = "btnConvertir";
            this.btnConvertir.Size = new System.Drawing.Size(360, 40);
            this.btnConvertir.TabIndex = 4;
            this.btnConvertir.Text = "Convertir";
            this.btnConvertir.UseVisualStyleBackColor = false;
            // 
            // lblResultado
            // 
            this.lblResultado.Font = new System.Drawing.Font("Segoe UI", 12F, System.Drawing.FontStyle.Bold);
            this.lblResultado.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(44)))), ((int)(((byte)(62)))), ((int)(((byte)(80)))));
            this.lblResultado.Location = new System.Drawing.Point(20, 240);
            this.lblResultado.Name = "lblResultado";
            this.lblResultado.Size = new System.Drawing.Size(360, 40);
            this.lblResultado.TabIndex = 5;
            this.lblResultado.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            this.lblResultado.Click += new System.EventHandler(this.lblResultado_Click);
            // 
            // lblTitulo
            // 
            this.lblTitulo.Font = new System.Drawing.Font("Segoe UI", 16F, System.Drawing.FontStyle.Bold);
            this.lblTitulo.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(52)))), ((int)(((byte)(152)))), ((int)(((byte)(219)))));
            this.lblTitulo.Location = new System.Drawing.Point(20, 20);
            this.lblTitulo.Name = "lblTitulo";
            this.lblTitulo.Size = new System.Drawing.Size(360, 40);
            this.lblTitulo.TabIndex = 0;
            this.lblTitulo.Text = "Conversor de Unidades";
            this.lblTitulo.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            this.lblTitulo.Click += new System.EventHandler(this.lblTitulo_Click);
            // 
            // MainForm
            // 
            this.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(245)))), ((int)(((byte)(246)))), ((int)(((byte)(250)))));
            this.ClientSize = new System.Drawing.Size(400, 300);
            this.Controls.Add(this.lblTitulo);
            this.Controls.Add(this.txtLongitud);
            this.Controls.Add(this.cmbUnidadEntrada);
            this.Controls.Add(this.cmbUnidadSalida);
            this.Controls.Add(this.btnConvertir);
            this.Controls.Add(this.lblResultado);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedSingle;
            this.MaximizeBox = false;
            this.Name = "MainForm";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Conversor de Unidades";
            this.Load += new System.EventHandler(this.MainForm_Load_1);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        private Label lblTitulo;
    }
}