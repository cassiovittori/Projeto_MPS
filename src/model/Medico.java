package model;

import utils.Enums.TipoUsuarioEnum;

import java.time.LocalDate;

public class Medico extends Usuario {

    private String crm;

    public Medico(String login, String senha, String nome, String cpf, String email, String sexo, String numContato,
                  String dataNascimento, TipoUsuarioEnum tipoUsuario, String crm) {
        this.setLogin(login);
        this.setSenha(senha);
        this.setNome(nome);
        this.setCpf(cpf);
        this.setDataNascimento(dataNascimento);
        this.setEmail(email);
        this.setSexo(sexo);
        this.setTipoUsuario(tipoUsuario);
        this.setNumContato(numContato);
        this.setCrm(crm);
    }

    public Medico() {
        this.setLogin(null);
        this.setSenha(null);
        this.setNome(null);
        this.setCpf(null);
        this.setDataNascimento(null);
        this.setEmail(null);
        this.setSexo(null);
        this.setTipoUsuario(TipoUsuarioEnum.MEDICO);
        this.setNumContato(null);
}


    public String getCrm() {
        return crm;
    }
    public void setCrm(String crm) {
        this.crm = crm;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario=" + super.getIdUsuario() +
                ", login='" + super.getLogin()+ '\'' +
                ", senha='" + super.getSenha() + '\'' +
                ", nome='" + super.getNome() + '\'' +
                ", cpf='" + super.getCpf() + '\'' +
                ", email='" + super.getEmail() + '\'' +
                ", sexo='" + super.getSexo() + '\'' +
                ", numContato='" + super.getNumContato() + '\'' +
                ", dataNascimento='" + super.getDataNascimento() + '\'' +
                ", tipoUsuario=" + super.getTipoUsuario() + '\'' +
                "crm='" + crm + '\'' +
                '}';
    }

    @Override
    public void gerarRelatorio() {

    }
}
