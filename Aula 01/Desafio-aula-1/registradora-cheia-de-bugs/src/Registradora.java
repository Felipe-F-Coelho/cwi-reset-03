
public class Registradora {

    public static void main(String[] args) {
//        primeiroBug();

//        segundoBug();

//        terceiroBug();

//        quartoBug();

//        quintoBug();

//        sextoBug();
    }

    private static double registrarItem(String item, int quantidade) {

        QuantidadeMinimaItem.verificacaoQuantidade(item,quantidade);

        if (QuantidadeMinimaItem.quantidadeSelecionada < quantidade) {
            if ("pao".equals(item) || "sanduiche".equals(item) || "torta".equals(item)) {
                if (!DataProjeto.cozinhaEmFuncionamento() && QuantidadeMinimaItem.verificacaoQuantidade(item,quantidade)) {
                    System.out.println("Cozinha fechada!");
                    System.out.println("Reposição indisponível de " + item +" quantidade restante em estoque é de " + QuantidadeMinimaItem.quantidadeSelecionada);
                }else if(QuantidadeMinimaItem.precisaReposicao(item, quantidade)){
                    ReposicaoCozinha.reporItem(item);
                }
            }else if(("leite".equals(item) || "cafe".equals(item)) && QuantidadeMinimaItem.precisaReposicao(item, quantidade)) {
                    ReposicaoFornecedor.reporItem(item);
            }
        }

        double precoItem = RelacaoPesoPreco.retornaPrecoProduto(item, quantidade);

        return precoItem;
    }

    private static void primeiroBug() {
        DataProjeto.criarDataComCozinhaFuncionando();
        String item = "sanduiche";
        int quantidade = 4;

        double precoTotal = registrarItem(item, quantidade);

        System.out.println(String.format("Valor total: %.2f", precoTotal));
    }

    private static void segundoBug() {
        DataProjeto.criarDataComCozinhaEncerradaMasComDiaUtil();
        String item = "torta";
        int quantidade = 10;

        double precoTotal = registrarItem(item, quantidade);

        System.out.println(String.format("Valor total: %.2f", precoTotal));
    }

    private static void terceiroBug() {
        DataProjeto.criarDataComCozinhaFuncionando();
        String item = "cafe";
        int quantidade = 40;

        double precoTotal = registrarItem(item, quantidade);

        System.out.println(String.format("Valor total: %.2f", precoTotal));
    }

    private static void quartoBug() {
        DataProjeto.criarDataComCozinhaFuncionando();
        // Cliente 1
        String item = "sanduiche";
        int quantidade = 20;

        double precoTotal = registrarItem(item, quantidade);

        System.out.println(String.format("Valor total: %.2f", precoTotal));

        // Cliente 2
        String item2 = "sanduiche";
        int quantidade2 = 5;

        double precoTotal2 = registrarItem(item2, quantidade2);

        System.out.println(String.format("Valor total: %.2f", precoTotal2));
    }

    private static void quintoBug() {
        DataProjeto.criarDataComCozinhaFuncionando();
        String item = "pao";
        int quantidade = 10;

        double precoTotal = registrarItem(item, quantidade);

        System.out.println(String.format("Valor total: %.2f", precoTotal));
    }

    private static void sextoBug() {
        DataProjeto.criarDataComCozinhaEncerradaSemDiaUtil();
        // Cliente 1
        String item = "sanduiche";
        int quantidade = 20;

        double precoTotal = registrarItem(item, quantidade);

        System.out.println(String.format("Valor total: %.2f", precoTotal));

        // Cliente 2
        String item2 = "sanduiche";
        int quantidade2 = 5;

        double precoTotal2 = registrarItem(item2, quantidade2);

        System.out.println(String.format("Valor total: %.2f", precoTotal2));
    }

}
