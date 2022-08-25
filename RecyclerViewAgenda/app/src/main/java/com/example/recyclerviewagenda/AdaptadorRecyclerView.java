package com.example.recyclerviewagenda;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorRecyclerView extends RecyclerView.Adapter<AdaptadorRecyclerView.ViewHolder> {

    private ArrayList<DatosVO> datosVO = new ArrayList<>();

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
        holder.asignarDatos(datosVO.get(position).getContacto(),datosVO.get(position).getDetalles(),datosVO.get(position).getImgcontacto());
    }

    @Override
    public int getItemCount() {
        return this.datosVO.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewNombre, textViewDetalle;
        private ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewNombre = itemView.findViewById(R.id.txtNombreContacto);
            textViewDetalle = itemView.findViewById(R.id.txtDetalleContacto);
            imageView = itemView.findViewById(R.id.imgContacto);
        }
        private void asignarDatos(String nombreContacto, String detalleContacto, Integer imgContacto){
            textViewNombre.setText(String.valueOf(nombreContacto));
            textViewDetalle.setText(String.valueOf(detalleContacto));
            imageView.setImageResource(imgContacto);
        }
    }
}
