import java.io.IOException;
import java.sql.SQLException;

import view.UsuarioView;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException {
        // Facade implementado ERRADO, precisa ajustar
        //Facade usuarioFacade = Facade.getInstance();
        ///usuarioFacade.executarTudo();
        UsuarioView userView = new UsuarioView();
        userView.obterNovoUsuario();
        userView.mostrarUsuarios();
        
    }
}
