package com.example.carteleracine;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

public class DetallePelicula extends AppCompatActivity implements View.OnClickListener {

    private TabLayout tabLayout;
    private TextView textNombrePelicula;
    private ImageButton imageButtonPelicula;

    //Para los Fragmentos
    private Fragment fragmentSinopsis, fragmentElenco, fragmentPuntuacion;
    private FragmentTransaction transaction;

    //Para el boton
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_pelicula);

        //Para el Tab Layout
        tabLayout = findViewById(R.id.tabDetalle);
        tabLayout.addTab(tabLayout.newTab().setText("Sinopsis"));
        tabLayout.addTab(tabLayout.newTab().setText("Directores y Actores"));
        tabLayout.addTab(tabLayout.newTab().setText("Puntuacion y Recaudacion"));

        //Inicializacion de Fragmentos
        fragmentSinopsis = new FragmentSinopsis();
        fragmentElenco =  new FragmentElenco();
        fragmentPuntuacion = new FragmentPuntuacion();
        getSupportFragmentManager().beginTransaction().add(R.id.fragPelicula,fragmentSinopsis).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.fragPelicula,fragmentElenco).hide(fragmentElenco).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.fragPelicula,fragmentPuntuacion).hide(fragmentPuntuacion).commit();
        //Navegacion entre Fragmentos
        this.datosParaFragmentos();
        this.navegacionFragmentos();

        //Para encabezados Imagen y Titulo
        textNombrePelicula = findViewById(R.id.tituloPeliculaDetalle);
        imageButtonPelicula = findViewById(R.id.imgPeliculaDetalle);
        imageButtonPelicula.setOnClickListener(this);
        obtenerDatos();

        //Para el boton
        button = findViewById(R.id.btnCompraBoleto);
        button.setOnClickListener(this);
    }
    private void navegacionFragmentos() {
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                transaction = getSupportFragmentManager().beginTransaction();
                switch (tab.getPosition()){
                    case 0:
                        if(fragmentSinopsis.isAdded()){
                            transaction.hide(fragmentElenco).hide(fragmentPuntuacion).show(fragmentSinopsis);
                        }
                        else{
                            transaction.hide(fragmentElenco).hide(fragmentPuntuacion).add(R.id.fragPelicula,fragmentSinopsis);
                        }
                        break;
                    case 1:
                        if(fragmentElenco.isAdded()){
                            transaction.hide(fragmentSinopsis).hide(fragmentPuntuacion).show(fragmentElenco);
                        }
                        else{
                            transaction.hide(fragmentSinopsis).hide(fragmentPuntuacion).add(R.id.fragPelicula,fragmentElenco);
                        }
                        break;
                    case 2:
                        if(fragmentPuntuacion.isAdded()){
                            transaction.hide(fragmentSinopsis).hide(fragmentElenco).show(fragmentPuntuacion);
                        }
                        else{
                            transaction.hide(fragmentSinopsis).hide(fragmentElenco).add(R.id.fragPelicula,fragmentPuntuacion);
                        }
                        break;
                    default:
                        break;
                }
                transaction.commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
    private void obtenerDatos(){
        Bundle bundle = getIntent().getExtras();
        if (bundle!=null){
            textNombrePelicula.setText(bundle.getInt("tituloPelicula"));
            imageButtonPelicula.setImageResource(bundle.getInt("imgPelicula"));
        }
    }
    private void datosParaFragmentos(){
        Bundle bundle = getIntent().getExtras();
        int sinopsis = bundle.getInt("sinopsisPelicula");
        int elenco = bundle.getInt("elencoPelicula");
        int puntuacion = bundle.getInt("rottenPelicula");
        trasladarSinopsis(sinopsis);
        trasladarElenco(elenco);
        trasladarPuntuacion(puntuacion);
    }
    //Trasladar datos al fragmento sinopsis
    private void trasladarSinopsis(int sinopsis){
        Bundle bundle = new Bundle();
        bundle.putInt("sinopsisPelicula",sinopsis);
        fragmentSinopsis.setArguments(bundle);
    }
    private void trasladarElenco(int elenco){
        Bundle bundle = new Bundle();
        bundle.putInt("elencoPelicula",elenco);
        fragmentElenco.setArguments(bundle);
    }
    private void trasladarPuntuacion(int puntuacion){
        Bundle bundle = new Bundle();
        bundle.putInt("rottenPelicula",puntuacion);
        fragmentPuntuacion.setArguments(bundle);
    }
    //Para escuchar el boton
    @Override
    public void onClick(View v) {
        Bundle bundle = getIntent().getExtras();
        int precioPelicula = bundle.getInt("precioPelicula");
        switch (v.getId()){
            case R.id.btnCompraBoleto:
                Intent intent = new Intent(this,ComprarBoleto.class);
                intent.putExtra("precioPelicula",precioPelicula);
                startActivity(intent);
                break;
            case R.id.imgPeliculaDetalle:
                Bundle bundle1 = getIntent().getExtras();
                Intent intentPortada = new Intent(this,VerPortada.class);
                intentPortada.putExtra("imgPelicula",bundle1.getInt("imgPelicula"));
                startActivity(intentPortada);
            default:
                break;
        }
    }
}