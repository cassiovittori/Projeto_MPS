 package factory;

import model.Paciente;
import model.Usuario;

public class PacienteFactory implements InterfaceFactory{

    @Override
    public Usuario criaUsuario(String tipo, String login, String senha) {
       return new Paciente(login, senha);
        //throw new UnsupportedOperationException("Unimplemented method 'criaUsuario'");
    }

}