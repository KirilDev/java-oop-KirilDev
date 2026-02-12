package rvt.todo;

import java.io.File;
import java.util.Scanner;

public class App {
    public static void main(String[] args){

        File file = new File("data/todo.csv");
        Scanner scanner = new Scanner(System.in);


        while (true) {
            System.out.println("1. Load to-do list from file");
            System.out.println("2. Create new task in the to-do list");
            System.out.println("3. Remove task from to-do list");
            System.out.print("Choose: ");

            int userInput = scanner.nextInt();
            scanner.nextLine();

            switch (userInput) {
                case 1:
                    loadFromFile();
                    break;
            
                default:
                    break;
            }
        }

    }
    private static void loadFromFile(){

    }

    private static void create(){

    }
    private static void remove(){

    }
}
