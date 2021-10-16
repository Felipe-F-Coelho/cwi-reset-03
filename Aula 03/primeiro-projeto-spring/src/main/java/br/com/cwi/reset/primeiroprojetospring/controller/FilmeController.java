package br.com.cwi.reset.primeiroprojetospring.controller;


import br.com.cwi.reset.primeiroprojetospring.domain.Filme;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/filme")
public class FilmeController {


    List<Filme> filmes = new ArrayList<>();

    private Filme selecionarNomeFilme(String nome){
        for(Filme i : filmes){
            if(i.getNome().equals(nome)){
                return i;
            }
        }
        return null;
    }

    @PostMapping
    public ResponseEntity<Filme> postFilme(@RequestBody Filme filme){


        if(selecionarNomeFilme(filme.getNome()) == null){
            filmes.add(filme);
            return ResponseEntity.ok(filme);
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public List<Filme> getAllFilme(){
        return filmes;
    }

    @GetMapping("/{nome}")
    public Filme getConsultarNomeFilme(@PathVariable String nome){
        return selecionarNomeFilme(nome);
    }


    @DeleteMapping("/{nome}")
    public void deleteFilme(@PathVariable String nome){
        Filme filmeBuscado = selecionarNomeFilme(nome);

        filmes.remove(filmeBuscado);
    }

    @PutMapping
    public Filme putFilme(@RequestBody Filme filme){
        Filme filmeCadastrado = selecionarNomeFilme(filme.getNome());

        if(filmeCadastrado != null){
            filmes.remove(filmeCadastrado);
            filmes.add(filme);
            return filme;
        }
        return null;
    }
}


