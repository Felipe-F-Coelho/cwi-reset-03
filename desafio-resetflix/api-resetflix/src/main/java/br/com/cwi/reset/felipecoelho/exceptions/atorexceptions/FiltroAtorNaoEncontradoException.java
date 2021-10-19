package br.com.cwi.reset.felipecoelho.exceptions.atorexceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class FiltroAtorNaoEncontradoException extends Exception{
    public FiltroAtorNaoEncontradoException(String filtro) {
        super("Ator não encontrato com o filtro " + filtro + ", favor informar outro filtro.");
    }
}
