package br.com.cwi.reset.felipecoelho.model;

import br.com.cwi.reset.felipecoelho.model.StatusCarreira;

import java.text.DateFormat;

public class Estudio {
    private Integer id;
    private String nome;
    private String descricao;
    private DateFormat dataCriacao;
    private StatusCarreira statusCarreira;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public DateFormat getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(DateFormat dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public StatusCarreira getStatusCarreira() {
        return statusCarreira;
    }

    public void setStatusCarreira(StatusCarreira statusCarreira) {
        this.statusCarreira = statusCarreira;
    }
}
