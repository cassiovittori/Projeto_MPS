package view.consoleStates.usuarioStates;

import view.commands.Command;
import view.commands.SairCommand;
import view.commands.usuarioCommands.DeletarUsuarioCommand;
import view.consoleStates.ConsoleState;

import java.util.Scanner;

public class DeletarUsuarioConsoleState implements ConsoleState {
        @Override
        public void montarTela(Scanner scanner){
            System.out.println("\n\n");
            System.out.println("Bem vindo a deleção de usuario!");
            System.out.println("A qualquer momento utilize V para voltar ou S para sair");
            System.out.println("Vou te pedir alguns dados para continuarmos");

            System.out.println();

            System.out.println("Digite o ID do usuario que deseja deletar:");
            String idUser = scanner.next();
            saidaOuVolta(idUser,scanner);

            Command command = new DeletarUsuarioCommand(idUser);
            command.executar();

            System.out.println("\n\n");
            System.out.println("#######-USUARIO-######");
            System.out.println("#    1-Deletar Outro #");
            System.out.println("#    2-Voltar        #");
            System.out.println("#    3-Sair          #");
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
