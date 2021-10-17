package br.com.cwi.reset.felipecoelho.diretorexceptions;

public class DataDeNascimentoDiretorException extends Exception{
    public DataDeNascimentoDiretorException() {
        super("Não é possível cadastrar diretores não nascidos");
    }
}
