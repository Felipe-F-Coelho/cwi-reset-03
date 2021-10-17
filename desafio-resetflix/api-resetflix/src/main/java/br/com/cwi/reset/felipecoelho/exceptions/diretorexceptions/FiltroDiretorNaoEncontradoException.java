package br.com.cwi.reset.felipecoelho.exceptions.diretorexceptions;

public class FiltroDiretorNaoEncontradoException extends Exception{
    public FiltroDiretorNaoEncontradoException(String filtro) {
        super("Diretor não encontrato com o filtro {"+filtro+"}, favor informar outro filtro.");
    }
}
