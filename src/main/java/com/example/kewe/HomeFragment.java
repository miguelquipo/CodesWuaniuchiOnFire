package com.example.kewe;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class HomeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_home, container, false);

//        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
//
//        // Obtén una referencia al botón en el fragmento
//        Button cambiarFragmentoButton = rootView.findViewById(R.id.cardComponetes);
//
//        // Configura un OnClickListener para el botón
//        cambiarFragmentoButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Cargar el fragmento que deseas mostrar
//                ((menuActivity) requireActivity()).cargarFragmento(new cbComponetesFragment());
//            }
//        });
//
//        return rootView;
    }
}