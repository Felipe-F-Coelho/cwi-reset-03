package br.com.cwi.reset.felipecoelho.service;

import br.com.cwi.reset.felipecoelho.FakeDatabase;
import br.com.cwi.reset.felipecoelho.exceptions.ConsultaInvalidaIdException;
import br.com.cwi.reset.felipecoelho.exceptions.MesmoObjetoMaisDeUmaVezGenero;
import br.com.cwi.reset.felipecoelho.exceptions.TipoDominioException;
import br.com.cwi.reset.felipecoelho.model.Diretor;
import br.com.cwi.reset.felipecoelho.model.Estudio;
import br.com.cwi.reset.felipecoelho.model.Filme;
import br.com.cwi.reset.felipecoelho.model.Genero;
import br.com.cwi.reset.felipecoelho.request.FilmeRequest;
import br.com.cwi.reset.felipecoelho.request.PersonagemRequest;
import br.com.cwi.reset.felipecoelho.validator.BasicInfoRequiredValidatorFilme;

import java.util.List;


public class FilmeService {

    final private FakeDatabase fakeDatabase;
    final private PersonagemService personagemService;
    private Integer id;

    public FilmeService(FakeDatabase fakeDatabase) {
        this.personagemService = new PersonagemService(FakeDatabase.getInstance());
        this.fakeDatabase = fakeDatabase;
    }

    public Integer getId() {
        return id;
    }

    // Demais metodos da classe

    public void criarFilme(FilmeRequest filmeRequest) throws Exception {

        List<Estudio> listaEstudios = fakeDatabase.recuperaEstudios();

        List<Diretor> listaDiretores = fakeDatabase.recuperaDiretores();

        List<Genero> validadorGenero = filmeRequest.getGeneros();

        new BasicInfoRequiredValidatorFilme().accept(filmeRequest.getNome(), filmeRequest.getAnoLancamento(),filmeRequest.getCapaFilme(),filmeRequest.getGeneros(), filmeRequest.getIdDiretor(), filmeRequest.getIdEstudio(), filmeRequest.getResumo());

        for(Estudio estudio : listaEstudios){
            if(!estudio.getId().equals(filmeRequest.getIdEstudio())){
                throw new ConsultaInvalidaIdException(TipoDominioException.ESTUDIO.getSingular(),filmeRequest.getIdEstudio());
            }
        }

        for(Diretor diretor : listaDiretores){
            if(!diretor.getId().equals(filmeRequest.getIdDiretor())){
                throw new ConsultaInvalidaIdException(TipoDominioException.DIRETOR.getSingular(),filmeRequest.getIdDiretor());
            }
        }

        for(int i = 0; i < validadorGenero.size(); i++ ){
            Genero cap1 = validadorGenero.get(i);
            for(int j = 1 + i; j < validadorGenero.size(); j++){
                Genero cap2 = validadorGenero.get(j);
                if(cap1 == cap2){
                    throw new MesmoObjetoMaisDeUmaVezGenero();
                }
            }
        }

        for(PersonagemRequest personagemRequest : filmeRequest.getPersonagens()){
            personagemService.criarPersonagem(personagemRequest);
        }

        this.id = this.fakeDatabase.solicitarID();
        final Filme newFilme = new Filme(id,filmeRequest.getNome(),filmeRequest.getAnoLancamento(),filmeRequest.getCapaFilme(),filmeRequest.getGeneros(),
                filmeRequest.getIdDiretor(),filmeRequest.getIdEstudio(),filmeRequest.getResumo(),filmeRequest.getPersonagens());
        fakeDatabase.persisteFilme(newFilme);

    }

}
