package controller;

import model.Usuario;
import service.UsuarioService;
import view.UsuarioView;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class UsuarioController {
    private UsuarioService usuarioService;
    private UsuarioView usuarioView;

    public UsuarioController(UsuarioService usuarioService, UsuarioView usuarioView) {
        this.usuarioService = usuarioService;
        this.usuarioView = usuarioView;
    }

    public void adicionarUsuario() {
        Usuario novoUsuario = usuarioView.obterNovoUsuario();
        usuarioService.adicionarUsuario(novoUsuario);
    }

    public void mostrarUsuarios() {
        List<Usuario> usuarios = usuarioService.getUsuarios();
        usuarioView.mostrarUsuarios(usuarios);
    }
}