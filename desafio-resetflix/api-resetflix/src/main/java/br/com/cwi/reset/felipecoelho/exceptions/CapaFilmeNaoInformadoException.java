package br.com.cwi.reset.felipecoelho.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CapaFilmeNaoInformadoException extends CampoNaoInformadoException {
    public CapaFilmeNaoInformadoException() {
        super("Capa do Filme");
    }
}
