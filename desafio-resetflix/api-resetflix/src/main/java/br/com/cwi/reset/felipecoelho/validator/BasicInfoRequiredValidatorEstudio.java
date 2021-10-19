package br.com.cwi.reset.felipecoelho.validator;

import br.com.cwi.reset.felipecoelho.exceptions.*;
import br.com.cwi.reset.felipecoelho.model.StatusAtividade;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;

public class BasicInfoRequiredValidatorEstudio {

    public void accept(final String nome, final String descricao, final LocalDate dataCriacao, final StatusAtividade statusAtividade, final TipoDominioException tipoDominioException) throws Exception{

        if(nome == null){
            throw new NomeNaoInformadoException();
        }

        if(descricao == null){
            throw new DescricaoNaoInformadoException();
        }

        if(dataCriacao == null){
            throw new DataCriacaoNaoInformadoException();
        }
        if(statusAtividade == null){
            throw new StatusAtividadeNaoInformadoException();
        }
        if(LocalDate.now().isBefore(dataCriacao)){
            throw new DataCriacaoNoFuturoException(TipoDominioException.ESTUDIO.getPlural());
        }
    }
}
