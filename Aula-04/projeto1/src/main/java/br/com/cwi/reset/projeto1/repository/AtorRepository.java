package br.com.cwi.reset.projeto1.repository;

import br.com.cwi.reset.projeto1.domain.Ator;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AtorRepository extends CrudRepository<Ator,Integer> {

    Ator findByNome(String nome);

    List<Ator> findByNumeroOscarsGreaterThan(Integer filtro);

    List<Ator> findByNumeroOscarsGreaterThanAndDataNascimentoGreaterThan(Integer numeroOscar, LocalDate nascimento);

}
