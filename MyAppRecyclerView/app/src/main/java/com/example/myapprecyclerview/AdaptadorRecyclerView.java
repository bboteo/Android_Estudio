package com.example.myapprecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorRecyclerView extends RecyclerView.Adapter<AdaptadorRecyclerView.ViewHolder> {


    private ArrayList<String> articulos = new ArrayList<>();

    //Constructor del adapter
    public AdaptadorRecyclerView(ArrayList<String> articulos) {
        this.articulos = articulos;
    }

    @NonNull
    @Override
    public AdaptadorRecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item,parent,false);

        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorRecyclerView.ViewHolder holder, int position) {
        holder.asignarDatos(articulos.get(position));
    }

    @Override
    public int getItemCount() {
        return this.articulos.size();
    }

    //esta clase se crea para solucionar el error en el extend de la clase principal
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.txtTextoRecycler);

        }

        //Se le va asignar los valores provenientes del arraylist a nuestros elementos views
        public void asignarDatos(String texto1){
            textView.setText(String.valueOf(texto1));
        }
    }
}
