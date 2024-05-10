package view.commands.consultaCommands;

import controller.Facade;
import view.commands.Command;

public class AtualizarConsultaCommand implements Command {

    private final Facade fachada;
    private final String idConsulta;
    private final String data;

    public AtualizarConsultaCommand(String idConsulta, String data) {
        this.fachada = Facade.getInstance();
        this.idConsulta= idConsulta;
        this.data = data;
    }

    @Override
    public void executar() {
        fachada.atualizarConsultaCtrl(idConsulta, data);
    }
}
