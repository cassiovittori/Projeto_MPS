package controller;

import exception.TipoRelatorioException;
import java.util.List;
import model.BuilderRelatorioCorpo;
import model.Consulta;
import model.Medico;
import model.Paciente;
import model.Relatorio;
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
    
    public List<Medico> buscarListaMedico() {
        return usuarioController.getListaMedico();
    }

    public List<Paciente> buscarListaPaciente() {
        return usuarioController.getListaPaciente();
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

    
    ////////////////Acesso aos controllers de relatorio//////////////

    public Relatorio adicionarNovoRelatorioCtrl(String relatorioTipo, String titulo, String descricao,boolean medico, boolean paciente, boolean consulta, String data, String nome) throws TipoRelatorioException{
       
         BuilderRelatorioCorpo corpo = new BuilderRelatorioCorpo();
       
       
        if(paciente){  List<Paciente> pacientes = usuarioController.getListaPaciente();
        
            corpo.comPacientes(pacientes);
        
        } if(medico) {
        
            List<Medico> medicos = usuarioController.getListaMedico();
            corpo.comMedicos(medicos);
        
        } if(consulta){
        
            List<Consulta> consultas = consultaController.getListaConsulta();
            corpo.comConsultas(consultas);
        
        }

        return relatorioController.postRelatorio(relatorioTipo, titulo, descricao,corpo, data, nome);
    
    }

    public boolean deleteRelatorioCtrl(String titulo){
        return relatorioController.deleteRelatorio(titulo);
    }

    public List<Relatorio> searchRelatorioByParam(String tipoParametro, String parametro){
        
        return relatorioController.readRelatorioByParametro(tipoParametro, parametro);

    }
    
}

