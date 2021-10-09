package br.com.cwi.reset.aula.dois.exercicios;

public class Aplicacao {
    public static void main(String[] args) {
        Diretor diretor = new Diretor("Cristopher",51,50,Genero.NAO_BINARIO);

        Ator ator = new Ator("Felipe",27,2,Genero.MASCULINO);

        Filme interinstelar = new Filme("Interestelar","Filme bom", 120,2014, 5.0,diretor);

        interinstelar.reproducao();

        ator.apresentacao();
        diretor.apresentacao();

    }
}
