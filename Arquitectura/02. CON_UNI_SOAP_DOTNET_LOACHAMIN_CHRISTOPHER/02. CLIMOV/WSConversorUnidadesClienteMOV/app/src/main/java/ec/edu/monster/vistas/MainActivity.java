package ec.edu.monster.vistas;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import ec.edu.monster.controladores.ConversorLongitudControlador;

public class MainActivity extends AppCompatActivity {

    private EditText valorInput;
    private Spinner unidadOrigenSpinner, unidadDestinoSpinner;
    private TextView resultadoView;
    private ConversorLongitudControlador conversorController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valorInput = findViewById(R.id.valorInput);
        unidadOrigenSpinner = findViewById(R.id.unidadOrigenSpinner);
        unidadDestinoSpinner = findViewById(R.id.unidadDestinoSpinner);
        resultadoView = findViewById(R.id.resultView);
        conversorController = new ConversorLongitudControlador();

        Button convertirButton = findViewById(R.id.convertirButton);
        convertirButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realizarConversion();
            }
        });
    }

    private void realizarConversion() {
        try {
            double valor = Double.parseDouble(valorInput.getText().toString());
            String unidadOrigen = unidadOrigenSpinner.getSelectedItem().toString();
            String unidadDestino = unidadDestinoSpinner.getSelectedItem().toString();

            String resultado = conversorController.convertirLongitud(valor, unidadOrigen, unidadDestino);
            resultadoView.setText(resultado);

        } catch (NumberFormatException e) {
            resultadoView.setText("Por favor, introduce un número válido.");
        }
    }
}