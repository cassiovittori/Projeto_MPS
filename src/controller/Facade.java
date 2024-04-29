package controller;

import java.io.IOException;
import java.sql.SQLDataException;
import java.sql.SQLException;
import exception.SexoException;
import exception.TipoUserException;

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
    public void adicionarNovoUsuarioCtrl(String login,String senha,String nome,String cpf,String email,String sexo,String numContato,
                                String dataNascimento,String idtipoUsuario, String crm) throws SQLDataException, TipoUserException, IOException, SexoException {

        usuarioController.postUsuario(login, senha, nome, cpf, email, sexo, numContato, dataNascimento, idtipoUsuario, crm);
   }

    public void mostrarTodosUsuarios() throws ClassNotFoundException, IOException, SQLException {
        usuarioController.getListaUsuario();
    }

    public void buscaUsuario(String idOpcao, String parametro) throws ClassNotFoundException, IOException, SQLException {
        usuarioController.getUsuario(idOpcao, parametro);
    }

    //Acesso a validação de usuario
    public void validarLoginDoUsuario(String login) {
        ValidacaoController.validarLogin(login);
   }

    public void validarSenhaDoUsuario(String senha) {
         ValidacaoController.validarSenha(senha);
    }

    //public List<Usuario> obterUsuarios() throws ClassNotFoundException, IOException, SQLException {
     //   return usuarioController.obterUsuarios();
    //}

}
