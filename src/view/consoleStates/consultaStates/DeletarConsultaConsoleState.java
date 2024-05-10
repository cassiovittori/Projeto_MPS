package view.consoleStates.consultaStates;

import view.commands.Command;
import view.commands.SairCommand;
import view.commands.consultaCommands.DeletarConsultaCommand;
import view.consoleStates.ConsoleState;

import java.util.Scanner;

public class DeletarConsultaConsoleState implements ConsoleState {
    @Override
    public void montarTela(Scanner scanner) {
        System.out.println("\n\n");
        System.out.println("Bem vindo a deleção de consultas!");
        System.out.println("A qualquer momento utilize V para voltar ou S para sair");

        System.out.println();

        System.out.println("Digite o ID da consulta para ser atualizada:");
        String idConsulta = scanner.next();
        saidaOuVolta(idConsulta,scanner);

        Command command = new DeletarConsultaCommand(idConsulta);
        command.executar();

        System.out.println("\n\n");
        System.out.println("######-CONSULTA-#######");
        System.out.println("#    1-Deletar Outra  #");
        System.out.println("#    2-Voltar         #");
        System.out.println("#    3-Sair           #");
        System.out.println("#######################");

        int opcao = Integer.parseInt(scanner.next());

        direcionar(opcao, scanner);
    }

    @Override
    public void direcionar(int opcao, Scanner scanner) {
        switch (opcao){
            case 1 -> this.montarTela(scanner);
            case 2 -> new ConsultaConsoleState().montarTela(scanner);
            case 3 -> this.sair();
        }
    }

    private void saidaOuVolta(String entrada, Scanner scanner){
        if (entrada.equalsIgnoreCase("V")) {
            new ConsultaConsoleState().montarTela(scanner);
        } else if (entrada.equalsIgnoreCase("S")){
            this.sair();
        }
    }

    @Override
    public void sair() {
        new SairCommand().executar();
    }
}
