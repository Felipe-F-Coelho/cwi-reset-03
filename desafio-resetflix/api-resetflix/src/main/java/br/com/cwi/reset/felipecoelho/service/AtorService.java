package br.com.cwi.reset.felipecoelho.service;

import br.com.cwi.reset.felipecoelho.exceptions.*;
import br.com.cwi.reset.felipecoelho.repository.AtorRepository;
import br.com.cwi.reset.felipecoelho.repository.PersonagemAtorRepository;
import br.com.cwi.reset.felipecoelho.response.AtorEmAtividade;
import br.com.cwi.reset.felipecoelho.model.Ator;
import br.com.cwi.reset.felipecoelho.model.StatusCarreira;
import br.com.cwi.reset.felipecoelho.request.AtorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class AtorService {

    @Autowired
    private AtorRepository repository;

    @Autowired
    private PersonagemAtorRepository personagemAtorRepository;

    // Demais métodos da classe

    public void criarAtor(AtorRequest atorRequest) throws Exception {

        if(atorRequest.getAnoInicioAtividade() < atorRequest.getDataNascimento().getYear()){
            throw new AnoNascimentoInvalidoExpection(TipoDominioException.ATOR.getSingular());
        }

        if (repository.findByNomeIgnoreCase(atorRequest.getNome()) != null) {
                throw new CadastroDuplicadoException(TipoDominioException.ATOR.getSingular(), atorRequest.getNome());
        }

        Ator newAtor = new Ator(atorRequest.getNome(),atorRequest.getDataNascimento(),atorRequest.getStatusCarreira(),atorRequest.getAnoInicioAtividade());
        repository.save(newAtor);
    }


    public List<AtorEmAtividade> listarAtoresEmAtividade() throws Exception {

        List<Ator> listaAtores = repository.findAllByStatusCarreira(StatusCarreira.EM_ATIVIDADE);

        if (listaAtores.isEmpty()) {
            throw new ListaConsultaVaziaExceptions(TipoDominioException.ATOR.getSingular(), TipoDominioException.ATOR.getPlural());
        }

        final List<AtorEmAtividade> retorno = new ArrayList<>();

        for (Ator ator : listaAtores) {
            retorno.add(new AtorEmAtividade(ator.getId(), ator.getNome(), ator.getDataNascimento()));
        }

        return retorno;
    }


    public List<AtorEmAtividade> listarAtoresEmAtividade(String filtroNome) throws Exception {

        List<Ator> listaAtores = repository.findAllByStatusCarreira(StatusCarreira.EM_ATIVIDADE);

        if (listaAtores.isEmpty()) {
            throw new ListaConsultaVaziaExceptions(TipoDominioException.ATOR.getSingular(), TipoDominioException.ATOR.getPlural());
        }

        final List<AtorEmAtividade> retorno = new ArrayList<>();

        for (Ator ator : listaAtores) {
            if(ator.getNome().toLowerCase(Locale.ROOT).contains(filtroNome.toLowerCase(Locale.ROOT)))
            retorno.add(new AtorEmAtividade(ator.getId(), ator.getNome(), ator.getDataNascimento()));
        }

        if (retorno.isEmpty()) {
            throw new FiltroNaoEncontradoException(TipoDominioException.ATOR.getSingular(), filtroNome);
        }

        return retorno;
    }


    public Optional<Ator> consultarAtor(Integer id) throws Exception {

        Optional<Ator> ator = repository.findById(id);

        if (!ator.isPresent()) {
            throw new ConsultaInvalidaIdException(TipoDominioException.ATOR.getSingular(), id);
        }
        return ator;
    }


    public List<Ator> consultarAtores() throws Exception {

        List<Ator> atores = repository.findAll();

        if (atores.isEmpty()) {
            throw new ListaConsultaVaziaExceptions(TipoDominioException.ATOR.getSingular(), TipoDominioException.ATOR.getPlural());
        }

        return atores;
    }

    public void atualizarAtor(Integer id, AtorRequest atorRequest) throws Exception {

        Optional<Ator> atualizarAtor = repository.findById(id);

        if(!atualizarAtor.isPresent()){
            throw new ConsultaInvalidaIdException(TipoDominioException.ATOR.getSingular(), id);
        }

        if(!repository.findByNomeIgnoreCase(atorRequest.getNome()).isEmpty()){
            throw new ObjetoJaCadastradoExcepetion(TipoDominioException.ATOR.getSingular(),atorRequest.getNome());
        }

        atualizarAtor.get().setAnoInicioAtividade(atorRequest.getAnoInicioAtividade());
        atualizarAtor.get().setNome(atorRequest.getNome());
        atualizarAtor.get().setDataNascimento(atorRequest.getDataNascimento());
        atualizarAtor.get().setStatusCarreira(atorRequest.getStatusCarreira());

        repository.save(atualizarAtor.get());
    }

    public void removerAtor(Integer id) throws Exception{

        Optional<Ator> atorSelecionado = repository.findById(id);

        if(!atorSelecionado.isPresent()){
            throw new ConsultaInvalidaIdException(TipoDominioException.ATOR.getSingular(), id);
        }

        if(!personagemAtorRepository.findByAtorNomeContainsIgnoreCase(atorSelecionado.get().getNome()).isEmpty()){
            throw new DeleteComVinculoException(TipoDominioException.PERSONAGEM.getPlural(),TipoDominioException.ATOR.getSingular());
        }

        repository.delete(atorSelecionado.get());
    }

}