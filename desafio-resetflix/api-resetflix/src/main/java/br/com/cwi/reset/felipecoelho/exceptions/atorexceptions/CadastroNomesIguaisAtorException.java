package br.com.cwi.reset.felipecoelho.exceptions.atorexceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CadastroNomesIguaisAtorException extends Exception {
    public CadastroNomesIguaisAtorException(String nome) {
        super("Já existe um ator cadastrado para o nome " + nome);
    }
}
