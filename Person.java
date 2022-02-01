/*****************************************************************************
/* Author:      Filip Segota
/* Class:       CSC 122, Fall 2020
/* Assignment:  Lab 5: Programming review
/* File:        Person class
/*****************************************************************************/
public class Person{
    //field variables
    String name, email, id, dob;
    
    //constructors
    public Person(){
        name = "";
        email = "";
        id = "";
        dob = "";
    }
    public Person(String name, String email, String id, String dob){
        this.name = name;
        this.email = email;
        this.id = id;
        this.dob = dob;
    }
    
    //accessors
    public String getName(){
        return name;
    }
    public String getEmail(){
        return email;
    }
    public String getId(){
        return id;
    }
    public String getDob(){
        return dob;
    }
    
    //mutators
    public void setName(String name){
        this.name = name;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setId(String id){
        this.id = id;
    }
    public void setDob(String dob){
        this.dob = dob;
    }
    
    //methods
    public boolean isEqual(Person p){
        if(p.name == name && p.email == email && p.id == id && p.dob == dob)
            return true;
        return false;
    }
    
    public String toString(){
        String s;
        
        s = "";
        
        s += name + ", " + email + ", " + id + ", " + dob;
        
        return s;
    }
}