package br.com.cwi.reset.felipecoelho;

import java.time.LocalDate;

public class Diretor extends Funcionario {

    public Diretor(Integer id, String nome, LocalDate dataDeNacimento, Integer anoInicioAtividade) {
        super(id, nome, dataDeNacimento, anoInicioAtividade);
    }
}

