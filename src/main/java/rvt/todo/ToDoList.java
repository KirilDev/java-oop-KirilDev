package rvt.todo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ToDoList {
    public static void main(String[] args){
        File file = new File("data/todo.csv");
        try {
            Scanner scanner = new Scanner(file);
            
            System.out.println(
                scanner.nextLine()
            );
        } catch (FileNotFoundException e) {
        }

    }
}
