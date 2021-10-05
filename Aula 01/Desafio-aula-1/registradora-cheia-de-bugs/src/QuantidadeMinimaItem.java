public class QuantidadeMinimaItem {

    public static boolean precisaReposicao(String item) {
        if ("paes".equals(item)) {
            return ItensPorQuantidade.pao < 600;
        }else if ("torta".equals(item)) {
            return ItensPorQuantidade.torta < 10;
        }else if ("sanduiche".equals(item)) {
            return ItensPorQuantidade.sanduiche <= 1;
        }else if ("cafe".equals(item)) {
            return ItensPorQuantidade.cafe < 12;
        }else if ("leite".equals(item)) {
            return ItensPorQuantidade.leite < 12;
        }

        return false;
    }
}
