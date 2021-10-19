package br.com.cwi.reset.felipecoelho.exceptions.atorexceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AtorNaoEncontradoException extends Exception{
    public AtorNaoEncontradoException(Integer id) {
        super("Nenhum ator encontrado com o parâmetro id={"+id+"}, favor verifique os parâmetros informados");
    }
}
