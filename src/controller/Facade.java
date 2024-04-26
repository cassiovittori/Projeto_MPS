package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import model.Usuario;

public class Facade {
    
    protected static Facade instance;
    protected UsuarioController usuarioController;
    protected ValidacaoController validacaoController;

    private Facade() { //aqui inicia os controllers na fachada
        this.usuarioController = UsuarioController.getInstance();
        this.validacaoController = ValidacaoController.getInstance();
    }

    public static Facade getInstance() {
        if (instance == null) {
            instance = new Facade();
        }
        return instance;
    }

    //Acesso ao controles do usuario
    public void adicionarNovoUsuario(String novoLogin, String novaSenha) {
        usuarioController.adicionarUsuario(novoLogin, novaSenha);
   }

   public void mostrarTodosUsuarios() throws ClassNotFoundException, IOException, SQLException {
       usuarioController.obterUsuarios();
   }

    //Acesso a validação de usuario
    public void validarLoginDoUsuario(String login) {
        ValidacaoController.validarLogin(login);
   }

    public void validarSenhaDoUsuario(String senha) {
         ValidacaoController.validarSenha(senha);
    }

    public List<Usuario> obterUsuarios() throws ClassNotFoundException, IOException, SQLException {
        return usuarioController.obterUsuarios();
    }

}
