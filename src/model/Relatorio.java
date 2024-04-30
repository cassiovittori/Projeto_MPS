package model;

import java.io.Serializable;

public class Relatorio implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long idRelatorio;
    private String titulo;
    private String descricao;
    private String dataCriacao;
    private String autor;

    public Relatorio(String titulo, String descricao, String dataCriacao, String autor) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataCriacao = dataCriacao;
        this.autor = autor;
    }

    public Relatorio() {
    }


    public Long getIdRelatorio() {
        return idRelatorio;
    }

    public void setIdRelatorio(Long idRelatorio) {
        this.idRelatorio = idRelatorio;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
