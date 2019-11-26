package com.educacionparatodos.edumovil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity implements View.OnClickListener {

    EditText textEmail;
    EditText textPass;
    Button btnIniciar;

    String correo = null;
    String pass = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        textEmail=findViewById(R.id.textEmail);
        textPass=findViewById(R.id.textPass);
        btnIniciar = findViewById(R.id.btnIniciar);

        correo = textEmail.getText().toString();
        pass = textPass.getText().toString();

        btnIniciar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
       if(view.getId() == R.id.btnIniciar){

            if(textEmail.getText().toString().equals("luis")){
                    if(textPass.getText().toString().equals("123")){
                        Intent bienvenida = new Intent(Login.this, Bienvenida.class);
                        startActivity(bienvenida);
                    }else{
                     Toast.makeText(this, "Correo o contraseña incorrecta", Toast.LENGTH_LONG).show();
                    }
            }else{
                   Toast.makeText(this, "Correo o contraseña incorrecta", Toast.LENGTH_LONG).show();
            }

        }
    }
}
