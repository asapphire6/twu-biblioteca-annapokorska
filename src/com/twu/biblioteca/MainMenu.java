package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class MainMenu implements Menu{

    private List<String> menuOptions;

    public MainMenu() {
        this.menuOptions = new ArrayList<>();
        this.menuOptions.add("List of books");
        this.menuOptions.add("List of movies");
        this.menuOptions.add("List of users");
    }

    @Override
    public List<String> buildMenu(){
        return menuOptions;
    }

    @Override
    public void displayMenu(){
        System.out.println("Menu:");
        System.out.println("----");

        for(String s : menuOptions){
            System.out.println(s);
        }
    }

    @Override
    public boolean validateMenuSelection(String menuSelection){

        if(menuOptions.contains(menuSelection)){
            return true;
        } else {
            System.out.println("Please select a valid option!");
            return false;
        }
    }
}
