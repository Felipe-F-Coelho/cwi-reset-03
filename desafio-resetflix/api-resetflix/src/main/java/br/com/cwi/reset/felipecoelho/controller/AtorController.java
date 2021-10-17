package br.com.cwi.reset.felipecoelho.controller;

import br.com.cwi.reset.felipecoelho.AtorService;
import br.com.cwi.reset.felipecoelho.FakeDatabase;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/atores")
public class AtorController {

    private AtorService atorService;

    public AtorController() {
        this.atorService = new AtorService(FakeDatabase.getInstance());
    }

    //demais métodos
}