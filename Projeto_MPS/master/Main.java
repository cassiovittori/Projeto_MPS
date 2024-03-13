package master;

import controller.UsuarioController;
import service.UsuarioService;
import view.UsuarioView;

public class Main {
    public static void main(String[] args) {
        UsuarioService usuarioService = new UsuarioService();
        UsuarioView usuarioView = new UsuarioView();
        UsuarioController usuarioController = new UsuarioController(usuarioService, usuarioView);

        usuarioController.adicionarUsuario();
        usuarioController.adicionarUsuario();
        usuarioController.adicionarUsuario();
        usuarioController.adicionarUsuario();

        usuarioController.mostrarUsuarios();
    }
}
