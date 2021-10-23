package br.com.cwi.reset.projeto1.repository;

import br.com.cwi.reset.projeto1.domain.Pet;

import java.util.List;

public interface PetRepository {

    List<Pet> retornarPets();

    Pet buscarPet(String nome);

    Pet adicionarPet(Pet pet);

    Pet atualizarPet(Pet pet);

    Pet deletarPet(String nome);
}
