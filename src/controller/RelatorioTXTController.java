package controller;


public class RelatorioTXTController extends RelatorioController {

    @Override
    protected String cabecalhoRelatorio(String titulo, String descricao) {
        return "Cabecalho em html";
    }

    @Override
    protected String corpoRelatorio(String usuarios) {
        return "<corpo em html";
    }

    @Override
    protected String rodapeRelatorio(String dataCriacao, String Autor) {

        return "rodape em html";

    }
    
}
