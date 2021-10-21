package br.com.cwi.reset.felipecoelho.controller;

import br.com.cwi.reset.felipecoelho.FakeDatabase;
import br.com.cwi.reset.felipecoelho.exceptions.FiltroFilmeNaoEncontradoException;
import br.com.cwi.reset.felipecoelho.exceptions.FiltroNaoEncontradoException;
import br.com.cwi.reset.felipecoelho.exceptions.ListaConsultaVaziaExceptions;
import br.com.cwi.reset.felipecoelho.exceptions.TipoDominioException;
import br.com.cwi.reset.felipecoelho.model.Filme;
import br.com.cwi.reset.felipecoelho.request.FilmeRequest;
import br.com.cwi.reset.felipecoelho.service.FilmeService;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    final private FilmeService filmeService;

    public FilmeController(){
        this.filmeService = new FilmeService(FakeDatabase.getInstance());
    }

    //Demais metodos

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarFilme(@RequestBody FilmeRequest filmeRequest) throws Exception {
        filmeService.criarFilme(filmeRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Filme> consultarFilmes(@RequestParam(value = "nomeFilme",required = false)@PathVariable String nomeFilme,
                                       @RequestParam(value = "nomeDiretor",required = false)@PathVariable String nomeDiretor,
                                       @RequestParam(value = "nomePersonagem",required = false)@PathVariable String nomePersonagem,
                                       @RequestParam(value = "nomeAtor",required = false)@PathVariable String nomeAtor) throws Exception {

        return filmeService.consultarFilmes(nomeFilme, nomeDiretor, nomePersonagem, nomeAtor);
    }
}
