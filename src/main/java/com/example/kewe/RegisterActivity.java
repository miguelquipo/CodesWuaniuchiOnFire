package com.example.kewe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    private EditText etName, etEmail, etPassword;
    private FirebaseAuth mAuth;
    private TextView irSigin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();

        etName = findViewById(R.id.Usuario);
        etEmail = findViewById(R.id.Correo);
        etPassword = findViewById(R.id.Password);
        irSigin=findViewById(R.id.Tv_Iniciarsesion);

        Button btnRegister = findViewById(R.id.btn_registrarse);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });

        irSigin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void registerUser() {
        String name = etName.getText().toString();
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // El registro fue exitoso. Puedes redirigir al usuario a la página de inicio o realizar otras acciones necesarias.
                            Toast.makeText(RegisterActivity.this, "Registro exitoso", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                            startActivity(intent);
                            etEmail.setText("");
                            etEmail.setText("");
                            etPassword.setText("");

                        } else {
                            // Si el registro falla, muestra un mensaje al usuario.
                            Toast.makeText(RegisterActivity.this, "Error al registrar. Por favor, intenta nuevamente.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }
}