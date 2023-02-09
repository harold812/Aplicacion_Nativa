package com.example.aplicacionnativa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class ActivityFormulario extends AppCompatActivity {

    EditText etNombre,etApellido,etEdad;
    Button btnContinuar;
    List<EditText> ltTexto = new ArrayList<EditText>();
    String[] ltDatos = new String[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        etNombre = findViewById(R.id.etNombres);
        etApellido = findViewById(R.id.etApellidos);
        etEdad = findViewById(R.id.etEdad);
        btnContinuar = findViewById(R.id.btnContinuar);

        ltTexto.add(etNombre);
        ltTexto.add(etApellido);
        ltTexto.add(etEdad);

        btnContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Boolean continuar = ValidarDatos();

                if (continuar){
                    Toast.makeText(ActivityFormulario.this,"Datos Completos",Toast.LENGTH_SHORT).show();
                    Bundle parametros = new Bundle();
                    parametros.putStringArray("lista", ltDatos);
                    Intent intent = new Intent(ActivityFormulario.this,ActivityResultado.class);
                    intent.putExtra("ltdatos",parametros);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(ActivityFormulario.this,"Datos Incompletos",Toast.LENGTH_LONG).show();
                }
            }
        });


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.Inicio:
                Intent intent = new Intent(ActivityFormulario.this,ActivityPrincipal.class);
                startActivity(intent);
                finish();
                break;
            case R.id.Formulario:

                break;
            case R.id.umb:
                Uri uri = Uri.parse("https://umb.edu.co/");
                Intent i = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(i);
                break;
            case R.id.busqueda:
                Uri url = Uri.parse("https://www.google.com/");
                Intent in = new Intent(Intent.ACTION_VIEW, url);
                startActivity(in);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private Boolean ValidarDatos(){
        EditText texto;
        Boolean Respuesta = true;
        for (int i =0; i < ltTexto.size();i++) {
            texto = ltTexto.get(i);
            if(texto.getText().toString().isEmpty()){
                Respuesta = false;
                break;
            }else{
                ltDatos[i] = texto.getText().toString();
                Respuesta= true;
                continue;
            }
        }
        return Respuesta;
    }

}