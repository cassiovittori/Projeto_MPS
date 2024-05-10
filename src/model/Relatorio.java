package model;

import utils.enums.TipoRelatorioEnum;

public abstract class Relatorio {
    public abstract String gerarCabecalho();
    public abstract String gerarCorpo();
    public abstract String gerarRodape();
    
    private TipoRelatorioEnum tipoRelatorio;
    protected String titulo;
    protected String descricao;
    protected String data;
    protected String autor;

    public Relatorio(String titulo, String descricao, String data, String autor) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.data = data;
        this.autor = autor;
    }

    public final String gerarRelatorio() {
        StringBuilder relatorio = new StringBuilder();
        relatorio.append(gerarCabecalho());
        relatorio.append(gerarCorpo());
        relatorio.append(gerarRodape());
        return relatorio.toString();
    }

    public TipoRelatorioEnum getTipoRelatorioo() {
        return tipoRelatorio;
    }

    public void setTipoRelatorio(TipoRelatorioEnum tipoRelatorio) {
        this.tipoRelatorio = tipoRelatorio;
    }
    
    public String getTitulo(){
        return titulo;
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public String getDescricao(){
        return descricao;
    }

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    public String getAutor(){
        return autor;
    }

    public void setAutor(String autor){
        this.autor = autor;
    }

    public String getData(){
        return data;
    }

    public void setData(String data){
        this.data = data;
    }

}