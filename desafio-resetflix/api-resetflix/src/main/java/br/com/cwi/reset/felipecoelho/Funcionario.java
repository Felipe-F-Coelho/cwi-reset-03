package br.com.cwi.reset.felipecoelho;

import java.time.LocalDate;

public class Funcionario {
    private Integer id;
    private String nome;
    private LocalDate dataDeNascimento;
    private Integer anoInicioAtividade;

    public Funcionario(Integer id, String nome, LocalDate dataDeNacimento, Integer anoInicioAtividade) {
        this.id = id;
        this.nome = nome;
        this.dataDeNascimento = dataDeNacimento;
        this.anoInicioAtividade = anoInicioAtividade;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public Integer getAnoInicioAtividade() {
        return anoInicioAtividade;
    }

}
