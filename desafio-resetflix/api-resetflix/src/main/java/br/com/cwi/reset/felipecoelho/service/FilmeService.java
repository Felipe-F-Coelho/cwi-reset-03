package br.com.cwi.reset.felipecoelho.service;

import br.com.cwi.reset.felipecoelho.repository.*;
import br.com.cwi.reset.felipecoelho.exceptions.*;
import br.com.cwi.reset.felipecoelho.model.*;
import br.com.cwi.reset.felipecoelho.request.FilmeRequest;
import br.com.cwi.reset.felipecoelho.request.PersonagemRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.*;

@Service
public class FilmeService {

    @Autowired
    private FilmeRepository repository;

    @Autowired
    private EstudioService estudioService;

    @Autowired
    private DiretorService diretorService;

    @Autowired
    private PersonagemService personagemService;


    // Demais metodos da classe

    public void criarFilme(FilmeRequest filmeRequest) throws Exception {

        Optional<Estudio> estudio = estudioService.consultarEstudio(filmeRequest.getIdEstudio());

        Optional<Diretor> diretor = diretorService.consultarDiretor(filmeRequest.getIdDiretor());

        List<Genero> listaValidadorGenero = filmeRequest.getGeneros();

        if(!estudio.isPresent()){
            throw new ConsultaInvalidaIdException(TipoDominioException.ESTUDIO.getSingular(),filmeRequest.getIdEstudio());
        }

        if(!diretor.isPresent()){
            throw new ConsultaInvalidaIdException(TipoDominioException.DIRETOR.getSingular(),filmeRequest.getIdDiretor());
        }

        for(int i = 0; i < listaValidadorGenero.size(); i++ ){
            Genero cap1 = listaValidadorGenero.get(i);
            for(int j = 1 + i; j < listaValidadorGenero.size(); j++){
                Genero cap2 = listaValidadorGenero.get(j);
                if(cap1 == cap2){
                    throw new MesmoObjetoMaisDeUmaVezGenero();
                }
            }
        }

        List<PersonagemAtor> listaPersonagens = new ArrayList<>();

        for(PersonagemRequest personagemRequest : filmeRequest.getPersonagens()){
            listaPersonagens.add(personagemService.criarPersonagem(personagemRequest));
        }

        final Filme newFilme = new Filme(filmeRequest.getNome(),filmeRequest.getAnoLancamento(),filmeRequest.getCapaFilme(),filmeRequest.getGeneros(),estudio.get(),diretor.get(),listaPersonagens,filmeRequest.getResumo());
        repository.save(newFilme);
    }

    public List<Filme> consultarFilmes(String nomeFilme,String nomeDiretor,String nomePersonagem,String nomeAtor) throws Exception {

        List<Filme> listaFilmes = repository.findAll();

        if(listaFilmes.isEmpty()){
            throw new ListaConsultaVaziaExceptions(TipoDominioException.FILME.getSingular(),TipoDominioException.FILME.getPlural());
        }

        if(!nomeFilme.isEmpty()){ //Verifica nomeFilme

            if(!repository.findByNomeContainsIgnoreCase(nomeFilme).isEmpty()){
                return repository.findByNomeContainsIgnoreCase(nomeFilme);
            }

        }else if(!nomeDiretor.isEmpty()){ //Verifica nomeDiretor

            if(!consultarDiretorFilme(nomeDiretor).isEmpty()){
                return consultarDiretorFilme(nomeDiretor);
            }

        }else if(!nomePersonagem.isEmpty()){ //Verifica nomePersonagem

            List<Filme> retorno = new ArrayList<>();

            for(Filme filme : listaFilmes){
                List<PersonagemAtor> buscarPersonagem = filme.getPersonagens();
                for(PersonagemAtor personagemAtor : buscarPersonagem){
                    if(personagemAtor.getNomePersonagem().toLowerCase(Locale.ROOT).contains(nomePersonagem.toLowerCase(Locale.ROOT))){
                        retorno.add(filme);
                    }
                }
            }
            if(!retorno.isEmpty()){
                return retorno;
            }

        }else if(!nomeAtor.isEmpty()){ //Verifica nomeAtor

            List<Filme> retorno = new ArrayList<>();

            for(Filme filme : listaFilmes){
                List<PersonagemAtor> buscarPersonagem = filme.getPersonagens();
                for(PersonagemAtor personagensAtor : buscarPersonagem){
                    if(personagensAtor.getAtor().getNome().toLowerCase(Locale.ROOT).contains(nomeAtor.toLowerCase(Locale.ROOT))){
                        retorno.add(filme);
                    }
                }
            }

            if(!retorno.isEmpty()){
                return retorno;
            }
        }
        throw new FiltroFilmeNaoEncontradoException(nomeFilme, nomeDiretor, nomePersonagem, nomeAtor);
    }

    public void removerFilme(Integer id) throws Exception {

        Optional<Filme> filmeSelecionado = repository.findById(id);

        if(!filmeSelecionado.isPresent()){
            throw new ConsultaInvalidaIdException(TipoDominioException.FILME.getSingular(), id);
        }

        List<PersonagemAtor> listaPersonagens = filmeSelecionado.get().getPersonagens();

        personagemService.removerPersonagens(listaPersonagens);

        repository.delete(filmeSelecionado.get());
    }

    public List<Filme> consultarDiretorFilme(String nomeDiretor){
        return repository.findByDiretorNomeContainsIgnoreCase(nomeDiretor);
    }
}
