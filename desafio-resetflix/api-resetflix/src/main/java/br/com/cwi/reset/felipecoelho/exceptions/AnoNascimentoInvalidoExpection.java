package br.com.cwi.reset.felipecoelho.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AnoNascimentoInvalidoExpection extends Exception {
    public AnoNascimentoInvalidoExpection(String singular) {
        super(String.format("Ano início de atividade inválido para o %s cadastrado.", singular));
    }
}
