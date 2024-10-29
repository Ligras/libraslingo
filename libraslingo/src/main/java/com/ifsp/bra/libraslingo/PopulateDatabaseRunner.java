package com.ifsp.bra.libraslingo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ifsp.bra.libraslingo.model.Jogador;
import com.ifsp.bra.libraslingo.repository.JogadorRepository;

@Component
public class PopulateDatabaseRunner implements CommandLineRunner {

    private final JogadorRepository jogadorRepository;

    public PopulateDatabaseRunner(JogadorRepository jogadorRepository) {
        this.jogadorRepository = jogadorRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if (jogadorRepository.count() == 0) {

            jogadorRepository.save(new Jogador(null, "jogador1", "senha123"));
            jogadorRepository.save(new Jogador(null, "jogador2", "senha456"));
            jogadorRepository.save(new Jogador(null, "jogador3", "senha789"));
            jogadorRepository.save(new Jogador(null, "jogador4", "senha321"));
            System.out.println("Banco de dados populado com dados iniciais de jogadores.");
        } else {
            System.out.println("Banco de dados já possui dados de jogadores. Nenhuma alteração foi feita.");
        }
    }
}
