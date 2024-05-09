package view.consoleStates.usuarioStates;

import view.commands.Command;
import view.commands.SairCommand;
import view.commands.usuarioCommands.AtualizarUsuarioCommand;
import view.consoleStates.ConsoleState;

import java.util.Scanner;

public class AtualizarUsuarioConsoleState implements ConsoleState {
    @Override
    public void montarTela(Scanner scanner){
        System.out.println("\n\n");
        System.out.println("Bem vindo a atualização de usuario!");
        System.out.println("A qualquer momento utilize V para voltar ou S para sair");
        System.out.println("Vou te pedir alguns dados para continuarmos");

        System.out.println();

        System.out.println("Digite o ID do usuario que deseja editar:");
        String idUser = scanner.next();
        saidaOuVolta(idUser,scanner);

        System.out.println("Digite o novo login do usuário:");
        String login = scanner.next();
        saidaOuVolta(login,scanner);

        System.out.println("Digite a nova senha do usuário:");
        String senha = scanner.next();
        saidaOuVolta(senha,scanner);

        System.out.println("Digite o novo nome do usuário:");
        String nome = scanner.next();
        saidaOuVolta(nome,scanner);

        System.out.println("Digite o novo número de contato do usuário:");
        String numContato = scanner.next();
        saidaOuVolta(numContato,scanner);

        System.out.println("Digite o novo email do usuário:");
        String email = scanner.next();
        saidaOuVolta(email,scanner);

        Command command = new AtualizarUsuarioCommand(idUser,login,senha,nome,email,numContato);
        command.executar();

        System.out.println("\n\n");
        System.out.println("#######-USUARIO-######");
        System.out.println("# 1-Atualizar Outro  #");
        System.out.println("#     2-Voltar       #");
        System.out.println("#     3-Sair         #");
        System.out.println("######################");

        int opcao = Integer.parseInt(scanner.next());

        direcionar(opcao, scanner);
    }

    @Override
    public void direcionar(int opcao, Scanner scanner) {
        switch (opcao) {
            case 1 -> this.montarTela(scanner);
            case 2 -> new UsuarioConsoleState().montarTela(scanner);
            case 3 -> this.sair();
            default -> {
            }
        }
    }

    private void saidaOuVolta(String entrada, Scanner scanner){
        if (entrada.equalsIgnoreCase("V")) {
            new UsuarioConsoleState().montarTela(scanner);
        } else if (entrada.equalsIgnoreCase("S")){
            this.sair();
        }
    }

    @Override
    public void sair() {
        new SairCommand().executar();
    }
}
