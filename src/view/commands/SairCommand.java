package view.commands;

public class SairCommand implements Command{
    @Override
    public void executar() {
        System.out.println("Fechando...");
        System.exit(0);
    }
}
