package br.com.cwi.reset.felipecoelho.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MesmoObjetoMaisDeUmaVezGenero extends Exception {
    public MesmoObjetoMaisDeUmaVezGenero() {
        super("Não é permitido informar o mesmo %s/%s mais de uma vez para o mesmo filme");
    }
}
