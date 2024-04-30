package view;

import java.util.Scanner;

import controller.Facade;

public class TelaLoginView{

    private Scanner scanner;
    private Facade fachada;

    public TelaLoginView(){
        this.fachada = Facade.getInstance();
    }

}