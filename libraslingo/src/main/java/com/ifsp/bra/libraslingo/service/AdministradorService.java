package com.ifsp.bra.libraslingo.service;

import com.ifsp.bra.libraslingo.model.Administrador;
import com.ifsp.bra.libraslingo.repository.AdministradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdministradorService {

    @Autowired
    private AdministradorRepository administradorRepository;

    // Método para listar todos os administradores
    public List<Administrador> listarTodos() {
        return administradorRepository.findAll();
    }

    // Método para buscar um administrador por ID
    public Administrador buscarPorId(Long id) {
        Optional<Administrador> administrador = administradorRepository.findById(id);
        return administrador.orElse(null);
    }

    // Método para salvar um novo administrador
    public Administrador salvar(Administrador administrador) {
        return administradorRepository.save(administrador);
    }

    // Método para atualizar um administrador existente
    public Administrador atualizar(Long id, Administrador administradorAtualizado) {
        if (administradorRepository.existsById(id)) {
            administradorAtualizado.setId(id);
            return administradorRepository.save(administradorAtualizado);
        }
        return null;
    }

    // Método para deletar um administrador
    public void deletar(Long id) {
        if (administradorRepository.existsById(id)) {
            administradorRepository.deleteById(id);
        }
    }

    // Método específico para alterar o ranking
    public void alterarRanking(Long id) {
        // Implementação da lógica para alterar o ranking do administrador
        // Esta é apenas uma estrutura, a lógica real dependerá dos requisitos de negócio
        Optional<Administrador> administrador = administradorRepository.findById(id);
        if (administrador.isPresent()) {
            // Exemplo de lógica para alterar o ranking
            // Adicione aqui a lógica necessária para atualizar o ranking
            System.out.println("Ranking alterado para o administrador com ID: " + id);
        } else {
            System.out.println("Administrador não encontrado com o ID: " + id);
        }
    }
}
