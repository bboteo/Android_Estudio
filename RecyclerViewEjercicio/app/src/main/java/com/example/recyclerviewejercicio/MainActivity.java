package com.example.recyclerviewejercicio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private Toolbar toolbar;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Peliculas");

        recyclerView = findViewById(R.id.rvId);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        AdaptadorRecyclerView adaptadorRecyclerView = new AdaptadorRecyclerView(tituloPelicula(),imgPelicula(),comentarioPelicula());
        recyclerView.setAdapter(adaptadorRecyclerView);

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
            case R.id.btnLista:
                Toast.makeText(this, "Ver Lista", Toast.LENGTH_LONG).show();
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                break;
            case R.id.btnCuadricula:
                Toast.makeText(this, "Ver Cuadricula", Toast.LENGTH_LONG).show();
                recyclerView.setLayoutManager(new GridLayoutManager(this,2));
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private ArrayList<Integer> tituloPelicula(){
        ArrayList<Integer> tituloPelicula = new ArrayList<>();
        tituloPelicula.add(R.string.titulo_1_ElPadrino);
        tituloPelicula.add(R.string.titulo_2_MadMax);
        tituloPelicula.add(R.string.titulo_3_Parasitos);
        tituloPelicula.add(R.string.titulo_4_Tiburon);
        tituloPelicula.add(R.string.titulo_5_ElBueno);
        tituloPelicula.add(R.string.titulo_6_CazaFantasmas);
        tituloPelicula.add(R.string.titulo_7_Rambo);
        tituloPelicula.add(R.string.titulo_8_Terminator);
        tituloPelicula.add(R.string.titulo_9_Alien);
        tituloPelicula.add(R.string.titulo_10_ElResplandor);
        return tituloPelicula;
    }
    private ArrayList<Integer> imgPelicula(){
        ArrayList<Integer> imgPelicula = new ArrayList<>();
        imgPelicula.add(R.drawable.ic_el_padrino);
        imgPelicula.add(R.drawable.ic_mad_max);
        imgPelicula.add(R.drawable.ic_parasitos);
        imgPelicula.add(R.drawable.ic_tiburon);
        imgPelicula.add(R.drawable.ic_el_bueno_el_malo_el_feo);
        imgPelicula.add(R.drawable.ic_caza_fantasmas);
        imgPelicula.add(R.drawable.ic_rambo);
        imgPelicula.add(R.drawable.ic_terminator);
        imgPelicula.add(R.drawable.ic_alien);
        imgPelicula.add(R.drawable.ic_el_resplandor);
        return imgPelicula;
    }
    private ArrayList<Integer> comentarioPelicula(){
        ArrayList<Integer> comentarioPelicula = new ArrayList<>();
        comentarioPelicula.add(R.string.comentario_1_ElPadrino);
        comentarioPelicula.add(R.string.comentario_2_MadMax);
        comentarioPelicula.add(R.string.comentario_3_Parasitos);
        comentarioPelicula.add(R.string.comentario_4_Tiburon);
        comentarioPelicula.add(R.string.comentario_5_ElBueno);
        comentarioPelicula.add(R.string.comentario_6_CazaFantasmas);
        comentarioPelicula.add(R.string.comentario_7_Rambo);
        comentarioPelicula.add(R.string.comentario_8_Terminator);
        comentarioPelicula.add(R.string.comentario_9_Alien);
        comentarioPelicula.add(R.string.comentario_10_ElResplandor);
        return comentarioPelicula;
    }

}