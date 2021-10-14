package br.com.cwi.reset.felipecoelho;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class Aplicacao {

    public static void main(String[] args) throws CampoObrigatorioException {
        FakeDatabase fakeDatabase = new FakeDatabase();

        AtorService atorService = new AtorService(fakeDatabase);

        String nome = "Will Smith";
        LocalDate dataNascimento = LocalDate.of(1968, Month.SEPTEMBER, 25);
        StatusCarreira statusCarreira = StatusCarreira.EM_ATIVIDADE;
        Integer anoInicioAtividade = 1986;
        AtorRequest atorRequest = new AtorRequest(nome, dataNascimento, statusCarreira, anoInicioAtividade);

        atorService.criarAtor(atorRequest);

        nome = "Felipe Coelho";
        dataNascimento = LocalDate.of(1993, Month.SEPTEMBER, 29);
        statusCarreira = StatusCarreira.EM_ATIVIDADE;
        anoInicioAtividade = 2002;
        AtorRequest atorRequest1 = new AtorRequest(nome, dataNascimento, statusCarreira, anoInicioAtividade);

        atorService.criarAtor(atorRequest1);

        List<Ator> atores = fakeDatabase.recuperaAtores();

        System.out.println("");
        System.out.println("Aqui Começa Os Testes Atores:");
        System.out.println("");

        System.out.println("Deve conter 1 ator, quantidade encontrada: " + atores.size());
        System.out.println("Primeiro ator deve ser 'Will Smith', valor encontrado: " + atores.get(0).getNome());

        System.out.println("Deve filtrar ator cadastrado (filtro: Fel): " + atorService.listarAtoresEmAtividade("Fel").get(0).getNome());

        System.out.println("Deve consultar o ator pelo id(2): " + atorService.consultarAtor(2).getNome());

        System.out.println("Deve consultar todos os atores (consulta 0 na data de nascimento): " + atorService.consultarAtores().get(0).getDataDeNascimento());

        System.out.println("");
        System.out.println("Aqui Começa Os Testes Diretor:");
        System.out.println("");


        DiretorService diretorService = new DiretorService(fakeDatabase);

        nome = "Alfred Hitchcock";
        dataNascimento = LocalDate.of(1899, Month.AUGUST, 13);
        anoInicioAtividade = 1921;
        DiretorRequest diretorRequest = new DiretorRequest(nome, dataNascimento, anoInicioAtividade);

        diretorService.criarDiretor(diretorRequest);

        List<Diretor> diretores = fakeDatabase.recuperaDiretores();

        System.out.println("Deve conter 1 Diretor, quantidade encontrada: " + diretores.size());
        System.out.println("Primeiro Diretor deve ser 'Alfred Hitchcock', valor encontrado: " + diretores.get(0).getNome());

        System.out.println("Imprime o primeiro diretor da função listarDiretores: " + diretorService.listarDiretores().get(0).getNome());
//
        System.out.println("Este valor irá retornar a consulta do Diretor id 3: " + diretorService.consultarDiretor(3).getNome());

    }
}