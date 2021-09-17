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
    private String estudiante, puntosString, estudiantes, newStudent;
    private TextView estudianteText;
    private int est;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registrarButton = findViewById(R.id.registrarButton);
        estudianteText = findViewById(R.id.estudianteText);

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

        String[] names = estudiante.split(":");
        String[] points = puntosString.split(":");

        for (int i = 0; i < names.length ; i++) {
            est = i;
            estudianteText.append(names[est] + "     " +points[est] + "\n");

        }
    }
}