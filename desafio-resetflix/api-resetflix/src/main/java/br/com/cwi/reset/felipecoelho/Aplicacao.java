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

        System.out.println("Deve conter 1 ator, quantidade encontrada: " + atores.size());
        System.out.println("Primeiro ator deve ser 'Will Smith', valor encontrado: " + atores.get(0).getNome());

//        System.out.println(atorService.listarAtoresEmAtividade("Felipe").get(0).getNome());

        System.out.println(atorService.consultarAtor(1).getNome());
    }
}