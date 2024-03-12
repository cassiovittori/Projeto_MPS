import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class UsuarioService {
    private static List<Usuario> listaUsuarios = new ArrayList<>();

    public static void adicionarUsuario(Usuario usuario) {
        listaUsuarios.add(usuario);
        System.out.println("Usuário adicionado com sucesso!");
    }

    public static List<Usuario> getUsuarios() {
        return listaUsuarios;
    }
}