package utils.enums;

import exception.TipoUserException;

public enum TipoUsuarioEnum {
   ADMIN(1),
   PACIENTE(2),
   MEDICO(3);

   private final int valor;

   TipoUsuarioEnum(int valor){
   this.valor = valor;
   }

   public int getValor() {
      return valor;
   }

   public static TipoUsuarioEnum comId(int idTipoUsuario) throws TipoUserException {
      for (TipoUsuarioEnum tipo : values()) {
         if (tipo.getValor() == idTipoUsuario) {
            return tipo;
         }
      }
     throw new TipoUserException("Tipo de usuario informado não mapeado!");
   }

}
