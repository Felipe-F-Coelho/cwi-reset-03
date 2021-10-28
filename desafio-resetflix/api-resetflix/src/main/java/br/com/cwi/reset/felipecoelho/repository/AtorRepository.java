package br.com.cwi.reset.felipecoelho.repository;

import br.com.cwi.reset.felipecoelho.model.Ator;
import br.com.cwi.reset.felipecoelho.model.StatusCarreira;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AtorRepository extends CrudRepository<Ator,Integer> {

    List<Ator> findAllByStatusCarreira(StatusCarreira statusCarreira);

    List<Ator> findAll();

    Ator findByNome(String nome);
}
