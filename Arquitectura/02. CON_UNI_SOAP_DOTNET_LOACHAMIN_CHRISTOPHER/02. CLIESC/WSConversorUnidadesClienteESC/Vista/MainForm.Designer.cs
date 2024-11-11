namespace WSConversorUnidadesClienteESC.Vista
{
    partial class MainForm
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;
        private System.Windows.Forms.TextBox txtLongitud;
        private System.Windows.Forms.ComboBox cmbUnidadEntrada;
        private System.Windows.Forms.ComboBox cmbUnidadSalida;
        private System.Windows.Forms.Button btnConvertir;
        private System.Windows.Forms.Label lblResultado;

        private void InitializeComponent()
        {
            this.txtLongitud = new System.Windows.Forms.TextBox();
            this.cmbUnidadEntrada = new System.Windows.Forms.ComboBox();
            this.cmbUnidadSalida = new System.Windows.Forms.ComboBox();
            this.btnConvertir = new System.Windows.Forms.Button();
            this.lblResultado = new System.Windows.Forms.Label();

            this.SuspendLayout();
            // 
            // txtLongitud
            // 
            this.txtLongitud.Location = new System.Drawing.Point(12, 12);
            this.txtLongitud.Name = "txtLongitud";
            this.txtLongitud.Size = new System.Drawing.Size(100, 20);
            // 
            // cmbUnidadEntrada
            // 
            this.cmbUnidadEntrada.FormattingEnabled = true;
            this.cmbUnidadEntrada.Location = new System.Drawing.Point(12, 38);
            this.cmbUnidadEntrada.Name = "cmbUnidadEntrada";
            this.cmbUnidadEntrada.Size = new System.Drawing.Size(121, 21);
            // 
            // cmbUnidadSalida
            // 
            this.cmbUnidadSalida.FormattingEnabled = true;
            this.cmbUnidadSalida.Location = new System.Drawing.Point(12, 65);
            this.cmbUnidadSalida.Name = "cmbUnidadSalida";
            this.cmbUnidadSalida.Size = new System.Drawing.Size(121, 21);
            // 
            // btnConvertir
            // 
            this.btnConvertir.Location = new System.Drawing.Point(12, 92);
            this.btnConvertir.Name = "btnConvertir";
            this.btnConvertir.Size = new System.Drawing.Size(75, 23);
            this.btnConvertir.TabIndex = 0;
            this.btnConvertir.Text = "Convertir";
            this.btnConvertir.UseVisualStyleBackColor = true;
            this.btnConvertir.Click += new System.EventHandler(this.btnConvertir_Click);
            // 
            // lblResultado
            // 
            this.lblResultado.AutoSize = true;
            this.lblResultado.Location = new System.Drawing.Point(12, 118);
            this.lblResultado.Name = "lblResultado";
            this.lblResultado.Size = new System.Drawing.Size(0, 13);
            // 
            // MainForm
            // 
            this.ClientSize = new System.Drawing.Size(224, 141);
            this.Controls.Add(this.lblResultado);
            this.Controls.Add(this.btnConvertir);
            this.Controls.Add(this.cmbUnidadSalida);
            this.Controls.Add(this.cmbUnidadEntrada);
            this.Controls.Add(this.txtLongitud);
            this.Name = "MainForm";
            this.Load += new System.EventHandler(this.MainForm_Load);
            this.ResumeLayout(false);
            this.PerformLayout();
        }

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>

        #endregion
    }
}