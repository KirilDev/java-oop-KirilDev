package rvt.student_registration_system;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    
    private static final String DATA_ACCESS = "data/students.csv";
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
                    showStudentsTable();    
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
        students.add(new Student(Id, studentName, studentSurname, studentEmail, studentClass, studentProgram));

        fileSaver();

        System.out.println("New student added!");
    }

    private static void fileSaver() {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(DATA_ACCESS))) {
            for (Student student: students){
                bufferedWriter.write(student.getId() + ", " + student.getName() + student.getSurname() + student.getClass() + student.getProgram());
                bufferedWriter.newLine();
            }
        } catch (Exception e) {
            System.out.println("Error during file update...");
        }
    }

    private static void showStudentsTable() {
       if (students.isEmpty()) {
        System.out.println("No students to show...");
        return;
       }

       for (Student student: students) {
        System.out.println(student.getId() + ": " + student.getName() + " " + student.getSurname() + " " + student.getEmail() + " " + student.getClass() + " " + student.getProgram());
       }
    }

    private static void removeStudentById() {

    }

    private static void updateStudentById() {

    }
     private static void loadFromFile(){


        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(DATA_ACCESS))) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {

                String[] parts = line.split(",\\s*");

                if (parts.length < 6) {
                    // skip malformed lines
                    continue;
                }

                int id;
                try {
                    id = Integer.parseInt(parts[0].trim());
                } catch (NumberFormatException e) {
                    // skip lines with invalid id
                    continue;
                }

                String name = parts[1].trim();
                String surname = parts[2].trim();
                String email = parts[3].trim();
                String studentClass = parts[4].trim();
                String program = parts[5].trim();

                students.add(new Student(id, name, surname, email, studentClass, program));
            }

            System.out.println("Students loaded successfully:" + "\n ");

            showStudentsTable();

            System.out.println(" ");
        } catch (IOException e) {
            System.out.println("Error while reading the file.");
        }
    }
}

