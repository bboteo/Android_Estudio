package com.example.ventapinturas_adapterpersonalizado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class VerCategoriaCubismo extends AppCompatActivity implements View.OnClickListener {

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
        setContentView(R.layout.activity_ver_categoria_cubismo);

        precioObra1 = findViewById(R.id.precio_ic_001_cubismo);
        precioObra2 = findViewById(R.id.precio_ic_002_cubismo);
        precioObra3 = findViewById(R.id.precio_ic_003_cubismo);

        //Se asignan los precios a las obras
        precioObra1.setText("Q100.00");
        precioObra2.setText("Q100.00");
        precioObra3.setText("Q100.00");

        btnObra1 = findViewById(R.id.btn_ic_001_cubismo);
        btnObra1.setOnClickListener(this);
        btnObra2 = findViewById(R.id.btn_ic_002_cubismo);
        btnObra2.setOnClickListener(this);
        btnObra3 = findViewById(R.id.btn_ic_003_cubismo);
        btnObra3.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_ic_001_cubismo:
                codigoObra = "ic_001_cubismo";
                imgObra = R.drawable.ic_cubismo_001;
                nameObra = R.string.ic_cubismo_001_obra;
                precioObra = "Q100.00";

                Intent intentCubismo1 = new Intent(this,ComprarPintura.class);
                intentCubismo1.putExtra("categoria","Cubismo");
                intentCubismo1.putExtra("codigoObra", codigoObra);
                intentCubismo1.putExtra("imgObra",imgObra);
                intentCubismo1.putExtra("nameObra",nameObra);
                intentCubismo1.putExtra("precioObra",precioObra);
                startActivity(intentCubismo1);
                break;
            case R.id.btn_ic_002_cubismo:
                codigoObra = "ic_002_cubismo";
                imgObra = R.drawable.ic_cubismo_002;
                nameObra = R.string.ic_cubismo_002_obra;
                precioObra = "Q.100.00";

                Intent intentCubismo2 = new Intent(this,ComprarPintura.class);
                intentCubismo2.putExtra("categoria","Cubismo");
                intentCubismo2.putExtra("codigoObra", codigoObra);
                intentCubismo2.putExtra("imgObra",imgObra);
                intentCubismo2.putExtra("nameObra",nameObra);
                intentCubismo2.putExtra("precioObra",precioObra);
                startActivity(intentCubismo2);
                break;
            case R.id.btn_ic_003_puntillismo:
                codigoObra = "ic_003_cubismo";
                imgObra = R.drawable.ic_cubismo_003;
                nameObra = R.string.ic_cubismo_003_obra;
                precioObra = "Q100.00";

                Intent intentCubismo3 = new Intent(this,ComprarPintura.class);
                intentCubismo3.putExtra("categoria","Cubismo");
                intentCubismo3.putExtra("codigoObra", codigoObra);
                intentCubismo3.putExtra("imgObra",imgObra);
                intentCubismo3.putExtra("nameObra",nameObra);
                intentCubismo3.putExtra("precioObra",precioObra);
                startActivity(intentCubismo3);
                break;
            default:
                break;
        }
    }
}