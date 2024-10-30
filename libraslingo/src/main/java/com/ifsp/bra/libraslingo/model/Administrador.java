package com.ifsp.bra.libraslingo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Administrador extends Usuario {


    public Administrador() {
    }


    public void alterarRanking() {
        
    }
}
