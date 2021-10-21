package br.com.cwi.reset.felipecoelho.service;

import br.com.cwi.reset.felipecoelho.FakeDatabase;
import br.com.cwi.reset.felipecoelho.exceptions.*;
import br.com.cwi.reset.felipecoelho.model.*;
import br.com.cwi.reset.felipecoelho.request.FilmeRequest;
import br.com.cwi.reset.felipecoelho.request.PersonagemRequest;
import br.com.cwi.reset.felipecoelho.validator.BasicInfoRequiredValidatorFilme;


import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.stream.Collectors;


public class FilmeService {

    final private FakeDatabase fakeDatabase;
    final private PersonagemService personagemService;
    private Integer id;

    public FilmeService(FakeDatabase fakeDatabase) {
        this.personagemService = new PersonagemService(FakeDatabase.getInstance());
        this.fakeDatabase = fakeDatabase;
    }

    public Integer getId() {
        return id;
    }

    // Demais metodos da classe

    public void criarFilme(FilmeRequest filmeRequest) throws Exception {

        List<Estudio> listaEstudios = fakeDatabase.recuperaEstudios();

        List<Diretor> listaDiretores = fakeDatabase.recuperaDiretores();

        List<Genero> validadorGenero = filmeRequest.getGeneros();

        new BasicInfoRequiredValidatorFilme().accept(filmeRequest.getNome(), filmeRequest.getAnoLancamento(),filmeRequest.getCapaFilme(),filmeRequest.getGeneros(), filmeRequest.getIdDiretor(), filmeRequest.getIdEstudio(), filmeRequest.getResumo());

        for(Estudio estudio : listaEstudios){
            if(!estudio.getId().equals(filmeRequest.getIdEstudio())){
                throw new ConsultaInvalidaIdException(TipoDominioException.ESTUDIO.getSingular(),filmeRequest.getIdEstudio());
            }
        }

        for(Diretor diretor : listaDiretores){
            if(!diretor.getId().equals(filmeRequest.getIdDiretor())){
                throw new ConsultaInvalidaIdException(TipoDominioException.DIRETOR.getSingular(),filmeRequest.getIdDiretor());
            }
        }

        for(int i = 0; i < validadorGenero.size(); i++ ){
            Genero cap1 = validadorGenero.get(i);
            for(int j = 1 + i; j < validadorGenero.size(); j++){
                Genero cap2 = validadorGenero.get(j);
                if(cap1 == cap2){
                    throw new MesmoObjetoMaisDeUmaVezGenero();
                }
            }
        }

        for(PersonagemRequest personagemRequest : filmeRequest.getPersonagens()){
            personagemService.criarPersonagem(personagemRequest);
        }

        this.id = this.fakeDatabase.solicitarID();
        final Filme newFilme = new Filme(id,filmeRequest.getNome(),filmeRequest.getAnoLancamento(),filmeRequest.getCapaFilme(),filmeRequest.getGeneros(),
                filmeRequest.getIdDiretor(),filmeRequest.getIdEstudio(),filmeRequest.getResumo(),filmeRequest.getPersonagens());
        fakeDatabase.persisteFilme(newFilme);

    }



    public List<Filme> consultarFilmes(String nomeFilme,String nomeDiretor,String nomePersonagem,String nomeAtor) throws Exception {

        List<Filme> listaFilmes = fakeDatabase.recuperaFilmes();

        if(listaFilmes.isEmpty()){
            throw new ListaConsultaVaziaExceptions(TipoDominioException.FILME.getSingular(), TipoDominioException.FILME.getPlural());
        }

        if(!nomeFilme.isEmpty()){ //Verifica nomeFilme

            List<Filme> retorno = listaFilmes.stream()
                    .filter(e -> e.getNome().toLowerCase(Locale.ROOT).contains(nomeFilme.toLowerCase(Locale.ROOT)))
                    .collect(Collectors.toList());

            if(!retorno.isEmpty()){
                return retorno;
            }

        }else if(!nomeDiretor.isEmpty()){ //Verifica nomeDiretor

            List<Diretor> listaDiretores = fakeDatabase.recuperaDiretores();

            List<Diretor> buscarDiretor = listaDiretores
                    .stream()
                    .filter(e -> e.getNome().toLowerCase(Locale.ROOT).contains(nomeDiretor.toLowerCase(Locale.ROOT)))
                    .collect(Collectors.toList());

            Diretor filtroDiretor =  buscarDiretor.get(0);

            List<Filme> retorno = listaFilmes
                    .stream()
                    .filter(e -> e.getIdDiretor().equals(filtroDiretor.getId()))
                    .collect(Collectors.toList());

            if(!retorno.isEmpty()){
                return retorno;
            }
        }else if(!nomePersonagem.isEmpty()){

            List<Personagem> listaPersonagens = fakeDatabase.recuperaPersonagens();

            List<Personagem> buscarPersonagem = listaPersonagens
                    .stream()
                    .filter(e -> e.getNomePersonagem().toLowerCase(Locale.ROOT).contains(nomePersonagem.toLowerCase(Locale.ROOT)))
                    .collect(Collectors.toList());

            final PersonagemRequest identificadorFiltro = new PersonagemRequest(buscarPersonagem.get(0).getIdAtor(),buscarPersonagem.get(0).getNomePersonagem(),buscarPersonagem.get(0).getDescricaoPersonagem(),buscarPersonagem.get(0).getTipoAtuacao());

            List<Filme> retorno = new ArrayList<>();


            for (int i = 0; i < listaFilmes.size();i++) {
                List<PersonagemRequest> identificadorListagem = listaFilmes.get(i).getPersonagens();
                if (Objects.equals(identificadorFiltro.getNomePersonagem(), identificadorListagem.get(i).getNomePersonagem())) {
                    retorno.add(listaFilmes.get(i));
                }
            }


            if(!retorno.isEmpty()){
                return retorno;
            }
        }else if(!nomeAtor.isEmpty()){

            List<Ator> listaAtores = fakeDatabase.recuperaAtores();

            List<Personagem> listaPersonagem = fakeDatabase.recuperaPersonagens();

            List<Ator> buscarAtor = listaAtores
                    .stream()
                    .filter(e -> e.getNome().toLowerCase(Locale.ROOT).contains(nomeAtor.toLowerCase(Locale.ROOT)))
                    .collect(Collectors.toList());

            Ator filtroAtor = buscarAtor.get(0);

            List<Personagem> buscarPersonagens = listaPersonagem
                    .stream()
                    .filter(e -> e.getIdAtor().equals(filtroAtor.getId()))
                    .collect(Collectors.toList());

            List<Filme> retorno = new ArrayList<>();

            final PersonagemRequest identificadorFiltro = new PersonagemRequest(buscarPersonagens.get(0).getIdAtor(),buscarPersonagens.get(0).getNomePersonagem(),buscarPersonagens.get(0).getDescricaoPersonagem(),buscarPersonagens.get(0).getTipoAtuacao());

            for (int i = 0; i < listaFilmes.size();i++) {
                List<PersonagemRequest> identificadorListagem = listaFilmes.get(i).getPersonagens();
                if (Objects.equals(identificadorFiltro.getNomePersonagem(), identificadorListagem.get(i).getNomePersonagem())) {
                    retorno.add(listaFilmes.get(i));
                }
            }

            if(!retorno.isEmpty()){
                return retorno;
            }

        }
        throw new FiltroFilmeNaoEncontradoException(nomeFilme, nomeDiretor, nomePersonagem, nomeAtor);
    }
}
