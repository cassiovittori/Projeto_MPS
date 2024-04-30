package model;

import java.time.LocalDate;

import interfaces.IntConsulta;

public class Consulta implements IntConsulta {
    
    private long idConsulta;
    private String crmMedico;
    private String cpfPaciente;
    private LocalDate dataConsulta;
    private String motivoConsulta;

    public long getIdConsulta() {
        return idConsulta;
    }
    public void setIdConsulta(long idConsulta) {
        this.idConsulta = idConsulta;
    }
    public String getCpfPaciente() {
        return cpfPaciente;
    }
    public void setCpfPaciente(String cpfPaciente) {
        this.cpfPaciente = cpfPaciente;
    }
    public String getCrmMedico() {
        return crmMedico;
    }
    public void setCrmMedico(String crmMedico) {
        this.crmMedico = crmMedico;
    }
    public LocalDate getDataConsulta() {
        return dataConsulta;
    }
    public void setDataConsulta(LocalDate dataConsulta) {
        this.dataConsulta = dataConsulta;
    }
    public String getMotivoConsulta() {
        return motivoConsulta;
    }
    public void setMotivoConsulta(String motivoConsulta) {
        this.motivoConsulta = motivoConsulta;
    }

}
