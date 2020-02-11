package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class QuitMenu extends MenuDecorator{

    private List<String> quitMenuOptions;

    public QuitMenu(Menu currentMenu){
        super(currentMenu);
        this.quitMenuOptions = new ArrayList<>();
        this.quitMenuOptions.add("Quit");
    }

    public void displayMenu(){
        super.displayMenu();
    }

    @Override
    public List<String> buildMenu() {
        List<String> expandedMenu = super.buildMenu();
        expandedMenu.addAll(quitMenuOptions);
        return expandedMenu;
    }
}
