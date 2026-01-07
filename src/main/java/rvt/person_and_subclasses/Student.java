package rvt.person_and_subclasses;
public class Student extends Person{

    private int credit = 0;
    public Student(String name, String address) {
        super(name, address);
    }
   public int credits(){
    return this.credit;
    }
    
    public void study(){
        this.credit++;
    }

     public String toString(){
        return super.toString()+"\n  Study credits "+ this.credit;
    }
}