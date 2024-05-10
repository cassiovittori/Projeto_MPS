package model;

public class RelatorioTXT extends Relatorio {
    public RelatorioTXT(String titulo, String descricao, String data, String autor) {
        super(titulo, descricao, data, autor);
    }

    @Override
    public String gerarCabecalho() {
        return "Título: " + titulo + "\nDescrição: " + descricao + "\n\n";
    }

    @Override
    public String gerarCorpo() {
        return "Corpo do Relatório TXT\n";
    }

    @Override
    public String gerarRodape() {
        return "\n\nData: " + data + "\nAutor: " + autor;
    }
}
