package factory;

import model.Medico;
import model.Usuario;

public class FactoryMedico {

    public static Usuario criaUsuario(String login,String senha,String nome,String cpf,String email,String sexo,String numContato, String dataNascimento,String idTipoUsuario, String crm) {
        
        return new Medico(login, senha, nome, cpf, email, sexo, numContato,  dataNascimento, idTipoUsuario, crm);

    }

}
