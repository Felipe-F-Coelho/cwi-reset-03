package br.com.cwi.reset.felipecoelho.service;

import br.com.cwi.reset.felipecoelho.exceptions.*;
import br.com.cwi.reset.felipecoelho.repository.AtorRepository;
import br.com.cwi.reset.felipecoelho.response.AtorEmAtividade;
import br.com.cwi.reset.felipecoelho.model.Ator;
import br.com.cwi.reset.felipecoelho.model.StatusCarreira;
import br.com.cwi.reset.felipecoelho.request.AtorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class AtorService {

    @Autowired
    private AtorRepository repository;

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
}