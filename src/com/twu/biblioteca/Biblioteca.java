package com.twu.biblioteca;

import java.util.*;

public class Biblioteca {

    private String welcomeMsg;
    private Menu menu;
    private List<Title> availableTitles;
    private List<Title> checkedOutTitles;
    private Map<String, User> userList;
    private String currentUserId;
    private boolean quit;

    public Biblioteca(){

        this.menu = new QuitMenu (new LoginMenu (new MainMenu()));
        menu.buildMenu();

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

        this.userList = new HashMap<>();
        this.userList.put("123-4567", new User("Kelly Jones", "kellyjones@gmail.com", "07944679902", "london1", "123-4567"));
        this.userList.put("654-7960", new User("Dwain Johnson", "lildwaine@hotmail.com", "07555799900", "therock", "654-7960"));

        this.checkedOutTitles = new ArrayList<>();

        this.welcomeMsg = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n";
        this.quit = false;
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

    private String createListFormatting(String additionalFormatting){
        String formatString = "%-20s  %-20s  %-10s" + additionalFormatting + " %n";
        return formatString;
    }

    private void createListHeading(String titleType){
        System.out.println("\nAvailable " + titleType);
        System.out.println("________________\n");
    }

    public void checkoutTitle(String inputTitle){
        // look for the book in the "checked out" list
        List<Integer> titleIndex = getTitleIndex(inputTitle, availableTitles);
        System.out.println("Title to check out: " + inputTitle + "\n" + titleIndex);


        if(titleIndex.isEmpty() == false){
            Title titleToCheckOut = availableTitles.get(titleIndex.get(0).intValue());

            // add the checked out title to the "checked out" list
            checkedOutTitles.add(titleToCheckOut);

            // add the title to the current user
            System.out.println(userList.get(currentUserId).toString());
            userList.get(currentUserId).addToCheckedOutTitles(titleToCheckOut);

            // remove it from the "available" list
            availableTitles.remove(titleIndex.get(0).intValue());

            // print a success message
            System.out.println("Thank you! Enjoy " + inputTitle);
        } else{
            System.out.println("Sorry, that title is not available");
        }
    }

    public void returnTitle(String inputTitle){
        // look for the book in the "checked out" list
        List<Integer> titleIndex = getTitleIndex(inputTitle, checkedOutTitles);

        if(titleIndex.isEmpty() == false){
            Title titleToReturn = checkedOutTitles.get(titleIndex.get(0).intValue());

            // add the checked out book to the "available" list
            availableTitles.add(titleToReturn);
            // remove it from the "checked out" list
            checkedOutTitles.remove(titleToReturn);

            // remove the title from the current user
            userList.get(currentUserId).returnCheckedOutTitle(titleToReturn);
            // print a success message
            System.out.println("Thank you for returning " + inputTitle);
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

    public boolean doQuit() {
        return quit;
    }

    public void navigateMenu(Scanner input) {
        String userMenuSelection;
        boolean askForInput = true;

        while(askForInput == true){
            userMenuSelection = input.nextLine();
            boolean validation = menu.validateMenuSelection(userMenuSelection);
            if(validation == true) {
                evaluateMainMenuSelection(userMenuSelection, input);
                askForInput = false;
            }
        }
    }

    public void evaluateMainMenuSelection(String userSelection, Scanner input){
        switch(userSelection){
            case "List of books":
                displayAvailableTitles("Book");
                break;
            case "List of movies":
                displayAvailableTitles("Movie");
                break;
            case "List of users":
                displayUsers();
                break;
            case "Checkout":
                System.out.println("What would you like to check out?");
                String titleToCheckOut = input.nextLine();
                if(titleToCheckOut.equals("Quit")){
                    quit = true;
                } else {
                    checkoutTitle(titleToCheckOut);
                }
                break;
            case "Return":
                System.out.println("What would you like to return?");
                String titleToReturn = input.nextLine();
                if(titleToReturn.equals("Quit")){
                    quit = true;
                } else {
                    returnTitle(titleToReturn);
                }
                break;
            case "Log in" :
                boolean loginSuccessful = logInUser(input);
                while(loginSuccessful == false){
                    System.out.println("Incorrect library number and/or password!");
                    loginSuccessful = logInUser(input);
                }
                menu = new QuitMenu(new UserMenu(new MainMenu()));
                menu.buildMenu();
                break;
            case "Quit":
                quit = true;
                System.out.println("Thank you for using Biblioteca");
                break;
        }
    }

    public boolean logInUser(Scanner input){
        System.out.println("Enter Library Number:");
        String inputLibraryNumber = input.nextLine();
        System.out.println("Enter Password:");
        String inputPassword = input.nextLine();

        if(userList.containsKey(inputLibraryNumber) && userList.get(inputLibraryNumber).getPassword().equals(inputPassword)){
            currentUserId = inputLibraryNumber;
            return true;
        } else {
            return false;
        }
    }

    // this is horrible....
    public void getDisplayMenu() {
        menu.displayMenu();
    }

    public void displayUsers(){
        System.out.println("Registered users:");
        System.out.println("----------------");
        for(Map.Entry<String, User> u : userList.entrySet()){
            System.out.println(u.getValue().toString());
        }
    }

    public Menu getMenu(){
        return menu;
    }
}
