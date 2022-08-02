package com.example.ventapinturas_adapterpersonalizado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class VerCategoriaPuntillismo extends AppCompatActivity implements View.OnClickListener {
    private ListView listView;
    private Button btnObra1;
    private Button btnObra2;
    private Button btnObra3;

    //Precio de las obras
    private TextView precioObra1;
    private TextView precioObra2;
    private TextView precioObra3;

    //Lo que debe enviarse a las siguientes pantallas
    private String codigoObra;
    private Integer imgObra;
    private Integer nameObra;
    private String precioObra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_categoria_puntillismo);

        precioObra1 = findViewById(R.id.precio_ic_001_puntillismo);
        precioObra2 = findViewById(R.id.precio_ic_002_puntillismo);
        precioObra3 = findViewById(R.id.precio_ic_003_puntillismo);

        //Se asignan los precios a las obras
        precioObra1.setText("Q9.98");
        precioObra2.setText("Q9.98");
        precioObra3.setText("Q9.98");

        btnObra1 = findViewById(R.id.btn_ic_001_puntillismo);
        btnObra1.setOnClickListener(this);
        btnObra2 = findViewById(R.id.btn_ic_002_puntillismo);
        btnObra2.setOnClickListener(this);
        btnObra3 = findViewById(R.id.btn_ic_003_puntillismo);
        btnObra3.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_ic_001_puntillismo:
                codigoObra = "ic_001_puntillismo";
                imgObra = R.drawable.ic_001_tarde_de_domingo;
                nameObra = R.string.ic_puntillismo_001_obra;
                precioObra = "Q9.98";

                Intent intentPuntillismo1 = new Intent(this,ComprarPintura.class);
                intentPuntillismo1.putExtra("categoria","Puntillismo");
                intentPuntillismo1.putExtra("codigoObra", codigoObra);
                intentPuntillismo1.putExtra("imgObra",imgObra);
                intentPuntillismo1.putExtra("nameObra",nameObra);
                intentPuntillismo1.putExtra("precioObra",precioObra);
                startActivity(intentPuntillismo1);
                break;
            case R.id.btn_ic_002_puntillismo:
                codigoObra = "ic_002_puntillismo";
                imgObra = R.drawable.ic_002_seurat_bano_asnieres;
                nameObra = R.string.ic_puntillismo_002_obra;
                precioObra = "Q.9.98";

                Intent intentPuntillismo2 = new Intent(this,ComprarPintura.class);
                intentPuntillismo2.putExtra("categoria","Puntillismo");
                intentPuntillismo2.putExtra("codigoObra", codigoObra);
                intentPuntillismo2.putExtra("imgObra",imgObra);
                intentPuntillismo2.putExtra("nameObra",nameObra);
                intentPuntillismo2.putExtra("precioObra",precioObra);
                startActivity(intentPuntillismo2);
                break;
            case R.id.btn_ic_003_puntillismo:
                codigoObra = "ic_003_puntillismo";
                imgObra = R.drawable.ic_003_seurat_canal_gravelinas_petit_fort_philippe;
                nameObra = R.string.ic_puntillismo_003_obra;
                precioObra = "Q9.98";

                Intent intentPuntillismo3 = new Intent(this,ComprarPintura.class);
                intentPuntillismo3.putExtra("categoria","Puntillismo");
                intentPuntillismo3.putExtra("codigoObra", codigoObra);
                intentPuntillismo3.putExtra("imgObra",imgObra);
                intentPuntillismo3.putExtra("nameObra",nameObra);
                intentPuntillismo3.putExtra("precioObra",precioObra);
                startActivity(intentPuntillismo3);
                break;
            default:
                break;
        }
    }

    /*
    CODIGO PARA LISTA PERSONALIZADA 2
    private ArrayList<Integer> nombreObra(){
        ArrayList<Integer> obra = new ArrayList<>();
        obra.add(R.string.ic_puntillismo_001_obra);
        obra.add(R.string.ic_puntillismo_002_obra);
        obra.add(R.string.ic_puntillismo_003_obra);
        return obra;
    }
    private ArrayList<Integer> detalleObra(){
        ArrayList<Integer> detalle = new ArrayList<>();
        detalle.add(R.string.ic_puntillismo_001_detalle);
        detalle.add(R.string.ic_puntillismo_002_detalle);
        detalle.add(R.string.ic_puntillismo_003_detalle);
        return detalle;
    }
    private ArrayList<Integer> imgObra(){
        ArrayList<Integer> img = new ArrayList<>();
        img.add(R.drawable.ic_001_tarde_de_domingo);
        img.add(R.drawable.ic_002_seurat_bano_asnieres);
        img.add(R.drawable.ic_003_seurat_canal_gravelinas_petit_fort_philippe);
        return img;
    }
     */
}