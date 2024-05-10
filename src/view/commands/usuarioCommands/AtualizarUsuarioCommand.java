package view.commands.usuarioCommands;

import controller.Facade;
import exception.SexoException;
import exception.TipoUserException;
import view.commands.Command;

import java.io.IOException;
import java.sql.SQLDataException;

public class AtualizarUsuarioCommand implements Command {
        Facade fachada;
        String idUser;
        String login;
        String senha;
        String nome;
        String email;
        String numContato;


        public AtualizarUsuarioCommand(String idUser, String login, String senha, String nome, String email, String numContato) {
            this.fachada = Facade.getInstance();
            this.idUser = idUser;
            this.login = login;
            this.senha = senha;
            this.nome = nome;
            this.email = email;
            this.numContato = numContato;
        }

        @Override
        public void executar(){
            fachada.atualizaUsuarioCtrl(idUser, login, senha, nome, numContato, email);
        }
}
