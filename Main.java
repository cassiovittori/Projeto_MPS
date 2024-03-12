import controller.UsuarioController;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

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

