package br.com.cwi.reset.felipecoelho.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ListaConsultaVaziaExceptions extends Exception {
    public ListaConsultaVaziaExceptions(String singular, String plural) {
        super(String.format("Nenhum %s cadastrado, favor cadastrar %s", singular, plural));
    }
}
