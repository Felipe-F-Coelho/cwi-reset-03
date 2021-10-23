package br.com.cwi.reset.projeto1.service;

import br.com.cwi.reset.projeto1.domain.Pet;
import br.com.cwi.reset.projeto1.repository.PetRepository;

import java.util.List;

public class PetService {

    private PetRepository petRepository = new PetRepository();


    public List<Pet> consultarPets() {
        return petRepository.retornarPets();
    }

    public Pet buscarPetPeloNome(String nome) {
        return petRepository.buscarPet(nome);
    }


    public Pet adicionarPet(Pet pet) {
        petRepository.adicionarPet(pet);
        return pet;
    }

    public void atualizarPet(Pet pet) {
        petRepository.atualizarPet(pet);
    }

    public void deletarPet(String nome) {
        petRepository.deletarPet(nome);
    }
}
