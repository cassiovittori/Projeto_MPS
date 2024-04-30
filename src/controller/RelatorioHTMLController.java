package controller;

import model.Usuario;

public class RelatorioHTMLController extends RelatorioController{

    @Override
    protected String cabecalhoRelatorio(String titulo, String descricao) {
        return "-----------------------"+titulo+"---------------- \n "+descricao+"";

    }

    @Override
    protected String corpoRelatorio(String usuarios) {
        return "Aqui vai  o meio do relatorio";
    }

    @Override
    protected String rodapeRelatorio(String dataCriacao, String Autor) {
        return "--Relatorio gerado na data "+dataCriacao+"--por: "+Autor+"";
    }

}
