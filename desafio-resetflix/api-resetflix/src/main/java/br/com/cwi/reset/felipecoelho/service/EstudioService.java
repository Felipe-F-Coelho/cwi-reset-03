package br.com.cwi.reset.felipecoelho.service;

import br.com.cwi.reset.felipecoelho.repository.EstudioRepository;
import br.com.cwi.reset.felipecoelho.exceptions.*;
import br.com.cwi.reset.felipecoelho.model.Estudio;
import br.com.cwi.reset.felipecoelho.request.EstudioRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudioService {

    @Autowired
    private EstudioRepository repository;

    // Demais metodos da classe

    public void criarEstudio(EstudioRequest estudioRequest) throws Exception {

        List<Estudio> listaEstudio = repository.findAll();

        for(Estudio estudio : listaEstudio){
            if(estudio.getNome().equalsIgnoreCase(estudioRequest.getNome())){
                throw new CadastroDuplicadoException(TipoDominioException.ESTUDIO.getSingular(), estudio.getNome());
            }
        }

        if(repository.findByNomeIgnoreCase(estudioRequest.getNome()) != null){
            throw new CadastroDuplicadoException(TipoDominioException.ESTUDIO.getSingular(), estudioRequest.getNome());
        }

        final Estudio newEstudio = new Estudio(estudioRequest.getNome(),estudioRequest.getDescricao(),estudioRequest.getDataCriacao(),estudioRequest.getStatusAtividade());
        repository.save(newEstudio);
    }

    public List<Estudio> consultarEstudios() throws Exception {
        List<Estudio> estudios = repository.findAll();

        if(estudios.isEmpty()){
            throw new ListaConsultaVaziaExceptions(TipoDominioException.ESTUDIO.getSingular(),TipoDominioException.ESTUDIO.getPlural());
        }

        return estudios;
    }

    public List<Estudio> consultarEstudios(String filtroNome) throws Exception{

        List<Estudio> estudios = repository.findAll();

        if(estudios.isEmpty()){
            throw new ListaConsultaVaziaExceptions(TipoDominioException.ESTUDIO.getSingular(),TipoDominioException.ESTUDIO.getPlural());
        }

        List<Estudio> retorno = repository.findByNomeContainsIgnoreCase(filtroNome);

        if(retorno.isEmpty()){
            throw new FiltroNaoEncontradoException(TipoDominioException.ESTUDIO.getSingular(),filtroNome);
        }

        return retorno;
    }

    public Optional<Estudio> consultarEstudio(Integer id) throws Exception {

        Optional<Estudio> estudios = repository.findById(id);

        if(!estudios.isPresent()){
            throw new ConsultaInvalidaIdException(TipoDominioException.ESTUDIO.getSingular(),id);
        }

        return estudios;
    }
}
