package br.com.cwi.reset.felipecoelho.service;

import br.com.cwi.reset.felipecoelho.exceptions.*;
import br.com.cwi.reset.felipecoelho.response.AtorEmAtividade;
import br.com.cwi.reset.felipecoelho.FakeDatabase;
import br.com.cwi.reset.felipecoelho.model.Ator;
import br.com.cwi.reset.felipecoelho.model.StatusCarreira;
import br.com.cwi.reset.felipecoelho.request.AtorRequest;
import br.com.cwi.reset.felipecoelho.validator.BasicInfoRequiredValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class AtorService {

    final private FakeDatabase fakeDatabase;
    private Integer id;

    public Integer getId() {
        return id;
    }

    public AtorService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;

    }

    // Demais métodos da classe

    public void criarAtor(AtorRequest atorRequest) throws Exception {

        final List<Ator> atoresCadastrados = fakeDatabase.recuperaAtores();

        new BasicInfoRequiredValidator().accept(atorRequest.getNome(), atorRequest.getDataNascimento(), atorRequest.getAnoInicioAtividade(),TipoDominioException.ATOR);

        if(atorRequest.getStatusCarreira() == null){
            throw new StatusCarreiraNaoInformadoException();
        }

        for (Ator atorCadastrado : atoresCadastrados) {
            if (atorCadastrado.getNome().equalsIgnoreCase(atorRequest.getNome())) {
                throw new CadastroDuplicadoException(TipoDominioException.ATOR.getSingular(), atorRequest.getNome());
            }
        }

        this.id = fakeDatabase.solicitarID();
        Ator newAtor = new Ator(this.id, atorRequest.getNome(), atorRequest.getDataNascimento(), atorRequest.getStatusCarreira(), atorRequest.getAnoInicioAtividade());
        fakeDatabase.persisteAtor(newAtor);
    }


    public List<AtorEmAtividade> listarAtoresEmAtividade() throws Exception {

        List<Ator> listaAtores = fakeDatabase.recuperaAtores()
                .stream()
                .filter(e -> e.getStatusCarreira().equals(StatusCarreira.EM_ATIVIDADE))
                .collect(Collectors.toList());

        if (listaAtores.isEmpty()) {
            throw new ListaConsultaVaziaExceptions(TipoDominioException.ATOR.getSingular(), TipoDominioException.ATOR.getPlural());
        }

        final List<AtorEmAtividade> retorno = new ArrayList<>();

        for (Ator ator : listaAtores) {
            retorno.add(new AtorEmAtividade(ator.getId(), ator.getNome(), ator.getDataDeNascimento()));
        }
        return retorno;
    }


    public List<AtorEmAtividade> listarAtoresEmAtividade(String filtroNome) throws Exception {

        List<Ator> listaAtores = fakeDatabase.recuperaAtores()
                .stream()
                .filter(e -> e.getStatusCarreira().equals(StatusCarreira.EM_ATIVIDADE))
                .collect(Collectors.toList());

        if (listaAtores.isEmpty()) {
            throw new ListaConsultaVaziaExceptions(TipoDominioException.ATOR.getSingular(), TipoDominioException.ATOR.getPlural());
        }

        final List<AtorEmAtividade> retorno = new ArrayList<>();

        for (Ator ator : listaAtores) {
            if(ator.getNome().toLowerCase(Locale.ROOT).contains(filtroNome.toLowerCase(Locale.ROOT)))
            retorno.add(new AtorEmAtividade(ator.getId(), ator.getNome(), ator.getDataDeNascimento()));
        }

        if (retorno.isEmpty()) {
            throw new FiltroNaoEncontradoException(TipoDominioException.ATOR.getSingular(), filtroNome);
        }

        return retorno;
    }


    public Ator consultarAtor(Integer id) throws Exception {

        if (id == null) {
            throw new IdNaoInformadoException();
        }

        List<Ator> atores = fakeDatabase.recuperaAtores();

        List<Ator> dadosAtor = atores
                .stream()
                .filter(e -> e.getId().equals(id))
                .collect(Collectors.toList());

        if (dadosAtor.isEmpty()) {
            throw new ConsultaInvalidaIdException(TipoDominioException.ATOR.getSingular(), id);
        }
        return dadosAtor.get(0);
    }


    public List<Ator> consultarAtores() throws Exception {
        List<Ator> atores = fakeDatabase.recuperaAtores();

        if (atores.isEmpty()) {
            throw new ListaConsultaVaziaExceptions(TipoDominioException.ATOR.getSingular(), TipoDominioException.ATOR.getPlural());
        }

        return atores;
    }
}