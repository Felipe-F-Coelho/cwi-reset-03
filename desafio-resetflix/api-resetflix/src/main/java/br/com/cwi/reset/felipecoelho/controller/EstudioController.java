package br.com.cwi.reset.felipecoelho.controller;

import br.com.cwi.reset.felipecoelho.model.Estudio;
import br.com.cwi.reset.felipecoelho.request.EstudioRequest;
import br.com.cwi.reset.felipecoelho.service.EstudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/estudios")
public class EstudioController {

    @Autowired
    private EstudioService estudioService;

    //Metodos da classe

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarEstudio(@RequestBody EstudioRequest estudioRequest) throws Exception {
        estudioService.criarEstudio(estudioRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Estudio> consultarEstudios(@RequestParam(value = "filtro",required = false) String filtro) throws Exception {

        if(filtro != null){
            return estudioService.consultarEstudios(filtro);
        }else{
            return estudioService.consultarEstudios();
        }
    }

    @GetMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public Optional<Estudio> consultarEstudio(@NotNull(message = "Campo obrigatório não informado. Favor informar campo ID") @PathVariable Integer id) throws Exception {

        return estudioService.consultarEstudio(id);
    }

}
