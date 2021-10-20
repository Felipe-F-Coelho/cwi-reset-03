package br.com.cwi.reset.felipecoelho;

import br.com.cwi.reset.felipecoelho.model.*;

import java.util.ArrayList;
import java.util.List;

public class FakeDatabase {

    final private static FakeDatabase fakeDatabase = new FakeDatabase();

    public static FakeDatabase getInstance() {
        return fakeDatabase;
    }

    private FakeDatabase() {
    }

    private static Integer idSequencia = 0;

    public Integer solicitarID(){
        idSequencia += 1;

        return idSequencia;
    }

    final private List<Ator> atores = new ArrayList<>();
    final private List<Diretor> diretores = new ArrayList<>();
    final private List<Estudio> estudios = new ArrayList<>();
    final private List<Filme> filmes = new ArrayList<>();
    final private List<Personagem> personagens = new ArrayList<>();

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

    public void persisteEstudio(Estudio estudio) {
        estudios.add(estudio);
    }

    public List<Estudio> recuperaEstudios() {
        return estudios;
    }

    public void persisteFilme(Filme filme) {
        filmes.add(filme);
    }

    public List<Filme> recuperaFilmes() {
        return filmes;
    }

    public void persistePersonagem(Personagem personagemAtor) {
        personagens.add(personagemAtor);
    }

    public List<Personagem> recuperaPersonagens() {
        return personagens;
    }
}