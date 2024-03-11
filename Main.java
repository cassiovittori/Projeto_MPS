import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

class Usuario {
    private String login;
    private String senha;

    public Usuario(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}

class UsuarioService {
    private static List<Usuario> listaUsuarios = new ArrayList<>();

    public static void adicionarUsuario(Usuario usuario) {
        listaUsuarios.add(usuario);
        System.out.println("Usuário adicionado com sucesso!");
    }

    public static List<Usuario> getUsuarios() {
        return listaUsuarios;
    }
}

class UsuarioView {
    public static void mostrarUsuarios(List<Usuario> usuarios) {
        System.out.println("Os usuários cadastrados no nosso sistema são:");
        for (Usuario usuario : usuarios) {
            System.out.println("Login: " + usuario.getLogin() + ", Senha: " + usuario.getSenha());
        }
    }
}

class UsuarioController {
    private UsuarioService usuarioService;
    private UsuarioView usuarioView;

    public UsuarioController(UsuarioService usuarioService, UsuarioView usuarioView) {
        this.usuarioService = usuarioService;
        this.usuarioView = usuarioView;
    }

    public void adicionarUsuario() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o login do usuário:");
        String novoLogin = scanner.next();
        System.out.println("Digite a senha do usuário:");
        String novaSenha = scanner.next();
        Usuario novoUsuario = new Usuario(novoLogin, novaSenha);
        usuarioService.adicionarUsuario(novoUsuario);
    }

    public void mostrarUsuarios() {
        List<Usuario> usuarios = usuarioService.getUsuarios();
        usuarioView.mostrarUsuarios(usuarios);
    }
}

public class Main {
    public static void main(String[] args) {
        UsuarioController usuarioController = new UsuarioController(new UsuarioService(), new UsuarioView());
        usuarioController.adicionarUsuario();
        usuarioController.adicionarUsuario();
        usuarioController.adicionarUsuario();
        usuarioController.adicionarUsuario();
        usuarioController.mostrarUsuarios();
    }
}
