package view;

import model.Usuario;
import java.util.List;
import java.util.Scanner;

public class UsuarioView {
    private Scanner scanner;

    public UsuarioView() {
        this.scanner = new Scanner(System.in);
    }

    public Usuario obterNovoUsuario() {
        System.out.println("Digite o login do usuário:");
        String novoLogin = scanner.next();
        System.out.println("Digite a senha do usuário:");
        String novaSenha = scanner.next();
        return new Usuario(novoLogin, novaSenha);
    }

    public void mostrarUsuarios(List<Usuario> usuarios) {
        System.out.println("Os usuários cadastrados no nosso sistema são:");
        for (Usuario usuario : usuarios) {
            System.out.println("Login: " + usuario.getLogin() + ", Senha: " + usuario.getSenha());
        }
    }
}
