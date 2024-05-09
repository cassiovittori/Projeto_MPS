package repository;

import java.util.ArrayList;
import java.util.List;
import java.util.random.RandomGenerator;

import model.Admin;
import model.Medico;
import model.Paciente;
import model.Usuario;
import utils.Constantes;

public abstract class UsuarioRepository{

    //TODOS OS SWITCHS COM IDS SÃO PARA CONTROLAR O TIPO RESPONDIDO AVALIAR MUDANÇA DEPOIS
    
    public static Usuario saveUsuario(Usuario usuario){
        System.out.println("Salvando usuario...\n");
        System.out.println(usuario.toString());
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


    public static Usuario readUsuarioParameter(String idOpcao, String parametro){
        System.out.println("Buscando usuario por parametro...");
            System.out.println("Usuario Encontrado!");
            switch (idOpcao) {
                case "2":
                    return new Admin();
                case "3":
                    return new Paciente();
                case "4":
                    return new Medico();
            }
        return null;
        
    }

    public static List<Usuario> readListUsuario(){
        System.out.println("Buscando todos os usuarios...");
        System.out.println("Lista:");
        System.out.println("Yurizin da massa");
        System.out.println("Jonas jonas jonas");
        System.out.println("Lucas do xadrez");
        System.out.println("Cassilds");
            
        List<Usuario> lista = new ArrayList<Usuario>();
        return lista;
        
    }

    public static Usuario updateUsuario(String idUser, String login, String senha, String nome, String numero, String email){
        System.out.println("Atualizando usuario de ID: " + idUser + "...");
        System.out.println("Usuario Atualizado!");
        switch (String.valueOf(idUser)) {
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
