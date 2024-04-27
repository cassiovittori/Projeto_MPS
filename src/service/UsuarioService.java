package service;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Usuario;

public class UsuarioService {
    private List<Usuario> listaUsuarios = new ArrayList<>();
    private String arquivoUsuarios = "usuarios.bin";
    private String url = "PLACEHOLDER PARA O DIRETORIO DO BD";

    public void adicionarUsuario(Usuario usuario) throws IOException, SQLException {
        listaUsuarios.add(usuario);
        salvarUsuariosEmArquivo(); //pq ele usa uma lista se é passado 1 por 1 ? 
        salvarUsuarioNoBancoDeDados(usuario);
    }

    public List<Usuario> getUsuarios() throws IOException, ClassNotFoundException, SQLException {
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
        try (Connection connection = DriverManager.getConnection(url)) {
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
