package br.com.cwi.reset.felipecoelho;

import java.util.ArrayList;
import java.util.List;

public class FakeDatabase {


    private List<Ator> atores = new ArrayList<>();
    private List<Diretor> diretores = new ArrayList<>();
    private static Integer idSequencia = 0;


    public Integer solicitarID(){
        idSequencia += 1;

        return idSequencia;
    }

    public void persisteAtor(Ator ator) {
        atores.add(ator);
    }

    public List<Ator> recuperaAtores() {
        return atores;
    }


    public void persisteDiretor(Diretor diretor) {
        diretores.add(diretor);
    }

    public List<Diretor> recuperaDiretores() {
        return diretores;
    }
}