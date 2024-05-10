package model;

import java.io.Serializable;
import interfaces.IntUsuario;
import utils.enums.TipoUsuarioEnum;

public abstract class Usuario implements Serializable, IntUsuario {

    private static final long serialVersionUID = 1L;

    private Long idUsuario;
    private String login;
    private String senha;
    private String nome;
    private String cpf;
    private String email;
    private String sexo;
    private String numContato;
    private String dataNascimento;
    private TipoUsuarioEnum tipoUsuario;



    public Long getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
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
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNumContato() {
        return numContato;
    }
    public void setNumContato(String numContato) {
        this.numContato = numContato;
    }
    public String getSexo() {
        return sexo;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    public TipoUsuarioEnum getTipoUsuario() {
        return tipoUsuario;
    }
    public void setTipoUsuario(TipoUsuarioEnum tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario=" + idUsuario +
                ", login='" + login + '\'' +
                ", senha='" + senha + '\'' +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                ", sexo='" + sexo + '\'' +
                ", numContato='" + numContato + '\'' +
                ", dataNascimento='" + dataNascimento + '\'' +
                ", tipoUsuario=" + tipoUsuario +
                '}';
    }
}
