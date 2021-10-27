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
    private EstudioRepository estudioRepository;

    @Autowired
    private DiretorRepository diretorRepository;

    @Autowired
    private PersonagemService personagemService;

    @Autowired
    private PersonagemAtorRepository personagemAtorRepository;


    // Demais metodos da classe

    public void criarFilme(FilmeRequest filmeRequest) throws Exception {

        Optional<Estudio> estudio = estudioRepository.findById(filmeRequest.getIdEstudio());

        Optional<Diretor> diretor = diretorRepository.findById(filmeRequest.getIdDiretor());

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
            throw new ListaConsultaVaziaExceptions(TipoDominioException.FILME.getSingular(), TipoDominioException.FILME.getPlural());
        }

        if(!nomeFilme.isEmpty()){ //Verifica nomeFilme

            List<Filme> retorno = repository.findByNomeContainsIgnoreCase(nomeFilme);

            if(!retorno.isEmpty()){
                return retorno;
            }

        }else if(!nomeDiretor.isEmpty()){ //Verifica nomeDiretor

            List<Filme> retorno = repository.findByDiretorNomeContainsIgnoreCase(nomeDiretor);

            if(!retorno.isEmpty()){
                return retorno;
            }
        }else if(!nomePersonagem.isEmpty()){ //Verifica nomePersonagem

            List<PersonagemAtor> buscaPersonagem = personagemService.consultarPersonagem(nomePersonagem);

            List<Filme> retorno = new ArrayList<>();

            for (int i = 0; i < listaFilmes.size();i++) {
                List<PersonagemAtor> identificadorListagem = listaFilmes.get(i).getPersonagens();
                for(PersonagemAtor personagemAtor : buscaPersonagem){
                    if (Objects.equals(personagemAtor.getNomePersonagem(), identificadorListagem.get(i).getNomePersonagem())) {
                        retorno.add(listaFilmes.get(i));
                    }
                }
            }
            if(!retorno.isEmpty()){
                return retorno;
            }
        }else if(!nomeAtor.isEmpty()){ //Verifica nomeAtor

            List<Ator> listaAtor = personagemService.consultarAtor(nomeAtor);

            List<PersonagemAtor> listaPersonagem = new ArrayList<>();

            for(Ator ator : listaAtor){
                listaPersonagem = personagemService.consultarPersonagem(ator.getNome());
            }

            List<Filme> retorno = new ArrayList<>();

            for (int i = 0; i < listaFilmes.size();i++) {
                List<PersonagemAtor> identificadorListagem = listaFilmes.get(i).getPersonagens();
                for(PersonagemAtor personagemAtor : listaPersonagem){
                    if (Objects.equals(personagemAtor.getNomePersonagem(), identificadorListagem.get(i).getNomePersonagem())) {
                        retorno.add(listaFilmes.get(i));
                    }
                }
            }
            if(!retorno.isEmpty()){
                return retorno;
            }
        }
        throw new FiltroFilmeNaoEncontradoException(nomeFilme, nomeDiretor, nomePersonagem, nomeAtor);
    }
}
