package com.example.myapprecyclerviewvo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rvId);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        AdaptadorRecyclerView adaptadorRecyclerView = new AdaptadorRecyclerView((this.datosVO()));
        recyclerView.setAdapter(adaptadorRecyclerView);
    }

    private ArrayList<DatosVO> datosVO(){
        ArrayList<DatosVO> datos = new ArrayList<>();
        datos.add(new DatosVO("La hamburguesa gigante","Muy deliciosas y gigantes",R.drawable.ic_launcher_foreground));
        datos.add(new DatosVO("Pizza x2","Ingredientes excelentes",R.drawable.ic_launcher_foreground));
        datos.add(new DatosVO("Super Tacos","tacos con todo!!!",R.drawable.ic_launcher_foreground));
        return datos;
    }
}