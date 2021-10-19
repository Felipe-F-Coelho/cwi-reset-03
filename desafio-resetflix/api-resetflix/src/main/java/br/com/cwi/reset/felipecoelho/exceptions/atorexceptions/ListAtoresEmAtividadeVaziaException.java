package br.com.cwi.reset.felipecoelho.exceptions.atorexceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ListAtoresEmAtividadeVaziaException extends Exception {
    public ListAtoresEmAtividadeVaziaException() {
        super("Nenhum ator cadastrado, favor cadastar atores.");
    }
}
