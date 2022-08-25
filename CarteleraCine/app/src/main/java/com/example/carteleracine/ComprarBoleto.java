package com.example.carteleracine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class ComprarBoleto extends AppCompatActivity implements View.OnClickListener {

    private TextView totalAPagar, cantidadBoletos;
    private EditText nombreCompra, apellidoCompra, nitCompra;
    private ImageButton buttonMenos, buttonMas, buttonComprar;

    //Variables para obtener precio:
    private Double precioPelicula;
    private Integer boletos = 0;
    private Double total = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comprar_boleto);

        nombreCompra = findViewById(R.id.edtNombreCompra);
        apellidoCompra = findViewById(R.id.edtApellidoCompra);
        nitCompra = findViewById(R.id.edtNitCompra);
        cantidadBoletos = findViewById(R.id.edtCantidadBoletos);

        totalAPagar = findViewById(R.id.txtTotalAPagar);
        totalAPagar.setText("0.0");

        buttonMenos = findViewById(R.id.btnMenosBoletos);
        buttonMenos.setOnClickListener(this);
        buttonMas = findViewById(R.id.btnMasBoletos);
        buttonMas.setOnClickListener(this);
        buttonComprar = findViewById(R.id.btnPagarTotal);
        buttonComprar.setOnClickListener(this);

        obtenerPrecio();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnMenosBoletos:
                if(boletos>0){
                    boletos = boletos - 1;
                    cantidadBoletos.setText(String.valueOf(boletos));
                    monto();
                }
                break;
            case R.id.btnMasBoletos:
                boletos = boletos + 1;
                cantidadBoletos.setText(String.valueOf(boletos));
                monto();
                break;
            case R.id.btnPagarTotal:
                validarCompra();
                break;
            default:
                break;
        }
    }
    private void obtenerPrecio(){
        Bundle bundle = getIntent().getExtras();
        precioPelicula = Double.valueOf(bundle.getInt("precioPelicula"));
    }
    private void monto(){
        total = boletos * precioPelicula;
        totalAPagar.setText(String.valueOf(total));
    }
    private void validarCompra(){
        String nombre = String.valueOf(nombreCompra.getText());
        String apellido = String.valueOf(apellidoCompra.getText());
        String nit = String.valueOf(nitCompra.getText());
        if (nombre.isEmpty()||apellido.isEmpty()||nit.isEmpty()){
            Toast.makeText(this, "Complete todos los campos", Toast.LENGTH_SHORT).show();
        }
        else{
            if (total==0){
                Toast.makeText(this, "Debe comprar al menos 1 boleto", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(this, "Su compra fue Satisfactoria", Toast.LENGTH_SHORT).show();
                this.finish();
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        }
    }
}