package rvt.todo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    private static final String FILE_NAME = "data/todo.csv";
    private static List<ToDoList> tasks = new ArrayList<>();
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Load to-do list from file");
            System.out.println("2. Create new task in the to-do list");
            System.out.println("3. Remove task from to-do list");
            System.out.println("\"0\" to close the program");
            System.out.print("Choose: ");

            int userInput = scanner.nextInt();
            scanner.nextLine();

            switch (userInput) {
                case 1:
                    loadFromFile();
                    break;
                case 2:
                    add(scanner);
                    break;
                case 3:
                    remove(scanner);
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Error during runtime!...");
                    main(null);
                    break;
            }
        }

    }
    private static void loadFromFile(){

        
        tasks.clear(); // prevent duplicates

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_NAME))) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {

                String[] parts = line.split(",", 2);

                int id = Integer.parseInt(parts[0]);
                String task = parts[1];

                tasks.add(new ToDoList(id, task));
            }

            System.out.println("Tasks loaded successfully:" + "\n ");

            displayTasks();

            System.out.println(" ");
        } catch (IOException e) {
            System.out.println("Error while reading the file.");
        }
    }

    private static void add(Scanner scanner){
        System.out.print("Enter the task: ");
        String taskDescription = scanner.nextLine();
    
    
    int newID = tasks.isEmpty() ? 1 : tasks.get(tasks.size() - 1).getID() + 1;

    tasks.add(new ToDoList(newID, taskDescription));

    saveToFile();

    System.out.println("Saved!");
    
    
    }

    private static void saveToFile() {
    try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILE_NAME))) {
        for (ToDoList task : tasks){
            bufferedWriter.write(task.getID() + ", " + task.getTask());
            bufferedWriter.newLine();
        }
    } catch (Exception e) {
        System.out.println("Something strange happened during the file saving...");
    }
    }
    private static void remove(Scanner scanner){
        loadFromFile();

        System.out.println("Enter the ID of task to procedure: ");

        int iDToRemove = scanner.nextInt();
        scanner.nextLine();

        tasks.removeIf(task -> task.getID() == iDToRemove);

        saveToFile();
        System.out.println("Task was removed...");
    }


        private static void displayTasks() {

        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }

        for (ToDoList task : tasks) {
            System.out.println(task.getID() + ": " + task.getTask());
        }
    }
}


