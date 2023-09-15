package com.example.kewe;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class GameFragment extends Fragment {

    private Button signOutButton;
    private ImageView profileImageView;
    private TextView nameTextView;
    private TextView emailTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_game, container, false);

    profileImageView = view.findViewById(R.id.profileImageView);
    nameTextView = view.findViewById(R.id.nameTextView);
    emailTextView = view.findViewById(R.id.emailTextView);



    // Obtén los datos del usuario actualmente autenticado
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
        String userName = user.getDisplayName();
        String userEmail = user.getEmail();
        Uri userPhotoUrl = user.getPhotoUrl();

        // Actualiza las vistas con los datos del usuario
        nameTextView.setText(userName);
        emailTextView.setText(userEmail);

        // Carga la foto de perfil utilizando una biblioteca de carga de imágenes (por ejemplo, Glide)
        if (userPhotoUrl != null) {
            Glide.with(this)
                    .load(userPhotoUrl)
                    .into(profileImageView);
        }

    }
        signOutButton = view.findViewById(R.id.signOutButton);

        signOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cerrar sesión
                FirebaseAuth.getInstance().signOut();

                // Redirigir al usuario a la pantalla de inicio de sesión o a otra actividad según sea necesario
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK); // Limpiar la pila de actividades
                startActivity(intent);
                getActivity().finish(); // Cierra la actividad actual
            }
        });

        return view;

}

}