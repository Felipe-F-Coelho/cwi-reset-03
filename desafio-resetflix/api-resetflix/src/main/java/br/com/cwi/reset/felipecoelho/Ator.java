package br.com.cwi.reset.felipecoelho;

import java.time.LocalDate;

public class Ator extends Funcionario {

    private StatusCarreira statusCarreira;

    public Ator(Integer id, String nome, LocalDate dataDeNacimento , StatusCarreira statusCarreira, Integer anoInicioAtividade) {
        super(id, nome, dataDeNacimento, anoInicioAtividade);
        this.statusCarreira = statusCarreira;
    }

}
