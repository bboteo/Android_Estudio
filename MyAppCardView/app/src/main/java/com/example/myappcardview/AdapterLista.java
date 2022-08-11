package com.example.myappcardview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterLista extends BaseAdapter {
    private Context context;
    private int referenciaLista;
    ArrayList<String> hola = new ArrayList<>();

    public AdapterLista(Context context, int referenciaLista, ArrayList<String> hola) {
        this.context = context;
        this.referenciaLista = referenciaLista;
        this.hola = hola;
    }

    @Override
    public int getCount() {
        return this.hola.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        v = layoutInflater.inflate(R.layout.list_car,null);

        String texto = this.hola.get(position);
        TextView textSaludo = v.findViewById(R.id.textCard);
        textSaludo.setText(texto);
/*
        Integer nombreObra = this.nombreObra.get(position);
        Integer detalleObra = this.detalleObra.get(position);
        Integer imgObra = this.imgObra.get(position);
        Integer precioObra = this.precioObra.get(position);

        TextView textViewNombreObra = v.findViewById(R.id.list2NombreObra);
        TextView textViewDetalleObra = v.findViewById(R.id.list2DetalleObra);
        TextView textViewPrecioObra = v.findViewById(R.id.list2Precio);
        ImageView imageViewImgObra = v.findViewById(R.id.list2ImgObra);
        Button buttonAdquirir = v.findViewById(R.id.list2btnAdquirir);

        textViewNombreObra.setText(nombreObra);
        textViewDetalleObra.setText(detalleObra);
        textViewPrecioObra.setText(precioObra);
        imageViewImgObra.setImageResource(imgObra);
 */

        return v;
    }
}
