package com.example.ventapinturas_adapterpersonalizado;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listCategorias);

        AdapterPersonalizado adapterPersonalizado = new AdapterPersonalizado(this,R.layout.list_personalizada,nombreCategoria(),items(),img());
        listView.setAdapter(adapterPersonalizado);

    }

    private ArrayList<String> nombreCategoria(){
        ArrayList<String> categoria = new ArrayList<>();
        categoria.add("Puntillismo");
        categoria.add("Cubismo");
        categoria.add("Realismo");
        return categoria;
    }
    private ArrayList<Integer> items(){
        ArrayList<Integer> conteo = new ArrayList<>();
        conteo.add(3);
        conteo.add(3);
        conteo.add(3);
        return conteo;
    }
    private ArrayList<Integer> img(){
        ArrayList<Integer> img = new ArrayList<>();
        img.add(R.drawable.ic_puntillismo);
        img.add(R.drawable.ic_cubismo);
        img.add(R.drawable.ic_realismo);
        return img;
    }
}