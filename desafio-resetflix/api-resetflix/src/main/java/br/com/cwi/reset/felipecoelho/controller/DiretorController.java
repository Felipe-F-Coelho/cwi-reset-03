package br.com.cwi.reset.felipecoelho.controller;

import br.com.cwi.reset.felipecoelho.model.Diretor;
import br.com.cwi.reset.felipecoelho.request.DiretorRequest;
import br.com.cwi.reset.felipecoelho.service.DiretorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/diretores")
public class DiretorController {

    @Autowired
    private DiretorService diretorService;

    //demais metodos

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrarDiretor(@RequestBody @Valid DiretorRequest diretorRequest) throws Exception {

        this.diretorService.criarDiretor(diretorRequest);
    }

    @PutMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void atualizarDiretor(@PathVariable @NotNull(message = "Campo obrigatório não informado. Favor informar campo ID") Integer id,@RequestBody @Valid DiretorRequest diretorRequest) throws Exception {
        diretorService.atualizarDiretor(id,diretorRequest);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void removerDiretores(@PathVariable @NotNull(message = "Campo obrigatório não informado. Favor informar campo ID") Integer id) throws Exception {
        diretorService.removerDiretor(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
        public List<Diretor> listarDiretores(@RequestParam(value = "filtro",required = false) String filtro) throws Exception {

        if(filtro != null){
            return diretorService.listarDiretores(filtro);
        }else {
            return diretorService.listarDiretores();
        }
    }

    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Diretor> consultarDiretor(@NotNull(message = "Campo obrigatório não informado. Favor informar campo ID") @PathVariable Integer id) throws Exception {
        return diretorService.consultarDiretor(id);
    }
}


