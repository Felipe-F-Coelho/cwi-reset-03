package br.com.cwi.reset.felipecoelho.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ObjetoJaCadastradoExcepetion extends Exception {
    public ObjetoJaCadastradoExcepetion(String singular,String nome) {
        super(String.format("Já existe um %s cadastrado para o nome {%s}.",singular,nome));
    }
}
