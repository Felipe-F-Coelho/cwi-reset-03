package br.com.cwi.reset.felipecoelho.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DeleteComVinculoException extends Exception {
    public DeleteComVinculoException(String plural, String singular) {
        super(String.format("Este %s está vinculado a um ou mais %s, para remover o %s é necessário remover os seus %s de atuação.",singular,plural,singular,plural));
    }
}
