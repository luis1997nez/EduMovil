package com.educacionparatodos.edumovil;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class home2 extends AppCompatActivity implements View.OnClickListener {

    Button btnCerrar;
    Button btnPerfil;
    Button btnUbi;
    Button btnLista;

    TextView textNombre;
    FirebaseAuth mAuth;
    DatabaseReference mDatabase;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);

        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        textNombre = findViewById(R.id.textNombre);
        btnCerrar = findViewById(R.id.btnCerrar);
        btnPerfil = findViewById(R.id.btnPerfil);
        btnUbi = findViewById(R.id.btnUbi);
        btnLista = findViewById(R.id.btnLista);

        getUserInfo();

        btnCerrar.setOnClickListener(this);
        btnPerfil.setOnClickListener(this);
        btnUbi.setOnClickListener(this);
        btnLista.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        if(view.getId()== R.id.btnCerrar){

            mAuth.signOut();

            Intent salida = new Intent(home2.this, Presentacion.class);
            startActivity(salida);
            finish();

        }else if(view.getId()==R.id.btnPerfil){
            Intent perfil = new Intent(home2.this, Perfil2.class);
            startActivity(perfil);

        } else if(view.getId()==R.id.btnUbi){
            Intent ubi = new Intent(home2.this, Ubicacion.class);
            startActivity(ubi);
        } else if(view.getId()==R.id.btnLista){
            Intent lis = new Intent(home2.this, ListaAlumnos.class);
            startActivity(lis);
        }

    }

    private void getUserInfo(){
        String id = mAuth.getCurrentUser().getUid();
        mDatabase.child("usuarios").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    String nombre = dataSnapshot.child("nombre").getValue().toString();

                    textNombre.setText(nombre);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
