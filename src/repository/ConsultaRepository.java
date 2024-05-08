package repository;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.Consulta;
import utils.Constantes;

public class ConsultaRepository {

    public static Consulta saveConsulta(Consulta consulta) throws SQLException {
        try (Connection connection = DriverManager.getConnection(Constantes.URL_BANCO)) {
            String sql = "INSERT INTO consultas (id_consulta, cpf_paciente, crm_medico, data_consulta, motivo_consulta) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                statement.setLong(1, consulta.getIdConsulta());
                statement.setString(2, consulta.getCpfPaciente());
                statement.setString(3, consulta.getCrmMedico());
                statement.setDate(4, Date.valueOf(consulta.getDataConsulta()));
                statement.setString(5, consulta.getMotivoConsulta());
                int affectedRows = statement.executeUpdate();
                if (affectedRows == 0) {
                    throw new SQLException("Creating consulta failed, no rows affected.");
                }
            }
        }
        return consulta;
    }

    public static Consulta readConsultaById(long idConsulta) throws SQLException {
        Consulta consulta = null;
        try (Connection connection = DriverManager.getConnection(Constantes.URL_BANCO)) {
            String sql = "SELECT * FROM consultas WHERE id_consulta = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setLong(1, idConsulta);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        consulta = new Consulta();
                        consulta.setIdConsulta(resultSet.getLong("id_consulta"));
                        consulta.setCpfPaciente(resultSet.getString("cpf_paciente"));
                        consulta.setCrmMedico(resultSet.getString("crm_medico"));
                        consulta.setDataConsulta(resultSet.getDate("data_consulta").toLocalDate());
                        consulta.setMotivoConsulta(resultSet.getString("motivo_consulta"));
                    }
                }
            }
        }
        return consulta;
    }

    public static List<Consulta> readAllConsultas() throws SQLException {
        List<Consulta> consultas = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(Constantes.URL_BANCO)) {
            String sql = "SELECT * FROM consultas";
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(sql)) {
                while (resultSet.next()) {
                    Consulta consulta = new Consulta();
                    consulta.setIdConsulta(resultSet.getLong("id_consulta"));
                    consulta.setCpfPaciente(resultSet.getString("cpf_paciente"));
                    consulta.setCrmMedico(resultSet.getString("crm_medico"));
                    consulta.setDataConsulta(resultSet.getDate("data_consulta").toLocalDate());
                    consulta.setMotivoConsulta(resultSet.getString("motivo_consulta"));
                    consultas.add(consulta);
                }
            }
        }
        return consultas;
    }

    public static Consulta updateConsulta(Consulta consulta) throws SQLException {
        try (Connection connection = DriverManager.getConnection(Constantes.URL_BANCO)) {
            String sql = "UPDATE consultas SET cpf_paciente = ?, crm_medico = ?, data_consulta = ?, motivo_consulta = ? WHERE id_consulta = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, consulta.getCpfPaciente());
                statement.setString(2, consulta.getCrmMedico());
                statement.setDate(3, Date.valueOf(consulta.getDataConsulta()));
                statement.setString(4, consulta.getMotivoConsulta());
                statement.setLong(5, consulta.getIdConsulta());
                statement.executeUpdate();
            }
        }
        return readConsultaById(consulta.getIdConsulta());
    }

    public static void deleteConsultaById(long idConsulta) throws SQLException {
        try (Connection connection = DriverManager.getConnection(Constantes.URL_BANCO)) {
            String sql = "DELETE FROM consultas WHERE id_consulta = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setLong(1, idConsulta);
                statement.executeUpdate();
            }
        }
    }
}
