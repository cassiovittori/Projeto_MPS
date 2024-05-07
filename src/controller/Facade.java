package controller;

import exception.SexoException;
import exception.TipoUserException;
import java.io.IOException;
import java.sql.SQLDataException;
import java.sql.SQLException;
//import model.Usuario;

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

    public void deletaUsuarioCtrl(String idUser){

        usuarioController.delUsuario();

    }

    public void atualizaUsuarioCtrl(String idUser,String login,String senha,String nome,String numero,String email){

        usuarioController.putUsuario();

    }

    public void buscaListaUsuario(){

        usuarioController.getListaUsuario();

    }

    //Acesso a validação de usuario
    public void validarLoginDoUsuario(String login) {
        ValidacaoController.validarLogin(login);
   }

    public void validarSenhaDoUsuario(String senha) {
         ValidacaoController.validarSenha(senha);
    }

    /////////////Acesso ao controles da entidade relatorio/////////////////////////////////////////////////////////////////////////////////////////////////////

    public void adicionarNovoRelatorioCtrl(String usuarios, String titulo, String descricao,String dataCriacao,String autor){

        relatorioController.adicionarNovoRelatorio(usuarios,titulo, descricao, dataCriacao, autor);

    }

    public void buscarRelatorioCtrl(Long idRelatorio){

        relatorioController.buscarRelatorio(idRelatorio);

    }

    public void atualizarRelatorioCtrl(Long idRelatorio,String novoTitulo,String novaDescricao){

        relatorioController.atualizarRelatorio(idRelatorio, novoTitulo, novaDescricao);

    }

    public void deletarRelatorioCtrl(Long idRelatorio){

        relatorioController.deletarRelatorio(idRelatorio);

    }

    //public List<Usuario> obterUsuarios() throws ClassNotFoundException, IOException, SQLException {
     //   return usuarioController.obterUsuarios();
    //}


}
