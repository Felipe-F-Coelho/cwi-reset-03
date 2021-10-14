package br.com.cwi.reset.felipecoelho.DiretorExceptions;

public class DataDeNascimentoDiretorException extends Exception{
    public DataDeNascimentoDiretorException() {
        super("Não é possível cadastrar diretores não nascidos");
    }
}
