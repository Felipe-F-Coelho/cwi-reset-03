package br.com.cwi.reset.felipecoelho;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AtorService {

    private FakeDatabase fakeDatabase;
    private Integer id;

    public Integer getId() {
        return id;
    }

    public AtorService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;

    }

    // Demais métodos da classe

        // Metodos gerados como solicitado em contrato

    public void criarAtor(AtorRequest atorRequest) {

        try {
            invalidarNomesIguais(atorRequest.getNome());
            nomeSobrenome(atorRequest.getNome());
            validarDatadeNascimento(atorRequest.getDataNascimento());
            validarAnoNascimento(atorRequest.getDataNascimento(),atorRequest.getAnoInicioAtividade());
            campoObrigatorio(atorRequest.getNome(),atorRequest.getDataNascimento(),atorRequest.getStatusCarreira(),atorRequest.getAnoInicioAtividade());
            this.id = fakeDatabase.solicitarID();
            Ator newAtor = new Ator(this.id, atorRequest.getNome(), atorRequest.getDataNascimento(),atorRequest.getStatusCarreira(),atorRequest.getAnoInicioAtividade());
            fakeDatabase.persisteAtor(newAtor);
        }catch (CampoObrigatorioException | NomeSobrenomeException | DataDeNascimentoException | AnoNascimentoException | CadastroNomesIguaisException e){
            System.out.println(e.getMessage());
        }
    }

    public List<Ator> listarAtoresEmAtividade(){

        List<Ator> atores = fakeDatabase.recuperaAtores();

        List<Ator> listaAtores = atores.stream()
                .filter(e -> e.getStatusCarreira().equals(StatusCarreira.EM_ATIVIDADE))
                .collect(Collectors.toList());

        try {

            listaAtoresEmAtividadeVazia(listaAtores);
        } catch (ListAtoresEmAtividadeVaziaException e) {
            e.printStackTrace();
        }


        return listaAtores;
    }


    public List<Ator> listarAtoresEmAtividade(String filtroNome){

        List<Ator> atores = fakeDatabase.recuperaAtores();

        List<Ator> listaAtores = atores.stream()
                .filter(e -> e.getStatusCarreira().equals(StatusCarreira.EM_ATIVIDADE))
                .filter(e -> e.getNome().contains(filtroNome))
                .collect(Collectors.toList());

        try {
            listaAtoresEmAtividadeVazia(atores);
            atorNãoEncontrado(listaAtores,filtroNome);
        }catch (ListAtoresEmAtividadeVaziaException | FiltroAtorNaoEncontradoException e){
            e.printStackTrace();
        }

        return listaAtores;
    }

    public Ator consultarAtor(Integer id){

        List<Ator> atores = fakeDatabase.recuperaAtores();

        List<Ator> dadosAtor = new ArrayList<>();

        try{
            dadosAtor = atores
                    .stream()
                    .filter(e -> e.getId().equals(id))
                    .collect(Collectors.toList());
           idNaoInformado(id);
           idNaoEncontrado(dadosAtor,id);
        } catch (IdNãoInformadoException e) {
            e.printStackTrace();
        } catch (AtorNaoEncontradoException e) {
            e.printStackTrace();
        }

        return dadosAtor.get(0);
    }

    public List<Ator> consultarAtores(){
        List<Ator> atores = new ArrayList<>();

        try{
            atores = fakeDatabase.recuperaAtores();
            nenhumAtorEncontrado(atores);
        } catch (NenhumAtorEncontradoException e) {
            e.printStackTrace();
        }

        return atores;
    }

        // Metodos para gerar Excepetions

    private void nenhumAtorEncontrado(List<Ator> atores) throws NenhumAtorEncontradoException {
        if(atores.isEmpty()){
            throw new NenhumAtorEncontradoException();
        }
    }

    private void idNaoEncontrado(List<Ator> dadosAtor, Integer id) throws AtorNaoEncontradoException {

        if(dadosAtor.isEmpty()){
            throw new AtorNaoEncontradoException(id);
        }
    }

    private void idNaoInformado(Integer id) throws IdNãoInformadoException {

        if(id.describeConstable().isEmpty()){
            throw new IdNãoInformadoException();
        }
    }

    private void atorNãoEncontrado(List<Ator> list, String filtro) throws FiltroAtorNaoEncontradoException {

        if(list.isEmpty()){
            throw new FiltroAtorNaoEncontradoException(filtro);
        }
    }

    private void listaAtoresEmAtividadeVazia(List<Ator> list) throws ListAtoresEmAtividadeVaziaException {

        if(list.isEmpty()){
            throw new ListAtoresEmAtividadeVaziaException();
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

        List<Ator> atores = fakeDatabase.recuperaAtores();

        for(Ator f : atores){
            if(f.getNome().equals(nome)){
                throw new CadastroNomesIguaisException(nome);
            }
        }
    }

}