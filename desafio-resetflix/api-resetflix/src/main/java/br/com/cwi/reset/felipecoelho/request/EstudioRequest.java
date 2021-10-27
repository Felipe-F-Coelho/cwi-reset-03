package br.com.cwi.reset.felipecoelho.request;

import br.com.cwi.reset.felipecoelho.model.StatusAtividade;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

public class EstudioRequest {

    @NotNull(message = "Campo obrigatório não informado. Favor informar campo nome")
    @NotBlank(message = "Campo obrigatório não informado. Favor informar campo nome")
    final private String nome;
    @NotNull(message = "Campo obrigatório não informado. Favor informar campo descrição")
    @NotBlank(message = "Campo obrigatório não informado. Favor informar campo descrição")
    final private String descricao;
    @NotNull(message = "Campo obrigatório não informado. Favor informar campo status da data de criação")
    @Past(message = "Não é possível cadastrar estudio no futuro.")
    final private LocalDate dataCriacao;
    @NotNull(message = "Campo obrigatório não informado. Favor informar campo status da atividade")
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
