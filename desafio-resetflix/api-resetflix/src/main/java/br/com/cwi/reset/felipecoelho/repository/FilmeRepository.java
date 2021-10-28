package br.com.cwi.reset.felipecoelho.repository;

import br.com.cwi.reset.felipecoelho.model.Filme;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmeRepository extends CrudRepository<Filme,Integer> {

    List<Filme> findAll();

    List<Filme> findByNomeContainsIgnoreCase(String nome);

    List<Filme> findByDiretorNomeContainsIgnoreCase(String nome);

}
