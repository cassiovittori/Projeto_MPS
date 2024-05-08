<<<<<<< HEAD
package service;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Relatorio;
import repository.RelatorioRepository;
import utils.Constantes;

public class RelatorioService {
    private List<Relatorio> listaRelatorios;
    private static RelatorioService instance;

    private RelatorioService(){
        this.listaRelatorios = new ArrayList<>();
    }

    public static RelatorioService getInstance(){
        if (instance == null) {
            instance = new RelatorioService();
        }
        return instance;
    }

    // Métodos CRUD para relatórios
    public Relatorio createRelatorio(Relatorio relatorio) throws SQLException {
        try (Connection connection = DriverManager.getConnection(Constantes.URL_BANCO)) {
            return RelatorioRepository.saveRelatorio(relatorio);
        } catch (SQLException e) {
            System.out.println("Exceção capturada: " + e.getMessage());
            throw e;
        }
    }

    public Relatorio readRelatorioById(Long idRelatorio) throws SQLException {
        try (Connection connection = DriverManager.getConnection(Constantes.URL_BANCO)) {
            return RelatorioRepository.readRelatorioById(idRelatorio);
        } catch (SQLException e) {
            System.out.println("Exceção capturada: " + e.getMessage());
            throw e;
        }
    }

    public List<Relatorio> readAllRelatorios() throws SQLException {
        try (Connection connection = DriverManager.getConnection(Constantes.URL_BANCO)) {
            return RelatorioRepository.readAllRelatorios();
        } catch (SQLException e) {
            System.out.println("Exceção capturada: " + e.getMessage());
            throw e;
        }
    }

    public Relatorio updateRelatorio(Long idRelatorio, String titulo, String descricao) throws SQLException {
        try (Connection connection = DriverManager.getConnection(Constantes.URL_BANCO)) {
            return RelatorioRepository.updateRelatorio(idRelatorio, titulo, descricao);
        } catch (SQLException e) {
            System.out.println("Exceção capturada: " + e.getMessage());
            throw e;
        }
    }

    public void deleteRelatorio(Long idRelatorio) throws SQLException {
        try (Connection connection = DriverManager.getConnection(Constantes.URL_BANCO)) {
            RelatorioRepository.deleteRelatorioById(idRelatorio);
        } catch (SQLException e) {
            System.out.println("Exceção capturada: " + e.getMessage());
            throw e;
        }
    }
}
=======
package service;

import repository.RelatorioAdapterImpl;

public class RelatorioService extends RelatorioTemplate {

    @Override
    protected void obterDados() {

    }

    @Override
    protected void gerarRelatorioAdapter() {
        RelatorioAdapterImpl adaptador = new RelatorioAdapterImpl();
        adaptador.gerarRelatorio();
    }
}
>>>>>>> 2d4cef8d391cbc0695814da56db2830d32e0c157
