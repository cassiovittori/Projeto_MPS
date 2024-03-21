package controller;

import model.Usuario;
import service.UsuarioService;
import view.UsuarioView;

import java.io.IOException;
import java.sql.SQLException;

public class UsuarioController {
    private UsuarioService usuarioService;
    private UsuarioView usuarioView;

    public UsuarioController() {
        this.usuarioService = new UsuarioService();
        this.usuarioView = new UsuarioView();
    }

    public void executar() {
        adicionarUsuario();
        mostrarUsuarios();
    }

    private void adicionarUsuario() {
        try {
            Usuario novoUsuario = usuarioView.obterNovoUsuario();
            ValidacaoController.validarLogin(novoUsuario.getLogin());
            ValidacaoController.validarSenha(novoUsuario.getSenha());
            usuarioService.adicionarUsuario(novoUsuario);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao adicionar usuário: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Erro ao adicionar usuário: " + e.getMessage());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void mostrarUsuarios() {
        try {
            usuarioView.mostrarUsuarios(usuarioService.getUsuarios());
        } catch (IOException | ClassNotFoundException | SQLException e) {
            System.out.println("Erro ao obter usuários: " + e.getMessage());
        }
    }
}
