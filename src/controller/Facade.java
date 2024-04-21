package controller;

public class Facade {
    
    protected static Facade instance;
    protected UsuarioController usuarioController;
    protected ValidacaoController validacaoController;

    private Facade() { //aqui inicia os controllers na fachada
        this.usuarioController = UsuarioController.getInstance();
        this.validacaoController = ValidacaoController.getInstance();
    }

    public static Facade getInstance() {
        if (instance == null) {
            instance = new Facade();
        }
        return instance;
    }

    //Acesso ao controles do usuario
    public void adicionarNovoUsuario() {
        usuarioController.adicionarUsuario();
   }

   public void mostrarTodosUsuarios() {
       usuarioController.mostrarUsuarios();
   }

   public void executarTudo(){
    usuarioController.executar();
   }


    //Acesso a validação de usuario
    public void validarLoginDoUsuario(String login) {
        validacaoController.validarLogin(login);
   }

    public void validarSenhaDoUsuario(String senha) {
         validacaoController.validarSenha(senha);
    }

}
