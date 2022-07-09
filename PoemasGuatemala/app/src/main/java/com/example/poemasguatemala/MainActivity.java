package com.example.poemasguatemala;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button1;
    private Button button2;
    private Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = (Button) findViewById(R.id.btnPoemasRomanticos);
        button1.setOnClickListener(this);
        button2 = (Button) findViewById(R.id.btnPoemasHimnos);
        button2.setOnClickListener(this);
        button3 = (Button) findViewById(R.id.btnPoemasSatira);
        button3.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnPoemasRomanticos:
                Intent intent1 = new Intent(this,PoemasAmor.class);
                startActivity(intent1);
                break;
            case R.id.btnPoemasHimnos:
                Intent intent2 = new Intent(this,PoemasHimnos.class);
                startActivity(intent2);
                break;
            case R.id.btnPoemasSatira:
                Intent intent3 = new Intent(this,PoemasSatira.class);
                startActivity(intent3);
                break;
            default:
                break;
        }
    }

}