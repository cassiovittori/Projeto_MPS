package controller.factory;

import model.Medico;
import model.Usuario;

public class MedicoFactory implements InterfaceFactory{

    @Override
    public static Usuario criaUsuario(String tipo, String login, String senha) {
       return new Medico(login, senha);
        //throw new UnsupportedOperationException("Unimplemented method 'criaUsuario'");
    }

}