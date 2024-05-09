package view.consoleStates;

import exception.SexoException;
import exception.TipoUserException;

import java.io.IOException;
import java.sql.SQLDataException;
import java.util.Scanner;

public interface ConsoleState {
    void montarTela(Scanner scanner) throws SQLDataException, TipoUserException, SexoException, IOException;

    void direcionar(int opcao, Scanner scanner);
    void sair();
}
