package com.educacionparatodos.edumovil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class Presentacion extends AppCompatActivity implements View.OnClickListener {
    Button btn1;
    Button btn2;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presentacion);

        mAuth = FirebaseAuth.getInstance();
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

    protected void onStart(){
        super.onStart();

        if(mAuth.getCurrentUser() != null){
            Intent entrada = new Intent(Presentacion.this, home2.class);
            startActivity(entrada);
            finish();
        }

    }

}

