package com.example.listview_paises;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MostrarPais extends AppCompatActivity {
    private TextView textView;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_pais);
        textView = findViewById(R.id.txtBandera);
        imageView = findViewById(R.id.imgBandera);

        this.obtener();
    }
    private void obtener(){
        Bundle bundle = getIntent().getExtras();
        int imagen = bundle.getInt("imagenes");
        int info = bundle.getInt("informacion");
        imageView.setImageResource(imagen);
        textView.setText(info);
    }
}