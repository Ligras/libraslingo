package com.ifsp.bra.libraslingo;

import com.ifsp.bra.libraslingo.model.Administrador;
import com.ifsp.bra.libraslingo.model.Jogador;
import com.ifsp.bra.libraslingo.model.Usuario;
import com.ifsp.bra.libraslingo.service.AdministradorService;
import com.ifsp.bra.libraslingo.service.JogadorService;
import com.ifsp.bra.libraslingo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabasePopulator implements CommandLineRunner {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private AdministradorService administradorService;

    @Autowired
    private JogadorService jogadorService;

    @Override
    public void run(String... args) throws Exception {
        // Criar e salvar usuários
        Usuario usuario1 = new Usuario("usuario1", "senha123");
        usuarioService.criarUsuario(usuario1);

        Usuario usuario2 = new Usuario("usuario2", "senha456");
        usuarioService.criarUsuario(usuario2);

        // Criar e salvar administradores
        Administrador admin1 = new Administrador();
        admin1.setApelido("admin1");
        admin1.setSenha("senhaAdmin1");
        administradorService.salvar(admin1);

        // Criar e salvar jogadores
        Jogador jogador1 = new Jogador();
        jogador1.setApelido("jogador1");
        jogador1.setSenha("senhaJogador1");
        jogador1.setPontuacaoRanking(100); // Defina a pontuação desejada
        jogadorService.salvar(jogador1);

        Jogador jogador2 = new Jogador();
        jogador2.setApelido("jogador2");
        jogador2.setSenha("senhaJogador2");
        jogador2.setPontuacaoRanking(200); // Defina a pontuação desejada
        jogadorService.salvar(jogador2);

        System.out.println("Dados populados com sucesso!");
    }
}
