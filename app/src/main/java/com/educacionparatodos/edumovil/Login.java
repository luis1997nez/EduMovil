package com.educacionparatodos.edumovil;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity implements View.OnClickListener {

    EditText textEmail;
    EditText textPass;
    Button btnIniciar;

    String correo = "";
    String pass = "";

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();

        textEmail=findViewById(R.id.textEmail);
        textPass=findViewById(R.id.textPass);
        btnIniciar = findViewById(R.id.btnIniciar);

        btnIniciar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        correo = textEmail.getText().toString();
        pass = textPass.getText().toString();

        if(!correo.isEmpty() && !pass.isEmpty()){
            loginUser();
        }else{
            Toast.makeText(Login.this, "Por favor, llene todos los campos", Toast.LENGTH_SHORT).show();

        }
    }

    private void loginUser(){

        mAuth.signInWithEmailAndPassword(correo, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){

                    Intent entrada = new Intent(Login.this, home2.class);
                    startActivity(entrada);
                    finish();

                }else{

                    Toast.makeText(Login.this, "Correo o contraseña incorrecta", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

}
