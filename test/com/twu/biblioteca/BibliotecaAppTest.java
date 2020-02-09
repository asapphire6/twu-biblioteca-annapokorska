package com.twu.biblioteca;

import org.junit.Test;

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
        assertThat(testBiblioteca.getAvailableBooks().get(0).getTitle(), is("Romeo and Juliet"));
        assertThat(testBiblioteca.getAvailableBooks().get(2).getAuthor(), is("Jane Austen"));
        assertThat(testBiblioteca.getAvailableBooks().get(4).getYear(), is("1844"));
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
}