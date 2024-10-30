package com.ifsp.bra.libraslingo.repository;

import org.springframework.data.jpa.repository.JpaRepository; // Certifique-se de que o pacote da classe Administrador está correto
import org.springframework.stereotype.Repository;

import com.ifsp.bra.libraslingo.model.Administrador;

@Repository
public interface AdministradorRepository extends JpaRepository<Administrador, Long> {
    // Aqui você pode adicionar métodos personalizados se necessário
}
