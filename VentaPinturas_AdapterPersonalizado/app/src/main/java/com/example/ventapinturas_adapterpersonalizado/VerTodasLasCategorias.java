package com.example.ventapinturas_adapterpersonalizado;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class VerTodasLasCategorias extends AppCompatActivity {

    private ListView listView;
    private TextView textViewTitulo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_todas_las_categorias);

        listView = findViewById(R.id.verCategoriasList);
        textViewTitulo = findViewById(R.id.verCategoriaNombreCategoria);
        AdapterPersonalizado2 adapterPersonalizado2 = new AdapterPersonalizado2(this,R.layout.list_secundaria,
                nombreObra(),detalleObra(),imgObra(),obtenerCategoria(),precioObra());
        listView.setAdapter(adapterPersonalizado2);

    }
    //CODIGO PARA LISTA PERSONALIZADA 2
    private ArrayList<Integer> nombreObra(){
        ArrayList<Integer> obra = new ArrayList<>();
        switch (obtenerCategoria()){
            case "Puntillismo":
                obra.add(R.string.ic_puntillismo_001_obra);
                obra.add(R.string.ic_puntillismo_002_obra);
                obra.add(R.string.ic_puntillismo_003_obra);
                return obra;
            case "Cubismo":
                obra.add(R.string.ic_cubismo_001_obra);
                obra.add(R.string.ic_cubismo_002_obra);
                obra.add(R.string.ic_cubismo_003_obra);
                break;
            case "Realismo":
                obra.add(R.string.ic_realismo_001_obra);
                obra.add(R.string.ic_realismo_002_obra);
                obra.add(R.string.ic_realismo_003_obra);
                break;
            default:
                break;
        }
        return obra;
    }
    private ArrayList<Integer> detalleObra(){
        ArrayList<Integer> detalle = new ArrayList<>();
        switch (obtenerCategoria()){
            case "Puntillismo":
                detalle.add(R.string.ic_puntillismo_001_detalle);
                detalle.add(R.string.ic_puntillismo_002_detalle);
                detalle.add(R.string.ic_puntillismo_003_detalle);
                return detalle;
            case "Cubismo":
                detalle.add(R.string.ic_cubismo_001_detalle);
                detalle.add(R.string.ic_cubismo_002_detalle);
                detalle.add(R.string.ic_cubismo_003_detalle);
                break;
            case "Realismo":
                detalle.add(R.string.ic_realismo_001_detalle);
                detalle.add(R.string.ic_realismo_002_detalle);
                detalle.add(R.string.ic_realismo_003_detalle);
                break;
            default:
                break;
        }
        return detalle;
    }
    private ArrayList<Integer> imgObra(){
        ArrayList<Integer> img = new ArrayList<>();
        switch (obtenerCategoria()){
            case "Puntillismo":
                img.add(R.drawable.ic_001_tarde_de_domingo);
                img.add(R.drawable.ic_002_seurat_bano_asnieres);
                img.add(R.drawable.ic_003_seurat_canal_gravelinas_petit_fort_philippe);
                return img;
            case "Cubismo":
                img.add(R.drawable.ic_cubismo_001);
                img.add(R.drawable.ic_cubismo_002);
                img.add(R.drawable.ic_cubismo_003);
                break;
            case "Realismo":
                img.add(R.drawable.ic_realismo_001);
                img.add(R.drawable.ic_realismo_002);
                img.add(R.drawable.ic_realismo_003);
                break;
            default:
                break;
        }
        return img;
    }
    private ArrayList<Integer> precioObra(){
        ArrayList<Integer> precio = new ArrayList<>();
        switch (obtenerCategoria()){
            case "Puntillismo":
                precio.add(R.string.ic_001_puntillismo_precio);
                precio.add(R.string.ic_002_puntillismo_precio);
                precio.add(R.string.ic_003_puntillismo_precio);
                break;
            case "Cubismo":
                precio.add(R.string.ic_001_cubismo_precio);
                precio.add(R.string.ic_002_cubismo_precio);
                precio.add(R.string.ic_003_cubismo_precio);
                break;
            case "Realismo":
                precio.add(R.string.ic_001_realismo_precio);
                precio.add(R.string.ic_002_realismo_precio);
                precio.add(R.string.ic_003_realismo_precio);
                break;
            default:
                break;
        }
        return precio;
    }
    private String obtenerCategoria(){
        Bundle bundle = getIntent().getExtras();
        String categoria="";
        if(bundle != null){
            categoria = bundle.getString("categoria");
            textViewTitulo.setText(String.valueOf(categoria));
        }
        return categoria;
    }
}