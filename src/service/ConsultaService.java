package service;

import java.sql.*;
import java.util.List;
import model.Consulta;
import repository.ConsultaRepository;
import utils.Constantes;

public class ConsultaService {
    private static ConsultaService instance;

    private ConsultaService() {}

    public static ConsultaService getInstance(){
        if (instance == null) {
            instance = new ConsultaService();
        }
        return instance;
    }

    public Consulta createConsulta(Consulta consulta) throws SQLException {
        return ConsultaRepository.saveConsulta(consulta);
    }

    public Consulta readConsultaById(long idConsulta) throws SQLException {
        return ConsultaRepository.readConsultaById(idConsulta);
    }

    public List<Consulta> readAllConsultas() throws SQLException {
        return ConsultaRepository.readAllConsultas();
    }

    public Consulta updateConsulta(Consulta consulta) throws SQLException {
        return ConsultaRepository.updateConsulta(consulta);
    }

    public void deleteConsulta(long idConsulta) throws SQLException {
        ConsultaRepository.deleteConsultaById(idConsulta);
    }
}
