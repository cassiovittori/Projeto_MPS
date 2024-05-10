package view.consoleStates.usuarioStates;

import view.commands.Command;
import view.commands.SairCommand;
import view.commands.usuarioCommands.DeletarUsuarioCommand;
import view.commands.usuarioCommands.buscarTodosUsuariosCommand;
import view.commands.usuarioCommands.buscarUsuarioPorCommand;
import view.consoleStates.ConsoleState;

import java.util.Scanner;

public class ListarUsuarioState implements ConsoleState {
    @Override
    public void montarTela(Scanner scanner){
        System.out.println("\n\n");

        System.out.println("#######-USUARIO-######");
        System.out.println("#    1-Por ID        #");
        System.out.println("#    2-Por CPF       #");
        System.out.println("#    3-Por Nome      #");
        System.out.println("#    4-Por CRM       #");
        System.out.println("#    5-Listar Todos  #");
        System.out.println("#    6-Voltar        #");
        System.out.println("#    7-Sair          #");
        System.out.println("######################");

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
                command = new buscarUsuarioPorCommand(opcao,parametro);
                command.executar();
                this.montarTela(scanner);
                break;
            case 2:
                System.out.println("Informe o CPF que deseja buscar: ");
                parametro = scanner.next();
                command = new buscarUsuarioPorCommand(opcao,parametro);
                command.executar();
                this.montarTela(scanner);
                break;
            case 3:
                System.out.println("Informe o Nome que deseja buscar: ");
                parametro = scanner.next();
                command = new buscarUsuarioPorCommand(opcao,parametro);
                command.executar();
                this.montarTela(scanner);
                break;
            case 4:
                System.out.println("Informe o CRM que deseja buscar: ");
                parametro = scanner.next();
                command = new buscarUsuarioPorCommand(opcao,parametro);
                command.executar();
                this.montarTela(scanner);
                break;
            case 5:
                command = new buscarTodosUsuariosCommand();
                command.executar();
                this.montarTela(scanner);
                break;
            case 6:
                new UsuarioConsoleState().montarTela(scanner);
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
