package view.commands.consultaCommands;

import controller.Facade;
import view.commands.Command;

public class DeletarConsultaCommand implements Command {
    private final Facade fachada;
    private final String idConsulta;
    public DeletarConsultaCommand(String idConsulta) {
        this.fachada = Facade.getInstance();
        this.idConsulta = idConsulta;
    }

    @Override
    public void executar() {
        fachada.deletaConsultaCtrl(idConsulta);
    }
}
