package com.educacionparatodos.edumovil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Registro extends AppCompatActivity implements View.OnClickListener {

    EditText textNombre;
    EditText textCorreo;
    EditText textContrasenia;
    EditText textCiudad;
    EditText textEstado;
    EditText textTelefono;
    Button btnRegistro;

    String nombre, correo, contra, ciudad, estado;
    int telefono;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);


        textNombre = findViewById(R.id.textNombre);
        textCorreo = findViewById(R.id.textCorreo);
        textContrasenia = findViewById(R.id.textContrasenia);
        textCiudad = findViewById(R.id.textCiudad);
        textEstado = findViewById(R.id.textEstado);
        textTelefono =findViewById(R.id.textTelefono);

        btnRegistro = findViewById(R.id.btnRegistro);
        btnRegistro.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if(view.getId() == R.id.btnRegistro){

            Intent sesion2 = new Intent(Registro.this, Login.class);
            startActivity(sesion2);
        }

    }
}
