package com.example.projectnumber2;


import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.io.*;
import java.util.ArrayList;

public class HelloController {


    public Label loadSaveText;
    public Button loadFile1Button;
    public Button loadFile2Button;
    public Button loadFile3Button;
    public Button loadFile4Button;
    public Button saveFile1Button;
    public Button saveFile2Button;
    public Button saveFile3Button;
    public Button saveFile4Button;
    public TextField textPrompt1;
    public TextField textPrompt2;
    public TextField textPrompt3;
    public Label createLabel1;
    public Label createLabel2;
    public Label createLabel3;
    public Button passwordCreateButton;
    public Button toDoCreateButton;
    public Label createTitleText;
    public Button createButton;
    public Button noteCreateButton;
    public Tab passwordTab;
    public Tab toDoTab;
    public Tab notesTab;
    public Tab createTab;
    public ListView toDoList;
    public ListView toDoListUrgent;
    public ListView notesList;
    public ListView notesListUrgent;
    public ListView passwordList;
    public Label doneText;
    public Label passwordTextTitle;
    public Label accountTypeTextTitle;
    public Label usernameTextTitle;
    public Label passwordSmallTextTitle;
    public Label accountTypeText;
    public Label usernameText;
    public Label passwordText;
    public Label taskTitle;
    public Label taskSmallTitle;
    public Label taskText;
    public Label taskImportanceText;
    public Label taskUrgentText;
    public Label taskNormalText;
    public Label noteTextTitle;
    public Label noteNormalText;
    public Label noteSmallTitle;
    public Label noteText;
    public Label noteImportantText;
    public Label noteUrgentText;
    public Button passwordDeleteButton;
    public Button toDoDeleteButton;
    public Button notesDeleteButton;
    public Button toDoDeleteButtonUrgent;
    public Button notesDeleteButtonUrgent;

    public File passwordFile;
    public File notesFile;
    public File notesUrgentFile;
    public File tasksFile;
    public File tasksUrgentFile;

    //Requires: MouseEvent
    //Modifies: Label
    //Effects: Changes back the text to the original text if there is mouse activity(clicking/leaving the tab)
    public void textReturn(MouseEvent mouseEvent){
        loadSaveText.setText("CHOOSE YOUR DESIRED FILE TO LOAD/SAVE: ");
    }

    //Requires: ActionEvent
    //Modifies: Label, Tab, Button, TextField, ArrayList, ListView
    //Effects: When Load File 1 button is pressed, resets everything to its default value and transfer information from
    //text file to the proper ArrayList and ListView
    public void loadFile1(ActionEvent actionEvent) throws IOException {
        loadSaveText.setText("Go on to your noting journey!");
        createTab.setDisable(false);
        passwordTab.setDisable(false);
        toDoTab.setDisable(false);
        notesTab.setDisable(false);
        loadFile1Button.setDisable(true);
        loadFile2Button.setDisable(true);
        loadFile3Button.setDisable(true);
        loadFile4Button.setDisable(true);
        saveFile1Button.setDisable(false);
        createTitleText.setText("");
        createLabel1.setText("");
        createLabel2.setText("");
        createLabel3.setText("");
        textPrompt1.setOpacity(0.0);
        textPrompt1.clear();
        textPrompt1.setDisable(true);
        textPrompt2.setOpacity(0.0);
        textPrompt2.clear();
        textPrompt2.setDisable(true);
        textPrompt3.setOpacity(0.0);
        textPrompt3.clear();
        textPrompt3.setDisable(true);
        passwordFile = new File("PasswordFile1.txt");
        ArrayList<String> lines = new ArrayList<>();
        FileReader load = new FileReader(passwordFile);
        BufferedReader loading = new BufferedReader(load);
        String line;
        while((line = loading.readLine()) != null){
            lines.add(line);
        }
        for(int i=0; i<(lines.size()-2); i = i+3){
            String accountType = (lines.get(i)).toString();
            String username = (lines.get(i+1)).toString();
            String password = (lines.get(i+2)).toString();
            Password password1 = new Password(accountType, username, password);
            password1.addToList(password1);
            passwordList.getItems().add(password1);
        }
        tasksFile = new File("TaskFile1.txt");
        ArrayList<String> lines1 = new ArrayList<>();
        FileReader load1 = new FileReader(tasksFile);
        BufferedReader loading1 = new BufferedReader(load1);
        String line1;
        while((line1 = loading1.readLine()) != null){
            lines1.add(line1);
        }
        for(int i=0; i<(lines1.size()); i++){
            String task = (lines1.get(i)).toString();
            ToDo task1 = new ToDo(task);
            task1.addToList(task1);
            toDoList.getItems().add(task1);
        }
        tasksUrgentFile = new File("TaskFileUrgent1.txt");
        ArrayList<String> lines2 = new ArrayList<>();
        FileReader load2 = new FileReader(tasksUrgentFile);
        BufferedReader loading2 = new BufferedReader(load2);
        String line2;
        while((line2 = loading2.readLine()) != null){
            lines2.add(line2);
        }
        for(int i=0; i<(lines2.size()); i++){
            String task = (lines2.get(i)).toString();
            ToDo task1 = new ToDo(task);
            task1.addToUrgentList(task1);
            toDoListUrgent.getItems().add(task1);
        }
        notesFile = new File("NoteFile1.txt");
        ArrayList<String> lines3 = new ArrayList<>();
        FileReader load3 = new FileReader(notesFile);
        BufferedReader loading3 = new BufferedReader(load3);
        String line3;
        while((line3 = loading3.readLine()) != null){
            lines3.add(line3);
        }
        for(int i=0; i<(lines3.size()); i++){
            String note = (lines3.get(i)).toString();
            Notes notes = new Notes(note);
            notes.addToList(notes);
            notesList.getItems().add(notes);
        }
        notesUrgentFile = new File("NoteFileUrgent1.txt");
        ArrayList<String> lines4 = new ArrayList<>();
        FileReader load4 = new FileReader(notesUrgentFile);
        BufferedReader loading4 = new BufferedReader(load4);
        String line4;
        while((line4 = loading4.readLine()) != null){
            lines4.add(line4);
        }
        for(int i=0; i<(lines4.size()); i++){
            String note = (lines4.get(i)).toString();
            Notes notes = new Notes(note);
            notes.addToUrgentList(notes);
            notesListUrgent.getItems().add(notes);
        }
        Password one = new Password();
        if ((one.getList()).size()>0){
            passwordList.setDisable(false);
        } else {
            passwordList.setDisable(true);
        }
        ToDo two = new ToDo();
        if ((two.getList()).size()>0){
            toDoList.setDisable(false);
        } else {
            toDoList.setDisable(true);
        }
        if ((two.getListUrgent()).size()>0){
            toDoListUrgent.setDisable(false);
        } else {
            toDoListUrgent.setDisable(true);
        }
        Notes three = new Notes();
        if ((three.getList()).size()>0){
            notesList.setDisable(false);
        } else {
            notesList.setDisable(true);
        }
        if ((three.getUrgentList()).size()>0){
            notesListUrgent.setDisable(false);
        } else {
            notesListUrgent.setDisable(true);
        }
    }

