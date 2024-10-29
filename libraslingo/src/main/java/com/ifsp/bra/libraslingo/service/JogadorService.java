package com.ifsp.bra.libraslingo.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ifsp.bra.libraslingo.model.Jogador;

@Service
public class JogadorService {

    private static Map<Long, Jogador> jogadores = new HashMap<>();
    private static long currentId = 3; 

    static {
        jogadores.put(0L, new Jogador(0L, "jogador0", "1234"));
        jogadores.put(1L, new Jogador(1L, "jogador1", "5678"));
        jogadores.put(2L, new Jogador(2L, "jogador2", "4321"));
    }

   
    public Jogador getJogadorById(Long id) {
        return jogadores.get(id);
    }

   
    public Jogador addJogador(Jogador jogador) {
        jogador.setId(currentId++);
        jogadores.put(jogador.getId(), jogador);
        return jogador;
    }

  
    public Jogador updateJogador(Long id, Jogador jogadorAtualizado) {
        if (jogadores.containsKey(id)) {
            Jogador jogador = jogadores.get(id);
            jogador.setNome(jogadorAtualizado.getNome());
            jogador.setSenha(jogadorAtualizado.getSenha());
            return jogador;
        }
        return null; 
    }

   
    public boolean deleteJogador(Long id) {
        return jogadores.remove(id) != null; 
    }
}
