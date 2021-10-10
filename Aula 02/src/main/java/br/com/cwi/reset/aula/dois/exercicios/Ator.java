package br.com.cwi.reset.aula.dois.exercicios;

import java.time.LocalDate;

public class Ator extends Pessoa {

    private Integer oscarVencidos;

    public Ator(String nome, LocalDate dataDeNacimento, Integer oscarVencidos, Genero genero) {
        super(nome,dataDeNacimento,genero);
        this.oscarVencidos = oscarVencidos;
    }
}
