package br.com.cwi.reset.felipecoelho.service;

import br.com.cwi.reset.felipecoelho.FakeDatabase;
import br.com.cwi.reset.felipecoelho.exceptions.*;
import br.com.cwi.reset.felipecoelho.model.Diretor;

import br.com.cwi.reset.felipecoelho.request.DiretorRequest;
import br.com.cwi.reset.felipecoelho.validator.BasicInfoRequiredValidator;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class DiretorService {

    final private FakeDatabase fakeDatabase;
    private Integer id;

    public Integer getId() {
        return id;
    }

    public DiretorService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
    }

    // Demais métodos da classe

    // Metodos gerados como solicitado em contrato


    public void criarDiretor(DiretorRequest diretorRequest) throws Exception {

        final List<Diretor> diretoresCadastrados = fakeDatabase.recuperaDiretores();

        new BasicInfoRequiredValidator().accept(diretorRequest.getNome(), diretorRequest.getDataNascimento(), diretorRequest.getAnoInicioAtividade(), TipoDominioException.DIRETOR);

        for (Diretor diretorCadastrado : diretoresCadastrados) {
            if (diretorCadastrado.getNome().equalsIgnoreCase(diretorRequest.getNome())) {
                throw new CadastroDuplicadoException(TipoDominioException.DIRETOR.getSingular(), diretorRequest.getNome());
            }
        }

        this.id = fakeDatabase.solicitarID();
        Diretor newDiretor = new Diretor(this.id, diretorRequest.getNome(), diretorRequest.getDataNascimento(), diretorRequest.getAnoInicioAtividade());
        fakeDatabase.persisteDiretor(newDiretor);
    }


    public List<Diretor> listarDiretores() throws Exception {

        List<Diretor> listaDiretores = fakeDatabase.recuperaDiretores();

        if (listaDiretores.isEmpty()) {
            throw new ListaConsultaVaziaExceptions(TipoDominioException.DIRETOR.getSingular(), TipoDominioException.DIRETOR.getPlural());
        }

        return listaDiretores;
    }


    public List<Diretor> listarDiretores(String filtroNome) throws Exception {

        List<Diretor> listaDiretores = fakeDatabase.recuperaDiretores();

        if (listaDiretores.isEmpty()) {
            throw new ListaConsultaVaziaExceptions(TipoDominioException.DIRETOR.getSingular(), TipoDominioException.DIRETOR.getPlural());
        }

        List<Diretor> retorno = listaDiretores.stream()
                .filter(e -> e.getNome().toLowerCase(Locale.ROOT).contains(filtroNome.toLowerCase(Locale.ROOT)))
                .collect(Collectors.toList());

        if (retorno.isEmpty()) {
            throw new FiltroNaoEncontradoException(TipoDominioException.DIRETOR.getSingular(), filtroNome);
        }

        return retorno;
    }


    public Diretor consultarDiretor(Integer id) throws Exception {

        if (id == null) {
            throw new IdNaoInformadoException();
        }

        List<Diretor> diretores = fakeDatabase.recuperaDiretores();

        List<Diretor> dadosDiretor = diretores.stream()
                .filter(e -> e.getId().equals(id))
                .collect(Collectors.toList());

        if (dadosDiretor.isEmpty()) {
            throw new ConsultaInvalidaIdException(TipoDominioException.DIRETOR.getSingular(), id);
        }

        return dadosDiretor.get(0);
    }
}
