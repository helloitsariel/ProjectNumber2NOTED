package com.example.projectnumber2;

import java.util.ArrayList;

public class Password {
    private String accountType;
    private String accountUser;
    private String password;
    private static final ArrayList<Password> passwordArrayList = new ArrayList<>();

    Password(){
        //create default constructor
        accountType = "";
        accountUser = "";
        password = "";
    }

    public Password(String accountType, String username, String password){
        //constructor code here
        this.accountType = accountType;
        this.accountUser = username;
        this.password = password;
    }

    //Requires: Password you want to do the action on
    //Modifies: ArrayList
    //Effects: Adds to passwordArrayList
    public void addToList (Password a){
        passwordArrayList.add(a);
    }

    //Requires:Password you want to do the action on
    //Modifies: ArrayList
    //Effects: deletes from passwordArrayList
    public void deleteFromList (Password a){
        passwordArrayList.remove(a);
    }
    public ArrayList<Password> getList(){
        return passwordArrayList;
    }

    public String getAccountType() {
        return accountType;
    }

    public String getAccountUser() {
        return accountUser;
    }

    public String getPassword() {
        return password;
    }

    public String toString (){
        return accountType +": "+ accountUser;
    }
}
