package br.com.cwi.reset.felipecoelho.model;

import br.com.cwi.reset.felipecoelho.model.Ator;
import br.com.cwi.reset.felipecoelho.model.TipoAtuacao;

public class Personagem {
    private Integer id;
    private Integer idAtor;
    private String nomePersonagem;
    private String descricaoPersonagem;
    private TipoAtuacao tipoAtuacao;

    public Personagem(Integer id, Integer idAtor, String nomePersonagem, String descricaoPersonagem, TipoAtuacao tipoAtuacao) {
        this.id = id;
        this.idAtor = idAtor;
        this.nomePersonagem = nomePersonagem;
        this.descricaoPersonagem = descricaoPersonagem;
        this.tipoAtuacao = tipoAtuacao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdAtor() {
        return idAtor;
    }

    public void setIdAtor(Integer idAtor) {
        this.idAtor = idAtor;
    }

    public String getNomePersonagem() {
        return nomePersonagem;
    }

    public void setNomePersonagem(String nomePersonagem) {
        this.nomePersonagem = nomePersonagem;
    }

    public String getDescricaoPersonagem() {
        return descricaoPersonagem;
    }

    public void setDescricaoPersonagem(String descricaoPersonagem) {
        this.descricaoPersonagem = descricaoPersonagem;
    }

    public TipoAtuacao getTipoAtuacao() {
        return tipoAtuacao;
    }

    public void setTipoAtuacao(TipoAtuacao tipoAtuacao) {
        this.tipoAtuacao = tipoAtuacao;
    }
}
