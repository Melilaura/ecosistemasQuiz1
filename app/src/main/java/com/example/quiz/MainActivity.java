package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button registrarButton;
    private String estudiante, puntosString, estudiantes;
    private TextView estudianteText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        estudiantes = " estudiantes \n";
        registrarButton = findViewById(R.id.registrarButton);
        estudianteText = findViewById(R.id.estudianteText);



        //Go to the register
        registrarButton.setOnClickListener(
                (View view) -> {
                    Intent registro = new Intent(this, RegistroActivity.class);
                    startActivity(registro);
                }
        );
    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences sp = getSharedPreferences("student_info", MODE_PRIVATE);

        estudiante = sp.getString("estudiante", "");
        puntosString = sp.getString("puntos", "");

        estudiantes += estudiante + "    " +  puntosString  + "\n";

        estudianteText.setText(estudiantes);


    }

}