package com.example.carteleracine;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class VerPortada extends AppCompatActivity implements View.OnClickListener {

    private ImageButton imageButtonCerrar;
    private ImageView imageViewPortada;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_portada);
        imageButtonCerrar = findViewById(R.id.btnCerrarPortada);
        imageButtonCerrar.setOnClickListener(this);
        imageViewPortada = findViewById(R.id.verPortada);

        imgPortada();
    }

    private void imgPortada(){
        Bundle bundle = getIntent().getExtras();
        imageViewPortada.setImageResource(bundle.getInt("imgPelicula"));
    }
    @Override
    public void onClick(View v) {
        this.finish();
    }
}