package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {

        Biblioteca newBiblioteca = new Biblioteca();

        // print initial welcome message
        System.out.println(newBiblioteca.getWelcome());

        while(newBiblioteca.doQuit() != true){
            newBiblioteca.displayMenuOptions();
            Scanner input = new Scanner(System.in);
            newBiblioteca.navigateMenu(input);
        }


    }


}
