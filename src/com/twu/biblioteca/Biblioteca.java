package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Biblioteca {

    private String welcomeMsg;
    private List<String> menuOptions;
    private List<Book> availableBooks;
    private List<Movie> availableMovies;
    private List<Movie> checkedOutMovies;
    private List<Book> checkedOutBooks;
    private boolean quit;

    public Biblioteca(){
        this.availableBooks = new ArrayList<>();
        this.availableBooks.add(new Book("Romeo and Juliet", "William Shakespeare", "1595"));
        this.availableBooks.add(new Book("Lord of the Rings", "J.R.R.Tolkien", "1954"));
        this.availableBooks.add(new Book("Pride and Prejudice", "Jane Austen", "1813"));
        this.availableBooks.add(new Book("The Shining", "Stephen King", "1977"));
        this.availableBooks.add(new Book("The Three Musketeers", "Alexandre Dumas", "1844"));

        this.availableMovies = new ArrayList<>();
        this.availableMovies.add(new Movie("The Godfather", "Francis Ford Coppola", "1972", "9"));
        this.availableMovies.add(new Movie("Sleepless in Seattle", "Nora Ephron", "1993", "3"));
        this.availableMovies.add(new Movie("The Birds", "Alfred Hitchcock", "1963", "5"));
        this.availableMovies.add(new Movie("Home Alone", "Chris Columbus", "1990", "unrated"));
        this.availableMovies.add(new Movie("Die Hard", "John McTiernan", "1988", "10"));

        this.menuOptions = new ArrayList<>();
        this.menuOptions.add("List of books");
        this.menuOptions.add("List of movies");
        this.menuOptions.add("Checkout");
        this.menuOptions.add("Return");
        this.menuOptions.add("Quit");

        this.checkedOutBooks = new ArrayList<>();
        this.checkedOutMovies = new ArrayList<>();

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

    public List<Book> getAvailableBooks() {
        return availableBooks;
    }

    public void displayAvailableBooks(){
        System.out.println("Available Books:");
        System.out.println("_______________\n");
        String formatString = "%-20s  %-20s  %-10s %n";
        System.out.format(formatString, "Title", "Author", "Published\n");

        for(Book b : availableBooks) {
            System.out.format(formatString, b.getTitle(), b.getAuthor(), b.getYear());
        }
    }

    public void displayAvailableMovies(){
        System.out.println("Available Movies:");
        System.out.println("_______________\n");
        String formatString = "%-20s  %-20s  %-10s %-8s %n";
        System.out.format(formatString, "Title", "Director", "Released", "Rating\n");

        for(Movie m : availableMovies) {
            System.out.format(formatString, m.getMovieTitle(), m.getDirector(), m.getReleaseYear(), m.getRating());
        }
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
                displayAvailableBooks();
                break;
            case "List of movies":
                displayAvailableMovies();
                break;
            case "Checkout":
                System.out.println("Which book would you like to check out?");
                String bookToCheckOut = input.nextLine();
                checkoutBook(bookToCheckOut);
                break;
            case "Return":
                System.out.println("Which book would you like to return?");
                String bookToReturn = input.nextLine();
                returnBook(bookToReturn);
                break;
            case "Quit":
                quit = true;
                System.out.println("Thank you for using Biblioteca");
                break;
        }

    }

    public void checkoutBook(String bookToCheckOut){
        // look for the book in the "available" list
        List<Integer> bookIndex = getBookIndex(bookToCheckOut, availableBooks);

        if(bookIndex.isEmpty() == false){
            // add the checked out book to the "checked out" list
            checkedOutBooks.add(availableBooks.get(bookIndex.get(0).intValue()));
            // remove it from the "available" list
            availableBooks.remove(bookIndex.get(0).intValue());
            // print a success message
            System.out.println("Thank you! Enjoy the book");
        } else{
            System.out.println("Sorry, that book is not available");
        }
    }

    public void returnBook(String bookToReturn){
        // look for the book in the "checked out" list
        List<Integer> bookIndex = getBookIndex(bookToReturn, checkedOutBooks);


        if(bookIndex.isEmpty() == false){
            // add the checked out book to the "available" list
            availableBooks.add(checkedOutBooks.get(bookIndex.get(0).intValue()));
            // remove it from the "checked out" list
            checkedOutBooks.remove(bookIndex.get(0).intValue());
            // print a success message
            System.out.println("Thank you for returning the book");
        } else{
            System.out.println("This is not a valid book to return");
        }
    }

    private List<Integer> getBookIndex(String bookToCheckOut, List<Book> listOfBooks){

        List<Integer> bookIndex = new ArrayList<>();

        for(int i = 0; i < listOfBooks.size(); i++){
            if(bookToCheckOut.equals(listOfBooks.get(i).getTitle())){
                bookIndex.add(i);
            }
        }
        return bookIndex;
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

    public void setAvailableBooks(List<Book> availableBooks) {
        this.availableBooks = availableBooks;
    }

    public boolean doQuit() {
        return quit;
    }

    public void setQuit(boolean quit) {
        this.quit = quit;
    }
}
