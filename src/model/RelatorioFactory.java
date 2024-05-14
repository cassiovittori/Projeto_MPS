package model;

import exception.TipoRelatorioException;
import utils.enums.TipoRelatorioEnum;


public class RelatorioFactory {

    
    public static Relatorio criarRelatorio(TipoRelatorioEnum tipo, String titulo,String descricao,BuilderRelatorioCorpo corpo, String data, String nome) throws TipoRelatorioException {
        switch (tipo) {
            case TXT -> {
                return new RelatorioTXT(titulo, descricao, data, nome, corpo);
            }
            case HTML -> {
                return new RelatorioHTML(titulo, descricao, data, nome, corpo);
            }
            default -> throw new TipoRelatorioException("O tipo de relatorio passado é invalido");
        }
    }

    
}
