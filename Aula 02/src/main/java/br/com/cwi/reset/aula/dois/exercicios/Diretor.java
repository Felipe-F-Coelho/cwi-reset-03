package br.com.cwi.reset.aula.dois.exercicios;

public class Diretor {
    private String nome;
    private Integer idade;
    private Integer quantidadeFilmes;
    private Genero genero;

    public Diretor(String nome, Integer idade, Integer quantidadeFilmes, Genero genero) {
        this.nome = nome;
        this.idade = idade;
        this.quantidadeFilmes = quantidadeFilmes;
        this.genero = genero;
    }

    public String getNome() {
        return nome;
    }

    public void apresentacao(){
        System.out.println("Diretor: " + this.nome);
        System.out.println("Idade: " + this.idade);
        System.out.println("Genero: " + genero.getDescricao());
        System.out.println("");
    }
}
