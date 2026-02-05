package rvt.todo;

public class App {
    public static void main(String[] args){
        ToDoList toDoList = new ToDoList();

        toDoList.loadFromFile();
    }
}
