package com.example.recyclerclickfragmenttraslado;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorRecycler extends RecyclerView.Adapter<AdaptadorRecycler.ViewHolder> {

    private ArrayList<DatosVO> datosVO = new ArrayList<>();

    //Paso #2: para agregar el Click
    private static ClickListener clickListener;

    public AdaptadorRecycler(ArrayList<DatosVO> datosVO) {
        this.datosVO = datosVO;
    }

    @NonNull
    @Override
    public AdaptadorRecycler.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item,parent,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorRecycler.ViewHolder holder, int position) {
        holder.setData(datosVO.get(position).getImgen(),datosVO.get(position).getNombre(),datosVO.get(position).getPrecio());

    }

    @Override
    public int getItemCount() {
        return this.datosVO.size();
    }

    //Paso #3 Hacer el extend del View.OnClickListener
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ImageView imageView;
        private TextView textViewNombre, textViewPrecio;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //Aca esta el error
            imageView = itemView.findViewById(R.id.imgRecycler);
            textViewNombre = itemView.findViewById(R.id.txtNombreRecycler);
            textViewPrecio = itemView.findViewById(R.id.txtPrecioRecycler);

            //Paso#6
            itemView.setOnClickListener(this);


        }
        private void setData(Integer img, Integer nombre, Integer precio ){
            imageView.setImageResource(img);
            textViewNombre.setText(nombre);
            textViewPrecio.setText(precio);
        }

        //Paso #4: Agregar los metodos implementados del OnclickListener
        @Override
        public void onClick(View v) {
            //Paso#7
            clickListener.itemClick(getAdapterPosition(),v);
        }
    }
    //Paso#5: Crear metodo para el clik con relacion a la interfaz
    public void setItemClickListener(ClickListener clickListener){
        AdaptadorRecycler.clickListener = clickListener;
    }
}
