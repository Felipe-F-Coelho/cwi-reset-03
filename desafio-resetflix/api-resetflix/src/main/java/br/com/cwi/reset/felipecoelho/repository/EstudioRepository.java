package br.com.cwi.reset.felipecoelho.repository;

import br.com.cwi.reset.felipecoelho.model.Ator;
import br.com.cwi.reset.felipecoelho.model.Diretor;
import br.com.cwi.reset.felipecoelho.model.Estudio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface EstudioRepository extends CrudRepository<Estudio,Integer> {

    String findByNomeIgnoreCase(String nome);

    List<Estudio> findAll();

    List<Estudio> findByNomeContainsIgnoreCase(String nome);
}
