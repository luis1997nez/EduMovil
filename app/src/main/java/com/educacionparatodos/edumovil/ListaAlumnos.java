package com.educacionparatodos.edumovil;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ListaAlumnos extends AppCompatActivity {

    //private List<ListaAlumnos> listaAlumno = new ArrayList<ListaAlumnos>();
    //ArrayAdapter<ListaAlumnos> arrayAdapter;

    //ListView listV_personas;

    FloatingActionButton fab;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alumnos);

        fab = findViewById(R.id.fab);
        //listV_personas = findViewById(R.id.lista);


        inicializarFirebase();

        //listarDatos();


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent agregar = new Intent(ListaAlumnos.this, NuevoAlumno.class);
                startActivity(agregar);
            }
        });
    }
/*
    private void listarDatos() {
        databaseReference.child("alumnos").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listaAlumno.clear();

                for(DataSnapshot objSnaptshop : dataSnapshot.getChildren()){
                    ListaAlumnos a = objSnaptshop.getValue(ListaAlumnos.class);
                    //listaAlumno.add(a);

                    arrayAdapter = new ArrayAdapter<ListaAlumnos>(ListaAlumnos.this, android.R.layout.simple_list_item_1, listaAlumno);
                    listV_personas.setAdapter(arrayAdapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }*/

    private void inicializarFirebase(){
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }
}
