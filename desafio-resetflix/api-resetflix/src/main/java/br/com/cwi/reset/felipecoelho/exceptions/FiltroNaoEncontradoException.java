package br.com.cwi.reset.felipecoelho.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class FiltroNaoEncontradoException extends Exception {
    public FiltroNaoEncontradoException(String tipo, String filtroNome) {
        super(String.format("%S não encontrado com o filtro %s, favor informar outro filtro.",tipo,filtroNome));
    }
}
