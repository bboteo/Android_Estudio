package com.example.carteleracine;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class FragmentElenco extends Fragment {

    private int elenco;

    public FragmentElenco() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            elenco = getArguments().getInt("elencoPelicula");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_elenco,container,false);
        estructuraFragmento(v);
        return v;
    }

    private void estructuraFragmento(View v){
        TextView textView = v.findViewById(R.id.txtFragmentElenco);
        textView.setText(elenco);
    }
}