package view.commands.consultaCommands;

import controller.Facade;
import view.commands.Command;

import java.util.Stack;

public class AtualizarConsultaCommand implements Command {

    private final Facade fachada;
    private final String idConsulta;
    private final String newData;

    private Stack<ConsultaMemento> history = new Stack<>();

    public AtualizarConsultaCommand(String idConsulta, String newData) {
        this.fachada = Facade.getInstance();
        this.idConsulta = idConsulta;
        this.newData = newData;
    }

    @Override
    public void executar() {
        salvarEstado();

        fachada.atualizarConsultaCtrl(idConsulta, newData);
    }
    private void salvarEstado() {
        String currentData = fachada.obterDataConsulta(idConsulta);
        ConsultaMemento memento = new ConsultaMemento(idConsulta, currentData);
        history.push(memento);
    }

    public void desfazer() {
        if (!history.isEmpty()) {
            ConsultaMemento ultimoEstado = history.pop();
            fachada.atualizarConsultaCtrl(ultimoEstado.getIdConsulta(), ultimoEstado.getData());
        }
    }

    private static class ConsultaMemento {
        private final String idConsulta;
        private final String data;

        public ConsultaMemento(String idConsulta, String data) {
            this.idConsulta = idConsulta;
            this.data = data;
        }

        public String getIdConsulta() {
            return idConsulta;
        }

        public String getData() {
            return data;
        }
    }
}
