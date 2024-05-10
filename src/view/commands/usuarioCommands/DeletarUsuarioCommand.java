package view.commands.usuarioCommands;

import controller.Facade;
import exception.SexoException;
import exception.TipoUserException;
import view.commands.Command;

import java.io.IOException;
import java.sql.SQLDataException;

public class DeletarUsuarioCommand implements Command {
    Facade fachada;

    String idUser;

    public DeletarUsuarioCommand(String idUser) {
        this.fachada = Facade.getInstance();
        this.idUser = idUser;
    }

    @Override
    public void executar() {
            fachada.deletaUsuarioCtrl(idUser);
    }
}
