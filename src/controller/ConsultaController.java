package controller;

import model.Consulta;
import service.ConsultaService;

import java.util.List;

public class ConsultaController {
        
    private static ConsultaController instance;

    private ConsultaService consultaService;
    private ConsultaController(){this.consultaService = ConsultaService.getInstance();}
    public static ConsultaController getInstance(){
        if (instance == null) {
            instance = new ConsultaController();
        }
        return instance;
    }

    public Consulta postConsulta(String crm, String cpf, String data, String motivo){

        //TODO: Realizar validações para a criação da consulta.

        Consulta consulta = new Consulta(crm,cpf,data,motivo);

        return consultaService.createConsulta(consulta);
    }

    public void putConsulta(String idConsulta, String data){
        //TODO: Realizar validações.

        consultaService.updateConsulta(Long.valueOf(idConsulta), data);
    }

    public void delConsulta(String idConsulta){

        //TODO: Realizar validações.
        consultaService.deleteConsulta(Long.valueOf(idConsulta));
    }

    public Consulta getConsulta(String idOpcao,String parametro){
        //TODO: Realizar validações.
        switch (idOpcao) {
            case "1":
                return consultaService.readConsultaId(Long.valueOf(parametro));
            default :
                return consultaService.readConsultaBy(idOpcao, parametro);
        }
    }

    public List<Consulta> getListaConsulta(){
        return consultaService.getAllConsulta();
    }
}
