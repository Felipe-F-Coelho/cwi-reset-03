package br.com.cwi.reset.aula.dois.exercicios;

import java.time.LocalDate;

public class Diretor extends Pessoa {

    private Integer quantidadeFilmes;

    public Diretor(String nome, LocalDate dataDeNacimento, Integer quantidadeFilmes, Genero genero) {
        super(nome,dataDeNacimento,genero);
        this.quantidadeFilmes = quantidadeFilmes;
    }

}
