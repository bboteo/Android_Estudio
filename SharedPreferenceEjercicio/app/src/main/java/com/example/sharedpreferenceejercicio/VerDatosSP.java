package com.example.sharedpreferenceejercicio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class VerDatosSP extends AppCompatActivity {

    private TextView editTextCarnet, editTextCentroEstudio, editTextCarrra, editTextCurso;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_datos_sp);

        editTextCarnet = findViewById(R.id.verCarnet);
        editTextCentroEstudio = findViewById(R.id.verCentroEstudio);
        editTextCarrra = findViewById(R.id.verCarrera);
        editTextCurso = findViewById(R.id.verCurso);

        obtenerDatos();
    }
    private void obtenerDatos(){
        SharedPreferences preferences = getSharedPreferences("datosGuardados", Context.MODE_PRIVATE);

        String carnet = preferences.getString("carnet","****");
        String centroEstudios = preferences.getString("centroEstudios","****");
        String carrera = preferences.getString("carrera","****");
        String curso = preferences.getString("curso","****");

        editTextCarnet.setText(String.valueOf(carnet));
        editTextCentroEstudio.setText(String.valueOf(centroEstudios));
        editTextCarrra.setText(String.valueOf(carrera));
        editTextCurso.setText(String.valueOf(curso));

    }
}