package view.commands.usuarioCommands;

import controller.Facade;
import exception.SexoException;
import exception.TipoUserException;
import view.commands.Command;

import java.io.IOException;
import java.sql.SQLDataException;
import java.util.Stack;

public class CriarUsuarioCommand implements Command {
    private final Facade fachada;
    private final String login;
    private final String senha;
    private final String nome;
    private final String cpf;
    private final String email;
    private final String sexo;
    private final String numContato;
    private final String dataNascimento;
    private final String strTipoUsuario;
    private final String crm;

    private Stack<UsuarioMemento> history = new Stack<>();

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
        salvarEstado();
        fachada.adicionarNovoUsuarioCtrl(login, senha, nome, cpf, email, sexo, numContato, dataNascimento, strTipoUsuario, crm);
    }

    private void salvarEstado() {
        UsuarioMemento memento = new UsuarioMemento(login, senha, nome, cpf, email, sexo, numContato, dataNascimento, strTipoUsuario, crm);
        history.push(memento);
    }
    public void desfazer() {
        if (!history.isEmpty()) {
            UsuarioMemento ultimoEstado = history.pop();

            this.login = ultimoEstado.getLogin();
            this.senha = ultimoEstado.getSenha();
            this.nome = ultimoEstado.getNome();
            this.cpf = ultimoEstado.getCpf();
            this.email = ultimoEstado.getEmail();
            this.sexo = ultimoEstado.getSexo();
            this.numContato = ultimoEstado.getNumContato();
            this.dataNascimento = ultimoEstado.getDataNascimento();
            this.strTipoUsuario = ultimoEstado.getStrTipoUsuario();
            this.crm = ultimoEstado.getCrm();
        }
    }
    private static class UsuarioMemento {
        private final String login;
        private final String senha;
        private final String nome;
        private final String cpf;
        private final String email;
        private final String sexo;
        private final String numContato;
        private final String dataNascimento;
        private final String strTipoUsuario;
        private final String crm;

        public UsuarioMemento(String login, String senha, String nome, String cpf, String email, String sexo, String numContato, String dataNascimento, String strTipoUsuario, String crm) {
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
        public String getLogin() {
            return login;
        }

        public String getSenha() {
            return senha;
        }

        public String getNome() {
            return nome;
        }

        public String getCpf() {
            return cpf;
        }

        public String getEmail() {
            return email;
        }

        public String getSexo() {
            return sexo;
        }

        public String getNumContato() {
            return numContato;
        }

        public String getDataNascimento() {
            return dataNascimento;
        }

        public String getStrTipoUsuario() {
            return strTipoUsuario;
        }

        public String getCrm() {
            return crm;
        }
    }
}
