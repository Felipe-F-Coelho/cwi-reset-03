package br.com.cwi.reset.felipecoelho;

public class DataDeNascimentoDiretorException extends Exception{
    public DataDeNascimentoDiretorException() {
        super("Não é possível cadastrar diretores não nascidos");
    }
}
