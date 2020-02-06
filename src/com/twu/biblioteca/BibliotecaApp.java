package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaApp {

    private String welcomeMsg = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n";
    private List<Book> availableBooks = new ArrayList<>();

    public BibliotecaApp(){
        this.availableBooks.add(new Book("Romeo and Juliet", "William Shakespeare", "1595"));
        this.availableBooks.add(new Book("Lord of the Rings", "J.R.R.Tolkien", "1954"));
        this.availableBooks.add(new Book("Pride and Prejudice", "Jane Austen", "1813"));
        this.availableBooks.add(new Book("The Shining", "Stephen King", "1977"));
        this.availableBooks.add(new Book("The Three Musketeers", "Alexandre Dumas", "1844"));
    }

    public static void main(String[] args) {

        BibliotecaApp newApp = new BibliotecaApp();

        System.out.println(newApp.getWelcome());
        newApp.displayAvailableBooks();
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
}
