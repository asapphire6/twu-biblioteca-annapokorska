package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class UserMenu extends MenuDecorator {

    private List<String> userMenuOptions;

    public UserMenu(MainMenu currentMenu){
        super(currentMenu);
        this.userMenuOptions = new ArrayList<>();
        this.userMenuOptions.add("Checkout");
        this.userMenuOptions.add("Return");
    }

    public void displayMenu(){
        super.displayMenu();
    }

    @Override
    public List<String> buildMenu() {
        List<String> expandedMenu = super.buildMenu();
        expandedMenu.addAll(userMenuOptions);
        return expandedMenu;
    }
}
