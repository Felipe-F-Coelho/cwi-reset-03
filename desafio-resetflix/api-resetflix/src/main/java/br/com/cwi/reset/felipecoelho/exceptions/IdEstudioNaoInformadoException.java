package br.com.cwi.reset.felipecoelho.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class IdEstudioNaoInformadoException extends CampoNaoInformadoException {
    public IdEstudioNaoInformadoException() {
        super("ID do Estudio");
    }
}
