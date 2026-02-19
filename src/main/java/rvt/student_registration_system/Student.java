public class Student{

    private int id;
    private String name;
    private String surname;
    private String email;
    private String eduClass;
    private String program;

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
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + surname + " ";
    }
}