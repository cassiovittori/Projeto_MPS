package repository;

import model.Consulta;

import java.util.List;

public class ConsultaRepositoryImp implements ConsultaRepository{
    private static ConsultaRepositoryImp instance;

    public static ConsultaRepositoryImp getInstance(){
        if (instance == null) {
            instance = new ConsultaRepositoryImp();
        }
        return instance;
    }

    @Override
    public Consulta saveConsulta(Consulta consulta) {
        System.out.println("Salvando Consulta...\n");
        System.out.println(consulta.toString());
        return null;
    }

    @Override
    public void updateConsulta(long idConsulta, String data) {
        System.out.println("Buscando Consulta com ID " + idConsulta+ "...");
        System.out.println("Atualizando data da consulta para " + data);
        System.out.println("Consulta atualizada com SUCESSO!");
    }

    @Override
    public void deleteConsulta(long idConsulta) {
        System.out.println("Buscando Consulta...");
        System.out.println("Deletando Consulta de ID: " + idConsulta + "...");
        System.out.println("Consulta deletada com SUCESSO!");
    }

    @Override
    public Consulta readConsultaById(long idConsulta) {
        return null;
    }

    @Override
    public Consulta readConsultaBy(String opcao, String parametro) {
        return null;
    }

    @Override
    public List<Consulta> getAll() {
        return null;
    }
}
