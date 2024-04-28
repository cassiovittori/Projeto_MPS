package controller;

public class RelatorioController {
    
    private static RelatorioController instance;

    public static RelatorioController getInstance(){
        if (instance == null) {
            instance = new RelatorioController();
        }
        return instance;
    }

}