    //Requires: ActionEvent
    //Modifies: Label, Tab, Button, TextField, ArrayList, ListView
    //Effects: When Save File 1 button is pressed, resets everything to its default value and transfer information from
    //ArrayLists and ListViews to the proper text files
    public void saveFile1(ActionEvent actionEvent) throws IOException {
        loadSaveText.setText("SAVED (☆▽☆)");
        createTab.setDisable(true);
        passwordTab.setDisable(true);
        toDoTab.setDisable(true);
        notesTab.setDisable(true);
        loadFile1Button.setDisable(false);
        loadFile2Button.setDisable(false);
        loadFile3Button.setDisable(false);
        loadFile4Button.setDisable(false);
        saveFile1Button.setDisable(true);
        accountTypeText.setText("");
        usernameText.setText("");
        passwordText.setText("");
        accountTypeTextTitle.setOpacity(0.0);
        usernameTextTitle.setOpacity(0.0);
        passwordSmallTextTitle.setOpacity(0.0);
        passwordTextTitle.setOpacity(0.0);
        taskText.setText("");
        taskTitle.setOpacity(0.0);
        taskSmallTitle.setOpacity(0.0);
        taskImportanceText.setOpacity(0.0);
        taskNormalText.setOpacity(0.0);
        taskUrgentText.setOpacity(0.0);
        noteText.setText("");
        noteTextTitle.setOpacity(0.0);
        noteSmallTitle.setOpacity(0.0);
        noteImportantText.setOpacity(0.0);
        noteNormalText.setOpacity(0.0);
        noteUrgentText.setOpacity(0.0);
        doneText.setText("");
        createButton.setOpacity(0.0);
        createButton.setDisable(true);
        passwordDeleteButton.setOpacity(0.0);
        passwordDeleteButton.setDisable(true);
        toDoDeleteButton.setOpacity(0.0);
        toDoDeleteButton.setDisable(true);
        toDoDeleteButtonUrgent.setOpacity(0.0);
        toDoDeleteButtonUrgent.setDisable(true);
        notesDeleteButton.setOpacity(0.0);
        notesDeleteButton.setDisable(true);
        notesDeleteButtonUrgent.setDisable(true);
        notesDeleteButtonUrgent.setOpacity(0.0);
        Password one = new Password();
        passwordFile = new File("PasswordFile1.txt");
        FileOutputStream save = new FileOutputStream(passwordFile);
        BufferedWriter saved = new BufferedWriter(new OutputStreamWriter(save));
        for (int i = 0; i<(one.getList()).size(); i++){
            String accountType = ((one.getList()).get(i)).getAccountType();
            String accountUser = ((one.getList()).get(i)).getAccountUser();
            String password = ((one.getList()).get(i)).getPassword();
            saved.write(accountType);
            saved.newLine();
            saved.write(accountUser);
            saved.newLine();
            saved.write(password);
            saved.newLine();
        }
        saved.close();
        (one.getList()).clear();
        passwordList.getItems().clear();
        ToDo two = new ToDo();
        tasksFile = new File("TaskFile1.txt");
        FileOutputStream save1 = new FileOutputStream(tasksFile);
        BufferedWriter saved1 = new BufferedWriter(new OutputStreamWriter(save1));
        for (int i = 0; i<(two.getList()).size(); i++){
            String task = ((two.getList()).get(i)).toString();
            saved1.write(task);
            saved1.newLine();
        }
        saved1.close();
        (two.getList()).clear();
        toDoList.getItems().clear();
        tasksUrgentFile = new File("TaskFileUrgent1.txt");
        FileOutputStream save2 = new FileOutputStream(tasksUrgentFile);
        BufferedWriter saved2 = new BufferedWriter(new OutputStreamWriter(save2));
        for (int i = 0; i<(two.getListUrgent()).size(); i++){
            String task = ((two.getListUrgent()).get(i)).toString();
            saved2.write(task);
            saved2.newLine();
        }
        saved2.close();
        (two.getListUrgent()).clear();
        toDoListUrgent.getItems().clear();
        Notes three = new Notes();
        notesFile = new File("NoteFile1.txt");
        FileOutputStream save3 = new FileOutputStream(notesFile);
        BufferedWriter saved3 = new BufferedWriter(new OutputStreamWriter(save3));
        for (int i = 0; i<(three.getList()).size(); i++){
            String task = ((three.getList()).get(i)).toString();
            saved3.write(task);
            saved3.newLine();
        }
        saved3.close();
        (three.getList()).clear();
        notesList.getItems().clear();
        notesUrgentFile = new File("NoteFileUrgent1.txt");
        FileOutputStream save4 = new FileOutputStream(notesUrgentFile);
        BufferedWriter saved4 = new BufferedWriter(new OutputStreamWriter(save4));
        for (int i = 0; i<(three.getUrgentList()).size(); i++){
            String task = ((three.getUrgentList()).get(i)).toString();
            saved4.write(task);
            saved4.newLine();
        }
        saved4.close();
        (three.getUrgentList()).clear();
        notesListUrgent.getItems().clear();
    }

    //Requires: ActionEvent
    //Modifies: Label, Tab, Button, TextField, ArrayList, ListView
    //Effects: When Load File 2 button is pressed, resets everything to its default value and transfer information from
    //text file to the proper ArrayList and ListView
    public void loadFile2(ActionEvent actionEvent) throws IOException {
        loadSaveText.setText("Go on to your noting journey!");
        createTab.setDisable(false);
        passwordTab.setDisable(false);
        toDoTab.setDisable(false);
        notesTab.setDisable(false);
        loadFile1Button.setDisable(true);
        loadFile2Button.setDisable(true);
        loadFile3Button.setDisable(true);
        loadFile4Button.setDisable(true);
        saveFile2Button.setDisable(false);
        createTitleText.setText("");
        createLabel1.setText("");
        createLabel2.setText("");
        createLabel3.setText("");
        textPrompt1.setOpacity(0.0);
        textPrompt1.clear();
        textPrompt1.setDisable(true);
        textPrompt2.setOpacity(0.0);
        textPrompt2.clear();
        textPrompt2.setDisable(true);
        textPrompt3.setOpacity(0.0);
        textPrompt3.clear();
        textPrompt3.setDisable(true);
        passwordFile = new File("PasswordFile2.txt");
        ArrayList<String> lines = new ArrayList<>();
        FileReader load = new FileReader(passwordFile);
        BufferedReader loading = new BufferedReader(load);
        String line;
        while((line = loading.readLine()) != null){
            lines.add(line);
        }
        for(int i=0; i<(lines.size()-2); i = i+3){
            String accountType = (lines.get(i)).toString();
            String username = (lines.get(i+1)).toString();
            String password = (lines.get(i+2)).toString();
            Password password1 = new Password(accountType, username, password);
            password1.addToList(password1);
            passwordList.getItems().add(password1);
        }
        tasksFile = new File("TaskFile2.txt");
        ArrayList<String> lines1 = new ArrayList<>();
        FileReader load1 = new FileReader(tasksFile);
        BufferedReader loading1 = new BufferedReader(load1);
        String line1;
        while((line1 = loading1.readLine()) != null){
            lines1.add(line1);
        }
        for(int i=0; i<(lines1.size()); i++){
            String task = (lines1.get(i)).toString();
            ToDo task1 = new ToDo(task);
            task1.addToList(task1);
            toDoList.getItems().add(task1);
        }
        tasksUrgentFile = new File("TaskFileUrgent2.txt");
        ArrayList<String> lines2 = new ArrayList<>();
        FileReader load2 = new FileReader(tasksUrgentFile);
        BufferedReader loading2 = new BufferedReader(load2);
        String line2;
        while((line2 = loading2.readLine()) != null){
            lines2.add(line2);
        }
        for(int i=0; i<(lines2.size()); i++){
            String task = (lines2.get(i)).toString();
            ToDo task1 = new ToDo(task);
            task1.addToUrgentList(task1);
            toDoListUrgent.getItems().add(task1);
        }
        notesFile = new File("NoteFile2.txt");
        ArrayList<String> lines3 = new ArrayList<>();
        FileReader load3 = new FileReader(notesFile);
        BufferedReader loading3 = new BufferedReader(load3);
        String line3;
        while((line3 = loading3.readLine()) != null){
            lines3.add(line3);
        }
        for(int i=0; i<(lines3.size()); i++){
            String note = (lines3.get(i)).toString();
            Notes notes = new Notes(note);
            notes.addToList(notes);
            notesList.getItems().add(notes);
        }
        notesUrgentFile = new File("NoteFileUrgent2.txt");
        ArrayList<String> lines4 = new ArrayList<>();
        FileReader load4 = new FileReader(notesUrgentFile);
        BufferedReader loading4 = new BufferedReader(load4);
        String line4;
        while((line4 = loading4.readLine()) != null){
            lines4.add(line4);
        }
        for(int i=0; i<(lines4.size()); i++){
            String note = (lines4.get(i)).toString();
            Notes notes = new Notes(note);
            notes.addToUrgentList(notes);
            notesListUrgent.getItems().add(notes);
        }
        Password one = new Password();
        if ((one.getList()).size()>0){
            passwordList.setDisable(false);
        } else {
            passwordList.setDisable(true);
        }
        ToDo two = new ToDo();
        if ((two.getList()).size()>0){
            toDoList.setDisable(false);
        } else {
            toDoList.setDisable(true);
        }
        if ((two.getListUrgent()).size()>0){
            toDoListUrgent.setDisable(false);
        } else {
            toDoListUrgent.setDisable(true);
        }
        Notes three = new Notes();
        if ((three.getList()).size()>0){
            notesList.setDisable(false);
        } else {
            notesList.setDisable(true);
        }
        if ((three.getUrgentList()).size()>0){
            notesListUrgent.setDisable(false);
        } else {
            notesListUrgent.setDisable(true);
        }
    }

