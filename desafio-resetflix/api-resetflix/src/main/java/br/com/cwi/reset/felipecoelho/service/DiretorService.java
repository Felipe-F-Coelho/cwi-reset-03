package br.com.cwi.reset.felipecoelho.service;

import br.com.cwi.reset.felipecoelho.repository.DiretorRepository;
import br.com.cwi.reset.felipecoelho.exceptions.*;
import br.com.cwi.reset.felipecoelho.model.Diretor;

import br.com.cwi.reset.felipecoelho.request.DiretorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DiretorService {

    @Autowired
    private DiretorRepository repository;

    @Autowired
    private FilmeService filmeService;

    // Demais métodos da classe

    public void criarDiretor(DiretorRequest diretorRequest) throws Exception {

        List<Diretor> listaDiretores = repository.findAll();

        if(diretorRequest.getAnoInicioAtividade() < diretorRequest.getDataNascimento().getYear()){
            throw new AnoNascimentoInvalidoExpection(TipoDominioException.DIRETOR.getSingular());
        }

        for(Diretor diretor : listaDiretores){
            if(diretor.getNome().equalsIgnoreCase(diretorRequest.getNome())){
                throw new CadastroDuplicadoException(TipoDominioException.DIRETOR.getSingular(), diretor.getNome());
            }
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

    public void atualizarDiretor(Integer id, DiretorRequest diretorRequest) throws Exception {

        Optional<Diretor> atualizarDiretor = repository.findById(id);

        List<Diretor> listaDiretores = repository.findAll();

        if(!atualizarDiretor.isPresent()){
            throw new ConsultaInvalidaIdException(TipoDominioException.DIRETOR.getSingular(), id);
        }

        for(Diretor diretor : listaDiretores){
            if(Objects.equals(diretor.getNome(), diretorRequest.getNome()) && !Objects.equals(atualizarDiretor.get().getId(), diretor.getId())){
                throw new ObjetoJaCadastradoExcepetion(TipoDominioException.DIRETOR.getSingular(),diretorRequest.getNome());
            }
        }

        atualizarDiretor.get().setAnoInicioAtividade(diretorRequest.getAnoInicioAtividade());
        atualizarDiretor.get().setNome(diretorRequest.getNome());
        atualizarDiretor.get().setDataNascimento(diretorRequest.getDataNascimento());

        repository.save(atualizarDiretor.get());
    }

    public void removerDiretor(Integer id) throws Exception {

        Optional<Diretor> diretorSelecionado = repository.findById(id);

        if(!diretorSelecionado.isPresent()){
            throw new ConsultaInvalidaIdException(TipoDominioException.DIRETOR.getSingular(), id);
        }

        if(!filmeService.consultarDiretorFilme(diretorSelecionado.get().getNome()).isEmpty()){
            throw new DeleteComVinculoException(TipoDominioException.FILME.getPlural(),TipoDominioException.DIRETOR.getSingular());
        }

        repository.delete(diretorSelecionado.get());
    }
}
