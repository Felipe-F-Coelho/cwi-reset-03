package br.com.cwi.reset.projeto1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercicios1 {

    public Integer somarLista(List<Integer> numeros) {

        int soma = 0;

        for (int i = 0; i < numeros.size(); i++) {
            soma += numeros.get(i);
        }

        return soma;
    }

    public Double calcularMedia(List<Integer> numeros) {
        double soma = 0;

        for (int i = 0; i < numeros.size(); i++) {
            soma += numeros.get(i);
        }
        return soma / numeros.size();
    }

    public Integer obterMaiorNumero(List<Integer> numeros) {
        int numeroMaior = 0;
        for(int i = 0; i < numeros.size(); i++){
            if(numeros.get(i) > numeroMaior){
                numeroMaior = numeros.get(i);
            }
        }
        return numeroMaior;
    }

    public String obterPalavraInvertida(String palavra) {
        String palavraInvertida = "";

        for (int i = palavra.length() - 1; i >= 0; i--){
            palavraInvertida += palavra.charAt(i);
        }

        return  palavraInvertida;
    }

    public List<Integer> ordenarLista(List<Integer> numeros) {
        List<Integer> ordenacão = new ArrayList<>();
        int aux = 0;

        for(int num : numeros){
            ordenacão.add(num);
        }

        for(int i = 0; i < ordenacão.size(); i++){
            for (int j = i+1; j < ordenacão.size(); j++){
                if(ordenacão.get(j) < ordenacão.get(i)){
                    aux = ordenacão.get(j);

                    ordenacão.set(j, ordenacão.get(i));
                    ordenacão.set(i, aux);
                }
            }
        }

        return ordenacão;
    }
}

