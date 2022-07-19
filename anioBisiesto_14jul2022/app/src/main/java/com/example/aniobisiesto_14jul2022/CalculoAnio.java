package com.example.aniobisiesto_14jul2022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class CalculoAnio extends AppCompatActivity{

    private TextView textAnio, textTipoA, textMesesA, textSemanasA, textDiasA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo_anio);
        textAnio = findViewById(R.id.txtAnio);
        textTipoA = findViewById(R.id.txtbisiesto);
        textMesesA = findViewById(R.id.txtmeses);
        textSemanasA = findViewById(R.id.txtsemanas);
        textDiasA = findViewById(R.id.txtdias);

        obtnerDatos();

    }
    private void obtnerDatos(){
        Bundle bundle = getIntent().getExtras();
        Calendar cal = Calendar.getInstance();
        Integer year, semanas, dias;

        if(bundle != null){
            String anio = bundle.getString("anio");
            year = Integer.parseInt(anio);

            cal.set(year,0,1);
            semanas = cal.getActualMaximum(Calendar.WEEK_OF_YEAR); //Como obtener las semanas del anio???

            textAnio.setText(year.toString());
            textTipoA.setText(bisiesto(year));
            textMesesA.setText("12");
            textSemanasA.setText(semanas.toString());
            textDiasA.setText(diasAnio(year));
        }
        else{
            Toast.makeText(this,"Datos no encontrados",Toast.LENGTH_LONG).show();
        }
    }
    private String bisiesto(int y){
        String tipoAnio="";
        int a,b;
        //1ro. Es anio debe ser divisible entre 4
        a = y%4;
        //2do. El anio NO debe ser divisible entre 100
        b = y%100;
        if(a==0 && b > 0){
            tipoAnio="Bisiesto";
        }
        else{
            tipoAnio="Normal";
        }
        return tipoAnio;
    }
    private String diasAnio(int y){
        String dias= "";
        if(bisiesto(y).equals("Normal")){
            dias = "365";
        }else {
            dias = "366";
        }
        return dias;
    }
}