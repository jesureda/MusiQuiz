package com.example.jsureda.musiquiz;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Niveles extends AppCompatActivity {

    ArrayList<Nivel> levels = new ArrayList<Nivel>();
    ListView lv;
    AdapterNivel adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_niveles);
        rellenarArray(levels);
        lv = (ListView) findViewById(R.id.listNivel);
        adapter = new AdapterNivel(this, levels);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(

                new AdapterView.OnItemClickListener() {
                    public void onItemClick(
                            AdapterView<?> adapter, View v, int position, long id) {
/*
                        intencion.putExtra("titulo", getString(info[position].getTitulo()));
                        intencion.putExtra("anio", getString(info[position].getAnio()));*/
                        Intent intencion = new Intent(getApplicationContext(), Preguntas.class);
                        startActivity(intencion);
                        finish();
                    }
                }
        );
    }

    public void rellenarArray( ArrayList<Nivel> levels) {
        levels.add(0,(new Nivel("Nivel 1", 1, false)));
        levels.add(1,(new Nivel("Nivel 2", 2, true)));
        levels.add(2,(new Nivel("Nivel 3", 3, true)));
        levels.add(3,(new Nivel("Nivel 4", 4, true)));

    }
}
