package view;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import controller.Facade;
import model.Usuario;

public class GerenciaUsuarioView {
    private Scanner scanner;
    private Facade fachada;

    public GerenciaUsuarioView() {
        this.fachada = Facade.getInstance();
    }

    public void obterNovoUsuario() {
        System.out.println("Digite o login do usuário:");
        String novoLogin = scanner.next();
        System.out.println("Digite a senha do usuário:");
        String novaSenha = scanner.next();
        fachada.adicionarNovoUsuario(novoLogin,novaSenha);
        System.out.println("login: " + novoLogin +" senha: " + novaSenha);
    }

    public void mostrarUsuarios() throws ClassNotFoundException, IOException, SQLException {
        System.out.println("Os usuários cadastrados no nosso sistema são:");
        //jogar loop para o controller
        for (Usuario usuario : fachada.obterUsuarios()) {
            System.out.println("Login: " + usuario.getLogin() + ", Senha: " + usuario.getSenha());
        }
    }
}
