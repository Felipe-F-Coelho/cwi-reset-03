package br.com.cwi.reset.felipecoelho;

public class IdNãoInformadoException extends Exception{
    public IdNãoInformadoException() {
        super("Campo obrigatório não informado. Favor informar o campo de Identificação.");
    }
}
