package com.example.jsureda.musiquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ListaNiveles extends AppCompatActivity {

    private ArrayList<Nivel> levels = new ArrayList<>();
    private ListView lista;
    private AdapterNivel adapter;
    private NivelSQLite nivSQLite=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_niveles);
        nivSQLite = new NivelSQLite(this);
        //rellenarArray(levels);
        levels=nivSQLite.listaNiveles(4);
        lista = (ListView) findViewById(R.id.listNivel);
        adapter = new AdapterNivel(this, levels);
        lista.setAdapter(adapter);
        lista.setOnItemClickListener(

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

}
