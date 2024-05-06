package com.example.demo_dos;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnIngresar;
    EditText edtMainNombreUsuario;
    EditText edtMainUsuarioPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        this.generarUI();
    }

    private void generarUI() {
        // instancia de controles UI
        btnIngresar = findViewById(R.id.btnIngresar);
        edtMainNombreUsuario = findViewById(R.id.edtMainNombreUsuario);
        edtMainUsuarioPassword = findViewById(R.id.edtMainUsuarioPassword);

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtMainNombreUsuario.getText().toString().equals("alumno") && edtMainUsuarioPassword.getText().toString().equals("1234"))
                {
                    Toast.makeText(MainActivity.this, getString(R.string.welcome) + " " + edtMainNombreUsuario.getText().toString(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getBaseContext(), SegundaActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(MainActivity.this, getString(R.string.login_failed) + " ", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}