package com.example.kewe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        setTheme(R.style.Theme_Kewe);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }


    public void irALogin(View v){
        Intent intent = new Intent(MainActivity.this,LoginActivity.class);
        startActivity(intent);
    }
}