package rvt.student_registration_system;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    
    private static final String DATA_ACCESS = "data/students.cvs";
    private static List<Student> students = new ArrayList<>();
    
    
    public static void main(String[] args){
        
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("Welcome to college's student registration system! ");
            System.out.println(" ");
            System.out.println("Select action to complete: ");
            System.out.println("1 -> Add New Student");
            System.out.println("2 -> View Students Table");
            System.out.println("3 -> Remove Student by ID");
            System.out.println("4 -> Update Student Info by ID");
            System.out.println("5 -> Exit");

            
            int userInput = scanner.nextInt();
            scanner.nextLine();

            switch (userInput) {
                case 1:
                    addNewStudent(scanner);
                    break;
                case 2:
                    loadStudentTable();    
                    break;

                case 3:
                    removeStudentById();
                    break;

                case 4:
                    updateStudentById();     
                    break;

                    case 5:
                        System.exit(0);
                    break;

            
                default:
                    System.out.println("Error during program work!...");
                    main(null);
                    break;
            }
        }
    }

    private static void addNewStudent(Scanner scanner){
        System.out.println("Enter Students Name: ");
        String studentName = scanner.nextLine();

        System.out.println("Enter Students Surname: ");
        String studentSurname = scanner.nextLine();

        System.out.println("Enter Students Email: ");
        String studentEmail = scanner.nextLine();

        System.out.println("Enter Students Class: ");
        String studentClass = scanner.nextLine();

        System.out.println("Enter Students Program: ");
        String studentProgram = scanner.nextLine();

        System.out.println("Enter Students Personal Code: ");
        String studentPersonalCode = scanner.nextLine();


        int Id = students.isEmpty() ? 1 : students.get(students.size() - 1).getId() + 1;
        students.add(new Student(Id, studentName, studentSurname, studentEmail, studentClass, studentProgram, studentPersonalCode));

        fileSaver();

        System.out.println("New student added!");
    }

    private static void fileSaver() {
 
    }

    private static void loadStudentTable() {

    }

    private static void removeStudentById() {

    }

    private static void updateStudentById() {

    }
}