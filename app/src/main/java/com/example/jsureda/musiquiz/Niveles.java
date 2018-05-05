package com.example.jsureda.musiquiz;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Niveles extends AppCompatActivity {

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    FragNivel nivel = new FragNivel();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_niveles);
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frNivel1, nivel);
        fragmentTransaction.add(R.id.frNivel2, nivel);
        fragmentTransaction.add(R.id.frNivel3, nivel);
        fragmentTransaction.add(R.id.frNivel4, nivel);
        fragmentTransaction.commit();
    }
}
