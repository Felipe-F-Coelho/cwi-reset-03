package br.com.cwi.reset.felipecoelho.controller;

import br.com.cwi.reset.felipecoelho.model.Ator;
import br.com.cwi.reset.felipecoelho.response.AtorEmAtividade;
import br.com.cwi.reset.felipecoelho.request.AtorRequest;
import br.com.cwi.reset.felipecoelho.service.AtorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/atores")
public class AtorController {

    @Autowired
    private AtorService atorService;

    //demais métodos

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarAtor(@RequestBody @Valid AtorRequest atorRequest) throws Exception {
        this.atorService.criarAtor(atorRequest);
    }


    @GetMapping(path = "/filtro_atores")
    @ResponseStatus(HttpStatus.OK)
    public List<AtorEmAtividade> listarAtoresEmAtividade(@RequestParam (value = "filtro",required = false) String filtro) throws Exception {
        return atorService.listarAtoresEmAtividade(filtro);
    }

    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Ator> consultarAtor(@NotNull(message = "Campo obrigatório não informado. Favor informar campo ID") @PathVariable Integer id) throws Exception {
        return atorService.consultarAtor(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Ator> consultarAtores() throws Exception {
        return atorService.consultarAtores();
    }


}