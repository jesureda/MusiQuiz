package com.example.jsureda.musiquiz;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.IOException;

public class Aniadir extends AppCompatActivity {
    private static final int READ_REQUEST_CODE = 42;
    final String TAG = "INFO";
    EditText resA, resB, resC, resD, enunciado;
    Spinner spnNivel;
    String radio = "";
    Button btnConfirm;
    RadioButton radA, radB, radC, radD;
    FloatingActionButton fabAudio;
    String[] datos = new String[8];
    DatabaseHelper dbAniadir;
    boolean vacio;
    Uri uri = null;
    MediaPlayer mp;
    boolean sonido,tema;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tema = getIntent().getBooleanExtra("tema", true);
        if (tema) {
            setTheme(R.style.AppTheme);
        } else {setTheme(R.style.AppTheme2);}
        setContentView(R.layout.activity_aniadir);
        dbAniadir = new DatabaseHelper(this);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        inicializarGUI();
        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.niveles_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spnNivel.setAdapter(adapter);
        fabAudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sonido) { sonidoBoton(); }
                performFileSearch();
            }
        });
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //enunciado,refAudio,respuestaA,respuestaB,respuestaC,respuestaD,correcta,nivel
                if (sonido) { sonidoBoton(); }
                vacio = false;
                datos[0] = enunciado.getText().toString();
                if (uri == null) {datos[1] = "vacio";} else {datos[1] = uri.toString();}
                datos[2] = resA.getText().toString();
                datos[3] = resB.getText().toString();
                datos[4] = resC.getText().toString();
                datos[5] = resD.getText().toString();
                if (radA.isChecked()) {
                    radio = resA.getText().toString();
                } else if (radB.isChecked()) {
                    radio = resB.getText().toString();
                } else if (radC.isChecked()) {
                    radio = resC.getText().toString();
                } else if (radD.isChecked()) {radio = resD.getText().toString();}
                datos[6] = radio;
                datos[7] = spnNivel.getSelectedItem().toString().substring(6);

                for (int i = 0; i < datos.length; i++) {
                    if (datos[i].isEmpty()) {vacio = true;}
                }
                if (vacio) {
                    Toast.makeText(Aniadir.this, R.string.toastCampos, Toast.LENGTH_SHORT).show();
                } else if (datos[1].equals("vacio")) {
                    Toast.makeText(Aniadir.this, R.string.toastAudio, Toast.LENGTH_SHORT).show();
                } else {
                    dbAniadir.insertarPregunta(datos);
                    Intent intent = new Intent(getApplicationContext(), Principal.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    private void inicializarGUI() {
        spnNivel = (Spinner) findViewById(R.id.spnNivel);
        enunciado = (EditText) findViewById(R.id.txtEnunciado);
        resA = (EditText) findViewById(R.id.txtResA);
        resB = (EditText) findViewById(R.id.txtResB);
        resC = (EditText) findViewById(R.id.txtResC);
        resD = (EditText) findViewById(R.id.txtResD);
        radA = (RadioButton) findViewById(R.id.radResA);
        radB = (RadioButton) findViewById(R.id.radResB);
        radC = (RadioButton) findViewById(R.id.radResC);
        radD = (RadioButton) findViewById(R.id.radResD);
        fabAudio = (FloatingActionButton) findViewById(R.id.fabAudio);
        btnConfirm = (Button) findViewById(R.id.btnConfirm);
    }

    /**
     * Fires an intent to spin up the "file chooser" UI and select an image.
     */
    public void performFileSearch() {

        // ACTION_OPEN_DOCUMENT is the intent to choose a file via the system's file
        // browser.
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);

        // Filter to only show results that can be "opened", such as a
        // file (as opposed to a list of contacts or timezones)
        intent.addCategory(Intent.CATEGORY_OPENABLE);

        // Filter to show only audio, using the image MIME data type.
        intent.setType("audio/*");

        startActivityForResult(intent, READ_REQUEST_CODE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode,
                                 Intent resultData) {
        // The ACTION_OPEN_DOCUMENT intent was sent with the request code
        // READ_REQUEST_CODE. If the request code seen here doesn't match, it's the
        // response to some other intent, and the code below shouldn't run at all.

        if (requestCode == READ_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            // The document selected by the user won't be returned in the intent.
            // Instead, a URI to that document will be contained in the return intent
            // provided to this method as a parameter.
            // Pull that URI using resultData.getData().

            if (resultData != null) {
                uri = resultData.getData();
                Log.i(TAG, "Uri: " + uri.toString());
                Toast.makeText(Aniadir.this, R.string.toastRecurso, Toast.LENGTH_SHORT).show();
            }
        }
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(Aniadir.this, Principal.class);
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
