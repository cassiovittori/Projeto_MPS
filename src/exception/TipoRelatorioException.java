package exception;

public class TipoRelatorioException extends Exception {

    public TipoRelatorioException(String mensagem) {
        super(mensagem);
    }

    public TipoRelatorioException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }    
}


