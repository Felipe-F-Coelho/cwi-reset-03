package br.com.cwi.reset.projeto1.service;

import br.com.cwi.reset.projeto1.domain.Pet;
import br.com.cwi.reset.projeto1.exception.PetJaExistenteException;
import br.com.cwi.reset.projeto1.exception.PetNaoExistenteException;
import br.com.cwi.reset.projeto1.repository.PetRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {

    @Autowired
    private PetRepository repository;


    public List<Pet> consultarPets() {
        return (List<Pet>) repository.findAll();
    }

    public List<Pet> buscarPetPeloNome(String nome) throws PetNaoExistenteException {
        List<Pet> pet = repository.findByNome(nome);

        if (pet.isEmpty()) {
            throw new PetNaoExistenteException("Pet com o nome " + nome + " não existe");
        }
        return pet;
    }


    public Pet adicionarPet(Pet pet) {
        return repository.save(pet);
    }


    public Pet atualizarPet(Pet pet) throws Exception {

        if(pet.getId() == null || !repository.findById(pet.getId()).isPresent()) {
            throw new PetNaoExistenteException("Pet com o nome " + pet.getNome() + " não existe");
        }

        return repository.save(pet);
    }

    public void deletarPet(String nome) throws Exception {

        List<Pet> pet = repository.findByNome(nome);

        if (pet.isEmpty()) {
            throw new PetNaoExistenteException("Pet com o nome " + nome + " não existe");
        }

        repository.deleteAll(pet);
    }
}