    //Requires: ActionEvent
    //Modifies: Label, Tab, Button, TextField, ArrayList, ListView
    //Effects: When Save File 2 button is pressed, resets everything to its default value and transfer information from
    //ArrayLists and ListViews to the proper text files
    public void saveFile2(ActionEvent actionEvent) throws IOException {
        loadSaveText.setText("SAVED (☆▽☆)");
        createTab.setDisable(true);
        passwordTab.setDisable(true);
        toDoTab.setDisable(true);
        notesTab.setDisable(true);
        loadFile1Button.setDisable(false);
        loadFile2Button.setDisable(false);
        loadFile3Button.setDisable(false);
        loadFile4Button.setDisable(false);
        saveFile2Button.setDisable(true);
        accountTypeText.setText("");
        usernameText.setText("");
        passwordText.setText("");
        accountTypeTextTitle.setOpacity(0.0);
        usernameTextTitle.setOpacity(0.0);
        passwordSmallTextTitle.setOpacity(0.0);
        passwordTextTitle.setOpacity(0.0);
        taskText.setText("");
        taskTitle.setOpacity(0.0);
        taskSmallTitle.setOpacity(0.0);
        taskImportanceText.setOpacity(0.0);
        taskNormalText.setOpacity(0.0);
        taskUrgentText.setOpacity(0.0);
        noteText.setText("");
        noteTextTitle.setOpacity(0.0);
        noteSmallTitle.setOpacity(0.0);
        noteImportantText.setOpacity(0.0);
        noteNormalText.setOpacity(0.0);
        noteUrgentText.setOpacity(0.0);
        doneText.setText("");
        createButton.setOpacity(0.0);
        createButton.setDisable(true);
        passwordDeleteButton.setOpacity(0.0);
        passwordDeleteButton.setDisable(true);
        toDoDeleteButton.setOpacity(0.0);
        toDoDeleteButton.setDisable(true);
        toDoDeleteButtonUrgent.setOpacity(0.0);
        toDoDeleteButtonUrgent.setDisable(true);
        notesDeleteButton.setOpacity(0.0);
        notesDeleteButton.setDisable(true);
        notesDeleteButtonUrgent.setDisable(true);
        notesDeleteButtonUrgent.setOpacity(0.0);
        Password one = new Password();
        passwordFile = new File("PasswordFile2.txt");
        FileOutputStream save = new FileOutputStream(passwordFile);
        BufferedWriter saved = new BufferedWriter(new OutputStreamWriter(save));
        for (int i = 0; i<(one.getList()).size(); i++){
            String accountType = ((one.getList()).get(i)).getAccountType();
            String accountUser = ((one.getList()).get(i)).getAccountUser();
            String password = ((one.getList()).get(i)).getPassword();
            saved.write(accountType);
            saved.newLine();
            saved.write(accountUser);
            saved.newLine();
            saved.write(password);
            saved.newLine();
        }
        saved.close();
        (one.getList()).clear();
        passwordList.getItems().clear();
        ToDo two = new ToDo();
        tasksFile = new File("TaskFile2.txt");
        FileOutputStream save1 = new FileOutputStream(tasksFile);
        BufferedWriter saved1 = new BufferedWriter(new OutputStreamWriter(save1));
        for (int i = 0; i<(two.getList()).size(); i++){
            String task = ((two.getList()).get(i)).toString();
            saved1.write(task);
            saved1.newLine();
        }
        saved1.close();
        (two.getList()).clear();
        toDoList.getItems().clear();
        tasksUrgentFile = new File("TaskFileUrgent2.txt");
        FileOutputStream save2 = new FileOutputStream(tasksUrgentFile);
        BufferedWriter saved2 = new BufferedWriter(new OutputStreamWriter(save2));
        for (int i = 0; i<(two.getListUrgent()).size(); i++){
            String task = ((two.getListUrgent()).get(i)).toString();
            saved2.write(task);
            saved2.newLine();
        }
        saved2.close();
        (two.getListUrgent()).clear();
        toDoListUrgent.getItems().clear();
        Notes three = new Notes();
        notesFile = new File("NoteFile2.txt");
        FileOutputStream save3 = new FileOutputStream(notesFile);
        BufferedWriter saved3 = new BufferedWriter(new OutputStreamWriter(save3));
        for (int i = 0; i<(three.getList()).size(); i++){
            String task = ((three.getList()).get(i)).toString();
            saved3.write(task);
            saved3.newLine();
        }
        saved3.close();
        (three.getList()).clear();
        notesList.getItems().clear();
        notesUrgentFile = new File("NoteFileUrgent2.txt");
        FileOutputStream save4 = new FileOutputStream(notesUrgentFile);
        BufferedWriter saved4 = new BufferedWriter(new OutputStreamWriter(save4));
        for (int i = 0; i<(three.getUrgentList()).size(); i++){
            String task = ((three.getUrgentList()).get(i)).toString();
            saved4.write(task);
            saved4.newLine();
        }
        saved4.close();
        (three.getUrgentList()).clear();
        notesListUrgent.getItems().clear();
    }

