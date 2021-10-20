package br.com.cwi.reset.felipecoelho.request;

import br.com.cwi.reset.felipecoelho.model.StatusAtividade;

import java.time.LocalDate;

public class EstudioRequest {

    final private String nome;
    final private String descricao;
    final private LocalDate dataCriacao;
    final private StatusAtividade statusAtividade;

    public EstudioRequest(String nome, String descricao, LocalDate dataCriacao, StatusAtividade statusAtividade) {
        this.nome = nome;
        this.descricao = descricao;
        this.dataCriacao = dataCriacao;
        this.statusAtividade = statusAtividade;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public StatusAtividade getStatusAtividade() {
        return statusAtividade;
    }
}
