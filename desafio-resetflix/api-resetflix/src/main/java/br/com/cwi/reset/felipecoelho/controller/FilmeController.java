package br.com.cwi.reset.felipecoelho.controller;

import br.com.cwi.reset.felipecoelho.model.Filme;
import br.com.cwi.reset.felipecoelho.request.FilmeRequest;
import br.com.cwi.reset.felipecoelho.service.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    @Autowired
    private FilmeService filmeService;

    //Demais metodos

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarFilme(@RequestBody FilmeRequest filmeRequest) throws Exception {
        filmeService.criarFilme(filmeRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Filme> consultarFilmes(@RequestParam(value = "nomeFilme",required = false) String nomeFilme,
                                       @RequestParam(value = "nomeDiretor",required = false) String nomeDiretor,
                                       @RequestParam(value = "nomePersonagem",required = false) String nomePersonagem,
                                       @RequestParam(value = "nomeAtor",required = false) String nomeAtor) throws Exception {

        return filmeService.consultarFilmes(nomeFilme, nomeDiretor, nomePersonagem, nomeAtor);
    }
}
