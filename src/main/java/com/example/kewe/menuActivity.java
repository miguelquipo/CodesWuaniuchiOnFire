package com.example.kewe;

import static com.example.kewe.R.id.*;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.example.kewe.databinding.ActivityMenu2Binding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class menuActivity extends AppCompatActivity {

    ActivityMenu2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMenu2Binding.inflate(getLayoutInflater());


        setContentView(binding.getRoot());

        replaceFragment(new HomeFragment());
        binding.bottomNavigationView.setBackground(null);

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {

            if (item.getItemId() == R.id.pPrincipal){
                replaceFragment(new HomeFragment());
            } else if (item.getItemId() == R.id.juegoUsu) {
                replaceFragment(new GameFragment());
            } else if (item.getItemId() == R.id.perfilUsu) {
                replaceFragment(new ProfileFragment());
            } else if (item.getItemId() == R.id.musicaUsu) {
                replaceFragment(new MusicFragment());
            }

            return true;

            });
        // Obtén una referencia al botón de Wi-Fi
        FloatingActionButton wifiButton = findViewById(R.id.wifiButton);

        // Configura el OnClickListener para abrir la configuración de Wi-Fi al hacer clic en el botón
        wifiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirConfiguracionWiFi();
            }
        });
//        cargarFragmento(new HomeFragment());
    }

//    public void cargarFragmento(Fragment fragment) {
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction transaction = fragmentManager.beginTransaction();
//        transaction.add(R.id.contentedorComponetes, fragment);
//      transaction.addToBackStack(null); // Opcional, para la navegación hacia atrás
//        transaction.commit();
//    }

    private void abrirConfiguracionWiFi() {
        Intent intent = new Intent(android.provider.Settings.ACTION_WIFI_SETTINGS);
        startActivity(intent);
    }

    private void  replaceFragment (Fragment fragment){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(frame_layout, fragment);
        fragmentTransaction.commit();
    }

}