package br.com.cwi.reset.projeto1.controller;


import br.com.cwi.reset.projeto1.domain.Ator;
import br.com.cwi.reset.projeto1.exception.AtorNãoExisteException;
import br.com.cwi.reset.projeto1.service.AtorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/ator")
public class AtorController {

    @Autowired
    private AtorService atorService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Ator criarAtor(@RequestBody Ator ator){
        return atorService.criarAtor(ator);
    }

    @GetMapping(path = "/{nome}")
    @ResponseStatus(HttpStatus.OK)
    public Ator filtroNome(@PathVariable String nome) throws AtorNãoExisteException {
        return atorService.filterName(nome);
    }

    @GetMapping(path = "/filtrarOscar/{quantOscar}")
    @ResponseStatus(HttpStatus.OK)
    public List<Ator> filtroOscar(@PathVariable Integer quantOscar) throws AtorNãoExisteException {
        return atorService.filterOscar(quantOscar);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public Ator deletarAtor(@RequestBody Ator ator) throws AtorNãoExisteException {
        return atorService.deletarAtor(ator);
    }

    @GetMapping(path = "/oscar_anoNascimento")
    @ResponseStatus(HttpStatus.OK)
    public List<Ator> filtroOscarAnoNascimento(@RequestParam Integer oscar, Integer anoNascimento) throws AtorNãoExisteException {
        return atorService.filterOscarAndNascimento(oscar,anoNascimento);
    }
}
