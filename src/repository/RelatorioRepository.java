package repository;

import java.sql.*;
import model.Relatorio;
import utils.Constantes;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import model.Relatorio;
import utils.Constantes;

public class RelatorioRepository {

    public static Relatorio saveRelatorio(Relatorio relatorio) throws SQLException {
        try (Connection connection = DriverManager.getConnection(Constantes.URL_BANCO)) {
            String sql = "INSERT INTO relatorios (titulo, descricao, data_criacao, autor) VALUES (?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                statement.setString(1, relatorio.getTitulo());
                statement.setString(2, relatorio.getDescricao());
                statement.setString(3, relatorio.getDataCriacao());
                statement.setString(4, relatorio.getAutor());
                int affectedRows = statement.executeUpdate();
                if (affectedRows == 0) {
                    throw new SQLException("Creating relatorio failed, no rows affected.");
                }
                try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        relatorio.setIdRelatorio(generatedKeys.getLong(1));
                    } else {
                        throw new SQLException("Creating relatorio failed, no ID obtained.");
                    }
                }
            }
        }
        return relatorio;
    }

    public static Relatorio readRelatorioById(Long idRelatorio) throws SQLException {
        Relatorio relatorio = null;
        try (Connection connection = DriverManager.getConnection(Constantes.URL_BANCO)) {
            String sql = "SELECT * FROM relatorios WHERE id_relatorio = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setLong(1, idRelatorio);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        relatorio = new Relatorio(
                            resultSet.getString("titulo"),
                            resultSet.getString("descricao"),
                            resultSet.getString("data_criacao"),
                            resultSet.getString("autor")
                        );
                        relatorio.setIdRelatorio(resultSet.getLong("id_relatorio"));
                    }
                }
            }
        }
        return relatorio;
    }

    public static List<Relatorio> readAllRelatorios() throws SQLException {
        List<Relatorio> relatorios = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(Constantes.URL_BANCO)) {
            String sql = "SELECT * FROM relatorios";
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(sql)) {
                while (resultSet.next()) {
                    Relatorio relatorio = new Relatorio(
                        resultSet.getString("titulo"),
                        resultSet.getString("descricao"),
                        resultSet.getString("data_criacao"),
                        resultSet.getString("autor")
                    );
                    relatorio.setIdRelatorio(resultSet.getLong("id_relatorio"));
                    relatorios.add(relatorio);
                }
            }
        }
        return relatorios;
    }

    public static Relatorio updateRelatorio(Long idRelatorio, String titulo, String descricao) throws SQLException {
        try (Connection connection = DriverManager.getConnection(Constantes.URL_BANCO)) {
            String sql = "UPDATE relatorios SET titulo = ?, descricao = ? WHERE id_relatorio = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, titulo);
                statement.setString(2, descricao);
                statement.setLong(3, idRelatorio);
                statement.executeUpdate();
            }
        }
        return readRelatorioById(idRelatorio);
    }

    public static void deleteRelatorioById(Long idRelatorio) throws SQLException {
        try (Connection connection = DriverManager.getConnection(Constantes.URL_BANCO)) {
            String sql = "DELETE FROM relatorios WHERE id_relatorio = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setLong(1, idRelatorio);
                statement.executeUpdate();
            }
        }
    }
}
