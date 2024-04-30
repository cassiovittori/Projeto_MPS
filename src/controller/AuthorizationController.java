package controller;

public class AuthorizationController {
        
    private static AuthorizationController instance;

    public static AuthorizationController getInstance(){
        if (instance == null) {
            instance = new AuthorizationController();
        }
        return instance;
    }
}
