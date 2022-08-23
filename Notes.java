package com.example.projectnumber2;

import java.util.ArrayList;

public class Notes {

    private String item;
    private static final ArrayList<Notes> itemList = new ArrayList<>();
    private static final ArrayList<Notes> itemListUrgent = new ArrayList<>();

    Notes(){
        //create default constructor
        item = "";
    }

    public Notes(String note){
        //constructor code here
        this.item = note;
    }

    //Requires: Notes you want to do the action on
    //Modifies: ArrayList
    //Effects: add to itemsList
    public void addToList (Notes a){
        itemList.add(a);
    }

    //Requires: Notes you want to do the action on
    //Modifies: ArrayList
    //Effects: add to itemsListUrgent
    public void addToUrgentList (Notes a){
        itemListUrgent.add(a);
    }

    //Requires: Notes you want to do the action on
    //Modifies: ArrayList
    //Effects: delete from itemsList
    public void deleteFromList (Notes a){
        itemList.remove(a);
    }

    //Requires: Notes you want to do the action on
    //Modifies: ArrayList
    //Effects: delete from itemsListUrgent
    public void deleteFromListUrgent (Notes a){
        itemListUrgent.remove(a);
    }

    public ArrayList<Notes> getList(){
        return itemList;
    }

    public ArrayList<Notes> getUrgentList(){
        return itemListUrgent;
    }

    public String toString (){
        return item;
    }
}
