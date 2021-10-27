package br.com.cwi.reset.felipecoelho.service;

import br.com.cwi.reset.felipecoelho.model.PersonagemAtor;
import br.com.cwi.reset.felipecoelho.repository.AtorRepository;
import br.com.cwi.reset.felipecoelho.exceptions.ConsultaInvalidaIdException;
import br.com.cwi.reset.felipecoelho.exceptions.MesmoObjetoMaisDeUmaVez;
import br.com.cwi.reset.felipecoelho.exceptions.TipoDominioException;
import br.com.cwi.reset.felipecoelho.model.Ator;
import br.com.cwi.reset.felipecoelho.repository.PersonagemAtorRepository;
import br.com.cwi.reset.felipecoelho.request.PersonagemRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonagemService {

    @Autowired
    private PersonagemAtorRepository repository;
    @Autowired
    private AtorRepository atorRepository;

    // Demais metodos da classe

    public PersonagemAtor criarPersonagem(PersonagemRequest personagemRequest) throws Exception {

        Optional<Ator> retorno = atorRepository.findById(personagemRequest.getIdAtor());

        if (!retorno.isPresent()) {
            throw new ConsultaInvalidaIdException(TipoDominioException.PERSONAGEM.getSingular(), personagemRequest.getIdAtor());
        }

        if (repository.findByNomePersonagemContainsIgnoreCase(personagemRequest.getNomePersonagem()) != null &&
                repository.findById(personagemRequest.getIdAtor()).isPresent()) {
            throw new MesmoObjetoMaisDeUmaVez(TipoDominioException.ATOR.getSingular(), TipoDominioException.PERSONAGEM.getSingular());
        }

        Ator atorSelecionado = atorRepository.findByNome(retorno.get().getNome());

        final PersonagemAtor newPersonagem = new PersonagemAtor(atorSelecionado, personagemRequest.getNomePersonagem(), personagemRequest.getDescricaoPersonagem(), personagemRequest.getTipoAtuacao());
        repository.save(newPersonagem);

        return newPersonagem;
    }

    public List<PersonagemAtor> consultarPersonagem(String nome) {
        return repository.findByNomePersonagemContainsIgnoreCase(nome);
    }

    public List<PersonagemAtor> consultarAtorDoPersonagem(String nome){
        return repository.findByAtorNomeContainsIgnoreCase(nome);
    }

    public void removerPersonagens(List<PersonagemAtor> listaPersonagens){
        for(PersonagemAtor personagemAtor : listaPersonagens){
            repository.delete(personagemAtor);
        }
    }
}
