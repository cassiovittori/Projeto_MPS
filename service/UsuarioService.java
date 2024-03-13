package service;

import java.util.ArrayList;
import java.util.List;
import model.Usuario;

public class UsuarioService {
    private List<Usuario> listaUsuarios = new ArrayList<>();

    public void adicionarUsuario(Usuario usuario) {
        listaUsuarios.add(usuario);
        System.out.println("Usuário adicionado com sucesso!");
    }

    public List<Usuario> getUsuarios() {
        return listaUsuarios;
    }
}
