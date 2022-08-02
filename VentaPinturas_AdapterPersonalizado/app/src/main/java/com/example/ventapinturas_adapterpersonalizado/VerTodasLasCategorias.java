package com.example.ventapinturas_adapterpersonalizado;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class VerTodasLasCategorias extends AppCompatActivity {

    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_todas_las_categorias);

        listView = findViewById(R.id.verCategoriasList);
        AdapterPersonalizado2 adapterPersonalizado2 = new AdapterPersonalizado2(this,R.layout.list_secundaria,nombreObra(),detalleObra(),imgObra());
        listView.setAdapter(adapterPersonalizado2);

    }
    //CODIGO PARA LISTA PERSONALIZADA 2
    private ArrayList<Integer> nombreObra(){
        ArrayList<Integer> obra = new ArrayList<>();
        switch (obtenerDatos()){
            case "Puntillismo":
                obra.add(R.string.ic_puntillismo_001_obra);
                obra.add(R.string.ic_puntillismo_002_obra);
                obra.add(R.string.ic_puntillismo_003_obra);
                return obra;
            case "Cubismo":
                break;
            case "Realismo":
                break;
            default:
                break;
        }
        return obra;
    }
    private ArrayList<Integer> detalleObra(){
        ArrayList<Integer> detalle = new ArrayList<>();
        switch (obtenerDatos()){
            case "Puntillismo":
                detalle.add(R.string.ic_puntillismo_001_detalle);
                detalle.add(R.string.ic_puntillismo_002_detalle);
                detalle.add(R.string.ic_puntillismo_003_detalle);
                return detalle;
            case "Cubismo":
                break;
            case "Realismo":
                break;
            default:
                break;
        }
        return detalle;
    }
    private ArrayList<Integer> imgObra(){
        ArrayList<Integer> img = new ArrayList<>();
        switch (obtenerDatos()){
            case "Puntillismo":
                img.add(R.drawable.ic_001_tarde_de_domingo);
                img.add(R.drawable.ic_002_seurat_bano_asnieres);
                img.add(R.drawable.ic_003_seurat_canal_gravelinas_petit_fort_philippe);
                return img;
            case "Cubismo":
                break;
            case "Realismo":
                break;
            default:
                break;
        }
        return img;
    }
    private String obtenerDatos(){
        Bundle bundle = getIntent().getExtras();
        String categoria="";
        if(bundle != null){
            categoria = bundle.getString("categoria");
        }
        return categoria;
    }
}