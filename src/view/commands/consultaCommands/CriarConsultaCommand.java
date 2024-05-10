package view.commands.consultaCommands;

import controller.Facade;
import view.commands.Command;

public class CriarConsultaCommand implements Command {
    private final Facade fachada;
    private final String crm;
    private final String cpf;
    private final String data;
    private final String motivo;
    public CriarConsultaCommand(String crm, String cpf, String data, String motivo) {
        this.fachada = Facade.getInstance();
        this.crm = crm;
        this.cpf = cpf;
        this.data = data;
        this.motivo = motivo;
    }


    @Override
    public void executar() {
        fachada.adicionarNovaConsultaCtrl(crm,cpf,data,motivo);
    }
}
