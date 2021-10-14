package br.com.cwi.reset.felipecoelho;

public class NomeSobrenomeAtorException extends Exception{
    public NomeSobrenomeAtorException() {
        super("Deve ser informado no mínimo nome e sobrenome para o ator.");
    }
}
