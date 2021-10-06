public class QuantidadeMinimaItem {

    public static boolean precisaReposicao(String item, int qtd) {
        boolean verificacao = false;

        if ("paes".equals(item) && ItensPorQuantidade.pao < 600) {
            verificacao = true;
        }else if ("torta".equals(item) && ItensPorQuantidade.torta < 10) {
            verificacao = true;
        }else if ("sanduiche".equals(item) && ItensPorQuantidade.sanduiche <= 1) {
            verificacao = true;
        }else if ("cafe".equals(item) && ItensPorQuantidade.cafe < 12) {
            verificacao = true;
        }else if ("leite".equals(item) && ItensPorQuantidade.leite < 12) {
            verificacao = true;
        }
        if ("paes".equals(item) && qtd > ItensPorQuantidade.getPao() && ItensPorQuantidade.pao >= 600){
            ItensPorQuantidade.setPao(qtd);
        }else if ("torta".equals(item) && qtd > ItensPorQuantidade.getTorta() && ItensPorQuantidade.torta >= 10) {
            ItensPorQuantidade.setTorta(qtd);
        }else if ("sanduiche".equals(item) && qtd > ItensPorQuantidade.getSanduiche() && ItensPorQuantidade.sanduiche > 1) {
            ItensPorQuantidade.setSanduiche(qtd);
        }else if ("cafe".equals(item) && qtd > ItensPorQuantidade.getCafe() && ItensPorQuantidade.cafe >= 12) {
            ItensPorQuantidade.setCafe(qtd);
        }else if ("leite".equals(item) && qtd > ItensPorQuantidade.getLeite() && ItensPorQuantidade.leite >= 12) {
            ItensPorQuantidade.setLeite(qtd);
        }

        return verificacao;
    }

    static int quantidadeSelecionada = 0;

    public static boolean verificacaoQuantidade(String item, int quantidade) {
        boolean verificacao = false;
        if ("paes".equals(item) && quantidade > ItensPorQuantidade.getPao()) {
            verificacao = true;
            quantidadeSelecionada = ItensPorQuantidade.getPao();
        } else if ("torta".equals(item) && quantidade > ItensPorQuantidade.getTorta()) {
            verificacao = true;
            quantidadeSelecionada = ItensPorQuantidade.getTorta();
        } else if ("sanduiche".equals(item) && quantidade > ItensPorQuantidade.getSanduiche()) {
            verificacao = true;
            quantidadeSelecionada = ItensPorQuantidade.getSanduiche();
        } else if ("leite".equals(item) && quantidade > ItensPorQuantidade.getLeite()) {
            verificacao = true;
            quantidadeSelecionada = ItensPorQuantidade.getLeite();
        } else if ("cafe".equals(item) && quantidade > ItensPorQuantidade.getCafe()) {
            verificacao = true;
            quantidadeSelecionada = ItensPorQuantidade.getCafe();
        }

        return verificacao;
    }
}
