package com.example.quiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AutoevaluacionActivity  extends AppCompatActivity {

    private CheckBox ejercicios, temas, ninguno;
    private Button continuarButton3;
    private int puntos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autoevaluacion);

        ejercicios =findViewById(R.id.ejerciciosCheck);
        temas = findViewById(R.id.temasCheck);
        ninguno = findViewById(R.id.ningunoCheck2);

        continuarButton3= findViewById(R.id.continuarButton4);
        continuarButton3.setEnabled(false);


        checkBoxes();
        continuarButton3.setOnClickListener(
                (View view) ->{
                    //String puntaje = " puntaje: "+ puntos ;
                   //Toast.makeText(getApplicationContext(), puntaje, Toast.LENGTH_SHORT).show();

                    SharedPreferences sp = getSharedPreferences("student_info", MODE_PRIVATE);
                    sp.edit().putString("puntos", ""+ puntos).apply();
                    Intent registro = new Intent(this, MainActivity.class);
                    startActivity(registro);
                }
        );
    }

    public void checkBoxes(){

        puntos = getIntent().getExtras().getInt("puntos");

        ejercicios.setOnCheckedChangeListener(
                (c, b) -> {
                    if ( ejercicios.isChecked()){
                        puntos += 3;
                        continuarButton3.setEnabled(true);
                    } else {
                        puntos -= 3;
                        continuarButton3.setEnabled(false);
                    }
                }
        );

        temas .setOnCheckedChangeListener(
                (c, b) -> {
                    if (temas .isChecked()){
                        puntos += 3;
                        continuarButton3.setEnabled(true);
                    } else {
                        puntos-= 3;
                        continuarButton3.setEnabled(false);

                    }
                }
        );

        ninguno.setOnCheckedChangeListener(
                (c, b) -> {
                    if (ninguno.isChecked()){
                        puntos+= 0;
                        continuarButton3.setEnabled(true);

                    } else {
                        puntos+= 0;
                        continuarButton3.setEnabled(false);
                    }
                }
        );





    }
}
