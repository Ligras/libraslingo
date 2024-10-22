package com.ifsp.bra.libraslingo.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ifsp.bra.libraslingo.model.Jogador;

@Service
public class JogadorService {

    // Simulando um banco de dados com um mapa
    private static Map<Long, Jogador> jogadores = new HashMap<>();

    static {
        jogadores.put(0L, new Jogador(0L, "jogador0", "1234"));
        jogadores.put(1L, new Jogador(1L, "jogador1", "5678"));
        jogadores.put(2L, new Jogador(2L, "jogador2", "4321"));
    }

    public Jogador getJogadorById(Long id) {
        return jogadores.get(id);
    }
}
