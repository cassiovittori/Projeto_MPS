import exception.SexoException;
import exception.TipoUserException;
import java.io.IOException;
import java.sql.SQLException;
import view.GerenciaUsuarioView;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException, TipoUserException, SexoException {
        

        //////CENARIO 1 PACIENTE INDO SE AUTOCADASTRAR///////////

        GerenciaUsuarioView gerenciaUsuarioView = new GerenciaUsuarioView();

        gerenciaUsuarioView.addNovoUsuario();

        
        
    }
}
