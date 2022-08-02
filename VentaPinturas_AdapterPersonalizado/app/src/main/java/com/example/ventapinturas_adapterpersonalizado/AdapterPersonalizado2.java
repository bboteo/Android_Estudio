package com.example.ventapinturas_adapterpersonalizado;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterPersonalizado2 extends BaseAdapter {

    private Context context;
    private int referencia;
    private ArrayList<Integer> nombreObra = new ArrayList<>();
    private ArrayList<Integer> detalleObra = new ArrayList<>();
    private ArrayList<Integer> imgObra = new ArrayList<>();

    public AdapterPersonalizado2(Context context, int referencia, ArrayList<Integer> nombreObra, ArrayList<Integer> detalleObra, ArrayList<Integer> imgObra) {
        this.context = context;
        this.referencia = referencia;
        this.nombreObra = nombreObra;
        this.detalleObra = detalleObra;
        this.imgObra = imgObra;
    }

    @Override
    public int getCount() {
        return this.nombreObra.size();
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
        v = layoutInflater.inflate(R.layout.list_secundaria,null);

        Integer nombreObra = this.nombreObra.get(position);
        Integer detalleObra = this.detalleObra.get(position);
        Integer imgObra = this.imgObra.get(position);

        TextView textViewNombreObra = v.findViewById(R.id.list2NombreObra);
        TextView textViewDetalleObra = v.findViewById(R.id.list2DetalleObra);
        ImageView imageViewImgObra = v.findViewById(R.id.list2ImgObra);
        Button buttonAdquirir = v.findViewById(R.id.list2btnAdquirir);

        textViewNombreObra.setText(nombreObra);
        textViewDetalleObra.setText(detalleObra);
        imageViewImgObra.setImageResource(imgObra);

        //Metodo para el boton
        buttonAdquirir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return v;
    }
}
