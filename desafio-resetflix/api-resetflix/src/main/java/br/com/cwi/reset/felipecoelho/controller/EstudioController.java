package br.com.cwi.reset.felipecoelho.controller;

import br.com.cwi.reset.felipecoelho.FakeDatabase;
import br.com.cwi.reset.felipecoelho.model.Estudio;
import br.com.cwi.reset.felipecoelho.request.EstudioRequest;
import br.com.cwi.reset.felipecoelho.service.EstudioService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estudios")
public class EstudioController {

    private EstudioService estudioService;

    public EstudioController() {
        this.estudioService = new EstudioService(FakeDatabase.getInstance());
    }

    //Metodos da classe

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarEstudio(@RequestBody EstudioRequest estudioRequest) throws Exception {
        estudioService.criarEstudio(estudioRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Estudio> consultarEstudios(@RequestParam(value = "filtro",required = false)@PathVariable String filtro) throws Exception {

        if(filtro != null){
            return estudioService.consultarEstudios(filtro);
        }else{
            return estudioService.consultarEstudios();
        }
    }


    @GetMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public Estudio consultarEstudio(@PathVariable Integer id) throws Exception {

        return estudioService.consultarEstudio(id);
    }

}
