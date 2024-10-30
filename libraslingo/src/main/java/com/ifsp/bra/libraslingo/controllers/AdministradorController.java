package com.ifsp.bra.libraslingo.controllers;

import com.ifsp.bra.libraslingo.model.Administrador;
import com.ifsp.bra.libraslingo.service.AdministradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/administradores")
public class AdministradorController {

    @Autowired
    private AdministradorService administradorService;

    // Endpoint para listar todos os administradores
    @GetMapping
    public ResponseEntity<List<Administrador>> listarAdministradores() {
        List<Administrador> administradores = administradorService.listarTodos();
        return ResponseEntity.ok(administradores);
    }

    // Endpoint para buscar um administrador por ID
    @GetMapping("/{id}")
    public ResponseEntity<Administrador> buscarAdministrador(@PathVariable Long id) {
        Administrador administrador = administradorService.buscarPorId(id);
        return administrador != null ? ResponseEntity.ok(administrador) : ResponseEntity.notFound().build();
    }

    // Endpoint para criar um novo administrador
    @PostMapping
    public ResponseEntity<Administrador> criarAdministrador(@RequestBody Administrador administrador) {
        Administrador novoAdministrador = administradorService.salvar(administrador);
        return ResponseEntity.ok(novoAdministrador);
    }

    // Endpoint para atualizar um administrador
    @PutMapping("/{id}")
    public ResponseEntity<Administrador> atualizarAdministrador(@PathVariable Long id, @RequestBody Administrador administradorAtualizado) {
        Administrador administrador = administradorService.atualizar(id, administradorAtualizado);
        return administrador != null ? ResponseEntity.ok(administrador) : ResponseEntity.notFound().build();
    }

    // Endpoint para deletar um administrador
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAdministrador(@PathVariable Long id) {
        administradorService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    // Endpoint específico para alterar o ranking
    @PutMapping("/{id}/alterar-ranking")
    public ResponseEntity<Void> alterarRanking(@PathVariable Long id) {
        administradorService.alterarRanking(id);
        return ResponseEntity.ok().build();
    }
}
