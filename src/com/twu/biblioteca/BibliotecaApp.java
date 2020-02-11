package com.twu.biblioteca;

import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {

        Biblioteca newBiblioteca = new Biblioteca();

        // print initial welcome message
        System.out.println(newBiblioteca.getWelcome());

        while(newBiblioteca.doQuit() != true){
            newBiblioteca.getDisplayMenu();
            System.out.println("What would you like to do?");
            Scanner input = new Scanner(System.in);
            newBiblioteca.navigateMenu(input);
        }


    }


}
