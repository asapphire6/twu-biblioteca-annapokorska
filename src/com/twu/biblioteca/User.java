package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String name;
    private String email;
    private String phoneNumber;
    private String password;
    private List<Title> checkedOutTitles;

    public User(){

    }

    public User(String name, String email, String phoneNumber, String password) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.checkedOutTitles = new ArrayList<>();
    }

    public String getPassword(){
        return password;
    }

    public void addToCheckedOutTitles(Title title){
        checkedOutTitles.add(title);
    }

    public void returnCheckedOutTitle(Title title){
        for(int i = 0; i < checkedOutTitles.size(); i++){
            if(checkedOutTitles.get(i).getTitle().equals(title.getTitle())){
                checkedOutTitles.remove(i);
            }
        }
    }

    @Override
    public String toString() {
        return "User{" +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
