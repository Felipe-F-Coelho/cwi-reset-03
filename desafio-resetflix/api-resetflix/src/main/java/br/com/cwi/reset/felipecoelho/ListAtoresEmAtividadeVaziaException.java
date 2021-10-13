package br.com.cwi.reset.felipecoelho;

public class ListAtoresEmAtividadeVaziaException extends Exception {
    public ListAtoresEmAtividadeVaziaException() {
        super("Nenhum ator cadastrado, favor cadastar atores.");
    }
}
