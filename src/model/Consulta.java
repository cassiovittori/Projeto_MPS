package model;

import interfaces.IntConsulta;

public class Consulta implements IntConsulta {
    
    private long idConsulta;
    private String crmMedico;
    private String cpfPaciente;
    private String dataConsulta;
    private String motivoConsulta;

    public Consulta(String crmMedico, String cpfPaciente, String dataConsulta, String motivoConsulta) {
        this.crmMedico = crmMedico;
        this.cpfPaciente = cpfPaciente;
        this.dataConsulta = dataConsulta;
        this.motivoConsulta = motivoConsulta;
    }

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
    public String getDataConsulta() {
        return dataConsulta;
    }
    public void setDataConsulta(String dataConsulta) {
        this.dataConsulta = dataConsulta;
    }
    public String getMotivoConsulta() {
        return motivoConsulta;
    }
    public void setMotivoConsulta(String motivoConsulta) {
        this.motivoConsulta = motivoConsulta;
    }

    @Override
    public String toString() {
        return "consulta:" +
                "idConsulta=" + idConsulta +
                ", Medico='" + crmMedico + '\'' +
                ", Paciente='" + cpfPaciente + '\'' +
                ", Data='" + dataConsulta + '\'' +
                ", Motivo='" + motivoConsulta + '\'' +'.';
    }

}
