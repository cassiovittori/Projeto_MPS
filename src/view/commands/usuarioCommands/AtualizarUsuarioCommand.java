package view.commands.usuarioCommands;

import controller.Facade;
import view.commands.Command;

import java.util.Stack;

public class AtualizarUsuarioCommand implements Command {
    private final Facade fachada;
    private final String idUser;
    private final String newLogin;
    private final String newSenha;
    private final String newNome;
    private final String newEmail;
    private final String newNumContato;

    private Stack<UsuarioMemento> history = new Stack<>();

    public AtualizarUsuarioCommand(String idUser, String newLogin, String newSenha, String newNome, String newEmail, String newNumContato) {
        this.fachada = Facade.getInstance();
        this.idUser = idUser;
        this.newLogin = newLogin;
        this.newSenha = newSenha;
        this.newNome = newNome;
        this.newEmail = newEmail;
        this.newNumContato = newNumContato;
    }

    @Override
    public void executar() {
        salvarEstado();

        fachada.atualizaUsuarioCtrl(idUser, newLogin, newSenha, newNome, newNumContato, newEmail);
    }

    private void salvarEstado() {
        UsuarioMemento memento = new UsuarioMemento(idUser, newLogin, newSenha, newNome, newEmail, newNumContato);
        history.push(memento);
    }

    public void desfazer() {
        if (!history.isEmpty()) {
            UsuarioMemento ultimoEstado = history.pop();
            fachada.atualizaUsuarioCtrl(ultimoEstado.getIdUser(), ultimoEstado.getLogin(), ultimoEstado.getSenha(),
                    ultimoEstado.getNome(), ultimoEstado.getEmail(), ultimoEstado.getNumContato());
        }
    }

    private static class UsuarioMemento {
        private final String idUser;
        private final String login;
        private final String senha;
        private final String nome;
        private final String email;
        private final String numContato;

        public UsuarioMemento(String idUser, String login, String senha, String nome, String email, String numContato) {
            this.idUser = idUser;
            this.login = login;
            this.senha = senha;
            this.nome = nome;
            this.email = email;
            this.numContato = numContato;
        }

        public String getIdUser() {
            return idUser;
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

        public String getEmail() {
            return email;
        }

        public String getNumContato() {
            return numContato;
        }
    }
}
