package repository;

import java.util.random.RandomGenerator;

import model.Admin;
import model.Medico;
import model.Paciente;
import model.Usuario;
import utils.Constantes;

public abstract class UsuarioRepository{

    //TODOS OS SWITCHS COM IDS SÃO PARA CONTROLAR O TIPO RESPONDIDO AVALIAR MUDANÇA DEPOIS
    
    public static Usuario saveUsuario(Usuario usuario){
        System.out.println("Salvando usuario...");
        switch (String.valueOf(usuario.getTipoUsuario())) {
            case Constantes.USER_ADMIN:
                System.out.println("Usuario: " + usuario.getNome() 
                    + "de CPF:" + usuario.getCpf() 
                        + "Salvo com SUCESSO!" + usuario.getTipoUsuario());
                return new Admin();
            case Constantes.USER_PACIENTE:
                System.out.println("Usuario: " + usuario.getNome() 
                + "de CPF:" + usuario.getCpf() 
                    + "Salvo com SUCESSO!" + usuario.getTipoUsuario());
                return new Paciente();
            case Constantes.USER_MEDICO:
                System.out.println("Usuario: " + usuario.getNome() 
                + "de CPF:" + usuario.getCpf() 
                    + "Salvo com SUCESSO!" + usuario.getTipoUsuario());
                return new Medico();
        }
        return null;
        
    }

    public static Usuario readUsuarioById(Long idUsuario){
        System.out.println("Buscando usuario de ID: " + idUsuario + "...");
            System.out.println("Usuario Encontrado!");
            switch (String.valueOf(idUsuario)) {
                case "1":
                    return new Admin();
                case "2":
                    return new Paciente();
                case "3":
                    return new Medico();
            }
        return null;
        
    }

    public static Usuario updateUsuarioById(Long idUsuario){
        System.out.println("Atualizando usuario de ID: " + idUsuario + "...");
        System.out.println("Usuario Atualizado!");
        switch (String.valueOf(idUsuario)) {
            case "1":
                return new Admin();
            case "2":
                return new Paciente();
            case "3":
                return new Medico();
        }
        return null;
        
    }

    public static void deleteUsuarioById(long idUsuario){
        System.out.println("Buscando usuario...");
        System.out.println("Deletando usuario de ID: " + idUsuario + "...");
        System.out.println("Usuario deletado com SUCESSO!");    
        
    }

    public static long SequenceIdUsuario() {

        return Constantes.ID_USUARIO_SEQUENCE_VAL;
    }

}
