package br.com.cwi.reset.felipecoelho.validator;

import br.com.cwi.reset.felipecoelho.exceptions.*;
import br.com.cwi.reset.felipecoelho.model.Genero;

import java.util.List;

public class BasicInfoRequiredValidatorFilme {

    public void accept(String nome, Integer anoLancamento, String capaFilme, List<Genero> generos, Integer idDiretor, Integer idEstudio, String resumo) throws Exception {

        if(nome == null){
            throw new NomeNaoInformadoException();
        }
        if(anoLancamento == null){
            throw new AnoLancamentoNaoInformadoException();
        }
        if(capaFilme == null){
            throw new CapaFilmeNaoInformadoException();
        }
        if(generos.isEmpty()){
            throw new GeneroNaoInformadoException();
        }
        if(idDiretor == null){
            throw new IdDiretorNaoInformadoException();
        }
        if(idEstudio == null){
            throw new IdEstudioNaoInformadoException();
        }
        if(resumo == null){
            throw new ResumoNaoInformadoException();
        }

    }
}
