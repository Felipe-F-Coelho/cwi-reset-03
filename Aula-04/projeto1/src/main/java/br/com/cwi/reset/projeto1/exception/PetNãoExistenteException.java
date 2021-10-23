package br.com.cwi.reset.projeto1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PetNãoExistenteException extends Exception {
    public PetNãoExistenteException(String nome) {
        super("Pet não encontrado com o nome: " + nome);
    }
}
