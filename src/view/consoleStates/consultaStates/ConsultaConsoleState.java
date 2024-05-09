package view.consoleStates.consultaStates;

import view.commands.SairCommand;
import view.consoleStates.ConsoleState;
import view.consoleStates.MenuConsoleState;

import java.util.Scanner;

public class ConsultaConsoleState implements ConsoleState {

    @Override
    public void montarTela(Scanner scanner) {
        System.out.println("\n\n");
        System.out.println("######-CONSULTA-#####");
        System.out.println("#    1-Criar        #");
        System.out.println("#    2-Atualizar    #");
        System.out.println("#    3-Deletar      #");
        System.out.println("#    4-Listar       #");
        System.out.println("#    5-Voltar       #");
        System.out.println("#    6-Sair         #");
        System.out.println("####################");

        int opcao = Integer.parseInt(scanner.next());

        direcionar(opcao, scanner);
    }

    @Override
    public void direcionar(int opcao, Scanner scanner) {
        switch (opcao){
            case 1:
                new CriarConsultaConsoleState().montarTela(scanner);
                break;
            case 2:
                new AtualizarConsultaConsoleState().montarTela(scanner);
                break;
            case 3:
                new DeletarConsultaConsoleState().montarTela(scanner);
                break;
            case 4:
                new ListarConsultasState().montarTela(scanner);
                break;
            case 5:
                new MenuConsoleState().montarTela(scanner);
                break;
            case 6:
                this.sair();
                break;
            default:
        }
    }

    @Override
    public void sair() {
        new SairCommand().executar();
    }
}
