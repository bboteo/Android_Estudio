package com.example.ventapinturas_adapterpersonalizado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CompraTerminada extends AppCompatActivity implements View.OnClickListener {

    private TextView nombreObra;
    private TextView nombreCompra;
    private TextView apellidoCompra;
    private TextView compraNit;
    private TextView precioObra;
    private Button finalizar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compra_terminada);

        nombreObra = findViewById(R.id.finalObra);
        nombreCompra = findViewById(R.id.finalNombre);
        apellidoCompra = findViewById(R.id.finalApellido);
        compraNit = findViewById(R.id.finalNit);
        precioObra = findViewById(R.id.finalTotal);

        finalizar =findViewById(R.id.finalbtn);
        finalizar.setOnClickListener(this);

        obtenerDatos();
    }
    private void obtenerDatos(){
        Bundle bundle = getIntent().getExtras();

        if(bundle!=null){
            String nombreObra = bundle.getString("nombreObra");
            String nombreCompra = bundle.getString("nombreCompra");
            String apellidoCompra = bundle.getString("apellidoCompra");
            String compraNit = bundle.getString("compraNit");
            String precioObra = bundle.getString("precioObra");

            this.nombreObra.setText(nombreObra);
            this.nombreCompra.setText(nombreCompra);
            this.apellidoCompra.setText(apellidoCompra);
            this.compraNit.setText(compraNit);
            this.precioObra.setText(precioObra);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.finalbtn:
                this.finish();
                Intent intent1 = new Intent(this,MainActivity.class);
                startActivity(intent1);
                break;
            default:
                break;
        }
    }
}