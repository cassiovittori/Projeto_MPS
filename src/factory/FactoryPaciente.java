package factory;

import model.Paciente;
import model.Usuario;

public class FactoryPaciente {

    public static Usuario criaUsuario(String login,String senha,String nome,String cpf,String email,String sexo,String numContato, String dataNascimento,String idTipoUsuario) {
        
        return new Paciente(login, senha, nome, cpf, email, sexo, numContato,  dataNascimento, idTipoUsuario);

    }
    
}
