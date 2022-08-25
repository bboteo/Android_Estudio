package com.example.carteleracine;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorRecyclerView extends RecyclerView.Adapter<AdaptadorRecyclerView.ViewHolder> {

    //Para el Recyclerview
    private ArrayList<DatosVO> datosVO = new ArrayList<>();

    //Para el clik en el RecyclerView
    private static ClickListener clickListener;

    public AdaptadorRecyclerView(ArrayList<DatosVO> datosVO) {
        this.datosVO = datosVO;
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
        holder.setDatos(datosVO.get(position).getTituloPelicula(),datosVO.get(position).getDuracionPelicula(),
              datosVO.get(position).getImgPelicula(),datosVO.get(position).getPrecioPelicula());
    }

    @Override
    public int getItemCount() {
        return this.datosVO.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView txtTituloPelicula, txtDuracionPelicula, txtPrecioPelicula;
        ImageView imgPelicula;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTituloPelicula = itemView.findViewById(R.id.tituloPeliculaMain);
            txtDuracionPelicula = itemView.findViewById(R.id.duracionPeliculaMain);
            txtPrecioPelicula = itemView.findViewById(R.id.precioPeliculaMain);
            imgPelicula = itemView.findViewById(R.id.imgPeliculaMain);

            itemView.setOnClickListener(this);
        }
        private void setDatos(Integer titulo, Integer detalles, Integer img, Integer precio){
            txtTituloPelicula.setText(titulo);
            txtDuracionPelicula.setText(detalles);
            txtPrecioPelicula.setText(String.valueOf(precio));
            imgPelicula.setImageResource(img);
        }

        @Override
        public void onClick(View v) {
            clickListener.itemclick(getAdapterPosition(),v);

        }
    }
    public void setItemClickListener(ClickListener clickListener){
        AdaptadorRecyclerView.clickListener = clickListener;
    }
}
