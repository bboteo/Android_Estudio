package com.example.aniobisiesto_14jul2022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button1;
    private EditText editAnio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editAnio = findViewById(R.id.txtAnio);

        button1 = (Button) findViewById(R.id.btnAnio);
        button1.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnAnio:
                trasladarAnio();
                break;
            default:
                break;
        }
    }

    private void trasladarAnio(){
        String anio = editAnio.getText().toString();
        if(!anio.isEmpty() && Integer.parseInt(anio)!=0){
            Intent intent1 = new Intent(this,CalculoAnio.class);
            intent1.putExtra("anio",anio);
            startActivity(intent1);
        }
        else{
            Toast.makeText(this,"Anio no encontrado",Toast.LENGTH_LONG).show();
        }
    }
}