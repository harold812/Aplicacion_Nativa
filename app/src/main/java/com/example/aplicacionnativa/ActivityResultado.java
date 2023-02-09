package com.example.aplicacionnativa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityResultado extends AppCompatActivity {

    String[] lista;
    TextView tvNombres,tvApellidos,tvEdad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        tvNombres = findViewById(R.id.nombres);
        tvApellidos = findViewById(R.id.apellidos);
        tvEdad = findViewById(R.id.edad);

        Bundle parametros = new Bundle();
        parametros = getIntent().getBundleExtra("ltdatos");

        lista = (String[]) parametros.getSerializable("lista");

        tvNombres.setText("Nombres: " + lista[0]);
        tvApellidos.setText("Apellidos :" + lista[1]);
        tvEdad.setText("Edad: "  + lista[2]);

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(ActivityResultado.this,ActivityFormulario.class);
        startActivity(intent);
        finish();
    }
}