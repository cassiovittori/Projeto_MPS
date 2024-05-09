package model;

import exception.TipoUserException;
import utils.Enums.TipoUsuarioEnum;

public class UsuarioFactory {
    public static Usuario criarUsuario(TipoUsuarioEnum tipo,String login,String senha,String nome,String cpf,String email,String sexo,String numContato,
                                       String dataNascimento, String crm) throws TipoUserException {
        switch (tipo){
            case ADMIN:
                return new Admin(login,senha,nome,cpf,email,sexo,numContato,dataNascimento,tipo);
            case MEDICO:
                return new Medico(login,senha,nome,cpf,email,sexo,numContato,dataNascimento,tipo,crm);
            case PACIENTE:
                return new Paciente(login,senha,nome,cpf,email,sexo,numContato,dataNascimento,tipo);
            default:
                throw new TipoUserException("O tipo de usuario passado é invalido");
        }
    }
}
