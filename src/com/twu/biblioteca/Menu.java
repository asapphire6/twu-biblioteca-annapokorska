package com.twu.biblioteca;

import java.util.List;

public interface Menu {

    boolean validateMenuSelection(String menuSelection);
    void displayMenu();
    List<String> buildMenu();
}
