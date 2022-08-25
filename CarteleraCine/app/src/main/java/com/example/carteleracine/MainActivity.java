package com.example.carteleracine;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Par el Toolbar
        toolbar = findViewById(R.id.toolbarMain);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Cartelera");

        //Para el RecyclerView
        recyclerView = findViewById(R.id.recyclerMain);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        AdaptadorRecyclerView adaptadorRecyclerView = new AdaptadorRecyclerView(this.setItem());
        clickRecycler(adaptadorRecyclerView);
        recyclerView.setAdapter(adaptadorRecyclerView);
    }

    //Paso #8.2
    private void clickRecycler(AdaptadorRecyclerView adaptadorRecyclerView){
        adaptadorRecyclerView.setItemClickListener(new ClickListener(){
            @Override
            public void itemclick(Integer position, View v) {
                trasladarInformacioncompleta(position);
            }
        });
    }

    private ArrayList<DatosVO> setItem(){
        ArrayList<DatosVO> item = new ArrayList<>();
        item.add(new DatosVO(R.string.tituloPelicula1,R.string.duracionPelicula1,R.string.sinopsisPelicula1,
                R.string.elencoPelicula1,R.string.rottenTomatesPelicula1,
                R.drawable.ic_pelicula1_prey,31));
        item.add(new DatosVO(R.string.tituloPelicula2,R.string.duracionPelicula2,R.string.sinopsisPelicula2,
                R.string.elencoPelicula2,R.string.rottenTomatesPelicula2,
                R.drawable.ic_pelicula2_lightyear,32));
        item.add(new DatosVO(R.string.tituloPelicula3,R.string.duracionPelicula3,R.string.sinopsisPelicula3,
                R.string.elencoPelicula3,R.string.rottenTomatesPelicula3,
                R.drawable.ic_pelicula3_the_batman,33));
        item.add(new DatosVO(R.string.tituloPelicula4,R.string.duracionPelicula4,R.string.sinopsisPelicula4,
                R.string.elencoPelicula4,R.string.rottenTomatesPelicula4,
                R.drawable.ic_pelicula4_the_northman,34));
        item.add(new DatosVO(R.string.tituloPelicula5,R.string.duracionPelicula5,R.string.sinopsisPelicula5,
                R.string.elencoPelicula5,R.string.rottenTomatesPelicula5,
                R.drawable.ic_pelicula5_multiver_of_madness,35));
        item.add(new DatosVO(R.string.tituloPelicula6,R.string.duracionPelicula6,R.string.sinopsisPelicula6,
                R.string.elencoPelicula6,R.string.rottenTomatesPelicula6,
                R.drawable.ic_pelicula6_hustle,36));
        return item;
    }

    //#8.1 Para iniciar la nueva actividad y trasladar la informacion
    private void trasladarInformacioncompleta(int position){
        Intent intentDetalle = new Intent(getApplicationContext(),DetallePelicula.class);
        intentDetalle.putExtra("tituloPelicula",setItem().get(position).getTituloPelicula());
        intentDetalle.putExtra("duracionPelicula",setItem().get(position).getDuracionPelicula());
        intentDetalle.putExtra("sinopsisPelicula",setItem().get(position).getSinopsisPelicula());
        intentDetalle.putExtra("elencoPelicula",setItem().get(position).getElencoPelicula());
        intentDetalle.putExtra("rottenPelicula",setItem().get(position).getRottenPelicula());
        intentDetalle.putExtra("imgPelicula",setItem().get(position).getImgPelicula());
        intentDetalle.putExtra("precioPelicula",setItem().get(position).getPrecioPelicula());
        startActivity(intentDetalle);
    }

    //Para el ToolBar
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1Lista:
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                break;
            case R.id.item2Cuadricula:
                //recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));
                recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,LinearLayoutManager.HORIZONTAL));
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_item,menu);
        return true;
        //return super.onCreateOptionsMenu(menu);
    }
}