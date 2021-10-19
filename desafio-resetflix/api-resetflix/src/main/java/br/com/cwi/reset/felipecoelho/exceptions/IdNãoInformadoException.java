package br.com.cwi.reset.felipecoelho.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class IdNãoInformadoException extends Exception{
    public IdNãoInformadoException() {
        super("Campo obrigatório não informado. Favor informar o campo de Identificação.");
    }
}
