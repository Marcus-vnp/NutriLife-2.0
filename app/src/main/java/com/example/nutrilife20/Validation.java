package com.example.nutrilife20;

public abstract class Validation {
    static boolean verificarTexto(String nome){
        if (nome.isBlank()) return false;
        for(int i = 0; i < nome.length(); i++){
            char letra = nome.charAt(i);
            if (Character.isLetter(letra)) continue;
            else return false;
        }
        return true;
    }

    static double verificarNumero(String numero){
        double num;
        if (numero.isBlank()) return 0;

        try{
            num = Double.parseDouble(numero);
            if (num == 0) return 0;
        }catch(Exception e){
            return 0;
        }

        return num;
    }

    static String[] retornarClassificacaoEPerigos(Double IMC){
        if (IMC < 17) return new String[] {"Muito Abaixo do Peso", "Maior risco de problemas de saúde, deficiências nutricionais, " +
                "redução do desempenho físico e fraqueza/letargia"};
        else if(IMC < 18.4) return new String[] {"Abaixo do Peso", "Maior risco de problemas relacionados ao baixo peso e deficiências " +
                "nutricionais"};
        else if(IMC < 24.9) return new String[] {"Peso Normal", "Faixa de peso considerada adequada para a maioria dos adultos"};
        else if(IMC < 29.9) return new String[] {"Sobrepeso", "Maior risco de alterações metabólicas, diabetes tipo 2 e doenças " +
                "cardiovasculares"};
        else if(IMC < 34.9) return new String[] {"Obesidade Grau 1", "Risco elevado de diabetes tipo 2, hipertensão e doenças " +
                "cardiovasculares"};
        else if(IMC < 39.9) return new String[] {"Obesidade Grau 2", "Risco muito elevado de complicações metabólicas, cardiovasculares " +
                "e respiratórias"};

        return new String[] {"Obesidade Grau 3", "Risco muitíssimo elevado de comorbidades e comprometimento da " +
                "saúde e qualidade de vida"};
    }
}
