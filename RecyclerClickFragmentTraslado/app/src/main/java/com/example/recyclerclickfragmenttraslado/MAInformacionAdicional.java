package com.example.recyclerclickfragmenttraslado;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

public class MAInformacionAdicional extends AppCompatActivity {

    private TextView textView;
    private ImageView imageView;
    private TabLayout tabLayout;
    private Fragment fragmentDetalle, fragmentEspecificaciones;
    private FragmentTransaction transaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainformacion_adicional);
        textView = findViewById(R.id.txtNombreInfoAdicional);
        imageView = findViewById(R.id.imgInfoAdicional);

        tabLayout = findViewById(R.id.tlId);
        tabLayout.addTab(tabLayout.newTab().setText("Detalle"));
        tabLayout.addTab(tabLayout.newTab().setText("Especificaciones"));

        fragmentDetalle = new FragmentDetalle();
        fragmentEspecificaciones = new FragmentEspecificacion();
        getSupportFragmentManager().beginTransaction().add(R.id.flContenedor,fragmentDetalle).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.flContenedor,fragmentEspecificaciones).hide(fragmentEspecificaciones);

        this.getData();
        this.obtenerYTrasladarInformacionAdicional();
        this.navegacionTabLayout();
    }
    private void navegacionTabLayout(){
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                transaction = getSupportFragmentManager().beginTransaction();
                switch (tab.getPosition()){
                    case 0:
                        if (fragmentDetalle.isAdded()) {
                            transaction.hide(fragmentEspecificaciones).show(fragmentDetalle);
                        }
                        else{
                            transaction.hide(fragmentEspecificaciones).add(R.id.flContenedor,fragmentDetalle);
                        }
                        break;
                    case 1:
                        if (fragmentEspecificaciones.isAdded()) {
                            transaction.hide(fragmentDetalle).show(fragmentEspecificaciones);
                        }
                        else{
                            transaction.hide(fragmentDetalle).add(R.id.flContenedor,fragmentEspecificaciones);
                        }
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
    private void getData(){
        Bundle bundle = getIntent().getExtras();
        Integer nombreD = bundle.getInt("nombreD");
        Integer imgD = bundle.getInt("imgD");
        //----
        textView.setText(nombreD);
        imageView.setImageResource(imgD);
    }


    private void obtenerYTrasladarInformacionAdicional(){
        Bundle bundle = getIntent().getExtras();
        int detalleD = bundle.getInt("detalleD");
        int especificacionesD = bundle.getInt("especificacionesD");
        trasladarInfoFragmentDetalle(detalleD);
        trasladarInfoFregmenteEspecificaciones(especificacionesD);
    }
    private void trasladarInfoFragmentDetalle(int detalleD){
        Bundle bundle = new Bundle();
        bundle.putInt("detalleDF", detalleD);
        fragmentDetalle.setArguments(bundle);
    }
    private void trasladarInfoFregmenteEspecificaciones(int especificacionesD){
        Bundle bundle = new Bundle();
        bundle.putInt("especificacionesDF",especificacionesD);
        fragmentEspecificaciones.setArguments(bundle);
    }
}