    //Requires: ActionEvent
    //Modifies: Label, Tab, Button, TextField, ArrayList, ListView
    //Effects: When Load File 3 button is pressed, resets everything to its default value and transfer information from
    //text file to the proper ArrayList and ListView
    public void loadFile3(ActionEvent actionEvent) throws IOException {
        loadSaveText.setText("Go on to your noting journey!");
        createTab.setDisable(false);
        passwordTab.setDisable(false);
        toDoTab.setDisable(false);
        notesTab.setDisable(false);
        loadFile1Button.setDisable(true);
        loadFile2Button.setDisable(true);
        loadFile3Button.setDisable(true);
        loadFile4Button.setDisable(true);
        saveFile3Button.setDisable(false);
        createTitleText.setText("");
        createLabel1.setText("");
        createLabel2.setText("");
        createLabel3.setText("");
        textPrompt1.setOpacity(0.0);
        textPrompt1.clear();
        textPrompt1.setDisable(true);
        textPrompt2.setOpacity(0.0);
        textPrompt2.clear();
        textPrompt2.setDisable(true);
        textPrompt3.setOpacity(0.0);
        textPrompt3.clear();
        textPrompt3.setDisable(true);
        passwordFile = new File("PasswordFile3.txt");
        ArrayList<String> lines = new ArrayList<>();
        FileReader load = new FileReader(passwordFile);
        BufferedReader loading = new BufferedReader(load);
        String line;
        while((line = loading.readLine()) != null){
            lines.add(line);
        }
        for(int i=0; i<(lines.size()-2); i = i+3){
            String accountType = (lines.get(i)).toString();
            String username = (lines.get(i+1)).toString();
            String password = (lines.get(i+2)).toString();
            Password password1 = new Password(accountType, username, password);
            password1.addToList(password1);
            passwordList.getItems().add(password1);
        }
        tasksFile = new File("TaskFile3.txt");
        ArrayList<String> lines1 = new ArrayList<>();
        FileReader load1 = new FileReader(tasksFile);
        BufferedReader loading1 = new BufferedReader(load1);
        String line1;
        while((line1 = loading1.readLine()) != null){
            lines1.add(line1);
        }
        for(int i=0; i<(lines1.size()); i++){
            String task = (lines1.get(i)).toString();
            ToDo task1 = new ToDo(task);
            task1.addToList(task1);
            toDoList.getItems().add(task1);
        }
        tasksUrgentFile = new File("TaskFileUrgent3.txt");
        ArrayList<String> lines2 = new ArrayList<>();
        FileReader load2 = new FileReader(tasksUrgentFile);
        BufferedReader loading2 = new BufferedReader(load2);
        String line2;
        while((line2 = loading2.readLine()) != null){
            lines2.add(line2);
        }
        for(int i=0; i<(lines2.size()); i++){
            String task = (lines2.get(i)).toString();
            ToDo task1 = new ToDo(task);
            task1.addToUrgentList(task1);
            toDoListUrgent.getItems().add(task1);
        }
        notesFile = new File("NoteFile3.txt");
        ArrayList<String> lines3 = new ArrayList<>();
        FileReader load3 = new FileReader(notesFile);
        BufferedReader loading3 = new BufferedReader(load3);
        String line3;
        while((line3 = loading3.readLine()) != null){
            lines3.add(line3);
        }
        for(int i=0; i<(lines3.size()); i++){
            String note = (lines3.get(i)).toString();
            Notes notes = new Notes(note);
            notes.addToList(notes);
            notesList.getItems().add(notes);
        }
        notesUrgentFile = new File("NoteFileUrgent3.txt");
        ArrayList<String> lines4 = new ArrayList<>();
        FileReader load4 = new FileReader(notesUrgentFile);
        BufferedReader loading4 = new BufferedReader(load4);
        String line4;
        while((line4 = loading4.readLine()) != null){
            lines4.add(line4);
        }
        for(int i=0; i<(lines4.size()); i++){
            String note = (lines4.get(i)).toString();
            Notes notes = new Notes(note);
            notes.addToUrgentList(notes);
            notesListUrgent.getItems().add(notes);
        }
        Password one = new Password();
        if ((one.getList()).size()>0){
            passwordList.setDisable(false);
        } else {
            passwordList.setDisable(true);
        }
        ToDo two = new ToDo();
        if ((two.getList()).size()>0){
            toDoList.setDisable(false);
        } else {
            toDoList.setDisable(true);
        }
        if ((two.getListUrgent()).size()>0){
            toDoListUrgent.setDisable(false);
        } else {
            toDoListUrgent.setDisable(true);
        }
        Notes three = new Notes();
        if ((three.getList()).size()>0){
            notesList.setDisable(false);
        } else {
            notesList.setDisable(true);
        }
        if ((three.getUrgentList()).size()>0){
            notesListUrgent.setDisable(false);
        } else {
            notesListUrgent.setDisable(true);
        }
    }

    //Requires: ActionEvent
    //Modifies: Label, Tab, Button, TextField, ArrayList, ListView
    //Effects: When Save File 3 button is pressed, resets everything to its default value and transfer information from
    //ArrayLists and ListViews to the proper text files
    public void saveFile3(ActionEvent actionEvent) throws IOException {
        loadSaveText.setText("SAVED (☆▽☆)");
        createTab.setDisable(true);
        passwordTab.setDisable(true);
        toDoTab.setDisable(true);
        notesTab.setDisable(true);
        loadFile1Button.setDisable(false);
        loadFile2Button.setDisable(false);
        loadFile3Button.setDisable(false);
        loadFile4Button.setDisable(false);
        saveFile3Button.setDisable(true);
        accountTypeText.setText("");
        usernameText.setText("");
        passwordText.setText("");
        accountTypeTextTitle.setOpacity(0.0);
        usernameTextTitle.setOpacity(0.0);
        passwordSmallTextTitle.setOpacity(0.0);
        passwordTextTitle.setOpacity(0.0);
        taskText.setText("");
        taskTitle.setOpacity(0.0);
        taskSmallTitle.setOpacity(0.0);
        taskImportanceText.setOpacity(0.0);
        taskNormalText.setOpacity(0.0);
        taskUrgentText.setOpacity(0.0);
        noteText.setText("");
        noteTextTitle.setOpacity(0.0);
        noteSmallTitle.setOpacity(0.0);
        noteImportantText.setOpacity(0.0);
        noteNormalText.setOpacity(0.0);
        noteUrgentText.setOpacity(0.0);
        doneText.setText("");
        createButton.setOpacity(0.0);
        createButton.setDisable(true);
        passwordDeleteButton.setOpacity(0.0);
        passwordDeleteButton.setDisable(true);
        toDoDeleteButton.setOpacity(0.0);
        toDoDeleteButton.setDisable(true);
        toDoDeleteButtonUrgent.setOpacity(0.0);
        toDoDeleteButtonUrgent.setDisable(true);
        notesDeleteButton.setOpacity(0.0);
        notesDeleteButton.setDisable(true);
        notesDeleteButtonUrgent.setDisable(true);
        notesDeleteButtonUrgent.setOpacity(0.0);
        Password one = new Password();
        passwordFile = new File("PasswordFile3.txt");
        FileOutputStream save = new FileOutputStream(passwordFile);
        BufferedWriter saved = new BufferedWriter(new OutputStreamWriter(save));
        for (int i = 0; i<(one.getList()).size(); i++){
            String accountType = ((one.getList()).get(i)).getAccountType();
            String accountUser = ((one.getList()).get(i)).getAccountUser();
            String password = ((one.getList()).get(i)).getPassword();
            saved.write(accountType);
            saved.newLine();
            saved.write(accountUser);
            saved.newLine();
            saved.write(password);
            saved.newLine();
        }
        saved.close();
        (one.getList()).clear();
        passwordList.getItems().clear();
        ToDo two = new ToDo();
        tasksFile = new File("TaskFile3.txt");
        FileOutputStream save1 = new FileOutputStream(tasksFile);
        BufferedWriter saved1 = new BufferedWriter(new OutputStreamWriter(save1));
        for (int i = 0; i<(two.getList()).size(); i++){
            String task = ((two.getList()).get(i)).toString();
            saved1.write(task);
            saved1.newLine();
        }
        saved1.close();
        (two.getList()).clear();
        toDoList.getItems().clear();
        tasksUrgentFile = new File("TaskFileUrgent3.txt");
        FileOutputStream save2 = new FileOutputStream(tasksUrgentFile);
        BufferedWriter saved2 = new BufferedWriter(new OutputStreamWriter(save2));
        for (int i = 0; i<(two.getListUrgent()).size(); i++){
            String task = ((two.getListUrgent()).get(i)).toString();
            saved2.write(task);
            saved2.newLine();
        }
        saved2.close();
        (two.getListUrgent()).clear();
        toDoListUrgent.getItems().clear();
        Notes three = new Notes();
        notesFile = new File("NoteFile3.txt");
        FileOutputStream save3 = new FileOutputStream(notesFile);
        BufferedWriter saved3 = new BufferedWriter(new OutputStreamWriter(save3));
        for (int i = 0; i<(three.getList()).size(); i++){
            String task = ((three.getList()).get(i)).toString();
            saved3.write(task);
            saved3.newLine();
        }
        saved3.close();
        (three.getList()).clear();
        notesList.getItems().clear();
        notesUrgentFile = new File("NoteFileUrgent3.txt");
        FileOutputStream save4 = new FileOutputStream(notesUrgentFile);
        BufferedWriter saved4 = new BufferedWriter(new OutputStreamWriter(save4));
        for (int i = 0; i<(three.getUrgentList()).size(); i++){
            String task = ((three.getUrgentList()).get(i)).toString();
            saved4.write(task);
            saved4.newLine();
        }
        saved4.close();
        (three.getUrgentList()).clear();
        notesListUrgent.getItems().clear();
    }

