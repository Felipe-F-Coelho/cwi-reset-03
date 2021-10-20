package br.com.cwi.reset.felipecoelho.service;

import br.com.cwi.reset.felipecoelho.FakeDatabase;
import br.com.cwi.reset.felipecoelho.exceptions.ConsultaInvalidaIdException;
import br.com.cwi.reset.felipecoelho.exceptions.MesmoObjetoMaisDeUmaVez;
import br.com.cwi.reset.felipecoelho.exceptions.TipoDominioException;
import br.com.cwi.reset.felipecoelho.model.Ator;
import br.com.cwi.reset.felipecoelho.model.Personagem;
import br.com.cwi.reset.felipecoelho.request.PersonagemRequest;
import br.com.cwi.reset.felipecoelho.validator.BasicInfoRequiredValidatorPersonagem;

import java.util.List;
import java.util.Objects;

public class PersonagemService {

    final private FakeDatabase fakeDatabase;
    private Integer id;

    public PersonagemService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
    }

    // Demais metodos da classe

    public void criarPersonagem(PersonagemRequest personagemRequest) throws Exception {

        final List<Ator> atoresCadastrados = fakeDatabase.recuperaAtores();

        final List<Personagem> personagensCadastrados = fakeDatabase.recuperaPersonagens();

        new BasicInfoRequiredValidatorPersonagem().accept(personagemRequest.getNomePersonagem(),personagemRequest.getDescricaoPersonagem(),personagemRequest.getTipoAtuacao(),personagemRequest.getIdAtor());

        for(Ator atorCadastrado : atoresCadastrados){
            if(!atorCadastrado.getId().equals(personagemRequest.getIdAtor())){
                throw new ConsultaInvalidaIdException(TipoDominioException.PERSONAGEM.getSingular(),personagemRequest.getIdAtor());
            }
        }

        for(Personagem personagemCadastrado : personagensCadastrados){
            if(Objects.equals(personagemCadastrado.getIdAtor(), personagemRequest.getIdAtor()) &&
                    Objects.equals(personagemCadastrado.getNomePersonagem(), personagemRequest.getNomePersonagem())){
                throw new MesmoObjetoMaisDeUmaVez(TipoDominioException.ATOR.getSingular(),TipoDominioException.PERSONAGEM.getSingular());
            }
        }
        this.id = this.fakeDatabase.solicitarID();
        final Personagem newPersonagem = new Personagem(id,personagemRequest.getIdAtor(),personagemRequest.getNomePersonagem(),personagemRequest.getDescricaoPersonagem(),personagemRequest.getTipoAtuacao());
        fakeDatabase.persistePersonagem(newPersonagem);
    }
}
