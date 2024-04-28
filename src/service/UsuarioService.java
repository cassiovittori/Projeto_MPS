package service;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Usuario;
import utils.Constantes;

public class UsuarioService {
    private List<Usuario> listaUsuarios;
    private String arquivoUsuarios;
    private String urlBanco;
    private Scanner scanner;
    private static UsuarioService instance;

    private UsuarioService(){
        this.listaUsuarios = new ArrayList<>();
        this.arquivoUsuarios = Constantes.ARQUIVO_USERS;
        this.urlBanco = Constantes.URL_BANCO;
        this.scanner = new Scanner(System.in);
    }

    public static UsuarioService getInstance(){
        if (instance == null) {
            instance = new UsuarioService();
        }
        return instance;
    }

    public void adicionarUsuario(Usuario usuario) throws IOException, SQLException {
  
        listaUsuarios.add(usuario);
        salvarUsuariosEmArquivo(); //pq ele usa uma lista se é passado 1 por 1 ? 
        salvarUsuarioNoBancoDeDados(usuario);
    }

    public List<Usuario> getUsuariosArquivo() throws IOException, ClassNotFoundException, SQLException {
        try {
        carregarUsuariosDoArquivo();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao obter usuários: " + e.getMessage());
            return null;
        }

        return listaUsuarios;
    }

    private void salvarUsuariosEmArquivo() throws IOException {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(arquivoUsuarios))) {
            outputStream.writeObject(listaUsuarios);
        }
    }

    @SuppressWarnings("unchecked")
    private void carregarUsuariosDoArquivo() throws IOException, ClassNotFoundException {
        File arquivo = new File(arquivoUsuarios);
        if (arquivo.exists()) {
            try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(arquivoUsuarios))) {
                listaUsuarios = (List<Usuario>) inputStream.readObject();
            }
        }
    }

    private void salvarUsuarioNoBancoDeDados(Usuario usuario) throws SQLException {
        try (Connection connection = DriverManager.getConnection(urlBanco)) {
            String sql = "INSERT INTO usuarios (login, senha) VALUES (?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, usuario.getLogin());
                statement.setString(2, usuario.getSenha());
                statement.executeUpdate();
            }
        }
    }

    public List<Usuario> getUsuariosDoBancoDeDados() throws SQLException {
        List<Usuario> usuarios = null;
        /*List<Usuario> usuarios = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url)) {
            String sql = "SELECT * FROM usuarios";
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(sql)) {
                while (resultSet.next()) {
                    String login = resultSet.getString("login");
                    String senha = resultSet.getString("senha");
                    usuarios.add(new Usuario(login, senha));
                }
            }
        }
        */
        return usuarios;
    }
}
