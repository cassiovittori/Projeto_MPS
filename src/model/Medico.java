package model;

//import java.time.LocalDate;

public class Medico extends Usuario {

    private String crm;

    public Medico(String login, String senha, String nome, String cpf, String email, String sexo, String numContato,
            String dataNascimento, String tipoUsuario, String crm) {
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
        this.setTipoUsuario(null);
        this.setNumContato(null);
}


    public String getCrm() {
        return crm;
    }
    public void setCrm(String crm) {
        this.crm = crm;
    }

    @Override
    public void gerarRelatorio() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'gerarRelatorio'");
    }
}