    //Requires: ActionEvent
    //Modifies: Label, Tab, Button, TextField, ArrayList, ListView
    //Effects: When Load File 4 button is pressed, resets everything to its default value and transfer information from
    //text file to the proper ArrayList and ListView
    public void loadFile4(ActionEvent actionEvent) throws IOException {
        loadSaveText.setText("Go on to your noting journey!");
        createTab.setDisable(false);
        passwordTab.setDisable(false);
        toDoTab.setDisable(false);
        notesTab.setDisable(false);
        loadFile1Button.setDisable(true);
        loadFile2Button.setDisable(true);
        loadFile3Button.setDisable(true);
        loadFile4Button.setDisable(true);
        saveFile4Button.setDisable(false);
        createTitleText.setText("");
        createLabel1.setText("");
        createLabel2.setText("");
        createLabel3.setText("");
        textPrompt1.setOpacity(0.0);
        textPrompt1.clear();
        textPrompt1.setDisable(true);
        textPrompt2.setOpacity(0.0);
        textPrompt2.clear();
        textPrompt2.setDisable(true);
        textPrompt3.setOpacity(0.0);
        textPrompt3.clear();
        textPrompt3.setDisable(true);
        passwordFile = new File("PasswordFile4.txt");
        ArrayList<String> lines = new ArrayList<>();
        FileReader load = new FileReader(passwordFile);
        BufferedReader loading = new BufferedReader(load);
        String line;
        while((line = loading.readLine()) != null){
            lines.add(line);
        }
        for(int i=0; i<(lines.size()-2); i = i+3){
            String accountType = (lines.get(i)).toString();
            String username = (lines.get(i+1)).toString();
            String password = (lines.get(i+2)).toString();
            Password password1 = new Password(accountType, username, password);
            password1.addToList(password1);
            passwordList.getItems().add(password1);
        }
        tasksFile = new File("TaskFile4.txt");
        ArrayList<String> lines1 = new ArrayList<>();
        FileReader load1 = new FileReader(tasksFile);
        BufferedReader loading1 = new BufferedReader(load1);
        String line1;
        while((line1 = loading1.readLine()) != null){
            lines1.add(line1);
        }
        for(int i=0; i<(lines1.size()); i++){
            String task = (lines1.get(i)).toString();
            ToDo task1 = new ToDo(task);
            task1.addToList(task1);
            toDoList.getItems().add(task1);
        }
        tasksUrgentFile = new File("TaskFileUrgent4.txt");
        ArrayList<String> lines2 = new ArrayList<>();
        FileReader load2 = new FileReader(tasksUrgentFile);
        BufferedReader loading2 = new BufferedReader(load2);
        String line2;
        while((line2 = loading2.readLine()) != null){
            lines2.add(line2);
        }
        for(int i=0; i<(lines2.size()); i++){
            String task = (lines2.get(i)).toString();
            ToDo task1 = new ToDo(task);
            task1.addToUrgentList(task1);
            toDoListUrgent.getItems().add(task1);
        }
        notesFile = new File("NoteFile4.txt");
        ArrayList<String> lines3 = new ArrayList<>();
        FileReader load3 = new FileReader(notesFile);
        BufferedReader loading3 = new BufferedReader(load3);
        String line3;
        while((line3 = loading3.readLine()) != null){
            lines3.add(line3);
        }
        for(int i=0; i<(lines3.size()); i++){
            String note = (lines3.get(i)).toString();
            Notes notes = new Notes(note);
            notes.addToList(notes);
            notesList.getItems().add(notes);
        }
        notesUrgentFile = new File("NoteFileUrgent4.txt");
        ArrayList<String> lines4 = new ArrayList<>();
        FileReader load4 = new FileReader(notesUrgentFile);
        BufferedReader loading4 = new BufferedReader(load4);
        String line4;
        while((line4 = loading4.readLine()) != null){
            lines4.add(line4);
        }
        for(int i=0; i<(lines4.size()); i++){
            String note = (lines4.get(i)).toString();
            Notes notes = new Notes(note);
            notes.addToUrgentList(notes);
            notesListUrgent.getItems().add(notes);
        }
        Password one = new Password();
        if ((one.getList()).size()>0){
            passwordList.setDisable(false);
        } else {
            passwordList.setDisable(true);
        }
        ToDo two = new ToDo();
        if ((two.getList()).size()>0){
            toDoList.setDisable(false);
        } else {
            toDoList.setDisable(true);
        }
        if ((two.getListUrgent()).size()>0){
            toDoListUrgent.setDisable(false);
        } else {
            toDoListUrgent.setDisable(true);
        }
        Notes three = new Notes();
        if ((three.getList()).size()>0){
            notesList.setDisable(false);
        } else {
            notesList.setDisable(true);
        }
        if ((three.getUrgentList()).size()>0){
            notesListUrgent.setDisable(false);
        } else {
            notesListUrgent.setDisable(true);
        }
    }

