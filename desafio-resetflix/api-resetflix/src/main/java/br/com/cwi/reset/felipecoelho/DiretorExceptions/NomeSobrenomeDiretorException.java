package br.com.cwi.reset.felipecoelho.DiretorExceptions;

public class NomeSobrenomeDiretorException extends Exception{
    public NomeSobrenomeDiretorException() {
        super("Deve ser informado no mínimo nome e sobrenome para o diretor.");
    }
}
