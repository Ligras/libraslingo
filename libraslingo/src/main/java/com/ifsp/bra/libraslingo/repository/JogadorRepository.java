package com.ifsp.bra.libraslingo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ifsp.bra.libraslingo.model.Jogador;

@Repository
public interface JogadorRepository extends JpaRepository<Jogador, Long> {
    
}
