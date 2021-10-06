public class ItensPorQuantidade {

    static int pao = 3600;
    static int torta = 4;
    static int sanduiche = 20;
    static int leite = 20;
    static int cafe = 20;

    public static int getCafe() {
        return cafe;
    }

    public static void setCafe(int cafe) {
        ItensPorQuantidade.cafe = cafe;
    }

    public static int getLeite() {
        return leite;
    }

    public static void setLeite(int leite) {
        ItensPorQuantidade.leite = leite;
    }

    public static int getSanduiche() {
        return sanduiche;
    }

    public static void setSanduiche(int sanduiche) {
        ItensPorQuantidade.sanduiche = sanduiche;
    }

    public static int getTorta() {
        return torta;
    }

    public static void setTorta(int torta) {
        ItensPorQuantidade.torta = torta;
    }

    public static int getPao() {
        return pao;
    }

    public static void setPao(int pao) {
        ItensPorQuantidade.pao = pao;
    }

    static int quantidadeSelecionada = 0;

    public static boolean verificacaoQuantidade(String item, int quantidade) {
        boolean verificacao = false;
        if ("paes".equals(item) && quantidade > getPao()) {
            verificacao = true;
            quantidadeSelecionada = getPao();
        } else if ("torta".equals(item) && quantidade > getTorta()) {
            verificacao = true;
            quantidadeSelecionada = getTorta();
        } else if ("sanduiche".equals(item) && quantidade > getSanduiche()) {
            verificacao = true;
            quantidadeSelecionada = getSanduiche();
        } else if ("leite".equals(item) && quantidade > getLeite()) {
            verificacao = true;
            quantidadeSelecionada = getLeite();
        } else if ("cafe".equals(item) && quantidade > getCafe()) {
            verificacao = true;
            quantidadeSelecionada = getCafe();
        }
        return verificacao;
    }
}
