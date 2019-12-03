package com.educacionparatodos.edumovil;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class NuevoAlumno extends AppCompatActivity implements View.OnClickListener {

    EditText textNumero;
    EditText textNombre;
    Button btnAnadir;

    int numero = 0;
    String nombre = "";
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_alumno);

        textNumero = findViewById(R.id.textNumero);
        textNombre = findViewById(R.id.textNombre);
        btnAnadir = findViewById(R.id.btnAnadir);

        btnAnadir.setOnClickListener(this);

        inicializarFirebase();
    }

    private void inicializarFirebase(){
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }

    @Override
    public void onClick(View view) {

        if(!textNumero.getText().toString().equals("")){
            numero = Integer.parseInt(textNumero.getText().toString());
            nombre = textNombre.getText().toString();
        }

        if(numero != 0 && !nombre.isEmpty()){

            Map<String, Object> map = new HashMap<>();
            map.put("numero", numero);
            map.put("nombre", nombre);

            String id = UUID.randomUUID().toString();
            databaseReference.child("alumnos").child(id).setValue(map);

            Toast.makeText(NuevoAlumno.this, "Alumno agregado", Toast.LENGTH_SHORT).show();
        }else{

            Toast.makeText(NuevoAlumno.this, "Por favor, llene todos los campos", Toast.LENGTH_SHORT).show();
        }

    }
}
