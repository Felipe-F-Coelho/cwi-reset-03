package br.com.cwi.reset.felipecoelho.exceptions.diretorexceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CadastroNomesIguaisDiretorException extends Exception{
    public CadastroNomesIguaisDiretorException(String nome) {
        super("Já existe um diretor cadastrado para o nome: " + nome);
    }
}
