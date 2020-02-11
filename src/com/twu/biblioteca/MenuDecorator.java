package com.twu.biblioteca;

import java.util.List;

public class MenuDecorator implements Menu{

    private Menu currentMenu;

    public MenuDecorator(Menu currentMenu){
        this.currentMenu = currentMenu;
    }

    @Override
    public boolean validateMenuSelection(String menuSelection) {
        return currentMenu.validateMenuSelection(menuSelection);
    }

    @Override
    public List<String> buildMenu() {
        return currentMenu.buildMenu();
    }

    @Override
    public void displayMenu() {
        currentMenu.displayMenu();
    }

}
