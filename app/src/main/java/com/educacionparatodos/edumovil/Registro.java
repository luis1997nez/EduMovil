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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class Registro extends AppCompatActivity implements View.OnClickListener {

    EditText textNombre;
    EditText textCorreo;
    EditText textContrasenia;
    EditText textCiudad;
    EditText textEstado;
    EditText textTelefono;
    Button btnRegistro;

    String nombre = "", correo = "", contra = "", ciudad = "", estado = "";
    int telefono = 0;

    FirebaseAuth mAuth;
    DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();

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

        nombre = textNombre.getText().toString();
        correo = textCorreo.getText().toString();
        contra = textContrasenia.getText().toString();
        ciudad = textCiudad.getText().toString();
        estado = textEstado.getText().toString();
        //telefono = Integer.parseInt(textTelefono.getText().toString());

        if(!nombre.isEmpty() && !correo.isEmpty() && !contra.isEmpty() && !ciudad.isEmpty() && !estado.isEmpty()){

            if(correo.length() >= 6){
                registerUser();
            }else{
                Toast.makeText(this, "El correo debe tener minimo 6 caracteres", Toast.LENGTH_LONG).show();
            }

        }else{
            Toast.makeText(this, "Debe de llenar todos los campos", Toast.LENGTH_LONG).show();
        }


    }

    private void registerUser(){

        mAuth.createUserWithEmailAndPassword(correo, contra).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful()){

                    Map<String, Object> map = new HashMap<>();
                    map.put("nombre", nombre);
                    map.put("correo", correo);
                    map.put("contra", contra);
                    map.put("ciudad", ciudad);
                    map.put("estado", estado);
                    // map.put("telefono", telefono);

                    String id = mAuth.getCurrentUser().getUid();
                    mDatabase.child("Usuarios").child(id).setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task2) {
                            if(task2.isSuccessful()){
                                Intent bienvenida = new Intent(Registro.this, Login.class);
                                startActivity(bienvenida);
                            }else{
                                Toast.makeText(Registro.this, "No se creador los datos correctamente", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }) ;
                }else{

                    Toast.makeText(Registro.this, "Error al conectar al servidor", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }


}
