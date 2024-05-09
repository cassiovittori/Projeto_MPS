package model;

import utils.Enums.TipoUsuarioEnum;

public class Paciente extends Usuario {

    public Paciente(String login, String senha, String nome, String cpf, String email, String sexo, String numContato,
            String dataNascimento, TipoUsuarioEnum tipoUsuario) {
        this.setLogin(login);
        this.setSenha(senha);
        this.setNome(nome);
        this.setCpf(cpf);
        this.setDataNascimento(dataNascimento);
        this.setEmail(email);
        this.setSexo(sexo);
        this.setTipoUsuario(tipoUsuario);
        this.setNumContato(numContato);
    }

    public Paciente() {
        this.setLogin(null);
        this.setSenha(null);
        this.setNome(null);
        this.setCpf(null);
        this.setDataNascimento(null);
        this.setEmail(null);
        this.setSexo(null);
        this.setTipoUsuario(TipoUsuarioEnum.PACIENTE);
        this.setNumContato(null);
    }

    @Override
    public void gerarRelatorio() {

    }
}
