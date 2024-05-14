package model;

import java.util.List;

public class BuilderRelatorioCorpo {

    private StringBuilder corpo;

    public BuilderRelatorioCorpo() {
        this.corpo = new StringBuilder();
    }
    
    public BuilderRelatorioCorpo comPacientes(List<Paciente> pacientes){
        corpo.append("////////Lista de Pacientes://////////\n");
        for (Paciente paciente : pacientes) {
            corpo.append(paciente.toString()).append("\n");
        }
        corpo.append("\n");
        return this;
    }

    public BuilderRelatorioCorpo comMedicos(List<Medico> medicos){
        corpo.append("////////Lista de Medicos://////////\n");
        for(Medico medico: medicos){
            corpo.append(medico.toString()).append("\n");
        } 
        corpo.append("\n");
        return this;
    }

    public BuilderRelatorioCorpo comConsultas(List<Consulta> consultas){
        corpo.append("////////Lista de Consultas://////////\n");
        for(Consulta consulta: consultas){
            corpo.append(consulta.toString()).append("\n");
        } 
        corpo.append("\n");
        return this;

    }

    public BuilderRelatorioCorpo getCorpo(){
        return this;
    }

}
