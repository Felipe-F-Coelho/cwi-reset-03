package br.com.cwi.reset.felipecoelho.exceptions.diretorexceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DataDeNascimentoDiretorException extends Exception{
    public DataDeNascimentoDiretorException() {
        super("Não é possível cadastrar diretores não nascidos");
    }
}
