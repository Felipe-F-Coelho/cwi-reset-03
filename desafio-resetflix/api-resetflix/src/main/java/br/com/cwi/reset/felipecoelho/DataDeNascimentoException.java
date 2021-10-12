package br.com.cwi.reset.felipecoelho;

public class DataDeNascimentoException extends Exception{
    public DataDeNascimentoException() {
        super("Não é possível cadastrar atores não nascidos.");
    }
}
