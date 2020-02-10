package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Biblioteca {

    private String welcomeMsg;
    private List<String> menuOptions;
    private List<Title> availableTitles;
    private List<Title> checkedOutTitles;
    private boolean quit;

    public Biblioteca(){
        this.availableTitles = new ArrayList<>();
        this.availableTitles.add(new Book("Romeo and Juliet", "William Shakespeare", "1595"));
        this.availableTitles.add(new Book("Lord of the Rings", "J.R.R.Tolkien", "1954"));
        this.availableTitles.add(new Book("Pride and Prejudice", "Jane Austen", "1813"));
        this.availableTitles.add(new Book("The Shining", "Stephen King", "1977"));
        this.availableTitles.add(new Book("The Three Musketeers", "Alexandre Dumas", "1844"));

        this.availableTitles.add(new Movie("The Godfather", "Francis Ford Coppola", "1972", "9"));
        this.availableTitles.add(new Movie("Sleepless in Seattle", "Nora Ephron", "1993", "3"));
        this.availableTitles.add(new Movie("The Birds", "Alfred Hitchcock", "1963", "5"));
        this.availableTitles.add(new Movie("Home Alone", "Chris Columbus", "1990", "unrated"));
        this.availableTitles.add(new Movie("Die Hard", "John McTiernan", "1988", "10"));

        this.menuOptions = new ArrayList<>();
        this.menuOptions.add("List of books");
        this.menuOptions.add("List of movies");
        this.menuOptions.add("Checkout");
        this.menuOptions.add("Return");
        this.menuOptions.add("Log In");
        this.menuOptions.add("Quit");

        this.checkedOutTitles = new ArrayList<>();

        this.welcomeMsg = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n";
        this.quit = false;
    }

    public void navigateMenu(Scanner input) {
        String userMenuSelection;
        boolean askForInput = true;

        while(askForInput == true){
            userMenuSelection = input.nextLine();
            boolean validation = validateMenuSelection(userMenuSelection);
            if(validation == true) {
                evaluateMenuSelection(userMenuSelection, input);
                askForInput = false;
            }
        }
    }

    public  String getWelcome() {
        return welcomeMsg;
    }

    public List<Title> getAvailableTitles() {
        return availableTitles;
    }

    private void displayAvailableBooks(String formatString){

        System.out.format(formatString, "Title", "Author", "Published\n");

        for(Title t : availableTitles) {
            if(t.getClass().equals(Book.class)) {
                Book b = (Book) t;
                System.out.format(formatString, b.getTitle(), b.getAuthor(), b.getYear());
            }
        }
    }

    public void displayAvailableTitles(String titleType){

        String additionalFormatting = "";

        if(titleType.equals("Book")){
            createListHeading("Books:");
            displayAvailableBooks(createListFormatting(additionalFormatting));
        } else if(titleType.equals("Movie")){
            createListHeading("Movies:");
            additionalFormatting = " %-8s";
            displayAvailableMovies(createListFormatting(additionalFormatting));
        }
    }

    private void displayAvailableMovies(String formatString){

        System.out.format(formatString, "Title", "Director", "Released", "Rating\n");

        for(Title t : availableTitles) {
            if(t.getClass().equals(Movie.class)) {
                Movie m = (Movie) t;
                System.out.format(formatString, m.getTitle(), m.getDirector(), m.getReleaseYear(), m.getRating());
            }
        }
    }

    private Class getTitleImplementingClass(List<Title> listOfTitles){

        return listOfTitles.get(0).getClass();
    }

    private String createListFormatting(String additionalFormatting){
        String formatString = "%-20s  %-20s  %-10s" + additionalFormatting + " %n";
        return formatString;
    }

    private void createListHeading(String titleType){
        System.out.println("Available " + titleType);
        System.out.println("________________\n");
    }

    public void displayMenuOptions(){
        System.out.println("\nMenu:");
        System.out.println("----");
        for(String s : menuOptions){
            System.out.println(s);
        }
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

    public void evaluateMenuSelection(String userSelection, Scanner input){
        switch(userSelection){
            case "List of books":
                displayAvailableTitles("Book");
                break;
            case "List of movies":
                displayAvailableTitles("Movie");
                break;
            case "Checkout":
                System.out.println("What would you like to check out?");
                String titleToCheckOut = input.nextLine();
                checkoutTitle(titleToCheckOut);
                break;
            case "Log in" :
                
                break;
            case "Return":
                System.out.println("What would you like to return?");
                String titleToReturn = input.nextLine();
                returnTitle(titleToReturn);
                break;
            case "Quit":
                quit = true;
                System.out.println("Thank you for using Biblioteca");
                break;

        }

    }

    public void checkoutTitle(String titleToCheckOut){
        // look for the book in the "checked out" list
        List<Integer> titleIndex = getTitleIndex(titleToCheckOut, availableTitles);

        if(titleIndex.isEmpty() == false){
            // add the checked out book to the "checked out" list
            checkedOutTitles.add(availableTitles.get(titleIndex.get(0).intValue()));
            // remove it from the "available" list
            availableTitles.remove(titleIndex.get(0).intValue());
            // print a success message
            System.out.println("Thank you! Enjoy " + titleToCheckOut);
        } else{
            System.out.println("Sorry, that title is not available");
        }
    }

    public void returnTitle(String titleToReturn){
        // look for the book in the "checked out" list
        List<Integer> titleIndex = getTitleIndex(titleToReturn, checkedOutTitles);

        if(titleIndex.isEmpty() == false){
            // add the checked out book to the "available" list
            availableTitles.add(checkedOutTitles.get(titleIndex.get(0).intValue()));
            // remove it from the "checked out" list
            checkedOutTitles.remove(titleIndex.get(0).intValue());
            // print a success message
            System.out.println("Thank you for returning " + titleToReturn);
        } else{
            System.out.println("This is not a valid title to return");
        }
    }

    private List<Integer> getTitleIndex(String titleToFind, List<Title> listOfTitles){

        List<Integer> titleIndex = new ArrayList<>();

        for(int i = 0; i < listOfTitles.size(); i++){
            if(titleToFind.equals(listOfTitles.get(i).getTitle())){
                titleIndex.add(i);
            }
        }
        return titleIndex;
    }

    public String getWelcomeMsg() {
        return welcomeMsg;
    }

    public void setWelcomeMsg(String welcomeMsg) {
        this.welcomeMsg = welcomeMsg;
    }

    public List<String> getMenuOptions() {
        return menuOptions;
    }

    public void setMenuOptions(List<String> menuOptions) {
        this.menuOptions = menuOptions;
    }

    public void setAvailableTitles(List<Title> availableTitles) {
        this.availableTitles = availableTitles;
    }

    public boolean doQuit() {
        return quit;
    }

    public void setQuit(boolean quit) {
        this.quit = quit;
    }

    public List<Title> getCheckedOutTitles() {
        return checkedOutTitles;
    }

    public void setCheckedOutTitles(List<Title> checkedOutTitles) {
        this.checkedOutTitles = checkedOutTitles;
    }
}
