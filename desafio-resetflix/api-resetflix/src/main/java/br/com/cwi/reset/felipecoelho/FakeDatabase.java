package br.com.cwi.reset.felipecoelho;

import java.util.ArrayList;
import java.util.List;

public class FakeDatabase {

    private static FakeDatabase fakeDatabase = new FakeDatabase();

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

    public static Integer getIdSequencia() {
        return idSequencia;
    }

    public static void setIdSequencia(Integer idSequencia) {
        FakeDatabase.idSequencia = idSequencia;
    }

    private List<Ator> atores = new ArrayList<>();
    private List<Diretor> diretores = new ArrayList<>();
    private List<Estudio> estudios = new ArrayList<>();
    private List<Filme> filmes = new ArrayList<>();
    private List<PersonagemAtor> personagens = new ArrayList<>();

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

    public void persistePersonagem(PersonagemAtor personagemAtor) {
        personagens.add(personagemAtor);
    }

    public List<PersonagemAtor> recuperaPersonagens() {
        return personagens;
    }
}