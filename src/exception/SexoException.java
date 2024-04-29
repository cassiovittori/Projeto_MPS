package exception;

public class SexoException extends Exception {
    public SexoException(String mensagem) {
        super(mensagem);
    }

    public SexoException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }    
}
