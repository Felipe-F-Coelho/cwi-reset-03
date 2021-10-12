package br.com.cwi.reset.felipecoelho;

import java.time.LocalDate;
import java.util.List;

public class AtorRequest {

    private String nome;
    private LocalDate dataNascimento;
    private StatusCarreira statusCarreira;
    private Integer anoInicioAtividade;

    public AtorRequest(String nome, LocalDate dataNascimento, StatusCarreira statusCarreira, Integer anoInicioAtividade) {

        try {
            this.nome = nome;
            this.dataNascimento = dataNascimento;
            this.statusCarreira = statusCarreira;
            this.anoInicioAtividade = anoInicioAtividade;
            invalidarNomesIguais(this.nome);
            nomeSobrenome(this.nome);
            validarDatadeNascimento(this.dataNascimento);
            validarAnoNascimento(this.dataNascimento,this.anoInicioAtividade);
            campoObrigatorio(this.nome,this.dataNascimento,this.statusCarreira,this.anoInicioAtividade);
        }catch (CampoObrigatorioException | NomeSobrenomeException | DataDeNascimentoException | AnoNascimentoException | CadastroNomesIguaisException e){
            System.out.println(e.getMessage());
        }

    }

    private void campoObrigatorio (String nome, LocalDate dataNascimento, StatusCarreira statusCarreira, Integer anoInicioAtividade) throws CampoObrigatorioException{
        if(nome == null){
            throw new CampoObrigatorioException("do nome");
        }else if(dataNascimento == null){
            throw new CampoObrigatorioException("da data de nascimento");
        }else if(statusCarreira == null){
            throw new CampoObrigatorioException("do status da carreira");
        }else if(anoInicioAtividade == null){
            throw new CampoObrigatorioException("do ano inicio da atividade");
        }
    }

    private void nomeSobrenome(String nome) throws NomeSobrenomeException {

        if(!nome.matches("^[a-zA-Z\\u00C0-\\u017F´]+\\s+[a-zA-Z\\u00C0-\\u017F´]{0,}$")){
            throw new NomeSobrenomeException();
        }
    }

    private void validarDatadeNascimento(LocalDate dataNascimento) throws DataDeNascimentoException {

        LocalDate dataHoje = LocalDate.now();

        if(dataNascimento.getYear() > dataHoje.getYear() &&
            dataNascimento.getMonthValue() > dataHoje.getMonthValue() &&
            dataNascimento.getDayOfMonth() > dataHoje.getDayOfMonth()){
            throw new DataDeNascimentoException();
        }
    }

    private void validarAnoNascimento(LocalDate dataNascimento, Integer anoInicioAtividade) throws AnoNascimentoException{
        if(dataNascimento.getYear() > anoInicioAtividade){
            throw new AnoNascimentoException();
        }
    }

    private void invalidarNomesIguais(String nome) throws CadastroNomesIguaisException {

        FakeDatabase fakeDatabase = new FakeDatabase();

        List<Ator> atores = fakeDatabase.recuperaAtores();

        for(Ator f : atores){
            if(f.getNome().equals(nome)){
                throw new CadastroNomesIguaisException(nome);
            }
        }

    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public StatusCarreira getStatusCarreira() {
        return statusCarreira;
    }

    public Integer getAnoInicioAtividade() {
        return anoInicioAtividade;
    }
}
