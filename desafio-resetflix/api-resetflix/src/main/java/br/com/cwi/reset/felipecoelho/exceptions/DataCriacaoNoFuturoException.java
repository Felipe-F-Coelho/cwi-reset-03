package br.com.cwi.reset.felipecoelho.exceptions;

public class DataCriacaoNoFuturoException extends Exception {

    public DataCriacaoNoFuturoException(String tipo) {
        super(String.format("Não é possível cadastrar %s no futuro", tipo));
    }
}
