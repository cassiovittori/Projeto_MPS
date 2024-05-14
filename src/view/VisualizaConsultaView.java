package view;

import java.sql.SQLException;
import java.util.Scanner;
import model.Consulta;
import service.ConsultaService;

public class VisualizaConsultaView {
    private Scanner scanner = new Scanner(System.in);
    private ConsultaService consultaService = ConsultaService.getInstance();

    public void mostrarConsulta(long idConsulta) {
        // mostra uma consulta específica
    }
}
