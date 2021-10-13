package br.com.cwi.reset.felipecoelho;

public class FiltroAtorNaoEncontradoException extends Exception{
    public FiltroAtorNaoEncontradoException(String filtro) {
        super("Ator não encontrato com o filtro " + filtro + ", favor informar outro filtro.");
    }
}
