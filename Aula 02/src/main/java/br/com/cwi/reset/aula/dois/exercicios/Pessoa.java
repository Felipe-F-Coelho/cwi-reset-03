package br.com.cwi.reset.aula.dois.exercicios;


import java.time.LocalDate;
import java.time.Period;

public abstract class Pessoa {
    private String nome;
    private LocalDate dataDeNacimento;
    private Genero genero;
    private Period idade;

    public Pessoa(String nome, LocalDate dataDeNacimento, Genero genero) {
        this.nome = nome;
        this.dataDeNacimento = dataDeNacimento;
        this.genero = genero;
        this.idade = Period.between(dataDeNacimento,LocalDate.now());
    }

    public String getNome() {
        return nome;
    }

    public void apresentacao() {
        System.out.println("Ator: " + this.nome);
        System.out.println("Idade: " + this.idade.getYears());
        System.out.println("Nascido em: " + this.dataDeNacimento);
        System.out.println("Genero: " + genero.getDescricao());
        System.out.println("");
    }
}
