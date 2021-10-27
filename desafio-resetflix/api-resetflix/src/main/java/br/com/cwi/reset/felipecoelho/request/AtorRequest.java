package br.com.cwi.reset.felipecoelho.request;

import br.com.cwi.reset.felipecoelho.model.StatusCarreira;


import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.*;
import java.time.LocalDate;


public class AtorRequest {

    @NotNull(message = "Campo obrigatório não informado. Favor informar campo nome")
    @NotBlank(message = "Campo obrigatório não informado. Favor informar campo nome")
    @Pattern(regexp = "^[a-zA-Z\\u00C0-\\u017F´]+\\s+[a-zA-Z\\u00C0-\\u017F´]{0,}$", message =
            "Deve ser informado no mínimo nome e sobrenome para o Ator")
    private final String nome;

    @NotNull(message = "Campo obrigatório não informado. Favor informar campo data de nascimento")
    @Past(message = "Não é possível cadastrar atores não nascidos.")
    private final LocalDate dataNascimento;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Campo obrigatório não informado. Favor informar campo status da carreira")
    private final StatusCarreira statusCarreira;

    @NotNull(message = "Campo obrigatório não informado. Favor informar campo ano inicio da atividade")
    private final Integer anoInicioAtividade;

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
