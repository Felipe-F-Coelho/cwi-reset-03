package br.com.cwi.reset.felipecoelho.repository;

import br.com.cwi.reset.felipecoelho.model.Ator;
import br.com.cwi.reset.felipecoelho.model.Diretor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiretorRepository extends CrudRepository<Diretor,Integer> {

    String findByNomeIgnoreCase(String nome);

    List<Diretor> findAll();

    List<Diretor> findByNomeContainsIgnoreCase(String nome);

}
