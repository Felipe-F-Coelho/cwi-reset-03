package br.com.cwi.reset.felipecoelho;

public class AnoNascimentoException extends Exception{
    public AnoNascimentoException() {
        super("Ano de início de atividade inválido para o ator cadastrado.");
    }
}
