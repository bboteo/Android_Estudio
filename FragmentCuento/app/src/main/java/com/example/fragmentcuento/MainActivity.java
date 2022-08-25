package com.example.fragmentcuento;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton imageButtonLibros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageButtonLibros = findViewById(R.id.btnMainLibros);
        imageButtonLibros.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnMainLibros:
                Intent intent = new Intent(this,VerCuentos.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}