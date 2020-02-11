package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class LoginMenu extends MenuDecorator {

    private List<String> loginMenuOptions;

    public LoginMenu(Menu currentMenu) {
        super(currentMenu);
        this.loginMenuOptions = new ArrayList<>();
        this.loginMenuOptions.add("Log in");
    }

    public void displayMenu() {
        super.displayMenu();
    }

    @Override
    public List<String> buildMenu() {
        List<String> expandedMenu = super.buildMenu();
        expandedMenu.addAll(loginMenuOptions);
        return expandedMenu;
    }
}
