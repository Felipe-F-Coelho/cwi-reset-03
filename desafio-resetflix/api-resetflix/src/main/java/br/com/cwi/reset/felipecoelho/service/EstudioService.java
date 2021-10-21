package br.com.cwi.reset.felipecoelho.service;

import br.com.cwi.reset.felipecoelho.FakeDatabase;
import br.com.cwi.reset.felipecoelho.exceptions.*;
import br.com.cwi.reset.felipecoelho.model.Estudio;
import br.com.cwi.reset.felipecoelho.request.EstudioRequest;
import br.com.cwi.reset.felipecoelho.validator.BasicInfoRequiredValidatorEstudio;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class EstudioService {

    final private FakeDatabase fakeDatabase;
    private Integer id;

    public EstudioService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
    }

    public Integer getId() {
        return id;
    }

    // Demais metodos da classe

    public void criarEstudio(EstudioRequest estudioRequest) throws Exception {

        final List<Estudio> estudiosCadastrados =fakeDatabase.recuperaEstudios();

        for(Estudio estudioCadastrado : estudiosCadastrados){
            if(estudioCadastrado.getNome().equalsIgnoreCase(estudioRequest.getNome())){
                throw new CadastroDuplicadoException(TipoDominioException.ESTUDIO.getSingular(), estudioRequest.getNome());
            }
        }

        new BasicInfoRequiredValidatorEstudio().accept(estudioRequest.getNome(),estudioRequest.getDescricao(),estudioRequest.getDataCriacao(),estudioRequest.getStatusAtividade());

        this.id = this.fakeDatabase.solicitarID();
        final Estudio newEstudio = new Estudio(id,estudioRequest.getNome(),estudioRequest.getDescricao(),estudioRequest.getDataCriacao(),estudioRequest.getStatusAtividade());
        fakeDatabase.persisteEstudio(newEstudio);

    }

    public List<Estudio> consultarEstudios(String filtroNome) throws Exception{

        List<Estudio> estudios = fakeDatabase.recuperaEstudios();

        if(estudios.isEmpty()){
            throw new ListaConsultaVaziaExceptions(TipoDominioException.ESTUDIO.getSingular(),TipoDominioException.ESTUDIO.getPlural());
        }

        List<Estudio> retorno = estudios.stream()
                .filter(e -> e.getNome().toLowerCase(Locale.ROOT).contains(filtroNome.toLowerCase(Locale.ROOT)))
                .collect(Collectors.toList());

        if(retorno.isEmpty()){
            throw new FiltroNaoEncontradoException(TipoDominioException.ESTUDIO.getSingular(),filtroNome);
        }

        return retorno;
    }

    public List<Estudio> consultarEstudios() throws Exception {
        List<Estudio> estudios = fakeDatabase.recuperaEstudios();

        if(estudios.isEmpty()){
            throw new ListaConsultaVaziaExceptions(TipoDominioException.ESTUDIO.getSingular(),TipoDominioException.ESTUDIO.getPlural());
        }


        return estudios;
    }

    public Estudio consultarEstudio(Integer id) throws Exception {

        if(id == null){
            throw new IdNaoInformadoException();
        }

        List<Estudio> estudios = fakeDatabase.recuperaEstudios();

        List<Estudio> dadosEstudio = estudios
                .stream()
                .filter(e -> e.getId().equals(id))
                .collect(Collectors.toList());

        if(dadosEstudio.isEmpty()){
            throw new ConsultaInvalidaIdException(TipoDominioException.ESTUDIO.getSingular(),id);
        }

        return dadosEstudio.get(0);
    }
}
