package br.com.cwi.reset.felipecoelho.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NaoNascidosExceptions extends Exception {
    public NaoNascidosExceptions(String plural) {
        super(String.format("Não é possível cadastrar %s não nascidos.",plural));
    }
}
