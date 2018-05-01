package com.example.jsureda.musiquiz;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

public class Carga extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 1500;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carga);
        inicializarGUI();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Carga.this, Sesion.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
    private void inicializarGUI()
    {
        img = (ImageView) findViewById(R.id.imgCarga);
    }
}
