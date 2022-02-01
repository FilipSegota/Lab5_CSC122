/*****************************************************************************
/* Author:      Filip Segota
/* Class:       CSC 122, Fall 2020
/* Assignment:  Lab 5: Programming review
/* File:        Student class
/*****************************************************************************/
public class Student extends Person implements Comparable<Student>{
    //field variables
    float gpa;
    int hours;
    String major;
    
    //constructors
    public Student(){
        super();
        gpa = 0;
        hours = 0;
        major = "";
    }
    public Student(String name, String email, String id, String dob,
                   float gpa, int hours, String major){
        super(name, email, id, dob);
        this.gpa = gpa;
        this.hours = hours;
        this.major = major;
    }
    
    //accessors
    public float getGpa(){
        return gpa;
    }
    public int getHours(){
        return hours;
    }
    public String getMajor(){
        return major;
    }
    
    //mutators
    public void setGpa(float gpa){
        this.gpa = gpa;
    }
    public void setHours(int hours){
        this.hours = hours;
    }
    public void setMajor(String major){
        this.major = major;
    }
    
    //methods
    public void modifyGpa(int courseHours, String grade){
    //this will be called when adding Course to the student list of courses
    //method of the Course will be called for argument courseHours
    //Course.getHours();
        float temp;
        switch(grade.toUpperCase()){
            case "A":
                temp = gpa*hours;
                hours += courseHours;
                gpa = (float)(temp + courseHours * 4.00) / (float)hours;
                break;
            case "A-":
                temp = gpa*hours;
                hours += courseHours;
                gpa = (float)(temp + courseHours * 3.70) / (float)hours;
                break;
            case "B+":
                temp = gpa*hours;
                hours += courseHours;
                gpa = (float)(temp + courseHours * 3.33) / (float)hours;
                break;
            case "B":
                temp = gpa*hours;
                hours += courseHours;
                gpa = (float)(temp + courseHours * 3.00) / (float)hours;
                break;
            case "B-":
                temp = gpa*hours;
                hours += courseHours;
                gpa = (float)(temp + courseHours * 2.70) / (float)hours;
                break;
            case "C+":
                temp = gpa*hours;
                hours += courseHours;
                gpa = (float)(temp + courseHours * 2.30) / (float)hours;
                break;
            case "C":
                temp = gpa*hours;
                hours += courseHours;
                gpa = (float)(temp + courseHours * 2.00) / (float)hours;
                break;
            case "C-":
                temp = gpa*hours;
                hours += courseHours;
                gpa = (float)(temp + courseHours * 1.70) / (float)hours;
                break;
            case "D+":
                temp = gpa*hours;
                hours += courseHours;
                gpa = (float)(temp + courseHours * 1.30) / (float)hours;
                break;
            case "D":
                temp = gpa*hours;
                hours += courseHours;
                gpa = (float)(temp + courseHours * 1.00) / (float)hours;
                break;
            case "D-":
                temp = gpa*hours;
                hours += courseHours;
                gpa = (float)(temp + courseHours * 0.70) / (float)hours;
                break;
        }
    }
    
//     public int compareTo(Student s){
//         if(gpa == s.gpa) return 0;
//         else if(gpa > s.gpa) return 1;
//         else return -1;
//     }
//     
    public int compareTo(Student s){
        int compare;
        compare = name.compareTo(s.name);
        if(compare == 0) return 0;
        else if(compare < 0) return 1;
        else return -1;
    }
    
    public String toString(){
        String s;
        
        s = "";
    
        s += super.toString() + "\n";
        s += Math.round(gpa * 100.0) / 100.0 + ", " + hours +
             " credit hours, " + major;
        return s;
    }
}