package br.com.cwi.reset.felipecoelho.exceptions.diretorexceptions;

public class DataDeNascimentoDiretorException extends Exception{
    public DataDeNascimentoDiretorException() {
        super("Não é possível cadastrar diretores não nascidos");
    }
}
