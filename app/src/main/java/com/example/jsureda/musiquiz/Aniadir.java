package com.example.jsureda.musiquiz;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class Aniadir extends AppCompatActivity {
    EditText resA, resB, resC, resD, enunciado;
    Spinner spnNivel;
    String radio = "";
    RadioButton radA, radB, radC, radD;
    FloatingActionButton fabAudio, fabAceptar;
    String[] datos = new String[8];
    DatabaseHelper dbAniadir;
    boolean vacio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aniadir);
        dbAniadir = new DatabaseHelper(this);
        inicializarGUI();
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.niveles_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spnNivel.setAdapter(adapter);
        fabAudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        fabAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //enunciado,refAudio,respuestaA,respuestaB,respuestaC,respuestaD,correcta,nivel
                vacio = false;
                datos[0] = enunciado.getText().toString();
                datos[1] = "batmanbso.mp3";
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
                    Toast.makeText(Aniadir.this, "Debes rellenar todos los campos", Toast.LENGTH_SHORT).show();
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
        fabAceptar = (FloatingActionButton) findViewById(R.id.fabConfirm);
    }
}
