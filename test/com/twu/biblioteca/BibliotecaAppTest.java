package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


public class BibliotecaAppTest {

    private Biblioteca testBiblioteca = new Biblioteca();

    @Test
    public void shouldReturnWelcomeMessage() {
        assertThat(testBiblioteca.getWelcome(), is("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n"));
    }

    @Test
    public void shouldReturnAvailableBooks(){
        assertThat(testBiblioteca.getAvailableTitles().get(0).getTitle(), is("Romeo and Juliet"));
     //   assertThat(testBiblioteca.getAvailableBooks().get(2).getAuthor(), is("Jane Austen"));
     //   assertThat(testBiblioteca.getAvailableBooks().get(4).getYear(), is("1844"));
    }

    @Test
    public void shouldReturnFalseOnInvalidMenuSelection(){
        Scanner input = new Scanner(System.in);
        assertFalse("Menu selection is valid: ", testBiblioteca.validateMenuSelection("List"));
    }

    @Test
    public void shouldReturnTrueOnValidMenuSelection(){
        assertTrue("Menu selection is valid: ", testBiblioteca.validateMenuSelection("List of books"));
    }

    @Test
    public void shouldRemoveBookFromAvailableList(){
        //create a dummy available books list which does not include the book to be checked out
        List<Title> testTitleList = new ArrayList<>();
        testTitleList.add(new Book("Romeo and Juliet", "William Shakespeare", "1595"));
        testTitleList.add(new Book("Lord of the Rings", "J.R.R.Tolkien", "1954"));
        testTitleList.add(new Movie("Home Alone", "Chris Columbus", "1990", "unrated"));
        testTitleList.add(new Movie("Die Hard", "John McTiernan", "1988", "10"));

        testBiblioteca.checkoutTitle("The Shining");
        assertThat(testTitleList.get(0).getTitle(), is(testBiblioteca.getAvailableTitles().get(0).getTitle()));
        assertThat(testTitleList.get(1).getTitle(), is(testBiblioteca.getAvailableTitles().get(1).getTitle()));
        assertThat(testTitleList.get(2).getTitle(), is(testBiblioteca.getAvailableTitles().get(7).getTitle()));
        assertThat(testTitleList.get(3).getTitle(), is(testBiblioteca.getAvailableTitles().get(8).getTitle()));
    }
}