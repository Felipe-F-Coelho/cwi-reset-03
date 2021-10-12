package br.com.cwi.reset.felipecoelho;

public class CadastroNomesIguaisException extends Exception {
    public CadastroNomesIguaisException(String nome) {
        super("Já existe um ator cadastrado para o nome " + nome);
    }
}
