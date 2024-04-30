package exception;

public class TipoUserException extends Exception {
    public TipoUserException(String mensagem) {
        super(mensagem);
    }

    public TipoUserException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }    
}
