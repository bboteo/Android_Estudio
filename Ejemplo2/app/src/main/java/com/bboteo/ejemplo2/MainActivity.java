package com.bboteo.ejemplo2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Declaracion de variables locales
    private TextView textViewContador;
    private int contador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewContador = findViewById(R.id.txtContador);

    }

    private void mas(){
        this.contador++;
        this.textViewContador.setText(String.valueOf(contador));
    }

    private void menos(){
        this.contador--;
        this.textViewContador.setText(String.valueOf(contador));
    }

    public void onClick(View view) {
        if(view.getId() == R.id.btnMas){
            this.mas();
            Toast.makeText(this, "Estoy Sumando", Toast.LENGTH_SHORT).show();
        }
        if(view.getId() == R.id.btnMenos){
            this.menos();
            Toast.makeText(this, "Estoy Restando", Toast.LENGTH_SHORT).show();
        }
    }
}