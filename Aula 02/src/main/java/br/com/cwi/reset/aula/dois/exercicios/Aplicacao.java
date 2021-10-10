package br.com.cwi.reset.aula.dois.exercicios;

import java.time.LocalDate;
import java.util.ArrayList;

public class Aplicacao {
    public static void main(String[] args) throws AvaliacaoForaDoPadraoException {
        Diretor diretor = new Diretor("Cristopher",LocalDate.of(1970,7,30),50,Genero.NAO_BINARIO);

        Diretor diretor1 = new Diretor("Jeff Cronenweth",LocalDate.of(1962,1,14),4,Genero.MASCULINO);

        Diretor diretor2 = new Diretor("Clint Eastwood",LocalDate.of(1930,3,31),4,Genero.MASCULINO);

        Diretor diretor3 = new Diretor("Gary Trousdale",LocalDate.of(1960,6,8),6,Genero.NAO_BINARIO);

        Ator ator = new Ator("Felipe",LocalDate.of(1993,9,29),2,Genero.MASCULINO);

//        ator.apresentacao();
//        diretor.apresentacao();

        Filme interinstelar = new Filme("Interestelar","Filme bom", 120,2014, 5.0,diretor);
        Filme clubeDaLuta   = new Filme("Clube da Luta","Filme Perfeito", 139,1999,5.0,diretor1);
        Filme sniperAmericado = new Filme("Sniper Americano", "Filme Bom Demais", 132,2014,5.0,diretor2);
        Filme aBelaEAFera = new Filme("A Bela e a Fera", "Filme para Criança",84,1991,3.0,diretor3);

        ArrayList<Filme> colecaoDeFilmes = new ArrayList();

        colecaoDeFilmes.add(interinstelar);
        colecaoDeFilmes.add(clubeDaLuta);
        colecaoDeFilmes.add(sniperAmericado);
        colecaoDeFilmes.add(aBelaEAFera);

        for(int i = 0;i < colecaoDeFilmes.size();i++ ){
            colecaoDeFilmes.get(i).reproducao();
        }
    }
}
