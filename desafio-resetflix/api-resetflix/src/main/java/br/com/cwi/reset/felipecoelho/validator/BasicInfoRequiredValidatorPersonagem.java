package br.com.cwi.reset.felipecoelho.validator;

import br.com.cwi.reset.felipecoelho.exceptions.*;
import br.com.cwi.reset.felipecoelho.model.TipoAtuacao;

public class BasicInfoRequiredValidatorPersonagem {

    public void accept(String nomePersonagem, String descricaoPersonagem, TipoAtuacao tipoAtuacao, Integer idAtor) throws Exception {

        if(nomePersonagem == null){
            throw new NomePersonagemNaoInformadoException();
        }
        if(descricaoPersonagem == null){
            throw new DescricaoPersonagemNaoInformadoException();
        }
        if(tipoAtuacao == null){
            throw new TipoAtuacaoNaoInformadoException();
        }
        if(idAtor == null){
            throw new IdAtorNaoInformadoException();
        }

    }
}
