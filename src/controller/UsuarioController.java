package controller;

import model.Usuario;
import service.UsuarioService;
import view.UsuarioView;

import java.io.IOException;
import java.sql.SQLException;

public class UsuarioController {
    private UsuarioService usuarioService;
    private UsuarioView usuarioView;
    private static UsuarioController instance; //cria a instancia desse controler

    private UsuarioController() { //privado, para construir em outro lugar do codigo so usando o get.instance
        this.usuarioService = new UsuarioService();
        this.usuarioView = new UsuarioView();
    }

    protected void executar() {
        adicionarUsuario();
        mostrarUsuarios();
    }

    protected void adicionarUsuario() {
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

    protected void mostrarUsuarios() {
        try {
            usuarioView.mostrarUsuarios(usuarioService.getUsuarios());
        } catch (IOException | ClassNotFoundException | SQLException e) {
            System.out.println("Erro ao obter usuários: " + e.getMessage());
        }
    }

    public static UsuarioController getInstance() {
            if (instance == null) {
                instance = new UsuarioController();
            }
            return instance;
      /* esse erro aqui gerou automaticamente pelo visual code acho que o tratamento de erro n ta certo 
       throw new UnsupportedOperationException("Unimplemented method 'getInstance'");
       */ 
    }
    
}
