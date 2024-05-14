package view.commands.usuarioCommands;

import controller.Facade;
import exception.SexoException;
import exception.TipoUserException;
import view.commands.Command;

import java.io.IOException;
import java.sql.SQLDataException;

public class CriarUsuarioCommand implements Command {
    Facade fachada;
    String login;
    String senha;
    String nome;
    String cpf;
    String email;
    String sexo;
    String numContato;
    String dataNascimento;
    String strTipoUsuario;
    String crm;


    public CriarUsuarioCommand(String login, String senha, String nome, String cpf, String email, String sexo, String numContato, String dataNascimento, String strTipoUsuario, String crm) {
        this.fachada = Facade.getInstance();
        this.login = login;
        this.senha = senha;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.sexo = sexo;
        this.numContato = numContato;
        this.dataNascimento = dataNascimento;
        this.strTipoUsuario = strTipoUsuario;
        this.crm = crm;
    }

    @Override
    public void executar() {
        fachada.adicionarNovoUsuarioCtrl(login, senha, nome, cpf, email, sexo, numContato, dataNascimento, strTipoUsuario, crm);
    }
}