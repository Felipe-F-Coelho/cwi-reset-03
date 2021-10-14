package br.com.cwi.reset.felipecoelho;

public class AnoNascimentoDiretorException extends Exception{
    public AnoNascimentoDiretorException() {
        super("Ano de início de atividade inválido para o diretor cadastrado.");
    }
}
