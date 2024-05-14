package repository;

import java.util.ArrayList;
import java.util.List;
import java.util.random.RandomGenerator;
import javax.print.attribute.standard.Media;

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
        System.out.println("Jonas Xoninhas Jonaos");
        System.out.println("Lucas do xadrez");
        System.out.println("Cassilds");
            
        List<Usuario> lista = new ArrayList<Usuario>();
        return lista;
        
    }

    public static List<Paciente> readListaPaciente(){
        System.out.println("Buscando todos os pacientes...");
        System.out.println("Lista:");
        System.out.println("Yurizin da massa com dengue");
        System.out.println("Jonas Xoninhas Jonaos com catapora");
        System.out.println("Lucas do xadrez com cachumba");
        System.out.println("Cassilds com bolsonarismo");
            
        List<Paciente> lista = new ArrayList<Paciente>();
        return lista;
        
    }

    public static List<Medico> readListaMedico(){
        System.out.println("Buscando todos os usuarios...");
        System.out.println("Lista:");
        System.out.println("Yurizin da massa");
        System.out.println("Jonas Xoninhas Jonaos");
        System.out.println("Lucas do xadrez");
        System.out.println("Cassilds");
            
        List<Medico> lista = new ArrayList<Medico>();
        return lista;
        
    }

    public static Usuario updateUsuario(String idUser, String login, String senha, String nome, String numero, String email){
        System.out.println("Buscando usuario de ID: " + idUser + "...");
        System.out.println("Alterando Login para: " + login);
        System.out.println("Alterando Senha para: " + senha);
        System.out.println("Alterando Nome para: " + nome);
        System.out.println("Alterando Numero para: " + numero);
        System.out.println("Alterando Email para: " + email);
        System.out.println("Usuario Atualizado com SUCESSO!");
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
