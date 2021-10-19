package br.com.cwi.reset.felipecoelho.exceptions.atorexceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NomeSobrenomeAtorException extends Exception{
    public NomeSobrenomeAtorException() {
        super("Deve ser informado no mínimo nome e sobrenome para o ator.");
    }
}
