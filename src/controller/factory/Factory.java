 package factory;

import model.Usuario;

public class Factory implements InterfaceFactory {
    private static Factory instance;
    
    @Override
    public Usuario criaUsuario(String tipo, String login, String senha) {
        switch (tipo.toLowerCase()) {
            case "paciente":
                PacienteFactory fabrica;
                return fabrica.criaUsuario(tipo,login,senha);
            case "médico":
                MedicoFactory.criaUsuario(tipo, login, senha);
            case "administrador":
                AdminFactory.criaUsuario(tipo, login, senha);
            default:
                throw new IllegalArgumentException("Tipo de usuário inválido: " + tipo);
        }
    }

    private Factory() {
        // Construtor privado para impedir instâncias diretas
    }

    public static Factory getInstance() {
        if (instance == null) {
            instance = new Factory();
        }
        return instance;
    }
   
}