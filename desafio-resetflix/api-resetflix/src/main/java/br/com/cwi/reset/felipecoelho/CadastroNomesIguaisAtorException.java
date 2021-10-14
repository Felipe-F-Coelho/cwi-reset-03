package br.com.cwi.reset.felipecoelho;

public class CadastroNomesIguaisAtorException extends Exception {
    public CadastroNomesIguaisAtorException(String nome) {
        super("Já existe um ator cadastrado para o nome " + nome);
    }
}
