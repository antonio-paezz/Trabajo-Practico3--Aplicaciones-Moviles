package com.example.demo_dos;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.net.Uri;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AcercadeActivity extends AppCompatActivity {

    Button btnVolver;
    Button btnCorreo;
    Button btnTelefono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_acercade);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        this.btnVolver();
        this.btnCorreo();
        this.btnTelefono();
    }

    public void btnVolver(){
        btnVolver = findViewById(R.id.btnVolver);
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), SegundaActivity.class);
                startActivity(intent);
            }
        });
    }

    public void btnCorreo(){
        btnCorreo = findViewById(R.id.btnCorreo);
        btnCorreo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentCorreo = new Intent(Intent.ACTION_SEND);
                intentCorreo.setType("text/plain");
                intentCorreo.putExtra(Intent.EXTRA_EMAIL, new String[]{"antoniopaez@gmail.com"});
                intentCorreo.putExtra(Intent.EXTRA_SUBJECT, "Asunto del correo");
                intentCorreo.putExtra(Intent.EXTRA_TEXT, "Cuerpo del correo electrónico");

                if (intentCorreo.resolveActivity(getPackageManager()) != null) {
                    startActivity(intentCorreo);
                } else {
                    Toast.makeText(getApplicationContext(), "No hay aplicaciones de correo electrónico instaladas.", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    public void btnTelefono(){
        btnTelefono = findViewById(R.id.btnTelefono);
        btnTelefono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentTelefono = new Intent(Intent.ACTION_DIAL);
                intentTelefono.setData(Uri.parse("tel:+123456789"));
                startActivity(intentTelefono);


            }
        });
    }

}
