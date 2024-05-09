package view.consoleStates.usuarioStates;

import view.commands.Command;
import view.commands.SairCommand;
import view.commands.usuarioCommands.CriarUsuarioCommand;
import view.consoleStates.ConsoleState;

import java.util.Scanner;

public class CriarUsuarioConsoleState implements ConsoleState {
    @Override
    public void montarTela(Scanner scanner){
        System.out.println("\n\n");
        System.out.println("Bem vindo a criação de usuario!");
        System.out.println("A qualquer momento utilize V para voltar ou S para sair");
        System.out.println("Vou te pedir alguns dados para continuarmos");

        System.out.println();

        System.out.println("Digite o tipo do usuário");
        System.out.println("1 -> ADM 2 -> PACIENTE 3-> MEDICO");
        String strTipoUsuario = scanner.next();
        saidaOuVolta(strTipoUsuario,scanner);

        System.out.println("Digite o login do usuário:");
        System.out.println("Não pode ser vazio deve ter menos de 12 caracteres e não deve conter numeros");
        String login = scanner.next();
        saidaOuVolta(login,scanner);

        System.out.println("Digite a senha do usuário:");
        System.out.println("Deve ter entre 8 e 20 caracteres, com pelo menos 1 letra e 2 numeros");
        String senha = scanner.next();
        saidaOuVolta(senha,scanner);

        System.out.println("Digite o nome do usuário:");
        String nome = scanner.next();
        saidaOuVolta(nome,scanner);

        System.out.println("Digite o CPF do usuário:");
        String cpf = scanner.next();
        saidaOuVolta(cpf,scanner);

        System.out.println("Digite o sexo do usuário:");
        System.out.println("M -> Masculino e F -> Feminino");
        String sexo = scanner.next();
        saidaOuVolta(sexo,scanner);

        System.out.println("Digite o número de contato do usuário:");
        String numContato = scanner.next();
        saidaOuVolta(numContato,scanner);

        System.out.println("Digite a data de nascimento do usuário:");
        String dataNascimento = scanner.next();
        saidaOuVolta(dataNascimento,scanner);

        System.out.println("Digite o email do usuário");
        String email = scanner.next();
        saidaOuVolta(email,scanner);

        String crm = "";
        if (strTipoUsuario.equals("3")) {
            System.out.println("Digite o CRM");
            crm = scanner.next();
            saidaOuVolta(crm,scanner);
        }

        Command command = new CriarUsuarioCommand(login,senha,nome,cpf,email,sexo,numContato,dataNascimento,strTipoUsuario,crm);
        command.executar();

        System.out.println("\n\n");
        System.out.println("######-USUARIO-#####");
        System.out.println("#    1-Criar Outro #");
        System.out.println("#    2-Voltar      #");
        System.out.println("#    3-Sair        #");
        System.out.println("####################");

        int opcao = Integer.parseInt(scanner.next());

        direcionar(opcao, scanner);

    }

    @Override
    public void direcionar(int opcao, Scanner scanner) {
        switch (opcao){
            case 1:
                this.montarTela(scanner);
                break;
            case 2:
                new CriarUsuarioConsoleState().montarTela(scanner);
                break;
            case 3:
                this.sair();
                break;
            default:
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
