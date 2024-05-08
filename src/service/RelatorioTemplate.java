package service;

public abstract class RelatorioTemplate {

    public void gerarRelatorio() {
        obterDados();
        gerarRelatorioAdapter();
    }
    protected abstract void obterDados();
    protected abstract void gerarRelatorioAdapter();

}
