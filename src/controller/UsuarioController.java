package controller;

import model.Usuario;
import service.UsuarioService;
import utils.Constantes;

import java.io.IOException;
import java.sql.SQLDataException;
import java.sql.SQLException;

import exception.SexoException;
import exception.TipoUserException;
import factory.FactoryAdmin;
import factory.FactoryMedico;
import factory.FactoryPaciente;

public class UsuarioController {
    private final UsuarioService usuarioService;
    private static UsuarioController instance; //cria a instancia desse controler

    private UsuarioController() { //privado, para construir em outro lugar do codigo so usando o get.instance
        this.usuarioService = UsuarioService.getInstance();
    }

    public static UsuarioController getInstance() {
        if (instance == null) {
            instance = new UsuarioController();
        }
        return instance;
    }


    public void postUsuario(String login,String senha,String nome,String cpf,String email,String sexo,String numContato,
                                String dataNascimento,String idTipoUsuario, String crm) throws SQLDataException, IOException, TipoUserException, SexoException {
                                    
        Usuario user = null;

        try{
            ValidacaoController.validarLogin(login);
            ValidacaoController.validarSenha(senha);
            ValidacaoController.validarTipoUser(idTipoUsuario);
            ValidacaoController.validarSexo(sexo);

            switch (idTipoUsuario) {
                case Constantes.ID_USER_ADMIN -> user = FactoryAdmin.criaUsuario(login, senha, nome, cpf, email, sexo, numContato, dataNascimento, Constantes.USER_ADMIN);
                case Constantes.ID_USER_MEDICO -> user = FactoryMedico.criaUsuario(login, senha, nome, cpf, email, sexo, numContato, dataNascimento, Constantes.USER_MEDICO, crm);
                case Constantes.ID_USER_PACIENTE -> user = FactoryPaciente.criaUsuario(login, senha, nome, cpf, email, sexo, numContato, dataNascimento, idTipoUsuario);
                    
            }
            usuarioService.createUsuario(user);
            
        } catch (TipoUserException | SQLDataException e) {
            System.out.println("falha no cadastro: " + e.getMessage());
        } catch (SexoException | IllegalArgumentException | SQLException e){
            System.out.println("Falha no cadastro: " + e.getMessage());
        }
        
    }

    public void getUsuario(String idOpcao, String parametro){
        
    }

    public void getListaUsuario(){

    }

    
    public void putUsuario(){

    }

    
    public void delUsuario(){

    }

    
}
