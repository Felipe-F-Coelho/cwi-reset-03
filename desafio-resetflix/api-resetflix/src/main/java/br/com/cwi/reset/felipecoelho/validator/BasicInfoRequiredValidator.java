package br.com.cwi.reset.felipecoelho.validator;

import br.com.cwi.reset.felipecoelho.exceptions.*;
import br.com.cwi.reset.felipecoelho.model.StatusCarreira;

import java.time.LocalDate;

public class BasicInfoRequiredValidator {

    public void accept(String nome, LocalDate dataNascimento, Integer anoInicioAtividade, TipoDominioException tipoDominioException) throws Exception {

        if(nome == null){
            throw new NomeNaoInformadoException();
        }
        if(dataNascimento == null){
            throw new DataNascimentoNaoInformadoException();
        }
        if(anoInicioAtividade == null){
            throw new AnoInicioAtividadeNaoInformadoException();
        }
        if (!nome.matches("^[a-zA-Z\\u00C0-\\u017F´]+\\s+[a-zA-Z\\u00C0-\\u017F´]{0,}$")) {
            throw new NomeSobrenomeObrigatorioException(tipoDominioException.getSingular());
        }
        if(LocalDate.now().isBefore(dataNascimento)){
            throw new NaoNascidosExceptions(tipoDominioException.getPlural());
        }
        if(anoInicioAtividade < dataNascimento.getYear()){
            throw new AnoNascimentoInvalidoExpection(tipoDominioException.getSingular());
        }
    }
}
