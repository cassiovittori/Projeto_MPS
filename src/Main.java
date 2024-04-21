import controller.Facade;

public class Main {
    public static void main(String[] args) {
        Facade usuarioFacade = Facade.getInstance();
        usuarioFacade.executarTudo();
    }
}
