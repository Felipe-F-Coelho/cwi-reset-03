package br.com.cwi.reset.felipecoelho.diretorexceptions;

public class DiretorNaoEncontradoException extends Exception{
    public DiretorNaoEncontradoException(Integer id) {
        super("Nenhum diretor encontrado com o parâmetro id={"+id+"}, favor verifique os parâmetros informados.");
    }
}
