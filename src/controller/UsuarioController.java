package controller;

import model.*;
import repository.UsuarioRepository;
import service.UsuarioService;
import utils.Constantes;

import java.io.IOException;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import exception.SexoException;
import exception.TipoUserException;
import utils.Enums.TipoUsuarioEnum;

public class UsuarioController {
    private UsuarioService usuarioService;
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


    public Usuario postUsuario(String login,String senha,String nome,String cpf,String email,String sexo,String numContato,
                                String dataNascimento,String strTipoUsuario, String crm) throws SQLDataException, IOException, TipoUserException, SexoException {

        try{
            ValidacaoController.validarLogin(login);
            ValidacaoController.validarSenha(senha);
            ValidacaoController.validarSexo(sexo);

            int idTipoUsuario = Integer.parseInt(strTipoUsuario);
            Usuario usuario = UsuarioFactory.criarUsuario(TipoUsuarioEnum.comId(idTipoUsuario),login,senha,nome,cpf,email,sexo,numContato,dataNascimento,crm);

            return usuarioService.createUsuario(usuario);
            
        } catch (TipoUserException e) {
            System.out.println("falha no cadastro: " + e.getMessage());
        } catch (SQLDataException e){
            System.out.println("falha no cadastro: " + e.getMessage());
        } catch (SexoException e){
            System.out.println("Falha no cadastro: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Falha no cadastro: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Falha no cadastro: " + e.getMessage());
        }
        return null;
    }

    public Usuario getUsuario(String idOpcao, String parametro){
           switch (idOpcao) {
            case Constantes.ID_OPCAO_1:
                return usuarioService.readUsuarioId(Long.valueOf(parametro));
            default :
                return usuarioService.readUsuario(idOpcao, parametro);
           }
    }

    public List<Usuario> getListaUsuario(){
        return usuarioService.readListUsuario();
    }

    
    public void putUsuario(String idUser, String login, String senha, String nome, String numero, String email) throws SQLDataException, NumberFormatException{
        usuarioService.updateUsuario(idUser, login, senha, nome,numero, email);
        
    }

    
    public void delUsuario(String idUser){
        usuarioService.deleteUsuario(Long.valueOf(idUser));
    }

    
}
