package com.example.recyclerclickfragmenttraslado;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rvId);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        AdaptadorRecycler adaptadorRecycler = new AdaptadorRecycler(this.setItem());
        clickRecycler(adaptadorRecycler); //Aca se manda a llamar el paso 8
        recyclerView.setAdapter(adaptadorRecycler);

    }
    //Paso#8
    private void clickRecycler(AdaptadorRecycler adaptadorRecycler){
        adaptadorRecycler.setItemClickListener(new ClickListener() {
            @Override
            public void itemClick(Integer position, View v) {
                //trasladarDatosPrincipales(position);
                //trasladarInformacionCompleta(position);
                trasladarInformacionComplepleta(position);
            }
        });
    }

    private ArrayList<DatosVO> setItem(){
        ArrayList<DatosVO> item = new ArrayList<>();
        item.add(new DatosVO(R.drawable.ic_smartphone,R.string.nombreD1,R.string.precioD1));
        item.add(new DatosVO(R.drawable.ic_laptop,R.string.nombreD2,R.string.precioD2));
        item.add(new DatosVO(R.drawable.ic_auriculares,R.string.nombreD3,R.string.precioD3));
        item.add(new DatosVO(R.drawable.ic_television,R.string.nombreD4,R.string.precioD4));
        return item;
    }
    /*
    private void trasladarDatosPrincipales(int position){
        Intent intent = new Intent(getApplicationContext(),MAInformacionAdicional.class);
        intent.putExtra("nombreD",setItem().get(position).getNombre());
        intent.putExtra("imgD",setItem().get(position).getImgen());
        startActivity(intent);
    }
     */

    private ArrayList<DatosVO> datosInformacionAdicional(){
        ArrayList<DatosVO> datosInfo = new ArrayList<>();
        datosInfo.add(new DatosVO(R.string.detalleD1,R.string.especificacionesD1));
        datosInfo.add(new DatosVO(R.string.detalleD2,R.string.especificacionesD2));
        datosInfo.add(new DatosVO(R.string.detalleD2,R.string.especificacionesD2));
        datosInfo.add(new DatosVO(R.string.detalleD2,R.string.especificacionesD2));
        return datosInfo;
    }

    //Continuacion del paso #8
    private void trasladarInformacionComplepleta(int position){
        Intent intent = new Intent(getApplicationContext(),MAInformacionAdicional.class);
        intent.putExtra("nombreD",setItem().get(position).getNombre());
        intent.putExtra("imgD",setItem().get(position).getImgen());
        intent.putExtra("detalleD",datosInformacionAdicional().get(position).getDetalle());
        intent.putExtra("especificacionesD",datosInformacionAdicional().get(position).getEspecificaciones());
        startActivity(intent);
    }
}