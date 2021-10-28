package br.com.cwi.reset.felipecoelho.repository;

import br.com.cwi.reset.felipecoelho.model.PersonagemAtor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonagemAtorRepository extends CrudRepository<PersonagemAtor,Integer> {

    Optional<PersonagemAtor> findById(Integer id);

    List<PersonagemAtor> findAll();

    List<PersonagemAtor> findByNomePersonagemContainsIgnoreCase(String nome);

    List<PersonagemAtor> findByAtorNomeContainsIgnoreCase(String nome);

}
