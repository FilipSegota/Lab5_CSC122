/*****************************************************************************
/* Author:      Filip Segota
/* Class:       CSC 122, Fall 2020
/* Assignment:  Lab 5: Programming review
/* File:        Professor class
/*****************************************************************************/
import java.util.*;
import java.util.Iterator;

public class Professor extends Person{
    //field variables
    String department;
    double salary;
    Queue<Student> advisees;
    
    //constructors
    public Professor(){
        super();
        department = "";
        salary = 0;
        advisees = new PriorityQueue<Student>();
    }
    public Professor(String name, String email, String id, String dob,
                     String department, double salary){
        super(name, email, id, dob);
        this.department = department;
        this.salary = salary;
        advisees = new PriorityQueue<Student>();
    }
    
    //accessors
    public String getDepartment(){
        return department;
    }
    public double getSalary(){
        return salary;
    }
    
    //mutators
    public void setDepartment(String department){
        this.department = department;
    }
    public void setSalary(double salary){
        this.salary = salary;
    }
    
    //methods
    public String printAdvisees(){
        String s;
        
        s = "";
        
        s += Arrays.toString(advisees.toArray()) + ", ";
        
        return s;
    }
    
    public void addAdvisee(Student s){
        advisees.add(s);
    }
    
    public String peekAdvisee(){
        return advisees.peek().toString();
    }
    
    public Student removeAdvisee(Student s){
        try{
            advisees.remove(s);
            return s;
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
        return null;
    }
    
    public String toString(){
        String s;
        
        s = "";
    
        s += super.toString() + "\n";
        s += department + ", $" + salary;
        
        return s;
    }
}