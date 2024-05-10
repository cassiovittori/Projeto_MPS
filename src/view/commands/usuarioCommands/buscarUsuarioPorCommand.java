package view.commands.usuarioCommands;

import controller.Facade;
import view.commands.Command;

public class buscarUsuarioPorCommand implements Command {
    Facade fachada;
    int opcao;
    String parametro;
    public buscarUsuarioPorCommand(int opcao, String parametro) {
        fachada = Facade.getInstance();
        this.opcao = opcao;
        this.parametro = parametro;
    }

    @Override
    public void executar() {
        fachada.buscaUsuario(Integer.toString(opcao),parametro);
    }
}
