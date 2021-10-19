package br.com.cwi.reset.felipecoelho.exceptions.diretorexceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AnoNascimentoDiretorException extends Exception{
    public AnoNascimentoDiretorException() {
        super("Ano de início de atividade inválido para o diretor cadastrado.");
    }
}
