package br.com.cwi.reset.felipecoelho.exceptions.atorexceptions;

public class ListAtoresEmAtividadeVaziaException extends Exception {
    public ListAtoresEmAtividadeVaziaException() {
        super("Nenhum ator cadastrado, favor cadastar atores.");
    }
}
