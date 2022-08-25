package com.example.recyclerviewagenda;

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

        AdaptadorRecyclerView adaptadorRecyclerView = new AdaptadorRecyclerView(this.datosVO());
        recyclerView.setAdapter(adaptadorRecyclerView);

    }
    private ArrayList<DatosVO> datosVO(){
        ArrayList<DatosVO> datosVO = new ArrayList<>();
        datosVO.add(new DatosVO("Afrodita","Diosa Griega del Amor",R.drawable.ic_afrodita));
        datosVO.add(new DatosVO("Ares","Dios Griego de la Guerra",R.drawable.ic_ares));
        datosVO.add(new DatosVO("Demeter","Diosa Griega de la Agruicultura",R.drawable.ic_demeter));
        datosVO.add(new DatosVO("Freyja","Diosa Nordica del Amor",R.drawable.ic_feyja));
        datosVO.add(new DatosVO("Hades","Dios Griego de la muerte",R.drawable.ic_hades));
        datosVO.add(new DatosVO("Hebe","Hija de Zeus y Hera",R.drawable.ic_hebe));
        datosVO.add(new DatosVO("Hera","Diosa Griega de Matrimonio",R.drawable.ic_hera));
        datosVO.add(new DatosVO("Loki","Dios Nordico del engano",R.drawable.ic_loki));
        datosVO.add(new DatosVO("Poseidon","Dios Griego de los mares",R.drawable.ic_poseidon));
        datosVO.add(new DatosVO("Zeus","Dios Griego del Rayo",R.drawable.ic_zeus));
        return datosVO;
    }
}