package controller;

public class ConsultaController {
        
    private static ConsultaController instance;

    public static ConsultaController getInstance(){
        if (instance == null) {
            instance = new ConsultaController();
        }
        return instance;
    }
}
