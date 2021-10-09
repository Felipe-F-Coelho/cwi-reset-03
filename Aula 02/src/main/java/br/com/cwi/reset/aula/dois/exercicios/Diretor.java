package br.com.cwi.reset.aula.dois.exercicios;

public class Diretor extends Pessoa {

    private Integer quantidadeFilmes;

    public Diretor(String nome, Integer idade, Integer quantidadeFilmes, Genero genero) {
        super(nome,idade,genero);
        this.quantidadeFilmes = quantidadeFilmes;
    }

    public String getNome() {
        return nome;
    }

}
