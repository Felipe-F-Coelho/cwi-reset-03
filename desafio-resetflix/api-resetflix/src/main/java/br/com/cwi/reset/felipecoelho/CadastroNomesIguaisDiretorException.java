package br.com.cwi.reset.felipecoelho;

public class CadastroNomesIguaisDiretorException extends Exception{
    public CadastroNomesIguaisDiretorException(String nome) {
        super("Já existe um diretor cadastrado para o nome: " + nome);
    }
}
