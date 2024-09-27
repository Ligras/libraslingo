package com.ifsp.bra.libraslingo.controllers;

import org.springframework.web.bind.annotation.*;

import com.ifsp.bra.libraslingo.model.Jogador;

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
    @GetMapping
    public List<Jogador> listarJogadores() {
        return jogadores;
    }

    //GET
    @GetMapping("/{id}")
    public Jogador obterJogador(@PathVariable Long id) {
        for (Jogador jogador : jogadores) {
            if (jogador.getId().equals(id)) {
                return jogador;
            }
        }
        return null;
    }
    
    //POST
    @PostMapping("/criarJogador")
    public Jogador criarJogador(@RequestBody Jogador jogador) {
        jogador.setId(ID++);
        jogadores.add(jogador);
        return jogador;
    }

    //PUT
    @PutMapping("/atualizar/{id}")
    public Jogador atualizarJogador(@PathVariable Long id, @RequestBody Jogador jogador) {
        for (int i = 0; i < jogadores.size(); i++) {
            if (jogadores.get(i).getId().equals(id)) {
                jogadores.get(i).setNome(jogador.getNome());
                jogadores.get(i).setSenha(jogador.getSenha());
                return jogadores.get(i);
            }
        }
        return null;
    }
    

    //DELETE
    @DeleteMapping("remover/{id}")
    public String deletarJogador(@PathVariable Long id) {
        boolean jogadorRemovido = jogadores.removeIf(jogador -> jogador.getId().equals(id));
        
        if (jogadorRemovido) {
            return "O jogador foi removido com sucesso.";
        } else {
            return "Não foi possível encontrar um jogador com este id.";
        }
    }
    







}

