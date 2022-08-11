package com.example.myapprecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //La importacion debe ser la misma que en el layout
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rvId);


        //esto define como se van a presentar los datos
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        //recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        //recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));

        AdaptadorRecyclerView adaptadorRecyclerView = new AdaptadorRecyclerView(articulosOficina());
        recyclerView.setAdapter(adaptadorRecyclerView);

    }
    private ArrayList<String> articulosOficina(){
        ArrayList<String> articulos = new ArrayList<>();
        articulos.add("Lapicero");
        articulos.add("Lapiz");
        articulos.add("Computadora");
        articulos.add("Hojas de papel");
        articulos.add("Engrapadora");
        articulos.add("Silla");
        articulos.add("Escritorio");
        articulos.add("Folder");
        articulos.add("Sobres");
        articulos.add("Telefono");
        return articulos;
    }
}