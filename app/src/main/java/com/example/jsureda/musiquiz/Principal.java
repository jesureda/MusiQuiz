package com.example.jsureda.musiquiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
import java.io.IOException;

public class Principal extends AppCompatActivity {
    boolean exit = false;
    ImageButton btnSalir, btnAniadir, btnAjustes;
    Button btnJugar;
    private SharedPreferences prefs;
    boolean idioma, sonido, tema;
    String langu;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cargarPreferencias();
        if (tema) {
            setTheme(R.style.AppTheme);
        } else {setTheme(R.style.AppTheme2);}
        setContentView(R.layout.activity_principal);
        inicializarGUI();

        btnAjustes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sonido) { sonidoBoton(); }
                Intent intent = new Intent(getApplicationContext(), Ajustes.class);
                intent.putExtra("sonido", sonido);
                intent.putExtra("tema", tema);
                startActivity(intent);
                finish();
            }
        });
        btnAniadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sonido) { sonidoBoton(); }
                Intent intent = new Intent(getApplicationContext(), Aniadir.class);
                intent.putExtra("sonido", sonido);
                intent.putExtra("tema", tema);
                startActivity(intent);
                finish();
            }
        });

        btnJugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sonido) { sonidoBoton(); }
                Intent intent = new Intent(getApplicationContext(), ListaNiveles.class);
                intent.putExtra("sonido", sonido);
                intent.putExtra("tema", tema);
                startActivity(intent);
                finish();
            }
        });

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sonido) { sonidoBoton(); }
                finish();
                System.exit(0);
            }
        });
    }

    private void inicializarGUI() {
        btnSalir = (ImageButton) findViewById(R.id.imgBtnSalir);
        btnAniadir = (ImageButton) findViewById(R.id.imgBtnRanking);
        btnAjustes = (ImageButton) findViewById(R.id.imgBtnAjustes);
        btnJugar = (Button) findViewById(R.id.btnJugar);
    }

    private void cargarPreferencias() {
        prefs = PreferenceManager
                .getDefaultSharedPreferences(getApplicationContext());
        idioma = prefs.getBoolean("check_box_preference_1", true);
        tema = prefs.getBoolean("check_box_preference_3", true);
        if (idioma) {
            langu = "Español";
        } else {langu = "Inglés";}
        //Toast.makeText(getApplicationContext(), langu, Toast.LENGTH_SHORT).show();
        sonido = prefs.getBoolean("pref1", true);
    }

    private void sonidoBoton() {
        mp = new MediaPlayer();
        try {
            AssetFileDescriptor afd =
                    getApplicationContext().getAssets().openFd("clickbutton.mp3");
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

    @Override
    public void onBackPressed() {
        if (exit) {
            finish(); // finish activity
            System.exit(0);
        } else {
            Toast.makeText(this, R.string.toastSalir,
                    Toast.LENGTH_SHORT).show();
            exit = true;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    exit = false;
                }
            }, 3 * 1000);

        }
    }
}
