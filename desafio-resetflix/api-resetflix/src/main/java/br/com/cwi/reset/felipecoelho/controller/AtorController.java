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

    final private AtorService atorService;

    public AtorController() {
        this.atorService = new AtorService(FakeDatabase.getInstance());
    }

    //demais métodos

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarAtor(@RequestBody AtorRequest atorRequest) throws Exception {
        this.atorService.criarAtor(atorRequest);
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AtorEmAtividade> listarAtoresEmAtividade(@RequestParam(value = "filtro",required = false) @PathVariable String filtro) throws Exception {

        if (filtro != null) {
            return atorService.listarAtoresEmAtividade(filtro);
        }else{
            return atorService.listarAtoresEmAtividade();
        }
    }

    @GetMapping(value = {"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public Ator consultarAtor(@PathVariable Integer id) throws Exception {

        return atorService.consultarAtor(id);
    }

    @RequestMapping(value = "/{consultarAtores}")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Ator> consultarAtores() throws Exception {
        return atorService.consultarAtores();
    }


}