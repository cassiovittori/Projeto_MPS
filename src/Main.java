import java.io.IOException;
import java.sql.SQLException;

import exception.SexoException;
import exception.TipoUserException;
import view.GerenciaUsuarioView;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException, TipoUserException, SexoException {
        // Facade implementado ERRADO, precisa ajustar
        //Facade usuarioFacade = Facade.getInstance();
        ///usuarioFacade.executarTudo();

        //////CENARIO 1 PACIENTE INDO SE AUTOCADASTRAR///////////

        GerenciaUsuarioView gerenciaUsuarioView = new GerenciaUsuarioView();

        gerenciaUsuarioView.addNovoUsuario();

        
        
    }
}
