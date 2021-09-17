package com.example.quiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PreguntasActivity extends AppCompatActivity {

     private CheckBox videos, ejemplos, ninguno;
     private Button continuarButton2;

     private int puntos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preguntas);

        videos = (CheckBox)findViewById(R.id.videosCheck);
        ejemplos = (CheckBox)findViewById(R.id.ejemplosCheck);
        ninguno =(CheckBox) findViewById(R.id.ningunoCheck);

        continuarButton2=(Button) findViewById(R.id.continuarButton2);
        continuarButton2.setEnabled(false);

        checkBoxes();
        continuarButton2.setOnClickListener(
                (View view) -> {
                    String message = " puntaje: " + puntos;
                    Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();

                     Intent autoevaluacion = new Intent(this, AutoevaluacionActivity.class);
                     autoevaluacion.putExtra("puntos", puntos);
                     startActivity(autoevaluacion);
                     finish();
                }
        );
    }

    public void checkBoxes(){
        videos.setOnCheckedChangeListener(
                (c, b) -> {
                    if (videos.isChecked()){
                        puntos += 1;
                        continuarButton2.setEnabled(true);
                    } else {
                        puntos -= 1;
                        continuarButton2.setEnabled(false);
                    }
                }
        );
        ejemplos.setOnCheckedChangeListener(
                (c, b) -> {
                    if (ejemplos.isChecked()){
                        puntos+= 3;
                        continuarButton2.setEnabled(true);
                    } else {
                        puntos-=3;
                        continuarButton2.setEnabled(false);
                    }
                }
        );
        ninguno.setOnCheckedChangeListener(
                (c, b) -> {
                    if (ninguno.isChecked()){
                        puntos+= 0;
                        continuarButton2.setEnabled(true);
                    } else {
                        puntos+= 0;
                        continuarButton2.setEnabled(false);
                    }
                }
        );
    }






}
