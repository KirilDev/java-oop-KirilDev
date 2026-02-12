package rvt.todo;

public class ToDoList {

    private int id;
    private String task;

    public ToDoList(int id, String task){
        this.id = id;
        this.task = task;
    }

    public int getID(){
        return id;
    }
    public String getTask(){
        return task;
    }

    @Override
    public String toString(){
        return id + ", " + task;
    }
}
