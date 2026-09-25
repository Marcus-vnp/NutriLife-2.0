package com.example.nutrilife20;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RCQActivity extends AppCompatActivity {

    TextView tNome;
    TextView tRCQ;
    TextView tRiscos;
    Button bVoltar;
    String classificacao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_rcqactivity);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tNome = findViewById(R.id.tNome);
        tRCQ = findViewById(R.id.text_RCQ);
        tRiscos = findViewById(R.id.text_riscos);

        Intent it = getIntent();
        String nome = it.getStringExtra("nome");
        String cQuadril = it.getStringExtra("circ_quadril");
        String cCintura = it.getStringExtra("circ_cintura");
        String sexo = it.getStringExtra("sexo");

        double quadril = Double.parseDouble(cQuadril);
        double cintura = Double.parseDouble(cCintura);

        double rcq = cintura / quadril;

        if (sexo.equals("Masculino")) {
            if (rcq < 0.9) classificacao = "Normal";
            else classificacao = "Risco Aumentado";
        }else{
            if (rcq < 0.85) classificacao = "Normal";
            else classificacao = "Risco Aumentado";
        }

        tNome.setText("Olá " + nome);
        tRCQ.setText("Seu RCQ é: " + String.format("%.2f", rcq));
        tRiscos.setText("Sua Classificao é: " + classificacao);

        // Terminar classificação e Perigos
    }
}