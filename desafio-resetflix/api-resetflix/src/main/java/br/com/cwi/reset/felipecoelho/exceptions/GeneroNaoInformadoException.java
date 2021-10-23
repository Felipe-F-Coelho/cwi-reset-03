package br.com.cwi.reset.felipecoelho.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class GeneroNaoInformadoException extends Exception {
    public GeneroNaoInformadoException() {
        super("Deve ser informado pelo menos um gênero para cadastro do filme");
    }
}