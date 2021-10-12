package br.com.cwi.reset.felipecoelho;

import java.time.LocalDate;

public class AtorService {

    private FakeDatabase fakeDatabase;
    private Integer id;
    private static Integer idSequencia = 0;

    public AtorService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
    }

    // Demais métodos da classe

    public void criarAtor(AtorRequest atorRequest) throws CampoObrigatorioException{
        this.id = idSequencia++;
        Ator newAtor = new Ator(this.id, atorRequest.getNome(), atorRequest.getDataNascimento(),atorRequest.getStatusCarreira(),atorRequest.getAnoInicioAtividade());
        fakeDatabase.persisteAtor(newAtor);

    }
}