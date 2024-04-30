package controller;


import factory.FabricaRelatorio;
//import model.Usuario;
import service.RelatorioService;
import model.Relatorio;
import java.sql.SQLException;

abstract class RelatorioController {
    
    private RelatorioService relatorioService;
    protected abstract String cabecalhoRelatorio(String titulo, String descricao);
    protected abstract String corpoRelatorio(String usuarios);
    protected abstract String rodapeRelatorio(String dataCriacao, String Autor);
    

    protected RelatorioController() { //privado, para construir em outro lugar do codigo so usando o get.instance
        this.relatorioService = RelatorioService.getInstance();
    }

    public static RelatorioController getInstance() {
        return Singleton.INSTANCE; //singleton holder
    }

     private static class Singleton {
        private static final RelatorioController INSTANCE = new RelatorioTXTController(); // Pode ser qualquer uma das implementações
    }


    public final void adicionarNovoRelatorio(String usuarios,String titulo, String descricao,String dataCriacao,String autor){
           
            String cabecalho = cabecalhoRelatorio(titulo, descricao);
            String corpo = corpoRelatorio(usuarios);
            String rodape = rodapeRelatorio(dataCriacao, autor);
            Relatorio relatorio = FabricaRelatorio.criaRelatorio(cabecalho, corpo, rodape, dataCriacao, autor); //talvez fazer duas fabricas, nao sei
            //excessao criada pelo programa, alterar depoisssss
            try {
                relatorioService.createRelatorio(relatorio);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

    }

    public void buscarRelatorio(Long idRelatorio){

        //codigo de buscar relatorio

    }

    public void atualizarRelatorio(Long idRelatorio,String novoTitulo,String novaDescricao){

        //codigo de atualizar relatorio

    }

    public void deletarRelatorio(Long idRelatorio){

        //codigo here

    }

}
