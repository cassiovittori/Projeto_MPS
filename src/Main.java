import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import exception.SexoException;
import exception.TipoUserException;
import view.consoleStates.MenuConsoleState;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException, TipoUserException, SexoException {
        // Facade implementado ERRADO, precisa ajustar
        //Facade usuarioFacade = Facade.getInstance();
        ///usuarioFacade.executarTudo();

        //////CENARIO 1 PACIENTE INDO SE AUTOCADASTRAR///////////

        Scanner scanner = new Scanner(System.in);

        new MenuConsoleState().montarTela(scanner);

        //GerenciaUsuarioView gerenciaUsuarioView = new GerenciaUsuarioView();

        //gerenciaUsuarioView.addNovoUsuario();

        
        
    }
}
