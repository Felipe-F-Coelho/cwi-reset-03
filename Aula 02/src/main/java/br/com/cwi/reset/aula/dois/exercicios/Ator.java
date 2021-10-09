package br.com.cwi.reset.aula.dois.exercicios;

public class Ator {
    private String nome;
    private Integer idade;
    private Integer oscarVencidos;
    private Genero genero;

    public Ator(String nome, Integer idade, Integer oscarVencidos, Genero genero) {
        this.nome = nome;
        this.idade = idade;
        this.oscarVencidos = oscarVencidos;
        this.genero = genero;
    }

    public void apresentacao(){
        System.out.println("Ator: " + this.nome);
        System.out.println("Idade: " + this.idade);
        System.out.println("Genero: " + genero.getDescricao());
        System.out.println("");
    }
}
