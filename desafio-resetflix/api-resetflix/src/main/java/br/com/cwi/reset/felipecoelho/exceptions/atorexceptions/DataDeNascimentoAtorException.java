package br.com.cwi.reset.felipecoelho.exceptions.atorexceptions;

public class DataDeNascimentoAtorException extends Exception{
    public DataDeNascimentoAtorException() {
        super("Não é possível cadastrar atores não nascidos.");
    }
}