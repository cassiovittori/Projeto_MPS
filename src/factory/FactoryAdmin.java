package factory;

import model.Admin;
import model.Usuario;

public class FactoryAdmin{

    public static Usuario criaUsuario(String login,String senha,String nome,String cpf,String email,String sexo,String numContato, String dataNascimento,String idTipoUsuario) {
       
        return new Admin(login, senha, nome, cpf, email, sexo, numContato,  dataNascimento, idTipoUsuario);

    }

}
