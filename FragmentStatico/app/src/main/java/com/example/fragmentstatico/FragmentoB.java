package com.example.fragmentstatico;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentoB#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentoB extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentoB() {
        // Required empty public constructor
    }


/*
    // TODO: Rename and change types and number of parameters
    public static FragmentoB newInstance(String param1, String param2) {
        FragmentoB fragment = new FragmentoB();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
 */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragmento_b,container,false);
        this.estructuraFragment(v);
        return v;
    }

    private void estructuraFragment(View v){
        Button button;
        button = v.findViewById(R.id.btnPresionarFrgB);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = getActivity().findViewById(R.id.txtMostrarFrgA); //Para buscar objetos de otros fragmentos
                textView.setText("Lluvia en la Ciudad de Guatemala");
            }
        });
    }
}