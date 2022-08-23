package com.example.projectnumber2;

import java.util.ArrayList;

public class ToDo {

    private String tasks;
    private static final ArrayList<ToDo> toDoList = new ArrayList<>();
    private static final ArrayList<ToDo> toDoListUrgent = new ArrayList<>();

    public ToDo(){
        //create default constructor
        tasks = "";
    }

    public ToDo(String task){
        //constructor code here
        this.tasks = task;
    }

    //Requires: ToDoObject you want to do the action on
    //Modifies: ArrayList
    //Effects: add to toDoList
    public void addToList (ToDo a){
        toDoList.add(a);
    }

    //Requires: ToDoObject you want to do the action on
    //Modifies: ArrayList
    //Effects: add to toDoListUrgent
    public void addToUrgentList (ToDo a){
        toDoListUrgent.add(a);
    }

    //Requires: ToDoObject you want to do the action on
    //Modifies: ArrayList
    //Effects: delete from toDoList
    public void deleteFromList (ToDo a){
        toDoList.remove(a);
    }

    //Requires: ToDoObject you want to do the action on
    //Modifies: ArrayList
    //Effects: delete from toDoListUrgent
    public void deleteFromListUrgent (ToDo a){
        toDoListUrgent.remove(a);
    }

    public ArrayList<ToDo> getList(){
        return toDoList;
    }

    public ArrayList<ToDo> getListUrgent(){
        return toDoListUrgent;
    }
    public String toString (){
        return tasks;
    }
}
