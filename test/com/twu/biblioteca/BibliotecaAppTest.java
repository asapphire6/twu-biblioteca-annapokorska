package com.twu.biblioteca;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BibliotecaAppTest {

    private BibliotecaApp testApp = new BibliotecaApp();

    @Test
    public void shouldReturnWelcomeMessage() {
        assertThat(testApp.getWelcome(), is("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n"));
    }

    @Test
    public void shouldReturnAvailableBooks(){
        assertThat(testApp.getAvailableBooks().get(0).getTitle(), is("Romeo and Juliet"));
        assertThat(testApp.getAvailableBooks().get(2).getAuthor(), is("Jane Austen"));
        assertThat(testApp.getAvailableBooks().get(4).getYear(), is("1844"));
    }


}