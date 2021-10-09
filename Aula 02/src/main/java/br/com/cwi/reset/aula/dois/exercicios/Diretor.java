package br.com.cwi.reset.aula.dois.exercicios;

public class Diretor extends Pessoa {

    private Integer quantidadeFilmes;

    public Diretor(String nome, Integer idade, Integer quantidadeFilmes, Genero genero) {
        this.nome = nome;
        this.idade = idade;
        this.quantidadeFilmes = quantidadeFilmes;
        this.genero = genero;
    }

    public String getNome() {
        return nome;
    }

}
