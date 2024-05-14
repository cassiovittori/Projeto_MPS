package view.commands.usuarioCommands;

import controller.Facade;
import view.commands.Command;

import java.io.IOException;
import java.sql.SQLException;

public class buscarTodosUsuariosCommand implements Command {
    Facade fachada;
    public buscarTodosUsuariosCommand() {
        this.fachada = Facade.getInstance();
    }

    @Override
    public void executar() {
        fachada.buscaListaUsuario();
    }
}
