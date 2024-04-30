package view;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import controller.Facade;
import utils.Constantes;

public class GerenciaRelatorioView {
    private Scanner scanner;
    private Facade fachada;

    public GerenciaRelatorioView() {
        this.fachada = Facade.getInstance();
        this.scanner = new Scanner(System.in);
    }

    public void addNovoRelatorio() throws SQLException {
        System.out.println("Digite o título do relatório:");
        String titulo = scanner.nextLine();
        System.out.println("Digite a descrição do relatório:");
        String descricao = scanner.nextLine();
        System.out.println("Digite a data de criação do relatório:");
        String dataCriacao = scanner.nextLine();
        System.out.println("Digite o autor do relatório:");
        String autor = scanner.nextLine();
        
        fachada.adicionarNovoRelatorioCtrl(titulo, descricao, dataCriacao, autor);
        System.out.println("Relatório adicionado com sucesso!");
    }

    public void buscarRelatorio() throws SQLException {
        System.out.println("Digite o ID do relatório que deseja buscar:");
        Long idRelatorio = scanner.nextLong();
        scanner.nextLine(); // Limpa o buffer do scanner
        System.out.println(fachada.buscarRelatorioCtrl(idRelatorio));
    }

    public void atualizarRelatorio() throws SQLException {
        System.out.println("Digite o ID do relatório que deseja atualizar:");
        Long idRelatorio = scanner.nextLong();
        scanner.nextLine(); // Limpa o buffer do scanner
        System.out.println("Digite o novo título do relatório:");
        String novoTitulo = scanner.nextLine();
        System.out.println("Digite a nova descrição do relatório:");
        String novaDescricao = scanner.nextLine();

        fachada.atualizarRelatorioCtrl(idRelatorio, novoTitulo, novaDescricao);
        System.out.println("Relatório atualizado com sucesso!");
    }

    public void deletarRelatorio() throws SQLException {
        System.out.println("Digite o ID do relatório que deseja deletar:");
        Long idRelatorio = scanner.nextLong();
        scanner.nextLine(); // Limpa o buffer do scanner
        fachada.deletarRelatorioCtrl(idRelatorio);
        System.out.println("Relatório deletado com sucesso!");
    }
}
