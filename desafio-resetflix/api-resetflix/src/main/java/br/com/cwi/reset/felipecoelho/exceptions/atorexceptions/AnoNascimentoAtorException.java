package br.com.cwi.reset.felipecoelho.exceptions.atorexceptions;

public class AnoNascimentoAtorException extends Exception{
    public AnoNascimentoAtorException() {
        super("Ano de início de atividade inválido para o ator cadastrado.");
    }
}
