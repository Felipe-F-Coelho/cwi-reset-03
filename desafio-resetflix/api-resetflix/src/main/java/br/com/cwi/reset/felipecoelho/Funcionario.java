package br.com.cwi.reset.felipecoelho;

import java.time.LocalDate;

public class Funcionario {
    private Integer id;
    private String nome;
    private LocalDate dataDeNacimento;
    private Integer anoInicioAtividade;

    public Funcionario(Integer id, String nome, LocalDate dataDeNacimento, Integer anoInicioAtividade) {
        this.id = id;
        this.nome = nome;
        this.dataDeNacimento = dataDeNacimento;
        this.anoInicioAtividade = anoInicioAtividade;
    }

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

    public LocalDate getDataDeNacimento() {
        return dataDeNacimento;
    }

    public void setDataDeNacimento(LocalDate dataDeNacimento) {
        this.dataDeNacimento = dataDeNacimento;
    }

    public Integer getAnoInicioAtividade() {
        return anoInicioAtividade;
    }

    public void setAnoInicioAtividade(Integer anoInicioAtividade) {
        this.anoInicioAtividade = anoInicioAtividade;
    }
}
