package controller;

import java.io.IOException;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.List;

import exception.SexoException;
import exception.TipoUserException;
import model.Consulta;
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
                                String dataNascimento,String idtipoUsuario, String crm) {

        return usuarioController.postUsuario(login, senha, nome, cpf, email, sexo, numContato, dataNascimento, idtipoUsuario, crm);
   }

   public void atualizaUsuarioCtrl(String idUser, String login, String senha, String nome, String numero, String email) {
        usuarioController.putUsuario(idUser, login, senha, nome, numero, email);
    }

    public void deletaUsuarioCtrl(String idUser)  {
        usuarioController.delUsuario(idUser);
    }
    public Usuario buscaUsuario(String idOpcao, String parametro) {
        return usuarioController.getUsuario(idOpcao, parametro);
    }

    public List<Usuario> buscaListaUsuario() {
        return usuarioController.getListaUsuario();
    }

///////// Acesso aos controllers de consulta ///////////////////////

    public Consulta adicionarNovaConsultaCtrl(String crm, String cpf,String data,String motivo){
        return consultaController.postConsulta(crm,cpf,data,motivo);
    }

    public void atualizarConsultaCtrl(String idConsulta, String data){
        consultaController.putConsulta(idConsulta, data);
    }

    public void deletaConsultaCtrl(String idConsulta){
        consultaController.delConsulta(idConsulta);
    }

    public Consulta buscaConsulta(String idOpcao, String parametro){
        return consultaController.getConsulta(idOpcao,parametro);
    }

    public List<Consulta> buscaListaConsulta(){
        return consultaController.getListaConsulta();
    }
}
