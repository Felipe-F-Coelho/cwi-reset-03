package br.com.cwi.reset.felipecoelho.service;

import br.com.cwi.reset.felipecoelho.repository.DiretorRepository;
import br.com.cwi.reset.felipecoelho.exceptions.*;
import br.com.cwi.reset.felipecoelho.model.Diretor;

import br.com.cwi.reset.felipecoelho.request.DiretorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DiretorService {

    @Autowired
    private DiretorRepository repository;

    // Demais métodos da classe

    public void criarDiretor(DiretorRequest diretorRequest) throws Exception {

        if(diretorRequest.getAnoInicioAtividade() < diretorRequest.getDataNascimento().getYear()){
            throw new AnoNascimentoInvalidoExpection(TipoDominioException.DIRETOR.getSingular());
        }

        if (repository.findByNomeIgnoreCase(diretorRequest.getNome()) != null) {
            throw new CadastroDuplicadoException(TipoDominioException.DIRETOR.getSingular(), diretorRequest.getNome());
        }

        Diretor newDiretor = new Diretor(diretorRequest.getNome(), diretorRequest.getDataNascimento(), diretorRequest.getAnoInicioAtividade());
        repository.save(newDiretor);
    }

    public List<Diretor> listarDiretores() throws Exception {

        List<Diretor> listaDiretores = repository.findAll();

        if (listaDiretores.isEmpty()) {
            throw new ListaConsultaVaziaExceptions(TipoDominioException.DIRETOR.getSingular(), TipoDominioException.DIRETOR.getPlural());
        }

        return listaDiretores;
    }

    public List<Diretor> listarDiretores(String filtroNome) throws Exception {

        List<Diretor> listaDiretores = repository.findAll();

        if (listaDiretores.isEmpty()) {
            throw new ListaConsultaVaziaExceptions(TipoDominioException.DIRETOR.getSingular(), TipoDominioException.DIRETOR.getPlural());
        }

        List<Diretor> retorno = repository.findByNomeContainsIgnoreCase(filtroNome);

        if (retorno.isEmpty()) {
            throw new FiltroNaoEncontradoException(TipoDominioException.DIRETOR.getSingular(), filtroNome);
        }

        return retorno;
    }

    public Optional<Diretor> consultarDiretor(Integer id) throws Exception {

        Optional<Diretor> diretores = repository.findById(id);

        if (!diretores.isPresent()) {
            throw new ConsultaInvalidaIdException(TipoDominioException.DIRETOR.getSingular(), id);
        }

        return diretores;
    }
}
