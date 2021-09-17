package com.example.quiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegistroActivity  extends AppCompatActivity {

    private EditText estudianteText, codigoText;
    private String estudiante, codigo, codigos;
    private Boolean nuevoE;
    private Button continuarButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        estudianteText = findViewById(R.id.nombreText);
        codigoText = findViewById(R.id.codigoText);

        nuevoE=true;

        continuarButton = findViewById(R.id.continuarButton);

        SharedPreferences sp = getSharedPreferences("student_info", MODE_PRIVATE);

        continuarButton.setOnClickListener(
                (View view) ->{

                    estudiante= estudianteText.getText().toString();
                    codigo= codigoText.getText().toString();

                    if(estudiante.isEmpty() || codigo.isEmpty()){
                        Toast.makeText(this, "Verifique sus datos", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        sp.edit().putString("estudiante", estudiante).apply();
                        sp.edit().putString("codigo", codigo).apply();

                        nuevoE=true;
                    }
                    if (codigo.equals(codigos)){
                        Toast.makeText(this, "Código ya registrado", Toast.LENGTH_SHORT).show();
                        nuevoE=false;

                    } else if(nuevoE=true) {
                        Intent preguntas = new Intent(this, PreguntasActivity.class);
                        startActivity(preguntas);
                 }
                }
        );
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sp = getSharedPreferences("student_info", MODE_PRIVATE);
        codigos = sp.getString("codigo", "");
    }

}
