package br.com.cwi.reset.aula.dois.exercicios;

public class Ator extends Pessoa {

    private Integer oscarVencidos;

    public Ator(String nome, Integer idade, Integer oscarVencidos, Genero genero) {
        super(nome,idade,genero);
        this.oscarVencidos = oscarVencidos;
    }
}
