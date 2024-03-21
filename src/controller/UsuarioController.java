package controller;

import model.Usuario;
import service.UsuarioService;
import view.UsuarioView;

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
            validarUsuario(novoUsuario);
            usuarioService.adicionarUsuario(novoUsuario);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao adicionar usuário: " + e.getMessage());
        }
    }

    private void validarUsuario(Usuario usuario) {
        validarLogin(usuario.getLogin());
        validarSenha(usuario.getSenha());
    }

    private void validarLogin(String login) {
        if (login.isEmpty()) {
            throw new IllegalArgumentException("O login não pode ser vazio.");
        }
        if (login.length() > 12) {
            throw new IllegalArgumentException("O login não pode ter mais de 12 caracteres.");
        }
        if (login.matches(".*\\d.*")) {
            throw new IllegalArgumentException("O login não pode conter números.");
        }
    }

    private void validarSenha(String senha) {
        if (senha.length() < 8 || senha.length() > 20) {
            throw new IllegalArgumentException("A senha deve ter entre 8 e 20 caracteres.");
        }
        if (!senha.matches(".*[a-zA-Z].*") || !senha.matches(".*\\d.*")) {
            throw new IllegalArgumentException("A senha deve conter letras e números.");
        }
        int contadorNumeros = 0;
        for (char c : senha.toCharArray()) {
            if (Character.isDigit(c)) {
                contadorNumeros++;
            }
        }
        if (contadorNumeros < 2) {
            throw new IllegalArgumentException("A senha deve conter ao menos 2 números.");
        }
    }

    private void mostrarUsuarios() {
        usuarioView.mostrarUsuarios(usuarioService.getUsuarios());
    }
}
