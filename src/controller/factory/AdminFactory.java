package factory;

import model.Usuario;
import model.Admin;

public class AdminFactory implements InterfaceFactory{

    @Override
    public Usuario criaUsuario(String tipo, String login, String senha) {
       return new Admin(login, senha);
        //throw new UnsupportedOperationException("Unimplemented method 'criaUsuario'");
    }

}