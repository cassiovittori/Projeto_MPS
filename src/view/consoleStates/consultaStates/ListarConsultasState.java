package view.consoleStates.consultaStates;

import view.commands.Command;
import view.commands.SairCommand;
import view.commands.consultaCommands.buscarConsultaPorCommand;
import view.commands.consultaCommands.buscarTodasConsultasCommand;
import view.consoleStates.ConsoleState;


import java.util.Scanner;

public class ListarConsultasState implements ConsoleState {
    @Override
    public void montarTela(Scanner scanner) {
        System.out.println("\n\n");

        System.out.println("#######-CONSULTA-######");
        System.out.println("#    1-Por ID         #");
        System.out.println("#    2-Por CPF        #");
        System.out.println("#    3-Por CRM        #");
        System.out.println("#    4-Por Data       #");
        System.out.println("#    5-Listar Todos   #");
        System.out.println("#    6-Voltar         #");
        System.out.println("#    7-Sair           #");
        System.out.println("#######################");

        int opcao = Integer.parseInt(scanner.next());

        direcionar(opcao, scanner);
    }

    @Override
    public void direcionar(int opcao, Scanner scanner) {

        Command command;
        String parametro;

        switch (opcao) {
            case 1:
                System.out.println("Informe o ID que deseja buscar: ");
                parametro = scanner.next();
                command = new buscarConsultaPorCommand(opcao,parametro);
                command.executar();
                this.montarTela(scanner);
                break;
            case 2:
                System.out.println("Informe o CPF que deseja buscar: ");
                parametro = scanner.next();
                command = new buscarConsultaPorCommand(opcao,parametro);
                command.executar();
                this.montarTela(scanner);
                break;
            case 3:
                System.out.println("Informe o CRM que deseja buscar: ");
                parametro = scanner.next();
                command = new buscarConsultaPorCommand(opcao,parametro);
                command.executar();
                this.montarTela(scanner);
                break;
            case 4:
                System.out.println("Informe a Data que deseja buscar: ");
                parametro = scanner.next();
                command = new buscarConsultaPorCommand(opcao,parametro);
                command.executar();
                this.montarTela(scanner);
                break;
            case 5:
                command = new buscarTodasConsultasCommand();
                command.executar();
                this.montarTela(scanner);
                break;
            case 6:
                new ConsultaConsoleState().montarTela(scanner);
            case 7:
                this.sair();
            default:
        }
    }

    @Override
    public void sair() {
        new SairCommand().executar();
    }
}