    //Requires: ActionEvent
    //Modifies: Label, Tab, Button, TextField, ArrayList, ListView
    //Effects: When Save File 4 button is pressed, resets everything to its default value and transfer information from
    //ArrayLists and ListViews to the proper text files
    public void saveFile4(ActionEvent actionEvent) throws IOException {
        loadSaveText.setText("SAVED (☆▽☆)");
        createTab.setDisable(true);
        passwordTab.setDisable(true);
        toDoTab.setDisable(true);
        notesTab.setDisable(true);
        loadFile1Button.setDisable(false);
        loadFile2Button.setDisable(false);
        loadFile3Button.setDisable(false);
        loadFile4Button.setDisable(false);
        saveFile4Button.setDisable(true);
        accountTypeText.setText("");
        usernameText.setText("");
        passwordText.setText("");
        accountTypeTextTitle.setOpacity(0.0);
        usernameTextTitle.setOpacity(0.0);
        passwordSmallTextTitle.setOpacity(0.0);
        passwordTextTitle.setOpacity(0.0);
        taskText.setText("");
        taskTitle.setOpacity(0.0);
        taskSmallTitle.setOpacity(0.0);
        taskImportanceText.setOpacity(0.0);
        taskNormalText.setOpacity(0.0);
        taskUrgentText.setOpacity(0.0);
        noteText.setText("");
        noteTextTitle.setOpacity(0.0);
        noteSmallTitle.setOpacity(0.0);
        noteImportantText.setOpacity(0.0);
        noteNormalText.setOpacity(0.0);
        noteUrgentText.setOpacity(0.0);
        doneText.setText("");
        createButton.setOpacity(0.0);
        createButton.setDisable(true);
        passwordDeleteButton.setOpacity(0.0);
        passwordDeleteButton.setDisable(true);
        toDoDeleteButton.setOpacity(0.0);
        toDoDeleteButton.setDisable(true);
        toDoDeleteButtonUrgent.setOpacity(0.0);
        toDoDeleteButtonUrgent.setDisable(true);
        notesDeleteButton.setOpacity(0.0);
        notesDeleteButton.setDisable(true);
        notesDeleteButtonUrgent.setDisable(true);
        notesDeleteButtonUrgent.setOpacity(0.0);
        Password one = new Password();
        passwordFile = new File("PasswordFile4.txt");
        FileOutputStream save = new FileOutputStream(passwordFile);
        BufferedWriter saved = new BufferedWriter(new OutputStreamWriter(save));
        for (int i = 0; i<(one.getList()).size(); i++){
            String accountType = ((one.getList()).get(i)).getAccountType();
            String accountUser = ((one.getList()).get(i)).getAccountUser();
            String password = ((one.getList()).get(i)).getPassword();
            saved.write(accountType);
            saved.newLine();
            saved.write(accountUser);
            saved.newLine();
            saved.write(password);
            saved.newLine();
        }
        saved.close();
        (one.getList()).clear();
        passwordList.getItems().clear();
        ToDo two = new ToDo();
        tasksFile = new File("TaskFile4.txt");
        FileOutputStream save1 = new FileOutputStream(tasksFile);
        BufferedWriter saved1 = new BufferedWriter(new OutputStreamWriter(save1));
        for (int i = 0; i<(two.getList()).size(); i++){
            String task = ((two.getList()).get(i)).toString();
            saved1.write(task);
            saved1.newLine();
        }
        saved1.close();
        (two.getList()).clear();
        toDoList.getItems().clear();
        tasksUrgentFile = new File("TaskFileUrgent4.txt");
        FileOutputStream save2 = new FileOutputStream(tasksUrgentFile);
        BufferedWriter saved2 = new BufferedWriter(new OutputStreamWriter(save2));
        for (int i = 0; i<(two.getListUrgent()).size(); i++){
            String task = ((two.getListUrgent()).get(i)).toString();
            saved2.write(task);
            saved2.newLine();
        }
        saved2.close();
        (two.getListUrgent()).clear();
        toDoListUrgent.getItems().clear();
        Notes three = new Notes();
        notesFile = new File("NoteFile4.txt");
        FileOutputStream save3 = new FileOutputStream(notesFile);
        BufferedWriter saved3 = new BufferedWriter(new OutputStreamWriter(save3));
        for (int i = 0; i<(three.getList()).size(); i++){
            String task = ((three.getList()).get(i)).toString();
            saved3.write(task);
            saved3.newLine();
        }
        saved3.close();
        (three.getList()).clear();
        notesList.getItems().clear();
        notesUrgentFile = new File("NoteFileUrgent4.txt");
        FileOutputStream save4 = new FileOutputStream(notesUrgentFile);
        BufferedWriter saved4 = new BufferedWriter(new OutputStreamWriter(save4));
        for (int i = 0; i<(three.getUrgentList()).size(); i++){
            String task = ((three.getUrgentList()).get(i)).toString();
            saved4.write(task);
            saved4.newLine();
        }
        saved4.close();
        (three.getUrgentList()).clear();
        notesListUrgent.getItems().clear();
    }

    //Requires: ActionEvent
    //Modifies: Label, TextField, Button
    //Effects: When the password mode button is pressed, it switches all the labels to the proper text for creating a
    //password and setting all TextFields and buttons to appear with the correct text
    public void passwordMode(ActionEvent actionEvent){
        createTitleText.setText("keep track of your password here: (・∀・)");
        createLabel1.setText("account type: ");
        createLabel2.setText("username: ");
        createLabel3.setText("password: ");
        textPrompt1.setPromptText("type in account type. (eg. email) ");
        textPrompt1.setDisable(false);
        textPrompt2.setPromptText("type username here.");
        textPrompt2.setDisable(false);
        textPrompt3.setPromptText("type password here.");
        textPrompt3.setDisable(false);
        textPrompt1.clear();
        textPrompt2.clear();
        textPrompt3.clear();
        textPrompt1.setOpacity(1.0);
        textPrompt2.setOpacity(1.0);
        textPrompt3.setOpacity(1.0);
        createButton.setOpacity(0.3);
        createButton.setDisable(true);
        doneText.setText("");
    }

    //Requires: ActionEvent
    //Modifies: Label, TextField, Button
    //Effects: When the to do mode button is pressed, it switches all the labels to the proper text for creating a
    //password and setting all TextFields and buttons to appear with the correct text
    public void toDoMode(ActionEvent actionEvent){
        createTitleText.setText("enter your task here: (・∀・)");
        createLabel1.setText("task:");
        createLabel2.setText("importance: ");
        createLabel3.setText("");
        textPrompt1.setPromptText("type in the task");
        textPrompt1.setDisable(false);
        textPrompt2.setPromptText("type \"urgent\" for important tasks, otherwise leave blank.");
        textPrompt2.setDisable(false);
        textPrompt3.setPromptText("");
        textPrompt3.setDisable(true);
        textPrompt1.clear();
        textPrompt2.clear();
        textPrompt3.clear();
        textPrompt1.setOpacity(1.0);
        textPrompt2.setOpacity(1.0);
        textPrompt3.setOpacity(0.0);
        createButton.setOpacity(0.3);
        createButton.setDisable(true);
        doneText.setText("");
    }

    //Requires: ActionEvent
    //Modifies: Label, TextField, Button
    //Effects: When the notes mode button is pressed, it switches all the labels to the proper text for creating a
    //password and setting all TextFields and buttons to appear with the correct text
    public void notesMode(ActionEvent actionEvent){
        createTitleText.setText("enter your note here: (・∀・)");
        createLabel1.setText("note:");
        createLabel2.setText("importance: ");
        createLabel3.setText("");
        textPrompt1.setPromptText("type in the note");
        textPrompt1.setDisable(false);
        textPrompt2.setPromptText("type \"urgent\" for important notes, otherwise leave blank.");
        textPrompt2.setDisable(false);
        textPrompt3.setPromptText("");
        textPrompt3.setDisable(true);
        textPrompt1.clear();
        textPrompt2.clear();
        textPrompt3.clear();
        textPrompt1.setOpacity(1.0);
        textPrompt2.setOpacity(1.0);
        textPrompt3.setOpacity(0.0);
        createButton.setOpacity(0.3);
        createButton.setDisable(true);
        doneText.setText("");
    }

    //Requires: KeyEvent
    //Modifies: Label, button
    //Effects: Keeps the create button disabled until all the needed areas are filled
    public void ableCreate (KeyEvent keyEvent){
        String a = createTitleText.getText();
        doneText.setText("");
        if(a.equals("keep track of your password here: (・∀・)")) {
            String b = textPrompt1.getText();
            String c = textPrompt2.getText();
            String d = textPrompt3.getText();
            boolean isDisabled = (b.isEmpty() || c.isEmpty() || d.isEmpty());
            createButton.setDisable(isDisabled);
            if (isDisabled == true){
                createButton.setOpacity(0.3);
            } else if (isDisabled == false){
                createButton.setOpacity(1.0);
            }
        } else {
                String b = textPrompt1.getText();
                boolean isDisabled = (b.isEmpty());
                createButton.setDisable(isDisabled);
                if (isDisabled == true){
                    createButton.setOpacity(0.3);
                } else if (isDisabled == false){
                    createButton.setOpacity(1.0);
                }
            }
    }

