package br.com.cwi.reset.felipecoelho.request;

import br.com.cwi.reset.felipecoelho.model.StatusCarreira;

import java.time.LocalDate;


public class AtorRequest {

    final private String nome;
    final private LocalDate dataNascimento;
    final private StatusCarreira statusCarreira;
    final private Integer anoInicioAtividade;

    public AtorRequest(String nome, LocalDate dataNascimento, StatusCarreira statusCarreira, Integer anoInicioAtividade) {

            this.nome = nome;
            this.dataNascimento = dataNascimento;
            this.statusCarreira = statusCarreira;
            this.anoInicioAtividade = anoInicioAtividade;

    }


    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public StatusCarreira getStatusCarreira() {
        return statusCarreira;
    }

    public Integer getAnoInicioAtividade() {
        return anoInicioAtividade;
    }



}
