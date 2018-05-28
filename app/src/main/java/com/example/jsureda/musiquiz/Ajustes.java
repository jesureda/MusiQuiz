package com.example.jsureda.musiquiz;

import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.support.design.widget.FloatingActionButton;
import android.view.View;

import java.io.IOException;

public class Ajustes extends PreferenceActivity {

    FloatingActionButton fab;
    MediaPlayer mp;
    boolean sonido,tema;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tema = getIntent().getBooleanExtra("tema", true);
        if (tema) {
            setTheme(R.style.AppTheme);
        } else {setTheme(R.style.AppTheme2);}
        setContentView(R.layout.activity_ajustes);
        sonido = getIntent().getBooleanExtra("sonido", true);
        inicicializarGUI();
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sonido) { sonidoBoton(); }
                Intent intent = new Intent(getApplicationContext(), Principal.class);
                startActivity(intent);
                finish();
            }
        });
    }
    private void inicicializarGUI()
    {
        fab=(FloatingActionButton)findViewById(R.id.fabAjuste);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(Ajustes.this, Principal.class);
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
