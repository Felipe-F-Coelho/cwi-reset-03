public class RelacaoPesoPreco {

    public static double retornaPrecoProduto(String item, int qtd) {
        double precoTotal = 0;

        if ("pao".equals(item) && !QuantidadeMinimaItem.verificacaoQuantidade(item,qtd)) {
            precoTotal = (12.75 * 0.06) * qtd;
            ItensPorQuantidade.setPao(ItensPorQuantidade.getPao() - qtd);
        }else if ("torta".equals(item) && !QuantidadeMinimaItem.verificacaoQuantidade(item,qtd)) {
            precoTotal = qtd * (96.00 / 16);
            ItensPorQuantidade.setTorta(ItensPorQuantidade.getTorta() - (qtd / 16));
        }else if ("leite".equals(item) && !QuantidadeMinimaItem.verificacaoQuantidade(item,qtd)) {
            precoTotal = 4.48 * qtd;
            ItensPorQuantidade.setLeite(ItensPorQuantidade.getLeite() - qtd);
        }else if ("cafe".equals(item) && !QuantidadeMinimaItem.verificacaoQuantidade(item,qtd)) {
            precoTotal = 9.56 * qtd;
            ItensPorQuantidade.setCafe(ItensPorQuantidade.getCafe() - qtd);
        }else if ("sanduiche".equals(item) && !QuantidadeMinimaItem.verificacaoQuantidade(item,qtd)) {
            precoTotal = 4.5 * qtd;
            ItensPorQuantidade.setSanduiche(ItensPorQuantidade.getSanduiche() - qtd);
        }

        return precoTotal;
    }
}
