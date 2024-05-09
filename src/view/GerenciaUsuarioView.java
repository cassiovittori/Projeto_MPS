package view;

import java.io.IOException;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.Scanner;

import controller.Facade;
import utils.Constantes;
import exception.SexoException;
import exception.TipoUserException;

public class GerenciaUsuarioView {
    private Scanner scanner;
    private Facade fachada;

    public GerenciaUsuarioView() {
        this.fachada = Facade.getInstance();
        this.scanner = new Scanner(System.in);
    }

    public void addNovoUsuario() throws TipoUserException, SQLDataException, IOException, SexoException {

        System.out.println("Digite o login do usuário:");
        String login = scanner.next();
        System.out.println("Digite a senha do usuário:");
        String senha = scanner.next();
        System.out.println("Digite o nome do usuário:");
        String nome = scanner.next();
        System.out.println("Digite o CPF do usuário:");
        String cpf = scanner.next();
        System.out.println("Digite o sexo do usuário:");
        String sexo = scanner.next();
        System.out.println("Digite o número de contato do usuário:");
        String numContato = scanner.next();
        System.out.println("Digite a data de nascimento do usuário:");
        String dataNascimento = scanner.next();
        System.out.println("Digite o tipo do usuário");
        System.out.println("1 -> ADM 2 -> PACIENTE 3-> MEDICO");
        String idTipoUsuario = scanner.next();
        System.out.println("Digite o email do usuário");
        String email = scanner.next();
        System.out.println("Caso seja um médico, digite o CRM");
        String crm = scanner.next();
        
        fachada.adicionarNovoUsuarioCtrl(login, senha, nome, cpf, email, sexo, numContato, dataNascimento, idTipoUsuario, crm);    
        
    }

    public void buscaUsuario() throws ClassNotFoundException, IOException, SQLException{

        String parametro;

        System.out.println("Digite o numero correspondente ao tipo de consulta de usuário que deseja fazer:");
        System.out.println("1-> por id");
        System.out.println("2-> por cpf");
        System.out.println("3-> por nome");
        System.out.println("4-> por crm");
        String idOpcaoConsulta = scanner.next();
        switch (idOpcaoConsulta) {
            case Constantes.ID_OPCAO_1:
                System.out.println("agora informe o ID do usuario!");
                break;
            case Constantes.ID_OPCAO_2:
                System.out.println("agora informe o NOME do usuario!");
                break;
            case Constantes.ID_OPCAO_3:
                System.out.println("agora informe o CPF do usuario!");
                break;
            case Constantes.ID_OPCAO_4:
                System.out.println("agora informe o CRM do usuario!");
                break;
        }
        parametro = scanner.next();
        fachada.buscaUsuario(idOpcaoConsulta, parametro);
        
    }
    
    public void buscaListaUsuario() throws ClassNotFoundException, IOException, SQLException{
        System.out.println("Digite o numero correspondente ao tipo de consulta de usuário que deseja fazer:");
        fachada.buscaListaUsuario();
    }

    public void editarUsuario() throws TipoUserException, SQLDataException, IOException, SexoException {

        System.out.println("Digite o ID do usuario que deseja editar:");
        String idUser = scanner.next();
        System.out.println("Digite o novo login do usuário:");
        String login = scanner.next();
        System.out.println("Digite a nova senha do usuário:");
        String senha = scanner.next();
        System.out.println("Digite o novo nome do usuário:");
        String nome = scanner.next();
        System.out.println("Digite o novo número de contato do usuário:");
        String numero = scanner.next();
        System.out.println("Digite o novo email do usuário:");
        String email = scanner.next();
        fachada.atualizaUsuarioCtrl(idUser, login, senha, nome, numero, email);
        
    }

    public void deletarUsuario() throws TipoUserException, SQLDataException, IOException, SexoException {

        System.out.println("Digite o ID do usuario que deseja editar:");
        String idUser = scanner.next();
        fachada.deletaUsuarioCtrl(idUser);
        
    }

    /*
    public void mostrarUsuarios() throws ClassNotFoundException, IOException, SQLException {
        System.out.println("Os usuários cadastrados no nosso sistema são:");
        //jogar loop para o controller
        for (Usuario usuario : fachada.obterUsuarios()) {
            System.out.println("Login: " + usuario.getLogin() + ", Senha: " + usuario.getSenha());
        }
    }

    Interface Usuario()
        ADM
        PACIENTE
        MEDICO
    FACTORY -> 1 2 3


     */
}
