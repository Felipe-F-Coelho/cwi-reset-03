package br.com.cwi.reset.felipecoelho.request;

import br.com.cwi.reset.felipecoelho.model.TipoAtuacao;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class PersonagemRequest {
    @NotNull(message = "Campo obrigatório não informado. Favor informar campo ID Ator")
    final private Integer idAtor;
    @NotNull(message = "Campo obrigatório não informado. Favor informar campo nome do personagem")
    @NotBlank(message = "Campo obrigatório não informado. Favor informar campo nome do personagem")
    final private String nomePersonagem;
    @NotNull(message = "Campo obrigatório não informado. Favor informar campo descrição do personagem")
    @NotBlank(message = "Campo obrigatório não informado. Favor informar campo descrição do personagem")
    final private String descricaoPersonagem;
    @NotNull(message = "Campo obrigatório não informado. Favor informar campo tipo de atuação")
    final private TipoAtuacao tipoAtuacao;

    public PersonagemRequest(Integer idAtor, String nomePersonagem, String descricaoPersonagem, TipoAtuacao tipoAtuacao) {
        this.idAtor = idAtor;
        this.nomePersonagem = nomePersonagem;
        this.descricaoPersonagem = descricaoPersonagem;
        this.tipoAtuacao = tipoAtuacao;
    }

    public Integer getIdAtor() {
        return idAtor;
    }

    public String getNomePersonagem() {
        return nomePersonagem;
    }

    public String getDescricaoPersonagem() {
        return descricaoPersonagem;
    }

    public TipoAtuacao getTipoAtuacao() {
        return tipoAtuacao;
    }
}
