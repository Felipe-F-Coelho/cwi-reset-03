package br.com.cwi.reset.felipecoelho.domain;

import java.time.LocalDate;

public class Diretor extends Funcionario {

    public Diretor(Integer id, String nome, LocalDate dataDeNascimento, Integer anoInicioAtividade) {
        super(id, nome, dataDeNascimento, anoInicioAtividade);
    }
}

