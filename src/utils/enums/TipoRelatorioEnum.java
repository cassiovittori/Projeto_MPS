package utils.enums;

import exception.TipoRelatorioException;

public enum  TipoRelatorioEnum {
    
       TXT(1),
       HTML(2);
    
       private final int tipo;
    
       TipoRelatorioEnum(int valor){
       this.tipo = valor;
       }
    
       public int getTipo() {
          return tipo;
       }
    
       public static TipoRelatorioEnum comId(int idTipoRelatorio) throws TipoRelatorioException {
          for (TipoRelatorioEnum tipo : values()) {
             if (tipo.getTipo() == idTipoRelatorio) {
                return tipo;
             }
          }
         throw new TipoRelatorioException("Tipo de relatorio informado não mapeado!");
       }
    
}
