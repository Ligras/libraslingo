package com.ifsp.bra.libraslingo.controllers;

import com.ifsp.bra.libraslingo.model.Jogador;
import com.ifsp.bra.libraslingo.service.JogadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jogadores")
public class JogadorController {

    @Autowired
    private JogadorService jogadorService;

    // Endpoint para listar todos os jogadores
    @GetMapping
    public ResponseEntity<List<Jogador>> listarJogadores() {
        List<Jogador> jogadores = jogadorService.listarTodos();
        return ResponseEntity.ok(jogadores);
    }

    // Endpoint para buscar um jogador por ID
    @GetMapping("/{id}")
    public ResponseEntity<Jogador> buscarJogador(@PathVariable Long id) {
        Jogador jogador = jogadorService.buscarPorId(id);
        return jogador != null ? ResponseEntity.ok(jogador) : ResponseEntity.notFound().build();
    }

    // Endpoint para criar um novo jogador
    @PostMapping
    public ResponseEntity<Jogador> criarJogador(@RequestBody Jogador jogador) {
        Jogador novoJogador = jogadorService.salvar(jogador);
        return ResponseEntity.ok(novoJogador);
    }

    // Endpoint para atualizar um jogador
    @PutMapping("/{id}")
    public ResponseEntity<Jogador> atualizarJogador(@PathVariable Long id, @RequestBody Jogador jogadorAtualizado) {
        Jogador jogador = jogadorService.atualizar(id, jogadorAtualizado);
        return jogador != null ? ResponseEntity.ok(jogador) : ResponseEntity.notFound().build();
    }

    // Endpoint para deletar um jogador
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarJogador(@PathVariable Long id) {
        jogadorService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    // Endpoint para jogar (chamar o método jogar)
    @PutMapping("/{id}/jogar")
    public ResponseEntity<Void> jogar(@PathVariable Long id) {
        jogadorService.jogar(id);
        return ResponseEntity.ok().build();
    }
}
