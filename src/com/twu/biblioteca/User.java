package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String name;
    private String email;
    private String phoneNumber;
    private String password;
    private String libraryNumber;
    private List<Title> checkedOutTitles;

    public User(){

    }

    public User(String name, String email, String phoneNumber, String password, String libraryNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.libraryNumber = libraryNumber;
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

    public String getName(){
        return name;
    }

    @Override
    public String toString() {

        StringBuilder userRecord = new StringBuilder("Name: " + name + ", ");
        userRecord.append("Email: " + email + ", ");
        userRecord.append("Phone Number: " + phoneNumber + ", ");
        userRecord.append("Library Number: " + libraryNumber);
        userRecord.append(", Titles Checked Out: " );

        if(checkedOutTitles.isEmpty() == false) {
            for (Title t : checkedOutTitles) {
                userRecord.append(t.getTitle() + ", ");
            }
        } else {
            userRecord.append(" None");
        }
        return userRecord.toString();
    }
}
