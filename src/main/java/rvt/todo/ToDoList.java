package rvt.todo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ToDoList {
    private String COMMA_DELIMITER = ",";    
    private ArrayList<String> tasks;
    private File file = new File("data/todo.csv");

    public ToDoList () {
        this.tasks = new ArrayList<>();
    }
    public void loadFromFile(){

    }
        
    public void add(){

    }
    public void remove(){

    }
    private int getLastID(){
        return 0;
    }
}
