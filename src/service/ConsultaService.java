package service;

import model.Consulta;
import repository.ConsultaRepository;
import repository.ConsultaRepositoryImp;

import java.util.List;


public class ConsultaService {

    private static ConsultaService instance;
    private ConsultaRepository repository;

    private ConsultaService(){this.repository = ConsultaRepositoryImp.getInstance();}

    public static ConsultaService getInstance(){
        if (instance == null) {
            instance = new ConsultaService();
        }
        return instance;
    }

    public Consulta createConsulta(Consulta consulta){
        return repository.saveConsulta(consulta);
    }

    public void updateConsulta(long idConsulta, String data){
        repository.updateConsulta(idConsulta, data);
    }

    public void deleteConsulta(Long idConsulta){
        repository.deleteConsulta(idConsulta);
    }

    public Consulta readConsultaId(long idConsulta){
        return repository.readConsultaById(idConsulta);
    }

    public Consulta readConsultaBy(String opcao, String parametro){
        return repository.readConsultaBy(opcao, parametro);
    }

    public List<Consulta> getAllConsulta(){
        return repository.getAll();
    }
}
