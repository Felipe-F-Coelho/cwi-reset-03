package br.com.cwi.reset.felipecoelho.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ConsultaInvalidaIdException extends Exception {
    public ConsultaInvalidaIdException(String tipo, Integer id) {
        super(String.format("Nenhum %s encontrado com o parametro id={%s}, favor verifique os parâmetros informados",tipo,id));
    }
}
