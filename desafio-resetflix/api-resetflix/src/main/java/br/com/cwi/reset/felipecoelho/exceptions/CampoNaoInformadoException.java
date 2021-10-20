package br.com.cwi.reset.felipecoelho.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CampoNaoInformadoException extends Exception{

    public CampoNaoInformadoException(final String campo) {
        super(String.format("Campo obrigatório não informado. Favor informar campo %s", campo));
    }
}