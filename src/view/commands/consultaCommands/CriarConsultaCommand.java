package view.commands.consultaCommands;

import controller.Facade;
import view.commands.Command;

import java.util.Stack;

public class CriarConsultaCommand implements Command {
    private final Facade fachada;
    private final String crm;
    private final String cpf;
    private final String data;
    private final String motivo;

    private Stack<ConsultaMemento> history = new Stack<>();

    public CriarConsultaCommand(String crm, String cpf, String data, String motivo) {
        this.fachada = Facade.getInstance();
        this.crm = crm;
        this.cpf = cpf;
        this.data = data;
        this.motivo = motivo;
    }


    @Override
    public void executar() {
        salvarEstado();

        fachada.adicionarNovaConsultaCtrl(crm,cpf,data,motivo);
    }
    private void salvarEstado() {
        ConsultaMemento memento = new ConsultaMemento(crm, cpf, data, motivo);
        history.push(memento);
    }
    public void desfazer(){
        if(!history.isEmpty()){
            ConsultaMemento ultimoEstado = history.pop();
        }
    }
    privatic static class ConsultaMemento {
        private final String crm;
        private final String cpf;
        private final String data;
        private final String motivo;

        public ConsultaMemento(String crm, String cpf, String data, String motivo) {
            this.crm = crm;
            this.cpf = cpf;
            this.data = data;
            this.motivo = motivo;
        }

        public String getCrm() {
            return crm;
        }
        public String getCpf() {
            return cpf;
        }
        public String getData() {
            return data;
        }
        public String getMotivo() {
            return motivo;
        }
    }
}
