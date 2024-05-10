package view.commands.consultaCommands;

import controller.Facade;
import view.commands.Command;

public class buscarConsultaPorCommand implements Command {
    private final Facade fachada;
    private final int opcao;
    private final String parametro;
    public buscarConsultaPorCommand(int opcao, String parametro) {
        this.fachada = Facade.getInstance();
        this.opcao = opcao;
        this.parametro = parametro;
    }

    @Override
    public void executar() {
        fachada.buscaConsulta(Integer.toString(opcao), parametro);
    }
}
