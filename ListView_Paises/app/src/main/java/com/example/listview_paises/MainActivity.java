package com.example.listview_paises;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listPais);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                traslado(i);
            }
        });


        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,paises());
        listView.setAdapter(arrayAdapter);

    }
    private ArrayList<String> paises(){
        ArrayList<String> paises = new ArrayList<>();
        paises.add("Argentina");
        paises.add("Brazil");
        paises.add("Chile");
        paises.add("Francia");
        paises.add("Inglaterra");
        paises.add("Italia");
        paises.add("Mexico");
        paises.add("Peru");
        paises.add("Estados Unidos");
        paises.add("Venezuela");
        return paises;
    }
    private ArrayList<Integer> imagenes(){
        ArrayList<Integer> img = new ArrayList<>();
        img.add(R.drawable.ic_argentina);
        img.add(R.drawable.ic_brazil);
        img.add(R.drawable.ic_chile);
        img.add(R.drawable.ic_francia);
        img.add(R.drawable.ic_inglaterra);
        img.add(R.drawable.ic_italia);
        img.add(R.drawable.ic_mexico);
        img.add(R.drawable.ic_peru);
        img.add(R.drawable.ic_usa);
        img.add(R.drawable.ic_venezuela);
        return img;
    }
    private ArrayList<Integer> informacion(){
        ArrayList<Integer> info = new ArrayList<>();
        info.add(R.string.Argentina);
        info.add(R.string.Brazil);
        info.add(R.string.Chile);
        info.add(R.string.Francia);
        info.add(R.string.Inglaterra);
        info.add(R.string.Italia);
        info.add(R.string.Mexico);
        info.add(R.string.Peru);
        info.add(R.string.Usa);
        info.add(R.string.Venezuela);
        return info;
    }
    private void traslado(int posicion){
        Intent intentMostrarPais = new Intent(this,MostrarPais.class);
        intentMostrarPais.putExtra("imagenes",imagenes().get(posicion));
        intentMostrarPais.putExtra("informacion",informacion().get(posicion));
        startActivity(intentMostrarPais);
    }
}