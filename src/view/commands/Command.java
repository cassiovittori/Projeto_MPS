package view.commands;

import exception.SexoException;
import exception.TipoUserException;

import java.io.IOException;
import java.sql.SQLDataException;

public interface Command {
    void executar();
}
