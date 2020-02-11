package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    private List<String> menuOptions;

    public Menu() {
        this.menuOptions = new ArrayList<>();
        this.menuOptions.add("List of books");
        this.menuOptions.add("List of movies");
        this.menuOptions.add("Checkout");
        this.menuOptions.add("Return");
        this.menuOptions.add("Log in");
        this.menuOptions.add("Quit");

    }

    public void displayMenu(String menuType){
        System.out.println("Menu:");
        System.out.println("----");

        // display "List of books" and "List of movies" menu options
        System.out.println(menuOptions.get(0));
        System.out.println(menuOptions.get(1));

        if(menuType.equals("main")){
            // add "Log in" option to the main menu
           System.out.println(menuOptions.get(4));
        } else if(menuType.equals("user")){
            // add "Checkout" and "Return" options to the menu
            System.out.println(menuOptions.get(2));
            System.out.println(menuOptions.get(3));
        }

        System.out.println(menuOptions.get(5));
        System.out.println("\nType Menu Selection and Press Enter:");
    }

    public boolean validateMenuSelection(String menuSelection){

        if(menuOptions.contains(menuSelection)){
            return true;
        } else {
            System.out.println("Please select a valid option!");
            return false;
        }
    }


}
