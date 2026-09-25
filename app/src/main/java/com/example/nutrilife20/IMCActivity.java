package com.example.nutrilife20;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class IMCActivity extends AppCompatActivity {

    TextView tNome;
    TextView tIMC;
    TextView tClassificacao;
    TextView tPerigos;
    Button bVoltar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_imcactivity);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tNome = findViewById(R.id.text_nome);
        tIMC = findViewById(R.id.text_IMC);
        tClassificacao = findViewById(R.id.text_classificacao);
        tPerigos = findViewById(R.id.text_perigos);

        Intent it = getIntent();
        String nome = it.getStringExtra("nome");
        String p = it.getStringExtra("peso");
        String a = it.getStringExtra("altura");

        double peso = Double.parseDouble(p);
        double altura = Double.parseDouble(a);

        double imc = peso / (altura * altura);

        String[] conj_Class_Perigos = Validation.retornarClassificacaoEPerigos(imc);

        tNome.setText("Olá " + nome);
        tIMC.setText("Seu IMC é: " + String.format("%.2f", imc));
        tClassificacao.setText("A classificação é: " + conj_Class_Perigos[0]);
        tPerigos.setText("O que pode acontecer é: " + conj_Class_Perigos[1]);

    }

    public void voltar(View view){
        Intent it = new Intent(IMCActivity.this, MainActivity.class);
        startActivity(it);
    }
}