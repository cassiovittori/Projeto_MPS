package service;

import repository.RelatorioAdapterImpl;

public class RelatorioService extends RelatorioTemplate {

    @Override
    protected void obterDados() {

    }

    @Override
    protected void gerarRelatorioAdapter() {
        RelatorioAdapterImpl adaptador = new RelatorioAdapterImpl();
        adaptador.gerarRelatorio();
    }
}
