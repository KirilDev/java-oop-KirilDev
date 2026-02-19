package rvt.student_registration_system;
public class Student{

    private int id;
    private String name;
    private String surname;
    private String email;
    private String eduClass;
    private String program;
    private int personalCode;

    public Student(int id, String name, String surname, String email, String eduClass, String program){
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.eduClass = eduClass;
        this.program = program;
    }

    public String getName(){
        return name;
    }
    public String getSurname(){
        return surname;
    }
    public int getId(){
        return id;
    }
    public String getStudentEmail(){
        return email;
    }
    public String getStudentClass() {
        return eduClass;
    }
    public String getProgram(){
        return program;
    }
    public int getPersonalCode(){
        return personalCode;
    }
    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + surname + " ";
    }
}