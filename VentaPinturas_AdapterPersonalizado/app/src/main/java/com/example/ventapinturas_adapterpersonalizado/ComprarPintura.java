package com.example.ventapinturas_adapterpersonalizado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ComprarPintura extends AppCompatActivity implements View.OnClickListener {

    private ImageView imgObra;
    private TextView nombreObra;
    private TextView precioObra;

    private EditText nombre;
    private EditText apellido;
    private EditText nit;

    private Button btnComprar;
    private Button btnCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comprar_pintura);

        imgObra = findViewById(R.id.comprarImg);
        nombreObra = findViewById(R.id.comprarObra);
        precioObra = findViewById(R.id.comprarPrecio);


        nombre = findViewById(R.id.comprarNombre);
        apellido = findViewById(R.id.comprarApellido);
        nit = findViewById(R.id.comprarNit);

        btnComprar = findViewById(R.id.btnComprar);
        btnComprar.setOnClickListener(this);
        btnCancelar = findViewById(R.id.btnCancelar);
        btnCancelar.setOnClickListener(this);

        obtenerObra();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnComprar:
                if(!nombre.getText().toString().isEmpty()||!apellido.getText().toString().isEmpty()||!nit.getText().toString().isEmpty()){
                    Intent intent = new Intent(this,CompraTerminada.class);
                    //PutExtra: NombrePintura, Nombre, Apellido, Nit, total
                    intent.putExtra("nombreObra",nombreObra.getText());
                    intent.putExtra("nombreCompra",nombre.getText().toString());
                    intent.putExtra("apellidoCompra",apellido.getText().toString());
                    intent.putExtra("compraNit",nit.getText().toString());
                    intent.putExtra("precioObra",precioObra.getText().toString());
                    startActivity(intent);
                }else{
                    Toast.makeText(this,"Todos los datos son obligatorios",Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.btnCancelar:
                this.finish();
                break;
            default:
                break;
        }

    }

    private void obtenerObra(){
        Bundle bundle = getIntent().getExtras();
        if (bundle!=null){
            Integer imgObra0 = bundle.getInt("imgObra");
            Integer nombreObra0 = bundle.getInt("nameObra");
            String precioObra0 = bundle.getString("precioObra");

            nombreObra.setText(nombreObra0);
            precioObra.setText(precioObra0);
            imgObra.setImageResource(imgObra0);
        }
    }
}