package br.com.cwi.reset.felipecoelho.exceptions.diretorexceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NomeSobrenomeDiretorException extends Exception{
    public NomeSobrenomeDiretorException() {
        super("Deve ser informado no mínimo nome e sobrenome para o diretor.");
    }
}
