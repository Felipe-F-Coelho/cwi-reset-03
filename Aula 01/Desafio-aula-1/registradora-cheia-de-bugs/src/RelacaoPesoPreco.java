public class RelacaoPesoPreco {

    public static double retornaPrecoProduto(String item, int qtd) {
        double precoTotal = 0;

        if ("pao".equals(item)) {
            precoTotal = (12.75 * 0.06) * qtd;
            ItensPorQuantidade.setPao(ItensPorQuantidade.getPao() - qtd);
        }else if ("torta".equals(item)) {
            precoTotal = qtd * (96.00 / 16);
            ItensPorQuantidade.setTorta(ItensPorQuantidade.getTorta() - qtd);
        }else if ("leite".equals(item)) {
            precoTotal = 4.48 * qtd;
            ItensPorQuantidade.setLeite(ItensPorQuantidade.getLeite() - qtd);
        }else if ("cafe".equals(item)) {
            precoTotal = 9.56 * qtd;
            ItensPorQuantidade.setCafe(ItensPorQuantidade.getCafe() - qtd);
        }else if ("sanduiche".equals(item)) {
            precoTotal = 4.5 * qtd;
            ItensPorQuantidade.setSanduiche(ItensPorQuantidade.getSanduiche() - qtd);
        }

        return precoTotal;
    }
}
