package view.consoleStates;

import view.commands.SairCommand;
import view.consoleStates.consultaStates.ConsultaConsoleState;
import view.consoleStates.relatorioStates.RelatorioConsoleState;
import view.consoleStates.usuarioStates.UsuarioConsoleState;

import java.util.Scanner;

public class MenuConsoleState implements ConsoleState {
    @Override
    public void montarTela(Scanner scanner) {
        System.out.println("\n\n");
        System.out.println("#######-MENU-#######");
        System.out.println("#    1-Usuarios    #");
        System.out.println("#    2-Consultas   #");
        System.out.println("#    3-Relatorios  #");
        System.out.println("#    4-Sair        #");
        System.out.println("####################");

        int opcao = Integer.parseInt(scanner.next());

        direcionar(opcao, scanner);
    }

    @Override
    public void direcionar(int opcao, Scanner scanner) {
        switch (opcao){
            case 1:
                new UsuarioConsoleState().montarTela(scanner);
                break;
            case 2:
                new ConsultaConsoleState().montarTela(scanner);
                break;
            case 3:
                new RelatorioConsoleState().montarTela(scanner);
                break;
            case 4:
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
