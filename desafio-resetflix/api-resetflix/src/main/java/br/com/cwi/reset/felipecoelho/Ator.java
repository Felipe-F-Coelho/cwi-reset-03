package br.com.cwi.reset.felipecoelho;

import java.time.LocalDate;

public class Ator extends Funcionario {

    private StatusCarreira statusCarreira;

    public Ator(Integer id, String nome, LocalDate dataDeNascimento , StatusCarreira statusCarreira, Integer anoInicioAtividade) {
        super(id, nome, dataDeNascimento, anoInicioAtividade);
        this.statusCarreira = statusCarreira;
    }

    public StatusCarreira getStatusCarreira() {
        return statusCarreira;
    }
}
