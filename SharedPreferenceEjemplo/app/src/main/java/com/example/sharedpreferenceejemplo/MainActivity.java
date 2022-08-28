package com.example.sharedpreferenceejemplo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNombre, editTextEdad;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNombre = findViewById(R.id.edtNombreSP);
        editTextEdad = findViewById(R.id.edtEdadSP);
        button = findViewById(R.id.btnAlmacenarSP);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                almacenarDatos();
            }
        });

        this.obtenerDatos();
    }
    //Metodo para almacenar de Shared Preference
    private void almacenarDatos(){
        if(!editTextNombre.getText().toString().isEmpty() && !editTextEdad.getText().toString().isEmpty()){
            //Instanciar la clase Shared Preference
            SharedPreferences preferences = getSharedPreferences("DatosPreferidos", Context.MODE_PRIVATE);

            String nombre = editTextNombre.getText().toString();
            int edad = Integer.parseInt(editTextEdad.getText().toString());

            //Almacenar los datos que se encuentran en las variables
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("Nombre",nombre);
            editor.putInt("edad",edad);

            if(editor.commit()==true){
                editTextNombre.setText("");
                editTextEdad.setText("");

            }
            else {
                Toast.makeText(this, "Error al almacenar Datos", Toast.LENGTH_SHORT).show();
            }

        }
        else {
            Toast.makeText(this, "Debe completar todos los datos", Toast.LENGTH_SHORT).show();
        }
    }
    private void obtenerDatos(){
        SharedPreferences preferences = getSharedPreferences("DatosPreferidos", Context.MODE_PRIVATE);
        //Se asignan los datos que estan almacenados en el preferences
        String nombre = preferences.getString("Nombre","---");
        int edad = preferences.getInt("edad",0);

        String edadMostrar="";
        if (edad == 0){
            edadMostrar = "";
            editTextEdad.setText(edadMostrar);
        }
        else {
            editTextEdad.setText(String.valu               Toast.makeText(this, "Datos almacenados de forma correcta", Toast.LENGTH_SHORT).show();eOf(edad));
        }
        editTextNombre.setText(String.valueOf(nombre));

    }
}