    //Requires: ActionEvent
    //Modifies: ArrayList, ListView, TextField, Button
    //Effects: Depending on the mode the user is in, it will create an object with the entered information and add to
    //the appropriate ArrayList and Listview and keeps the ListView disabled until there is at least one object in
    //both lists
    public void create(ActionEvent actionEvent){
        String a = createTitleText.getText();
        if (a.equals("keep track of your password here: (・∀・)")){
            String b = textPrompt1.getText();
            String c = textPrompt2.getText();
            String d = textPrompt3.getText();
            Password one = new Password(b, c, d);
            one.addToList(one);
            passwordList.getItems().add(one);
            if ((one.getList()).size()>0){
                passwordList.setDisable(false);
            } else {
                passwordList.setDisable(true);
            }
        }else if (a.equals("enter your task here: (・∀・)")){
            String b = textPrompt1.getText();
            String c = textPrompt2.getText();
            ToDo one = new ToDo(b);
            if (c.equals("urgent")){
                one.addToUrgentList(one);
                toDoListUrgent.getItems().add(one);
                if ((one.getListUrgent()).size()>0){
                    toDoListUrgent.setDisable(false);
                } else {
                    toDoListUrgent.setDisable(true);
                }
            }else {
                one.addToList(one);
                toDoList.getItems().add(one);
                if ((one.getList()).size()>0){
                    toDoList.setDisable(false);
                } else {
                    toDoList.setDisable(true);
                }
            }

        }else if (a.equals("enter your note here: (・∀・)")){
            String b = textPrompt1.getText();
            String c = textPrompt2.getText();
            Notes one = new Notes(b);
            if (c.equals("urgent")){
                one.addToUrgentList(one);
                notesListUrgent.getItems().add(one);
                if ((one.getUrgentList()).size()>0){
                    notesListUrgent.setDisable(false);
                } else {
                    notesListUrgent.setDisable(true);
                }
            }else {
                one.addToList(one);
                notesList.getItems().add(one);
                if ((one.getList()).size()>0){
                    notesList.setDisable(false);
                } else {
                    notesList.setDisable(true);
                }
            }
        }
        textPrompt1.clear();
        textPrompt2.clear();
        textPrompt3.clear();
        createButton.setDisable(true);
        createButton.setOpacity(0.3);
        doneText.setText("DONE!  ─=≡Σ((( つ＞＜)つ");
    }

    //Requires: MouseEvent
    //Modifies: Label
    //Effects: Changes back the text to the original text if there is mouse activity(clicking/leaving the tab)
    public void doneTextGone(MouseEvent mouseEvent){
        doneText.setText("");
    }

    //Requires: MouseEvent
    //Modifies: Label, button
    //Effects: When selected an object on the Password ListView, it will show the proper information of the object
    //selected and keeps the delete button disabled and at zero opacity until an object is selected
    public void displayPassword(MouseEvent mouseEvent){
        Password one;
        one = (Password) passwordList.getSelectionModel().getSelectedItem();
        if(one == null){
            accountTypeText.setText("");
            usernameText.setText("");
            passwordText.setText("");
            accountTypeTextTitle.setOpacity(0.0);
            usernameTextTitle.setOpacity(0.0);
            passwordSmallTextTitle.setOpacity(0.0);
            passwordTextTitle.setOpacity(0.0);
            passwordDeleteButton.setOpacity(0.0);
            passwordDeleteButton.setDisable(true);
        } else {
            accountTypeText.setText(one.getAccountType());
            usernameText.setText(one.getAccountUser());
            passwordText.setText(one.getPassword());
            accountTypeTextTitle.setOpacity(1.0);
            usernameTextTitle.setOpacity(1.0);
            passwordSmallTextTitle.setOpacity(1.0);
            passwordTextTitle.setOpacity(1.0);
            boolean isDisable = one.equals(null);
            passwordDeleteButton.setDisable(isDisable);
            if (isDisable == false){
                passwordDeleteButton.setOpacity(1.0);
            }
        }
    }

    //Requires: MouseEvent
    //Modifies: Label, button
    //Effects: When selected an object on the Tasks ListView, it will show the proper information of the object
    //selected and keeps the delete button disabled and at zero opacity until an object is selected
    public void displayTasks(MouseEvent mouseEvent){
        ToDo one;
        one = (ToDo) toDoList.getSelectionModel().getSelectedItem();
        if (one == null){
            taskText.setText("");
            taskTitle.setOpacity(0.0);
            taskSmallTitle.setOpacity(0.0);
            taskImportanceText.setOpacity(0.0);
            taskNormalText.setOpacity(0.0);
            taskUrgentText.setOpacity(0.0);
            toDoDeleteButton.setOpacity(0.0);
            toDoDeleteButtonUrgent.setOpacity(0.0);
            toDoDeleteButtonUrgent.setDisable(true);
            toDoDeleteButton.setDisable(true);
        }else {
            taskText.setText(one.toString());
            taskTitle.setOpacity(1.0);
            taskSmallTitle.setOpacity(1.0);
            taskImportanceText.setOpacity(1.0);
            taskNormalText.setOpacity(1.0);
            taskUrgentText.setOpacity(0.0);
            toDoDeleteButtonUrgent.setDisable(true);
            toDoDeleteButtonUrgent.setOpacity(0.0);
            boolean isDisable = one.equals(null);
            toDoDeleteButton.setDisable(isDisable);
            if (isDisable == false){
                toDoDeleteButton.setOpacity(1.0);
            }
        }
    }

    //Requires: MouseEvent
    //Modifies: Label, button
    //Effects: When selected an object on the Urgent Tasks ListView, it will show the proper information of the object
    //selected and keeps the delete button disabled and at zero opacity until an object is selected
    public void displayUrgentTasks(MouseEvent mouseEvent){
        ToDo one;
        one = (ToDo) toDoListUrgent.getSelectionModel().getSelectedItem();
        if (one == null){
            taskText.setText("");
            taskTitle.setOpacity(0.0);
            taskSmallTitle.setOpacity(0.0);
            taskImportanceText.setOpacity(0.0);
            taskNormalText.setOpacity(0.0);
            taskUrgentText.setOpacity(0.0);
            toDoDeleteButton.setOpacity(0.0);
            toDoDeleteButtonUrgent.setOpacity(0.0);
            toDoDeleteButtonUrgent.setDisable(true);
            toDoDeleteButton.setDisable(true);
        }else {
            taskText.setText(one.toString());
            taskTitle.setOpacity(1.0);
            taskSmallTitle.setOpacity(1.0);
            taskImportanceText.setOpacity(1.0);
            taskNormalText.setOpacity(0.0);
            taskUrgentText.setOpacity(1.0);
            toDoDeleteButton.setDisable(true);
            toDoDeleteButton.setOpacity(0.0);
            boolean isDisable = one.equals(null);
            toDoDeleteButtonUrgent.setDisable(isDisable);
            if (isDisable == false){
                toDoDeleteButtonUrgent.setOpacity(1.0);
            }
        }
    }

    //Requires: MouseEvent
    //Modifies: Label, button
    //Effects: When selected an object on the Notes ListView, it will show the proper information of the object
    //selected and keeps the delete button disabled and at zero opacity until an object is selected
    public void displayNotes (MouseEvent mouseEvent){
        Notes one;
        one = (Notes) notesList.getSelectionModel().getSelectedItem();
        if (one == null){
            noteText.setText("");
            noteTextTitle.setOpacity(0.0);
            noteSmallTitle.setOpacity(0.0);
            noteImportantText.setOpacity(0.0);
            noteNormalText.setOpacity(0.0);
            noteUrgentText.setOpacity(0.0);
            notesDeleteButton.setOpacity(0.0);
            notesDeleteButton.setDisable(true);
            notesDeleteButtonUrgent.setDisable(true);
            notesDeleteButtonUrgent.setOpacity(0.0);
        }else {
            noteText.setText(one.toString());
            noteTextTitle.setOpacity(1.0);
            noteSmallTitle.setOpacity(1.0);
            noteImportantText.setOpacity(1.0);
            noteNormalText.setOpacity(1.0);
            noteUrgentText.setOpacity(0.0);
            notesDeleteButtonUrgent.setDisable(true);
            notesDeleteButtonUrgent.setOpacity(0.0);
            boolean isDisable = one.equals(null);
            notesDeleteButton.setDisable(isDisable);
            if (isDisable == false){
                notesDeleteButton.setOpacity(1.0);
            }
        }
    }

