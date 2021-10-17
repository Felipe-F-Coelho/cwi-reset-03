package br.com.cwi.reset.felipecoelho.atorexceptions;

public class AtorNaoEncontradoException extends Exception{
    public AtorNaoEncontradoException(Integer id) {
        super("Nenhum ator encontrado com o parâmetro id={"+id+"}, favor verifique os parâmetros informados");
    }
}
