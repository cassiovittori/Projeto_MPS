package model;

import java.time.LocalDate;

public class Admin extends Usuario {

    public Admin(String login, String senha, String nome, String cpf, String email, String sexo, String numContato,
            String dataNascimento, String tipoUsuario) {
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

    

    public Admin() {
        this.setLogin(null);
        this.setSenha(null);
        this.setNome(null);
        this.setCpf(null);
        this.setDataNascimento(null);
        this.setEmail(null);
        this.setSexo(null);
        this.setTipoUsuario(null);
        this.setNumContato(null);
}

    

}
