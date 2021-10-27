package br.com.cwi.reset.felipecoelho.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

public class DiretorRequest {

    @NotNull(message = "Campo obrigatório não informado. Favor informar campo nome")
    @NotBlank(message = "Campo obrigatório não informado. Favor informar campo nome")
    @Pattern(regexp = "^[a-zA-Z\\u00C0-\\u017F´]+\\s+[a-zA-Z\\u00C0-\\u017F´]{0,}$", message =
            "Deve ser informado no mínimo nome e sobrenome para o Diretor")
    final private String nome;
    @NotNull(message = "Campo obrigatório não informado. Favor informar campo data de nascimento")
    @Past(message = "Não é possível cadastrar atores não nascidos.")
    final private LocalDate dataNascimento;
    @NotNull(message = "Campo obrigatório não informado. Favor informar campo ano inicio da atividade")
    final private Integer anoInicioAtividade;

    public DiretorRequest(String nome, LocalDate dataNascimento, Integer anoInicioAtividade) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.anoInicioAtividade = anoInicioAtividade;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public Integer getAnoInicioAtividade() {
        return anoInicioAtividade;
    }
}
