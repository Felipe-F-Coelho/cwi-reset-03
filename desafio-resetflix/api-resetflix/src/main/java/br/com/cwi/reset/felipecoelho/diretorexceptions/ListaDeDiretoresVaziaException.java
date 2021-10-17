package br.com.cwi.reset.felipecoelho.diretorexceptions;

public class ListaDeDiretoresVaziaException extends Exception{
    public ListaDeDiretoresVaziaException() {
        super("Nenhum diretor cadastrado, favor cadastar diretores.");
    }
}
