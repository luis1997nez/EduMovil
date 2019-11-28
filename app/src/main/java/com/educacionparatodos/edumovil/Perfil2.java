package com.educacionparatodos.edumovil;

import android.os.Bundle;

import androidx.annotation.NonNull;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.TextView;

public class Perfil2 extends AppCompatActivity {

    TextView textNombre;
    TextView textUbicación;
    TextView textCorreo;

    FirebaseAuth mAuth;
    DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil2);


        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        textNombre = findViewById(R.id.textNombre);
        textUbicación = findViewById(R.id.textUbicacion);
        textCorreo = findViewById(R.id.textCorreo);

        getUserInfo();

    }


    private void getUserInfo(){
        String id = mAuth.getCurrentUser().getUid();
        mDatabase.child("usuarios").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    String nombre = dataSnapshot.child("nombre").getValue().toString();
                    String ubi = dataSnapshot.child("ciudad").getValue().toString();
                    String email = dataSnapshot.child("correo").getValue().toString();
                    textNombre.setText(nombre);
                    textUbicación.setText(ubi);
                    textCorreo.setText(email);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
