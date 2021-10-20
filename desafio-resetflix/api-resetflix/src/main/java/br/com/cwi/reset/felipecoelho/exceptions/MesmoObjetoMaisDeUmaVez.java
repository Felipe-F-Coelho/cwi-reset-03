package br.com.cwi.reset.felipecoelho.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MesmoObjetoMaisDeUmaVez extends Exception {
    public MesmoObjetoMaisDeUmaVez(String tipo01, String tipo02) {
        super(String.format("Não é permitido informar o mesmo %s/%s mais de uma vez para o mesmo filme",tipo01,tipo02));
    }
}
