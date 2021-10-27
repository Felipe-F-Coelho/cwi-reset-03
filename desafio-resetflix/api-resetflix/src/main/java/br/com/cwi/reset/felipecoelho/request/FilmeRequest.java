package br.com.cwi.reset.felipecoelho.request;

import br.com.cwi.reset.felipecoelho.model.Genero;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public class FilmeRequest {

    @NotNull(message = "Campo obrigatório não informado. Favor informar campo nome")
    @NotBlank(message = "Campo obrigatório não informado. Favor informar campo nome")
    final private String nome;
    @NotNull(message = "Campo obrigatório não informado. Favor informar campo ano de lançamento")
    final private Integer anoLancamento;
    @NotNull(message = "Campo obrigatório não informado. Favor informar campo capa do filme")
    @NotBlank(message = "Campo obrigatório não informado. Favor informar campo capa do filme")
    final private String capaFilme;
    @NotNull(message = "Campo obrigatório não informado. Favor informar campo generos")
    @NotEmpty(message = "Campo obrigatório não informado. Favor informar campo generos")
    final private List<Genero> generos;
    @NotNull(message = "Campo obrigatório não informado. Favor informar campo ID do diretor")
    final private Integer idDiretor;
    @NotNull(message = "Campo obrigatório não informado. Favor informar campo ID do estudio")
    final private Integer idEstudio;
    @NotNull(message = "Campo obrigatório não informado. Favor informar campo resumo")
    @NotBlank(message = "Campo obrigatório não informado. Favor informar campo resumo")
    final private String resumo;
    @NotEmpty(message = "Campo obrigatório não informado. Favor informar campo personagens")
    final private List<PersonagemRequest> personagens;

    public FilmeRequest(String nome, Integer anoLancamento, String capaFilme, List<Genero> generos, Integer idDiretor, Integer idEstudio, String resumo, List<PersonagemRequest> personagens) {
        this.nome = nome;
        this.anoLancamento = anoLancamento;
        this.capaFilme = capaFilme;
        this.generos = generos;
        this.idDiretor = idDiretor;
        this.idEstudio = idEstudio;
        this.resumo = resumo;
        this.personagens = personagens;
    }

    public String getNome() {
        return nome;
    }

    public Integer getAnoLancamento() {
        return anoLancamento;
    }

    public String getCapaFilme() {
        return capaFilme;
    }

    public List<Genero> getGeneros() {
        return generos;
    }

    public Integer getIdDiretor() {
        return idDiretor;
    }

    public Integer getIdEstudio() {
        return idEstudio;
    }

    public String getResumo() {
        return resumo;
    }

    public List<PersonagemRequest> getPersonagens() {
        return personagens;
    }
}
