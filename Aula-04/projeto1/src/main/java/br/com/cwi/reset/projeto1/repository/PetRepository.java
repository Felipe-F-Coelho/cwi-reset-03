package br.com.cwi.reset.projeto1.repository;

import br.com.cwi.reset.projeto1.domain.Pet;

import java.util.ArrayList;
import java.util.List;

public class PetRepository {

    private List<Pet> pets = new ArrayList<>();


    public List<Pet> retornarPets() {
        return pets;
    }

    public Pet buscarPet(String nome) {

        for (Pet pet : pets) {
            if (pet.getNome().equals(nome)) {
                return pet;
            }
        }
        return null;
    }

    public Pet adicionarPet(Pet pet){
        pets.add(pet);
        return pet;
    }

    public void atualizarPet(Pet pet) {

        Pet petCadastrado = buscarPet(pet.getNome());

        if (petCadastrado != null) {
            pets.remove(petCadastrado);
            pets.add(pet);
        }
    }

    public void deletarPet(String nome) {
        Pet pet = buscarPet(nome);
        if (pet != null) {
            pets.remove(pet);
        }
    }
}
