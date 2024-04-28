package model;

import java.io.Serializable;
import java.time.LocalDate;
import interfaces.IntUsuario;

public abstract class Usuario implements Serializable, IntUsuario {

    private static final long serialVersionUID = 1L;

    private Long idUsuario;
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
    }

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
    public Long getCpf() {
        return cpf;
    }
    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(LocalDate dataNascimento) {
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
    public String getTipoUsuario() {
        return tipoUsuario;
    }
    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}
