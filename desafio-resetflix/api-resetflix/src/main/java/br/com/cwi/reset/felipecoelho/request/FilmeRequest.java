package br.com.cwi.reset.felipecoelho.request;

import br.com.cwi.reset.felipecoelho.model.Diretor;
import br.com.cwi.reset.felipecoelho.model.Estudio;
import br.com.cwi.reset.felipecoelho.model.Genero;
import br.com.cwi.reset.felipecoelho.model.PersonagemAtor;

import java.util.List;

public class FilmeRequest {

    private String nome;
    private Integer anoLancamento;
    private String capaFilme;
    private List<Genero> generos;
    private Integer idDiretor;
    private Integer idStudio;
    private String resumo;
    private List<PersonagemAtor> personagens;

}
