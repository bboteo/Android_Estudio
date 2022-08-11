package com.example.recyclerviewejercicio;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorRecyclerView extends RecyclerView.Adapter<AdaptadorRecyclerView.ViewHolder> {

    private ArrayList<Integer> tituloPelicula = new ArrayList<>();
    private ArrayList<Integer> imgPelicula = new ArrayList<>();
    private ArrayList<Integer> comentarioPelicula = new ArrayList<>();

    public AdaptadorRecyclerView(ArrayList<Integer> tituloPelicula, ArrayList<Integer> imgPelicula, ArrayList<Integer> comentarioPelicula) {
        this.tituloPelicula = tituloPelicula;
        this.imgPelicula = imgPelicula;
        this.comentarioPelicula = comentarioPelicula;
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
        holder.asignarDatos(tituloPelicula.get(position),comentarioPelicula.get(position),imgPelicula.get(position));
    }

    @Override
    public int getItemCount() {
        return this.tituloPelicula.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView tituloPelicula;
        private ImageView imgPelicula;
        private TextView comentarioPelicula;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tituloPelicula = itemView.findViewById(R.id.txtTituloPelicula);
            imgPelicula = itemView.findViewById(R.id.imgPelicula);
            comentarioPelicula = itemView.findViewById(R.id.txtComentarioPelicula);
        }

        public void asignarDatos(Integer titulo, Integer comentario, Integer img){
            tituloPelicula.setText(titulo);
            imgPelicula.setImageResource(img);
            comentarioPelicula.setText(comentario);
        }
    }
}
