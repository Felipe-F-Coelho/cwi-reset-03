package br.com.cwi.reset.felipecoelho.controller;

import br.com.cwi.reset.felipecoelho.FakeDatabase;
import br.com.cwi.reset.felipecoelho.model.Diretor;
import br.com.cwi.reset.felipecoelho.request.DiretorRequest;
import br.com.cwi.reset.felipecoelho.service.AtorService;
import br.com.cwi.reset.felipecoelho.service.DiretorService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/diretores")
public class DiretorController {

    private DiretorService diretorService;

    public DiretorController() {
        this.diretorService = new DiretorService(FakeDatabase.getInstance());
    }

    //demais metodos

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrarDiretor(@RequestBody DiretorRequest diretorRequest){

        this.diretorService.criarDiretor(diretorRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Diretor> listarDiretores(){
        return diretorService.listarDiretores();
    }

    @GetMapping(value = "/{filtroNome}")
    @ResponseStatus(HttpStatus.OK)
        public List<Diretor> listarDiretores(String filtroNome){
        return diretorService.listarDiretores(filtroNome);
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Diretor consultarDiretor(@RequestParam(value = "id") @PathVariable Integer id){
        return diretorService.consultarDiretor(id);
    }
}


