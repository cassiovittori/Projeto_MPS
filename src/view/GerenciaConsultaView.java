package view;

import java.sql.SQLException;
import java.util.Scanner;
import model.Consulta;
import service.ConsultaService;

public class GerenciaConsultaView {
    private Scanner scanner = new Scanner(System.in);
    private ConsultaService consultaService = ConsultaService.getInstance();

    public void adicionarConsulta() {
        // adiciona uma consulta através da interface do usuário
    }

    public void visualizarConsulta() {
        // visualiza detalhes de uma consulta
    }

    public void atualizarConsulta() {
        // atualiza uma consulta existente
    }

    public void deletarConsulta() {
        // deleta uma consulta
    }
}
