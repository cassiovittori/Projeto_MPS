package view.commands.consultaCommands;

import controller.Facade;
import view.commands.Command;

public class buscarTodasConsultasCommand implements Command {
    private final Facade fachada;

    public buscarTodasConsultasCommand() {
        this.fachada = Facade.getInstance();
    }

    @Override
    public void executar() {
        fachada.buscaListaConsulta();
    }
}
