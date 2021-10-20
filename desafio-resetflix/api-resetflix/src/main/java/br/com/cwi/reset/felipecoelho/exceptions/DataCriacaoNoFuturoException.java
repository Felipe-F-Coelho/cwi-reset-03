package br.com.cwi.reset.felipecoelho.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DataCriacaoNoFuturoException extends Exception {

    public DataCriacaoNoFuturoException(String tipo) {
        super(String.format("Não é possível cadastrar %s no futuro", tipo));
    }
}
