public class ReposicaoCozinha {

    static void reporItem(String item) {
        if ("paes".equals(item)) {
            ItensPorQuantidade.setPao(ItensPorQuantidade.getPao() + 3600);
        }else if ("torta".equals(item)) {
            ItensPorQuantidade.setTorta(ItensPorQuantidade.getTorta() + (4 * 16));
        }else if ("sanduiche".equals(item)) {
            ItensPorQuantidade.setSanduiche(ItensPorQuantidade.getSanduiche() + 20);
        }
    }
}
