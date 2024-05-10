package model;

public class RelatorioHTML extends Relatorio {
   
    public RelatorioHTML(String titulo, String descricao, String data, String autor) {
        super(titulo, descricao, data, autor);
    }

    @Override
    public String gerarCabecalho() {
        return "<html><head><title>" + titulo + "</title></head><body>\n<p>" + descricao + "</p>\n\n";
    }

    @Override
    public String gerarCorpo() {
        return "<h1>Corpo do Relatório HTML</h1>\n";
    }

    @Override
    public String gerarRodape() {
        return "\n\n<p>Data: " + data + "<br/>Autor: " + autor + "</p>\n</body></html>\n";
    }
    
}