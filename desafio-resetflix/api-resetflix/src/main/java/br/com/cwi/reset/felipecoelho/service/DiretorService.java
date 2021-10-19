package br.com.cwi.reset.felipecoelho.service;

import br.com.cwi.reset.felipecoelho.FakeDatabase;
import br.com.cwi.reset.felipecoelho.model.Diretor;
import br.com.cwi.reset.felipecoelho.exceptions.CampoObrigatorioException;
import br.com.cwi.reset.felipecoelho.exceptions.IdNãoInformadoException;
import br.com.cwi.reset.felipecoelho.exceptions.diretorexceptions.*;
import br.com.cwi.reset.felipecoelho.request.DiretorRequest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DiretorService {

    private FakeDatabase fakeDatabase;
    private Integer id;

    public Integer getId() {
        return id;
    }

    public DiretorService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
    }

    // Demais métodos da classe

    // Metodos gerados como solicitado em contrato

    public void criarDiretor(DiretorRequest diretorRequest) {

        try {
            invalidarNomesIguais(diretorRequest.getNome());
            validarAnoNascimento(diretorRequest.getDataNascimento(), diretorRequest.getAnoInicioAtividade());
            campoObrigatorio(diretorRequest.getNome(), diretorRequest.getDataNascimento(), diretorRequest.getAnoInicioAtividade());
            nomeSobrenome(diretorRequest.getNome());
            validarDatadeNascimento(diretorRequest.getDataNascimento());
            this.id = fakeDatabase.solicitarID();
            Diretor newDiretor = new Diretor(this.id, diretorRequest.getNome(), diretorRequest.getDataNascimento(), diretorRequest.getAnoInicioAtividade());
            fakeDatabase.persisteDiretor(newDiretor);
        } catch (CampoObrigatorioException | NomeSobrenomeDiretorException | DataDeNascimentoDiretorException | AnoNascimentoDiretorException | CadastroNomesIguaisDiretorException e) {
            e.printStackTrace();
        }
    }

    public List<Diretor> listarDiretores() {

        List<Diretor> diretores = fakeDatabase.recuperaDiretores();

        try {
            listaDeDiretoresVazia(diretores);
        } catch (ListaDeDiretoresVaziaException e) {
            e.printStackTrace();
        }

        return diretores;
    }

    public List<Diretor> listarDiretores(String filtroNome) {

        List<Diretor> diretores = fakeDatabase.recuperaDiretores();

        List<Diretor> listaDiretores = new ArrayList<>();

        try {
            listaDiretores = diretores.stream()
                    .filter(e -> e.getNome().contains(filtroNome))
                    .collect(Collectors.toList());

            filtroDiretorNãoEncontrado(listaDiretores, filtroNome);
            listaDeDiretoresVazia(listaDiretores);
        } catch (ListaDeDiretoresVaziaException | FiltroDiretorNaoEncontradoException e) {
            e.printStackTrace();
        }

        return listaDiretores;
    }

    public Diretor consultarDiretor(Integer id) {

        List<Diretor> diretores = fakeDatabase.recuperaDiretores();

        List<Diretor> dadosDiretor = new ArrayList<>();

        try {
            dadosDiretor = diretores.stream()
                    .filter(e -> e.getId().equals(id))
                    .collect(Collectors.toList());

            idNaoInformado(id);
            idNaoEncontrado(dadosDiretor, id);
        } catch (DiretorNaoEncontradoException | IdNãoInformadoException e) {
            e.printStackTrace();
        }

        return dadosDiretor.get(0);
    }


    // Metodos para gerar Excepetions

    private void idNaoEncontrado(List<Diretor> dadosDiretor, Integer id) throws DiretorNaoEncontradoException {

        if (dadosDiretor.isEmpty()) {
            throw new DiretorNaoEncontradoException(id);
        }
    }

    private void idNaoInformado(Integer id) throws IdNãoInformadoException {

        if (id == null) {
            throw new IdNãoInformadoException();
        }
    }

    private void filtroDiretorNãoEncontrado(List<Diretor> list, String filtro) throws FiltroDiretorNaoEncontradoException {

        if (list.isEmpty()) {
            throw new FiltroDiretorNaoEncontradoException(filtro);
        }
    }

    private void listaDeDiretoresVazia(List<Diretor> diretores) throws ListaDeDiretoresVaziaException {
        if (diretores.isEmpty()) {
            throw new ListaDeDiretoresVaziaException();
        }
    }

    private void invalidarNomesIguais(String nome) throws CadastroNomesIguaisDiretorException {

        List<Diretor> diretores = fakeDatabase.recuperaDiretores();

        for (Diretor f : diretores) {
            if (f.getNome().equals(nome)) {
                throw new CadastroNomesIguaisDiretorException(nome);
            }
        }
    }

    private void validarAnoNascimento(LocalDate dataNascimento, Integer anoInicioAtividade) throws AnoNascimentoDiretorException {
        if (dataNascimento.getYear() > anoInicioAtividade) {
            throw new AnoNascimentoDiretorException();
        }
    }

    private void validarDatadeNascimento(LocalDate dataNascimento) throws DataDeNascimentoDiretorException {

        LocalDate dataHoje = LocalDate.now();

        if (dataNascimento.getYear() > dataHoje.getYear() &&
                dataNascimento.getMonthValue() > dataHoje.getMonthValue() &&
                dataNascimento.getDayOfMonth() > dataHoje.getDayOfMonth()) {
            throw new DataDeNascimentoDiretorException();
        }
    }

    private void nomeSobrenome(String nome) throws NomeSobrenomeDiretorException {

        if (!nome.matches("^[a-zA-Z\\u00C0-\\u017F´]+\\s+[a-zA-Z\\u00C0-\\u017F´]{0,}$")) {
            throw new NomeSobrenomeDiretorException();
        }
    }

    private void campoObrigatorio(String nome, LocalDate dataNascimento, Integer anoInicioAtividade) throws CampoObrigatorioException {
        if (nome.isEmpty()) {
            throw new CampoObrigatorioException("do nome");
        } else if (dataNascimento == null) {
            throw new CampoObrigatorioException("da data de nascimento");
        } else if (anoInicioAtividade == null) {
            throw new CampoObrigatorioException("do ano inicio da atividade");
        }
    }

}
