package com.educacionparatodos.edumovil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class Bienvenida extends AppCompatActivity implements View.OnClickListener {

    Button btnCerrar;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida);

        mAuth = FirebaseAuth.getInstance();
        btnCerrar = findViewById(R.id.btnCerrar);

        btnCerrar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        mAuth.signOut();

        Intent salida = new Intent(Bienvenida.this, Presentacion.class);
        startActivity(salida);
        finish();
    }
}
