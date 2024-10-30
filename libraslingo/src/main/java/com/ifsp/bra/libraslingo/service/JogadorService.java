package com.ifsp.bra.libraslingo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifsp.bra.libraslingo.model.Jogador;
import com.ifsp.bra.libraslingo.repository.JogadorRepository;

@Service
public class JogadorService {

    @Autowired
    private JogadorRepository jogadorRepository;

    // Método para listar todos os jogadores
    public List<Jogador> listarTodos() {
        return jogadorRepository.findAll();
    }

    // Método para buscar um jogador por ID
    public Jogador buscarPorId(Long id) {
        Optional<Jogador> jogador = jogadorRepository.findById(id);
        return jogador.orElse(null);
    }

    // Método para salvar um novo jogador
    public Jogador salvar(Jogador jogador) {
        return jogadorRepository.save(jogador);
    }

    // Método para atualizar um jogador existente
    public Jogador atualizar(Long id, Jogador jogadorAtualizado) {
        if (jogadorRepository.existsById(id)) {
            jogadorAtualizado.setId(id);
            return jogadorRepository.save(jogadorAtualizado);
        }
        return null;
    }

    // Método para deletar um jogador
    public void deletar(Long id) {
        if (jogadorRepository.existsById(id)) {
            jogadorRepository.deleteById(id);
        }
    }

    // Método para chamar o método jogar do jogador
    public void jogar(Long id) {
        Optional<Jogador> jogador = jogadorRepository.findById(id);
        if (jogador.isPresent()) {
            jogador.get().jogar(); // Chama o método jogar() na instância do jogador
            // Se você quiser atualizar a pontuação no banco após jogar, você pode salvar novamente:
            jogadorRepository.save(jogador.get());
        } else {
            System.out.println("Jogador não encontrado com o ID: " + id);
        }
    }
}
