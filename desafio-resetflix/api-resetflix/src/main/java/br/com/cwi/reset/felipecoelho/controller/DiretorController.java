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
    public void cadastrarDiretor(@RequestBody DiretorRequest diretorRequest) throws Exception {

        this.diretorService.criarDiretor(diretorRequest);
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
        public List<Diretor> listarDiretores(@RequestParam(value = "filtro",required = false)@PathVariable String filtro) throws Exception {

        if(filtro != null){
            return diretorService.listarDiretores(filtro);
        }else {
            return diretorService.listarDiretores();
        }
    }

    @GetMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public Diretor consultarDiretor(@PathVariable Integer id) throws Exception {
        return diretorService.consultarDiretor(id);
    }
}


