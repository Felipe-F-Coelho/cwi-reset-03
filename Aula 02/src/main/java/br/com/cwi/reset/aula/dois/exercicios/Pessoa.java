package br.com.cwi.reset.aula.dois.exercicios;

public class Pessoa {
    protected String nome;
    protected Integer idade;
    protected Genero genero;

    public Pessoa(String nome, Integer idade, Genero genero) {
        this.nome = nome;
        this.idade = idade;
        this.genero = genero;
    }

    public void apresentacao() {
        System.out.println("Ator: " + this.nome);
        System.out.println("Idade: " + this.idade);
        System.out.println("Genero: " + genero.getDescricao());
        System.out.println("");
    }
}
