package ec.edu.monster.vistas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import ec.edu.monster.wsconversorunidadesclientemov.R;

public class LoginActivity extends AppCompatActivity {

    // Datos de usuario quemados (predefinidos)
    private final String USERNAME = "admin";
    private final String PASSWORD = "123456";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText editTextUsername = findViewById(R.id.editTextUsername);
        EditText editTextPassword = findViewById(R.id.editTextPassword);
        Button buttonLogin = findViewById(R.id.buttonLogin);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernameInput = editTextUsername.getText().toString();
                String passwordInput = editTextPassword.getText().toString();

                // Validar el usuario y la contraseña
                if (usernameInput.equals(USERNAME) && passwordInput.equals(PASSWORD)) {
                    // Redirigir al usuario a la actividad principal (MainActivity)
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish(); // Finaliza LoginActivity para que no se pueda regresar con el botón "Atrás"
                } else {
                    // Mostrar mensaje de error
                    Toast.makeText(LoginActivity.this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}