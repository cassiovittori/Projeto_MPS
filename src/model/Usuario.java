package model;

import java.io.Serializable;
import java.time.LocalDate;
import interfaces.IntUsuario;

public abstract class Usuario implements Serializable, IntUsuario {

    private static final long serialVersionUID = 1L;

    private String login;
    private String senha;
    private String nome;
    private Long cpf;
    private String email;
    private String sexo;
    private String numContato;
    private LocalDate dataNascimento;
    private String tipoUsuario;

    public Usuario(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
