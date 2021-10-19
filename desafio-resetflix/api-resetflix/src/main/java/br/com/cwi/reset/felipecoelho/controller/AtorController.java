package br.com.cwi.reset.felipecoelho.controller;

import br.com.cwi.reset.felipecoelho.model.Ator;
import br.com.cwi.reset.felipecoelho.response.AtorEmAtividade;
import br.com.cwi.reset.felipecoelho.request.AtorRequest;
import br.com.cwi.reset.felipecoelho.service.AtorService;
import br.com.cwi.reset.felipecoelho.FakeDatabase;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/atores")
public class AtorController {

    private AtorService atorService;

    public AtorController() {
        this.atorService = new AtorService(FakeDatabase.getInstance());
    }

    //demais métodos

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarAtor(@RequestBody AtorRequest atorRequest){
        this.atorService.criarAtor(atorRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AtorEmAtividade> listarAtoresEmAtividade(){

        return atorService.listarAtoresEmAtividade();
    }

    @GetMapping(value = "/{ator}")
    @ResponseStatus(HttpStatus.OK)
    public List<AtorEmAtividade> listarAtoresEmAtividade(@RequestParam(value = "ator",required = false) @PathVariable String ator){

        return atorService.listarAtoresEmAtividade(ator);
    }

    @GetMapping(value = {"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public Ator consultarAtor(@RequestParam(value = "id") @PathVariable Integer id){

        return atorService.consultarAtor(id);
    }

    @RequestMapping(value = "/{consultarAtores}")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Ator> consultarAtores(){
        return atorService.consultarAtores();
    }


}