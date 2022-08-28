package com.example.sharedpreferenceejercicio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextCarnet, editTextCentroEstudio, editTextCarrera, editTextCurso;
    private Button buttonGuardar;
    private Button buttonVerDatos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextCarnet =  findViewById(R.id.edtCarnet);
        editTextCentroEstudio = findViewById(R.id.edtCentroEstudio);
        editTextCarrera = findViewById(R.id.edtCarrera);
        editTextCurso = findViewById(R.id.edtCurso);
        buttonGuardar = findViewById(R.id.btnGuardar);
        buttonGuardar.setOnClickListener(this);
        buttonVerDatos = findViewById(R.id.btnVerDatos);
        buttonVerDatos.setOnClickListener(this);

    }

    private void guardarInformacion(){
        if (!editTextCarnet.getText().toString().isEmpty() && !editTextCentroEstudio.getText().toString().isEmpty()
                && !editTextCarrera.getText().toString().isEmpty() && !editTextCurso.getText().toString().isEmpty()){
            SharedPreferences preferences = getSharedPreferences("datosGuardados", Context.MODE_PRIVATE);

            String carnet = editTextCarnet.getText().toString();
            String centroEstudio = editTextCentroEstudio.getText().toString();
            String carrera = editTextCarrera.getText().toString();
            String curso = editTextCurso.getText().toString();

            //Almacenan los datos
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("carnet",carnet);
            editor.putString("centroEstudio",centroEstudio);
            editor.putString("carrera",carrera);
            editor.putString("curso",curso);

            if (editor.commit()==true){
                editTextCarnet.setText("");
                editTextCentroEstudio.setText("");
                editTextCarrera.setText("");
                editTextCurso.setText("");
                Toast.makeText(this, "Datos Guardados exitosamente", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(this, "Error al Guardar los datos", Toast.LENGTH_SHORT).show();
            }
        }
        else {
            Toast.makeText(this, "Debes completar todos los datos", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnGuardar:
                guardarInformacion();
                break;
            case R.id.btnVerDatos:
                Intent intent = new Intent(this,VerDatosSP.class);
                startActivity(intent);
            default:
                break;
        }
    }
}