    //Requires: MouseEvent
    //Modifies: Label, button
    //Effects: When selected an object on the Urgent Notes ListView, it will show the proper information of the object
    //selected and keeps the delete button disabled and at zero opacity until an object is selected
    public void displayUrgentNotes (MouseEvent mouseEvent){
        Notes one;
        one = (Notes) notesListUrgent.getSelectionModel().getSelectedItem();
        if (one == null){
            noteText.setText("");
            noteTextTitle.setOpacity(0.0);
            noteSmallTitle.setOpacity(0.0);
            noteImportantText.setOpacity(0.0);
            noteNormalText.setOpacity(0.0);
            noteUrgentText.setOpacity(0.0);
            notesDeleteButton.setOpacity(0.0);
            notesDeleteButton.setDisable(true);
            notesDeleteButtonUrgent.setDisable(true);
            notesDeleteButtonUrgent.setOpacity(0.0);
        }else {
            noteText.setText(one.toString());
            noteTextTitle.setOpacity(1.0);
            noteSmallTitle.setOpacity(1.0);
            noteImportantText.setOpacity(1.0);
            noteNormalText.setOpacity(0.0);
            noteUrgentText.setOpacity(1.0);
            notesDeleteButton.setDisable(true);
            notesDeleteButton.setOpacity(0.0);
            boolean isDisable = one.equals(null);
            notesDeleteButtonUrgent.setDisable(isDisable);
            if (isDisable == false){
                notesDeleteButtonUrgent.setOpacity(1.0);
            }
        }
    }

    //Requires: ActionEvent
    //Modifies: Label, ArrayList, ListView, Button
    //Effects: When the delete button is pressed, the selected Password object will be deleted from the ArrayList and
    //ListView and the Labels and Button will be set to default, also disables ListView unless there is at least one
    //object in the list
    public void deletePassword (ActionEvent actionEvent){
        Password one;
        one = (Password) passwordList.getSelectionModel().getSelectedItem();
        passwordList.getItems().remove(one);
        one.deleteFromList(one);
        accountTypeText.setText("");
        usernameText.setText("");
        passwordText.setText("");
        accountTypeTextTitle.setOpacity(0.0);
        usernameTextTitle.setOpacity(0.0);
        passwordSmallTextTitle.setOpacity(0.0);
        passwordTextTitle.setOpacity(0.0);
        passwordDeleteButton.setOpacity(0.0);
        passwordDeleteButton.setDisable(true);
        if ((one.getList()).size()>0){
            passwordList.setDisable(false);
        } else {
            passwordList.setDisable(true);
        }
    }

    //Requires: ActionEvent
    //Modifies: Label, ArrayList, ListView, Button
    //Effects: When the delete button is pressed, the selected ToDoObject will be deleted from the ArrayList and
    //ListView and the Labels and Button will be set to default, also disables ListView unless there is at least one
    //object in the list
    public void deleteTasks (ActionEvent actionEvent){
        ToDo one;
        one = (ToDo) toDoList.getSelectionModel().getSelectedItem();
        toDoList.getItems().remove(one);
        one.deleteFromList(one);
        taskText.setText("");
        taskTitle.setOpacity(0.0);
        taskSmallTitle.setOpacity(0.0);
        taskImportanceText.setOpacity(0.0);
        taskNormalText.setOpacity(0.0);
        taskUrgentText.setOpacity(0.0);
        toDoDeleteButton.setOpacity(0.0);
        toDoDeleteButtonUrgent.setOpacity(0.0);
        toDoDeleteButtonUrgent.setDisable(true);
        toDoDeleteButton.setDisable(true);
        if ((one.getList()).size()>0){
            toDoList.setDisable(false);
        } else {
            toDoList.setDisable(true);
        }
    }
    //Requires: ActionEvent
    //Modifies: Label, ArrayList, ListView, Button
    //Effects: When the delete button is pressed, the selected ToDoObject will be deleted from the urgent ArrayList and
    //ListView and the Labels and Button will be set to default, also disables ListView unless there is at least one
    //object in the list
    public void deleteTasksUrgent (ActionEvent actionEvent){
        ToDo one;
        one = (ToDo) toDoListUrgent.getSelectionModel().getSelectedItem();
        toDoListUrgent.getItems().remove(one);
        one.deleteFromListUrgent(one);
        taskText.setText("");
        taskTitle.setOpacity(0.0);
        taskSmallTitle.setOpacity(0.0);
        taskImportanceText.setOpacity(0.0);
        taskNormalText.setOpacity(0.0);
        taskUrgentText.setOpacity(0.0);
        toDoDeleteButton.setOpacity(0.0);
        toDoDeleteButton.setDisable(true);
        toDoDeleteButtonUrgent.setOpacity(0.0);
        toDoDeleteButtonUrgent.setDisable(true);
        if ((one.getListUrgent()).size()>0){
            toDoListUrgent.setDisable(false);
        } else {
            toDoListUrgent.setDisable(true);
        }
    }

    //Requires: ActionEvent
    //Modifies: Label, ArrayList, ListView, Button
    //Effects: When the delete button is pressed, the selected Notes object will be deleted from the ArrayList and
    //ListView and the Labels and Button will be set to default, also disables ListView unless there is at least one
    //object in the list
    public void deleteNotes(ActionEvent actionEvent){
        Notes one;
        one = (Notes) notesList.getSelectionModel().getSelectedItem();
        notesList.getItems().remove(one);
        one.deleteFromList(one);
        noteText.setText("");
        noteTextTitle.setOpacity(0.0);
        noteSmallTitle.setOpacity(0.0);
        noteImportantText.setOpacity(0.0);
        noteNormalText.setOpacity(0.0);
        noteUrgentText.setOpacity(0.0);
        notesDeleteButton.setOpacity(0.0);
        notesDeleteButton.setDisable(true);
        notesDeleteButtonUrgent.setDisable(true);
        notesDeleteButtonUrgent.setOpacity(0.0);
        if ((one.getList()).size()>0){
            notesList.setDisable(false);
        } else {
            notesList.setDisable(true);
        }
    }

    //Requires: ActionEvent
    //Modifies: Label, ArrayList, ListView, Button
    //Effects: When the delete button is pressed, the selected Notes object will be deleted from the urgent ArrayList and
    //ListView and the Labels and Button will be set to default, also disables ListView unless there is at least one
    //object in the list
    public void deleteNotesUrgent(ActionEvent actionEvent){
        Notes one;
        one = (Notes) notesListUrgent.getSelectionModel().getSelectedItem();
        notesListUrgent.getItems().remove(one);
        one.deleteFromListUrgent(one);
        noteText.setText("");
        noteTextTitle.setOpacity(0.0);
        noteSmallTitle.setOpacity(0.0);
        noteImportantText.setOpacity(0.0);
        noteNormalText.setOpacity(0.0);
        noteUrgentText.setOpacity(0.0);
        notesDeleteButton.setOpacity(0.0);
        notesDeleteButton.setDisable(true);
        notesDeleteButtonUrgent.setDisable(true);
        notesDeleteButtonUrgent.setOpacity(0.0);
        if ((one.getUrgentList()).size()>0){
            notesListUrgent.setDisable(false);
        } else {
            notesListUrgent.setDisable(true);
        }
    }
}
