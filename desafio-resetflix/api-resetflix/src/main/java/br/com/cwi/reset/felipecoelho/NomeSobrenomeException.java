package br.com.cwi.reset.felipecoelho;

public class NomeSobrenomeException extends Exception{
    public NomeSobrenomeException() {
        super("Deve ser informado no mínimo nome e sobrenome para o ator.");
    }
}
