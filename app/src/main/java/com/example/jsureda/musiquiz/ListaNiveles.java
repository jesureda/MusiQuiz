package com.example.jsureda.musiquiz;

import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.IOException;
import java.util.ArrayList;

public class ListaNiveles extends AppCompatActivity {

    private ArrayList<Nivel> levels = new ArrayList<>();
    private ListView lista;
    private AdapterNivel adapter;
    private DatabaseHelper nivSQLite=null;
    boolean sonido,tema;
    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tema = getIntent().getBooleanExtra("tema", true);
        if (tema) {
            setTheme(R.style.AppTheme);
        } else {setTheme(R.style.AppTheme2);}
        setContentView(R.layout.activity_niveles);
        sonido = getIntent().getBooleanExtra("sonido", true);
        nivSQLite = new DatabaseHelper(this);
        levels=nivSQLite.listaNiveles(4);
        lista = (ListView) findViewById(R.id.listNivel);
        adapter = new AdapterNivel(this, levels);
        lista.setAdapter(adapter);
        lista.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    public void onItemClick(
                            AdapterView<?> adapter, View v, int position, long id) {
                        if (levels.get(position).getBloqueado()<1) {
                            if (sonido) { sonidoBoton(); }
                            int nivelSeleccionado = levels.get(position).getOrden();
                            int progreso = levels.get(position).getProgreso();
                            Intent intencion = new Intent(getApplicationContext(), Preguntas.class);
                            intencion.putExtra("nivelSel", nivelSeleccionado);
                            intencion.putExtra("progresoInicial", progreso);
                            intencion.putExtra("sonido", sonido);
                            intencion.putExtra("tema", tema);
                            startActivity(intencion);
                            finish();
                        }
                    }
                }
        );
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(ListaNiveles.this, Principal.class);
        startActivity(intent);
        finish();
    }

    private void sonidoBoton() {
        mp = new MediaPlayer();
        try {
            AssetFileDescriptor afd = getApplicationContext().getAssets().openFd("clickbutton.mp3");
            mp.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
            afd.close();
            mp.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
        mp.start();
        if(!mp.isPlaying())
            mp.release();
    }
}
