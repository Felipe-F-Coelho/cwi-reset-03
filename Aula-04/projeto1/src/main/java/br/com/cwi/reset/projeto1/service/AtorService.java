package br.com.cwi.reset.projeto1.service;

import br.com.cwi.reset.projeto1.domain.Ator;
import br.com.cwi.reset.projeto1.exception.AtorNãoExisteException;
import br.com.cwi.reset.projeto1.repository.AtorRepository;
import br.com.cwi.reset.projeto1.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AtorService {

    @Autowired
    private AtorRepository repository;

    public Ator criarAtor(Ator ator){
        return repository.save(ator);
    }


    public Ator filterName(String filterName) throws AtorNãoExisteException {

        Ator ator = repository.findByNome(filterName);

        if(ator.getNome().isEmpty()){
            throw new AtorNãoExisteException("Não foi encontrado Ator com o filtro: " + filterName);
        }

        return ator;
    }

    public List<Ator> filterOscar(Integer filtro) throws AtorNãoExisteException {

        List<Ator> atores = repository.findByNumeroOscarsGreaterThan(filtro);

        if(atores.isEmpty()){
            throw new AtorNãoExisteException("Não foi encontrado Ator com o filtro: " + filtro);
        }

        return atores;

    }

    public List<Ator> filterOscarAndNascimento(Integer oscar, Integer anoNascimento) throws AtorNãoExisteException {

        LocalDate dataNascimentoBefore = LocalDate.of(anoNascimento,1,1);

        List<Ator> atores = repository.findByNumeroOscarsGreaterThanAndDataNascimentoGreaterThan(oscar,dataNascimentoBefore);

        if(atores.isEmpty()){
            throw new AtorNãoExisteException("Não foi encontrado Ator com o filtro: " + oscar + "+" + anoNascimento);
        }

        return atores;
    }

    public Ator deletarAtor(Ator ator) throws AtorNãoExisteException {

        if(ator == null){
            throw new AtorNãoExisteException("Não foi encontrado Ator: " + ator);
        }

        repository.delete(ator);

        return ator;
    }
}
