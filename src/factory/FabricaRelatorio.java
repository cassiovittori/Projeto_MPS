package factory;

import model.Relatorio;

public class FabricaRelatorio {

    public static Relatorio criaRelatorio(String cabecalho,String corpo,String rodape,String dataCriacao,String autor) {
       
        return new Relatorio(cabecalho, corpo,rodape,autor,dataCriacao);

    }

}

