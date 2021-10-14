package br.com.cwi.reset.felipecoelho.AtorExceptions;

public class ListAtoresEmAtividadeVaziaException extends Exception {
    public ListAtoresEmAtividadeVaziaException() {
        super("Nenhum ator cadastrado, favor cadastar atores.");
    }
}
