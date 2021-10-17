package br.com.cwi.reset.felipecoelho.exceptions.diretorexceptions;

public class NomeSobrenomeDiretorException extends Exception{
    public NomeSobrenomeDiretorException() {
        super("Deve ser informado no mínimo nome e sobrenome para o diretor.");
    }
}
