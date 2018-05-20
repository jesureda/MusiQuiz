package com.example.jsureda.musiquiz;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;


public class Carga extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 1500;
    private SharedPreferences prefs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carga);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                prefs = PreferenceManager
                        .getDefaultSharedPreferences(getApplicationContext());
                if (!prefs.getBoolean("UserLoggedIn", false)) {

                    Intent intent = new Intent(Carga.this, Sesion.class);
                    startActivity(intent);
                    finish();

               } else {
                    Intent intent = new Intent(Carga.this, Principal.class);
                    startActivity(intent);
                    finish();
                }
            }
        }, SPLASH_TIME_OUT);
    }
}
