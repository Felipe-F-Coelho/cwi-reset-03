package br.com.cwi.reset.felipecoelho.exceptions.atorexceptions;

public class NenhumAtorEncontradoException extends Exception{
    public NenhumAtorEncontradoException() {
        super("Nenhum ator cadastrado, favor cadastar atores.");
    }
}