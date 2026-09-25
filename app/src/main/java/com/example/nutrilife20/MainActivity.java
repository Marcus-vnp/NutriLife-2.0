package com.example.nutrilife20;

import com.example.nutrilife20.Validation;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    TextInputEditText input_name;
    TextInputEditText input_peso;
    TextInputEditText input_altura;
    TextInputEditText input_circ_quadril;
    TextInputEditText input_circ_cintura;
    RadioGroup group;
    Button calc_imc;
    Button calc_rcq;
    String sexo = "Vazio";
    Intent int_RCQ = new Intent(MainActivity.this, RCQActivity.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        input_name = findViewById(R.id.nome);
        input_peso = findViewById(R.id.peso);
        input_altura = findViewById(R.id.altura);
        input_circ_cintura = findViewById(R.id.circ_cintura);
        input_circ_quadril = findViewById(R.id.circ_quadril);

        group = findViewById(R.id.rd_group);
        calc_imc = findViewById(R.id.IMC);
        calc_rcq = findViewById(R.id.RCQ);

        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull RadioGroup radioGroup, int i) {
                RadioButton rd_selecionado = findViewById(i);
                sexo = rd_selecionado.getText().toString();
            }
        });



    }

    public void calcular_IMC(View view) {
        String nome = input_name.getText().toString();
        String altura = input_altura.getText().toString();
        String peso = input_peso.getText().toString();
        String circ_quadril = input_circ_quadril.getText().toString();
        String circ_cintura = input_circ_cintura.getText().toString();

        if (!Validation.verificarTexto(nome)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setMessage("Valor digitado no Nome incorreto!").setTitle("ERRO!");
            builder.show();
            return;
        }

        if (Validation.verificarNumero(peso) == 0) {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setMessage("Valor digitado no Peso incorreto!").setTitle("ERRO!");
            builder.show();
            return;
        }

        if (Validation.verificarNumero(altura) == 0) {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setMessage("Valor digitado no Altura incorreto!").setTitle("ERRO!");
            builder.show();
            return;
        }


        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Deseja Enviar esses dados?").setTitle("Confirme!");
        builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Intent int_IMC = new Intent(MainActivity.this, IMCActivity.class);
                int_IMC.putExtra("nome", nome);
                int_IMC.putExtra("peso", peso);
                int_IMC.putExtra("altura", altura);
                startActivity(int_IMC);
            }
        });
        builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

            }
        });
        builder.show();
        }
    public void calcular_RCQ(View view) {
        String nome = input_name.getText().toString();
        String altura = input_altura.getText().toString();
        String peso = input_peso.getText().toString();
        String circ_quadril = input_circ_quadril.getText().toString();
        String circ_cintura = input_circ_cintura.getText().toString();

        if (!Validation.verificarTexto(nome)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setMessage("Valor digitado no Nome incorreto!").setTitle("ERRO!");
            builder.show();
            return;
        }

        if (Validation.verificarNumero(circ_quadril) == 0) {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setMessage("Valor digitado na Circunferência do Quadril incorreto!").setTitle("ERRO!");
            builder.show();
            return;
        }

        if (Validation.verificarNumero(circ_cintura) == 0) {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setMessage("Valor digitado na Circunferência da Cintura incorreto!").setTitle("ERRO!");
            builder.show();
            return;
        }

        if (sexo.equals("Vazio")) {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setMessage("Nao foi Selecionado Nenhum Sexo!").setTitle("ERRO!");
            builder.show();
            return;
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Deseja Enviar esses dados?").setTitle("Confirme!");
        builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Intent int_RCQ = new Intent(MainActivity.this, RCQActivity.class);
                int_RCQ.putExtra("nome", nome);
                int_RCQ.putExtra("circ_cintura", circ_cintura);
                int_RCQ.putExtra("circ_quadril", circ_quadril);
                int_RCQ.putExtra("sexo", sexo);
                startActivity(int_RCQ);
            }
        });
        builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

            }
        });
        builder.show();
    }
}
