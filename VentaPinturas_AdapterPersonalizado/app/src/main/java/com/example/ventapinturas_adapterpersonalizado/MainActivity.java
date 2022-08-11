package com.example.ventapinturas_adapterpersonalizado;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listCategorias);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Nuevo Toolbar");

        AdapterPersonalizado adapterPersonalizado = new AdapterPersonalizado(this,R.layout.list_personalizada,nombreCategoria(),items(),img());
        listView.setAdapter(adapterPersonalizado);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_item,menu);
        return true;
        //return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.itemTelefono:
                Toast.makeText(this,"Ver Telefono",Toast.LENGTH_LONG).show();
                break;
            case R.id.itemCorreo:
                Toast.makeText(this,"Ver Correo",Toast.LENGTH_LONG).show();
                break;
            case R.id.itemWhatsapp:
                Toast.makeText(this,"Ver WhatsApp",Toast.LENGTH_LONG).show();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    private ArrayList<String> nombreCategoria(){
        ArrayList<String> categoria = new ArrayList<>();
        categoria.add("Puntillismo");
        categoria.add("Cubismo");
        categoria.add("Realismo");
        return categoria;
    }
    private ArrayList<Integer> items(){
        ArrayList<Integer> conteo = new ArrayList<>();
        conteo.add(3);
        conteo.add(3);
        conteo.add(3);
        return conteo;
    }
    private ArrayList<Integer> img(){
        ArrayList<Integer> img = new ArrayList<>();
        img.add(R.drawable.ic_puntillismo);
        img.add(R.drawable.ic_cubismo);
        img.add(R.drawable.ic_realismo);
        return img;
    }
}