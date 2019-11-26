package com.educacionparatodos.edumovil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Presentacion extends AppCompatActivity implements View.OnClickListener {
    Button btn1;
    Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presentacion);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if(view.getId() == R.id.btn1){
            Intent registro = new Intent(Presentacion.this, Registro.class);
            startActivity(registro);
        }
        else if(view.getId() == R.id.btn2){
            Intent sesion = new Intent(Presentacion.this, Login.class);
            startActivity(sesion);
        }
    }

}

