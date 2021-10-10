package br.com.cwi.reset.aula.dois.exercicios;

public class Filme {

    private String nome;
    private String descricao;
    private Integer duracao;
    private Integer anoLancamento;
    private Double avaliacao;
    private Pessoa nomeDiretor;

    public Filme(String nome, String descricao, Integer duracao, Integer anoLancamento, Double avaliacao, Diretor diretor) throws AvaliacaoForaDoPadraoException {
        try {
            validacaoAvalicao(avaliacao);
            this.nome = nome;
            this.descricao = descricao;
            this.duracao = duracao;
            this.anoLancamento = anoLancamento;
            this.avaliacao = avaliacao;
            this.nomeDiretor = diretor;
        }catch (AvaliacaoForaDoPadraoException e){
            System.out.println(e.getMessage());
        }
    }

    private void validacaoAvalicao(Double avaliacao) throws AvaliacaoForaDoPadraoException {
        if(avaliacao < 1 || avaliacao > 5){
            throw new AvaliacaoForaDoPadraoException();
        }
    }

    public void reproducao(){
        System.out.println("Nome do Fime: " + this.nome);
        System.out.println("Descrição do Filme: " + this.descricao);
        System.out.println("Duração: " + this.duracao);
        System.out.println("Diretor: " + nomeDiretor.getNome());
        System.out.println("");
    }
}
