package repository;

import model.Consulta;

import java.util.List;

public interface ConsultaRepository {

     public Consulta saveConsulta(Consulta consulta);
     public void updateConsulta(long idConsulta, String data);
    public void deleteConsulta(long idConsulta);

    public Consulta readConsultaById(long idConsulta);

    public Consulta readConsultaBy(String opcao,String parametro);

    public List<Consulta> getAll();
}
