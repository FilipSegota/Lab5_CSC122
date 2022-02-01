/*****************************************************************************
/* Author:      Filip Segota
/* Class:       CSC 122, Fall 2020
/* Assignment:  Lab 5: Programming review
/* File:        Course class
/*****************************************************************************/
import java.util.*;

public class Course{
    //field variables
    String courseCode, courseName;
    Professor instructor;
    int hours, searchCompares, sortCompares, sortMoves;
    List<Student> students;
    Student[][] seating;
    
    //constructors
    public Course(){
        courseCode = "";
        courseName = "";
        instructor = null;
        hours = 0;
        searchCompares = 0;
        sortCompares = 0;
        sortMoves = 0;
        students = new ArrayList<Student>();
        seating = new Student[3][10];
        for(Student[] row: seating){
            for(Student s: row){
                s = null;
            }
        }
    }
    public Course(String courseCode, String courseName, Professor instructor,
                  int hours){
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.instructor = instructor;
        this.hours = hours;
        searchCompares = 0;
        sortCompares = 0;
        sortMoves = 0;
        students = new ArrayList<Student>();
        seating = new Student[3][10];
        for(Student[] row: seating){
            for(Student s: row){
                s = null;
            }
        }
    }
    
    //accessors
    public String getCourseCode(){
        return courseCode;
    }
    public String getCourseName(){
        return courseName;
    }
    public String getInstructor(){
        return instructor.toString();
    }
    public int getHours(){
        return hours;
    }
    public int getSearchCompares(){
        return searchCompares;
    }
    public int getSortCompares(){
        return sortCompares;
    }
    public int getSortMoves(){
        return sortMoves;
    }
    
    //mutators
    public void setCourseCode(String courseCode){
        this.courseCode = courseCode;
    }
    public void setCourseName(String courseName){
        this.courseName = courseName;
    }
    public void setInstructor(Professor instructor){
        this.instructor = instructor;
    }
    public void setHours(int hours){
        this.hours = hours;
    }
    //for testing purpose
    public void setSearchCompares(int searchCompares){
        this.searchCompares = searchCompares;
    }
    //for testing purpose
    public void setSortCompares(int sortCompares){
        this.sortCompares = sortCompares;
    }
    //for testing purpose
    public void setSortMoves(int sortMoves){
        this.sortMoves = sortMoves;
    }
    
    //methods
    public String printStudents(){
        String s;
        
        s = "";
        
        for(int i = 0; i<students.size(); i++){
            s += students.get(i).toString() + "\n";
        }
        
        return s;
    }
    
    public void addStudent(Student s){
        students.add(s);
    }
    
    public Student removeStudent(String id){
        for(int i = 0; i<students.size(); i++){
            if(students.get(i).getId() == id) return students.remove(i);
        }
        return null;
    }
    
    public String printSeating(){
        String s;
        int r, c;
        
        s = "";
        r = -1;
        c = -1;
        
        for(Student[] row: seating){
            r++;
            for(Student x: row){
            c++;
                if(seating[r][c] == null){
                    s += " |empty| ";
                }
                else{
                    s += " |" + x.getName() + ", " + x.getId() + "| ";
                }
            }
            c = -1;
            s += "\n";
        }
        return s;
    }
    
    public void assignSeating(Student s, int r, int c){
        try{
            if(seating[r][c] == null){
                seating[r][c] = s;
            }
            else{
                System.out.println("Seat [" + r + "][" + c + "] is occupied!");
            }
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
    }
    
    public Student removeSeating(String id){
        int r, c;
        r = -1;
        c = -1;
        
        for(Student[] row: seating){
            r++;
            for(Student s: row){
                c++;
                if(s != null){
                    if(s.getId() == id){
                        seating[r][c] = null;
                        return s; 
                    }
                }         
            }
            c = -1;
        }
        return null;
    }
    
    public Student removeSeating(int r, int c){  
        try{
            Student s = seating[r][c];
            seating[r][c] = null;
            return s;
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
        return null;
    }
    
    public boolean find(String id){
        for(int i = 0; i < students.size(); i++){
            searchCompares++;
            if(students.get(i).getId().equals(id)) return true;
        }
        return false;
    }
    
    public void sort(){
        //selection sort
        for(int i = 0; i < students.size()-1; i++){
            int minIndex = i;
            for(int j = i+1; j < students.size(); j++){
                sortCompares++;
                if(students.get(j).compareTo(students.get(minIndex)) == -1){
                    minIndex = j;
                }
            }
            sortMoves++;
            Student temp = students.get(minIndex);
            students.set(minIndex, students.get(i));
            students.set(i, temp);
        }
    }
    
    public int binarySearch(int l, int r, String name){
        if(r >= 1){
            int mid = l + (r-1) / 2;
            
            if(students.get(mid).getName().equals(name)) return mid;
            
            if(students.get(mid).getName().compareTo(name) > 0){
                return binarySearch(l, mid-1, id);
            }
            return binarySearch(mid+1, r, id);
        }
        return -1;
    }
    
    public boolean findSequentialOrder(String name){
        for(int i = 0; i < students.size(); i++){
            if(students.get(i).getName().equals(name)) return true;
            else if(students.get(i).getName().compareTo(name) < 0){
                return false;
            }
        }
        return false;
    }
    
    public String toString(){
        return courseCode + " " + courseName + ", " + hours + 
               " credit hours, " + instructor.getName();
    }
}