package br.com.cwi.reset.felipecoelho.domain;

import br.com.cwi.reset.felipecoelho.enumapplication.Genero;

import java.util.List;

public class Filme {
    private Integer id;
    private String nome;
    private Integer anoLancamento;
    private String capaFilme;
    private Genero genero;
    private Diretor diretor;
    private List<PersonagemAtor> personagens;
    private String resumo;
}
