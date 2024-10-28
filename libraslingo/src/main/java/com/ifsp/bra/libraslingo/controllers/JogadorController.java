package com.ifsp.bra.libraslingo.controllers;

import org.springframework.web.bind.annotation.*;

import com.ifsp.bra.libraslingo.model.Jogador;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/jogadores")

public class JogadorController {
    private List<Jogador> jogadores = new ArrayList<>();
    private long ID = 0;

    public JogadorController(){
        jogadores.add(new Jogador(ID++, "Jogador0", "1234"));
        jogadores.add(new Jogador(ID++, "Jogador1", "5678"));
        jogadores.add(new Jogador(ID++, "Jogador2", "4321"));

        
    }

    //GET sem id

    //GET

    //POST
    @PostMapping("/criarjogador")
    public ResponseEntity<Jogador> criarJogador(@RequestBody Jogador novoJogador) {
        novoJogador.setId(ID++); 
        jogadores.add(novoJogador); 
        return new ResponseEntity<>(novoJogador, HttpStatus.CREATED); 
    }

    //PUT

    //DELETE
}

