package controller;

import exception.TipoRelatorioException;
import java.util.List;
import model.BuilderRelatorioCorpo;
import model.Relatorio;
import model.RelatorioFactory;
import service.RelatorioService;
import utils.enums.TipoRelatorioEnum;

public class RelatorioController {
    
    private static RelatorioController instance;
    private static  RelatorioService relatorioservice;

    public static RelatorioController getInstance(){
        if (instance == null) {
            instance = new RelatorioController();
        }
        return instance;
    }

    private  RelatorioController(){
        this.relatorioservice = RelatorioService.getInstance();
        
    }


    public Relatorio postRelatorio(String relatorioTipo, String titulo, String descricao,BuilderRelatorioCorpo corpo, String data, String nome) throws TipoRelatorioException {
        
        int idtipoRelatorio = Integer.parseInt(relatorioTipo);
        Relatorio relatorio = RelatorioFactory.criarRelatorio(TipoRelatorioEnum.comId(idtipoRelatorio), titulo, descricao, corpo, data, nome);
       
        return relatorioservice.criarRelatorio(relatorio);
    }

    public List<Relatorio> readRelatorioByParametro(String tipoParametro,String Parametro){

        return relatorioservice.readRelatorioByParame(tipoParametro, Parametro);

    }

    public boolean deleteRelatorio(String titulo){
       
        Relatorio relatorio = relatorioservice.readRelatorio(titulo);


        return relatorioservice.deleteRelatorio(relatorio);

    }




}
