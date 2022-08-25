package com.example.fragmentodinamico;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Fragment fragment1, fragment2, fragment3;
    private FragmentTransaction transaction;
    Button buttonFrg1, buttonFrg2, buttonFrg3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragment1 = new FragmentoUno();
        fragment2 = new FragmentoDos();
        fragment3 = new FragmentTres();

        buttonFrg1 = findViewById(R.id.btnFrgUnoN);
        buttonFrg2 = findViewById(R.id.btnFrgDosN);
        buttonFrg3 = findViewById(R.id.btnFrgTresN);
        //Forma #1 Para activar y mostrar los fragmentos en el contenedor --> Commit inicia los fragmentos
        //getSupportFragmentManager().beginTransaction().replace(R.id.frlContenedor,fragment1).disallowAddToBackStack().commit();

        //Forma #2 para activar todos los fragmentos y mostrando y ocultando los necesarios
        getSupportFragmentManager().beginTransaction().add(R.id.frlContenedor,fragment1).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.frlContenedor,fragment2).hide(fragment2).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.frlContenedor,fragment3).hide(fragment3).commit();

        this.click(buttonFrg1, buttonFrg2, buttonFrg3);

    }

    private void click(Button buttonFrg1, Button buttonFrg2, Button buttonFrg3) {

        //transaction = getSupportFragmentManager().beginTransaction();


        buttonFrg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transaction = getSupportFragmentManager().beginTransaction();
                if (fragment1.isAdded()){
                    transaction.hide(fragment2).hide(fragment3).show(fragment1);
                }
                else{
                    transaction.hide(fragment2).hide(fragment3).add(R.id.frlContenedor,fragment1);
                    transaction.addToBackStack(null);
                }
                transaction.commit();
            }
        });
        buttonFrg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transaction = getSupportFragmentManager().beginTransaction();
                if (fragment2.isAdded()){
                    transaction.hide(fragment1).hide(fragment3).show(fragment2);
                }
                else{
                    transaction.hide(fragment1).hide(fragment3).add(R.id.frlContenedor,fragment2).addToBackStack(null);
                }
                transaction.commit();
            }
        });
        buttonFrg3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transaction = getSupportFragmentManager().beginTransaction();
                if(fragment3.isAdded()){
                    transaction.hide(fragment1).hide(fragment2).show(fragment3);
                }
                else{
                    transaction.hide(fragment1).hide(fragment2).add(R.id.frlContenedor,fragment3).addToBackStack(null);
                }
                transaction.commit();
            }
        });
        //transaction.commit();
    }
}