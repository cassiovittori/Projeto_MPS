package controller;

import model.Usuario;
import service.UsuarioService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class UsuarioController {
    private UsuarioService usuarioService;
    private static UsuarioController instance; //cria a instancia desse controler

    public UsuarioController() { //privado, para construir em outro lugar do codigo so usando o get.instance
        this.usuarioService = new UsuarioService();
    }


    public void adicionarUsuario(String loginUser, String senhaUser) {
      /*
        try {
            ValidacaoController.validarLogin(loginUser);
            ValidacaoController.validarSenha(senhaUser);
            Usuario novoUser = new Usuario(loginUser, senhaUser);
            usuarioService.adicionarUsuario(novoUser);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao adicionar usuário: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Erro ao adicionar usuário: " + e.getMessage());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
         */
    }

    public List<Usuario> obterUsuarios() throws ClassNotFoundException, IOException, SQLException {
       
            return usuarioService.getUsuarios();
        
    }

    public static UsuarioController getInstance() {
            if (instance == null) {
                instance = new UsuarioController();
            }
            return instance;
      /* esse erro aqui gerou automaticamente pelo visual code acho que o tratamento de erro n ta certo 
       throw new UnsupportedOperationException("Unimplemented method 'getInstance'");
       */ 
    }
    
}
