package repository;

import factory.FactoryAdmin;
import model.Admin;
import model.Medico;
import model.Paciente;

public class RelatorioAdapterImpl implements interfaces.intRelatorio {

    @Override
    public void gerarRelatorio() {
       // Admin admin = FactoryAdmin.getUsuario();
        Paciente paciente = new Paciente();
        Medico medico = new Medico();

        System.out.println("Relatório gerado com sucesso!");
    }
}
