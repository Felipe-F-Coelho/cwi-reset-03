package br.com.cwi.reset.felipecoelho.controller;

import br.com.cwi.reset.felipecoelho.FakeDatabase;
import br.com.cwi.reset.felipecoelho.request.FilmeRequest;
import br.com.cwi.reset.felipecoelho.service.FilmeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
}
