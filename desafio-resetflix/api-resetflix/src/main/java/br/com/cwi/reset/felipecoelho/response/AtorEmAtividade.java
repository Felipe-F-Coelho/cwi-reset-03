package br.com.cwi.reset.felipecoelho.response;

import java.time.LocalDate;

public class AtorEmAtividade {

    final private Integer id;
    final private String nome;
    final private LocalDate dataNascimento;

    public AtorEmAtividade(Integer id, String nome, LocalDate dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() { return dataNascimento; }
}