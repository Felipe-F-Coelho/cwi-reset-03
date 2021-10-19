package br.com.cwi.reset.felipecoelho.exceptions.atorexceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AnoNascimentoAtorException extends Exception{
    public AnoNascimentoAtorException() {
        super("Ano de início de atividade inválido para o ator cadastrado.");
    }
}
