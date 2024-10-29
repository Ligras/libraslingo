package com.ifsp.bra.libraslingo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ifsp.bra.libraslingo.model.Jogador;

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

 
    @GetMapping
    public List<Jogador> getAllJogadores() {
        return jogadores;
    }


    @GetMapping("/{id}")
    public Jogador getJogadorById(@PathVariable long id) {
        return jogadores.stream()
                .filter(jogador -> jogador.getId() == id)
                .findFirst()
                .orElse(null);
    }


    @PostMapping
    public Jogador addJogador(@RequestBody Jogador jogador) {
        jogador.setId(ID++);
        jogadores.add(jogador);
        return jogador;
    }


    @PutMapping("/{id}")
    public Jogador updateJogador(@PathVariable long id, @RequestBody Jogador jogadorAtualizado) {
        for (Jogador jogador : jogadores) {
            if (jogador.getId() == id) {
                jogador.setNome(jogadorAtualizado.getNome());
                jogador.setSenha(jogadorAtualizado.getSenha());
                return jogador;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public String deleteJogador(@PathVariable long id) {
        boolean removed = jogadores.removeIf(jogador -> jogador.getId() == id);
        return removed ? "Jogador removido com sucesso." : "Jogador não encontrado.";
    }
}
