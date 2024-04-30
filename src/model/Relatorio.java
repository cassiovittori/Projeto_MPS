package model;

import java.io.Serializable;

public class Relatorio implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long idRelatorio;
    private String cabecalho;
    private String corpo;
    private String rodape;
    private String autor;
    private String dataCriacao;

    public Relatorio(String cabechalho, String corpo, String rodape, String autor,String dataCriacao) {
        this.cabecalho = cabechalho;
        this.corpo = corpo;
        this.rodape = rodape;
        this.autor = autor;
        this.dataCriacao = dataCriacao;
    }

    public Relatorio() {
    }


    public Long getIdRelatorio() {
        return idRelatorio;
    }

    public void setIdRelatorio(Long idRelatorio) {
        this.idRelatorio = idRelatorio;
    }

    public String getCabecalho() {
        return cabecalho;
    }

    public void setCabecalho(String cabecalho) {
        this.cabecalho = cabecalho;
    }

    public String getCorpo() {
        return corpo;
    }

    public String getRodape() {
        return rodape;
    }
    
    public void setRodape(String rodape) {
        this.rodape = rodape;
    }

    

    public void setCorpo(String corpo) {
        this.corpo = corpo;
    }

    public String getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(String dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}
