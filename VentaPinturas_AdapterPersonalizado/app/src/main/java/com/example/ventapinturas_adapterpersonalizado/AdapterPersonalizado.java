package com.example.ventapinturas_adapterpersonalizado;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterPersonalizado extends BaseAdapter {

    private Context context;
    private int refenciaLista;
    ArrayList<String> categoria = new ArrayList<>();
    ArrayList<Integer> items = new ArrayList<>();
    ArrayList<Integer> img = new ArrayList<>();
    public AdapterPersonalizado(Context context, int refenciaLista,
                                ArrayList<String> categoria, ArrayList<Integer> items, ArrayList<Integer> img) {
        this.context = context;
        this.refenciaLista = refenciaLista;
        this.categoria = categoria;
        this.items = items;
        this.img = img;
    }


    @Override
    public int getCount() {
        return this.categoria.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = view;
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        v = layoutInflater.inflate(R.layout.list_personalizada,null);

        String categoria1 = this.categoria.get(i);
        Integer items1 = this.items.get(i);
        Integer img1 = this.img.get(i);

        TextView textViewCategoria = v.findViewById(R.id.nombreCategoria);
        TextView textViewItems = v.findViewById(R.id.itemsCategoria);
        ImageView imageView = v.findViewById(R.id.imgList);
        Button buttonVer = v.findViewById(R.id.btnVer);

        textViewCategoria.setText(String.valueOf(categoria1));
        textViewItems.setText(String.valueOf("Items en stock"+items1));
        imageView.setImageResource(img1);

        //Metodo para el boton
        buttonVer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                trasladarDatos(categoria1);
            }
        });

        return v;
    }
    private void trasladarDatos(String categoria){
        switch (categoria){
            case "Puntillismo":
                Intent intentPuntillismo = new Intent(context,VerTodasLasCategorias.class);
                intentPuntillismo.putExtra("categoria","Puntillismo");
                context.startActivity(intentPuntillismo);
                break;
            case "Cubismo":
                Intent intentCubismo = new Intent(context,VerTodasLasCategorias.class);
                intentCubismo.putExtra("categoria","Cubismo");
                context.startActivity(intentCubismo);
                break;
            case "Realismo":
                Intent intentRealismo = new Intent(context,VerTodasLasCategorias.class);
                intentRealismo.putExtra("categoria","Realismo");
                context.startActivity(intentRealismo);
                break;
            default:
                break;
        }
    }
}
