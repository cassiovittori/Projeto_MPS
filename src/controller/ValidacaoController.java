package controller;

public class ValidacaoController {
    public static void validarLogin(String login) {
        if (login.isEmpty()) {
            throw new IllegalArgumentException("O login não pode ser vazio.");
        }
        if (login.length() > 12) {
            throw new IllegalArgumentException("O login não pode ter mais de 12 caracteres.");
        }
        if (login.matches(".*\\d.*")) {
            throw new IllegalArgumentException("O login não pode conter números.");
        }
    }

    public static void validarSenha(String senha) {
        if (senha.length() < 8 || senha.length() > 20) {
            throw new IllegalArgumentException("A senha deve ter entre 8 e 20 caracteres.");
        }
        if (!senha.matches(".*[a-zA-Z].*") || !senha.matches(".*\\d.*")) {
            throw new IllegalArgumentException("A senha deve conter letras e números.");
        }
        int contadorNumeros = 0;
        for (char c : senha.toCharArray()) {
            if (Character.isDigit(c)) {
                contadorNumeros++;
            }
        }
        if (contadorNumeros < 2) {
            throw new IllegalArgumentException("A senha deve conter ao menos 2 números.");
        }
    }
}

