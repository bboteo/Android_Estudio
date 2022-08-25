package com.example.carteleracine;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class FragmentPuntuacion extends Fragment {

    private int puntuacion;

    public FragmentPuntuacion() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            puntuacion = getArguments().getInt("rottenPelicula");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_puntuacion,container,false);
        estructuraFragmento(v);
        return v;
    }

    private void estructuraFragmento(View v){
        TextView textView = v.findViewById(R.id.txtFragmentPuntuacion);
        textView.setText(puntuacion);
    }
}