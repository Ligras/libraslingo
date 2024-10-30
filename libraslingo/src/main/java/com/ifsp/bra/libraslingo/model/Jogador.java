package com.ifsp.bra.libraslingo.model;

import jakarta.persistence.Entity;

@Entity
public class Jogador extends Usuario {

    private int pontuacaoRanking;

    // Construtores
    public Jogador() {
        super(); // Chama o construtor da classe pai (Usuario)
    }

    public Jogador(String apelido, String senha, int pontuacaoRanking) {
        super(apelido, senha); // Chama o construtor da classe pai (Usuario)
        this.pontuacaoRanking = pontuacaoRanking;
    }

    // Getter e Setter para pontuacaoRanking
    public int getPontuacaoRanking() {
        return pontuacaoRanking;
    }

    public void setPontuacaoRanking(int pontuacaoRanking) {
        this.pontuacaoRanking = pontuacaoRanking;
    }

    // Método para simular uma partida
    public void jogar() {
        // Lógica do jogo
        // Por exemplo, incrementar a pontuação de acordo com o desempenho do jogador
        System.out.println(getApelido() + " está jogando...");
        
        // Exemplo de lógica para incrementar a pontuação
        int pontosGanho = (int) (Math.random() * 100); // Ganha um número aleatório de pontos
        pontuacaoRanking += pontosGanho;
        System.out.println(getApelido() + " ganhou " + pontosGanho + " pontos! Total: " + pontuacaoRanking);
    }
}
