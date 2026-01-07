package rvt.school_program;

public class App {
    public static void main(String[] args){
        Person personFirst = new Person("Kirill", "N/A", "Krišjana Valdemara", "students@rvt.lv");
        personFirst.getName();

        // personFirst.name = "Alex"; | Doesn't work because person field isn't visible.
    }
}
