package controller.factory;

import model.Usuario;

public interface InterfaceFactory {
    Usuario criaUsuario(String tipo, String login, String Senha);
}
