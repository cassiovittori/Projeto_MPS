package controller;

import java.io.IOException;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.List;

import exception.SexoException;
import exception.TipoUserException;
import model.Usuario;

public class Facade {
    
    protected static Facade instance;
    protected UsuarioController usuarioController;
    protected ValidacaoController validacaoController;
    protected AuthorizationController authorizationController;
    protected RelatorioController relatorioController;
    protected ConsultaController consultaController;

    private Facade() { //aqui inicia os controllers na fachada
        this.usuarioController = UsuarioController.getInstance();
        this.validacaoController = ValidacaoController.getInstance();
        this.authorizationController = AuthorizationController.getInstance();
        this.relatorioController = RelatorioController.getInstance();
        this.consultaController = ConsultaController.getInstance();
    }

    public static Facade getInstance() {
        if (instance == null) {
            instance = new Facade();
        }
        return instance;
    }

/////////////Acesso ao controles do usuario/////////////////////////////////////////////////////////////////////////////////////////////////////
    public Usuario adicionarNovoUsuarioCtrl(String login,String senha,String nome,String cpf,String email,String sexo,String numContato,
                                String dataNascimento,String idtipoUsuario, String crm) throws SQLDataException, TipoUserException, IOException, SexoException {

        return usuarioController.postUsuario(login, senha, nome, cpf, email, sexo, numContato, dataNascimento, idtipoUsuario, crm);
   }

   public void atualizaUsuarioCtrl(String idUser, String login, String senha, String nome, String numero, String email) throws SQLDataException, TipoUserException, IOException, SexoException {
        usuarioController.putUsuario(idUser, login, senha, nome, numero, email);
    }

    public void deletaUsuarioCtrl(String idUser) throws SQLDataException, TipoUserException, IOException, SexoException {
        usuarioController.delUsuario(idUser);
    }
    public Usuario buscaUsuario(String idOpcao, String parametro) throws ClassNotFoundException, IOException, SQLException {
        return usuarioController.getUsuario(idOpcao, parametro);
    }

    public List<Usuario> buscaListaUsuario() throws ClassNotFoundException, IOException, SQLException {
        return usuarioController.getListaUsuario();
    }

    /*
    //Acesso a validação de usuario
    public void validarLoginDoUsuario(String login) {
        ValidacaoController.validarLogin(login);
   }

    public void validarSenhaDoUsuario(String senha) {
         ValidacaoController.validarSenha(senha);
    }
    */



    //public List<Usuario> obterUsuarios() throws ClassNotFoundException, IOException, SQLException {
     //   return usuarioController.obterUsuarios();
    //}

}
