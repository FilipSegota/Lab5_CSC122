/*****************************************************************************
/* Author:      Filip Segota
/* Class:       CSC 122, Fall 2020
/* Assignment:  Lab 5: Programming review
/* File:        Driver
/*****************************************************************************/
public class Driver{
    public static void main(String[] args){
        System.out.println("Person class testing.");
        //constructor
        Person p1 = new Person("Filip", "filip.segota@betheluniversity.edu",
                               "638005", "10/05/2000");
        //accessors
        System.out.println(p1.getName());
        System.out.println(p1.getEmail());
        System.out.println(p1.getId());
        System.out.println(p1.getDob());
        
        //mutators
        p1.setName("Mark");
        p1.setEmail("");
        p1.setId("111111");
        p1.setDob("05/10/2001");
        
        //methods
        System.out.println(p1.isEqual(p1));
        System.out.println(p1.toString());
        
        System.out.println("\nStudent class testing.");
        //constructor
        Student s1 = new Student("Filip", "filip.segota@betheluniversity.edu",
                                 "638005", "10/05/2000", (float)4.00, 15,
                                 "Computer Science");
                                 
        //accessors
        System.out.println(s1.getGpa());
        System.out.println(s1.getHours());
        System.out.println(s1.getMajor());
        
        //mutators
        s1.setGpa((float)3.00);
        s1.setHours(16);
        s1.setMajor("Cyber Security");
        
        //methods
        s1.modifyGpa(3, "A");
        //compareTo testing - will use compareTo depending on which compare to
        //is not commented out.
        //it should print 0 in both cases.
        System.out.println(s1.compareTo(s1));
        Student s4 = new Student("Alex", "alex.segota@betheluniversity.edu",
                                 "638005", "10/05/2000", (float)3.0, 15,
                                 "Computer Science");
        //it should print 1 if compareTo is comparing GPAs,
        //and -1 if comparing names
        System.out.println(s1.compareTo(s4));                         
        System.out.println(s1.toString());
        
        System.out.println("\nProfessor class testing.");
        //constructor
        Professor prof1 = new Professor("Nick", "", "222222", "",
                                        "Math and Engineering", 36100.00);
        
        //accessors
        System.out.println(prof1.getDepartment());
        System.out.println(prof1.getSalary());
        
        //mutators
        prof1.setDepartment("Education");
        prof1.setSalary(35000.00);
        
        //methods
        prof1.addAdvisee(s1);
        System.out.println(prof1.printAdvisees());
        Student s2 = new Student("Marko", "marko.segota@betheluniversity.edu",
                                 "638000", "10/05/2000", (float)4.00, 15,
                                 "Computer Science");
        Student s3 = new Student("Nikola","nikola.segota@betheluniversity.edu",
                                 "638001", "10/05/2000", (float)4.00, 15,
                                 "Computer Science");
        prof1.addAdvisee(s2);
        prof1.addAdvisee(s3);
        System.out.println(prof1.peekAdvisee());
        prof1.removeAdvisee(s1);
        prof1.removeAdvisee(s2);
        System.out.println(prof1.printAdvisees());
        System.out.println(prof1.toString());
        
        System.out.println("\nCourse class testing.");
        //constructor
        Course course1 = new Course("CSC122", "Programming 2", prof1, 3);
        
        //accessors
        System.out.println(course1.getCourseCode());
        System.out.println(course1.getCourseName());
        System.out.println(course1.getInstructor());
        System.out.println(course1.getHours());
        
        //mutators
        course1.setCourseCode("CSC310");
        course1.setCourseName("Advanced CS Topics");
        course1.setHours(2);
        Professor prof2 = new Professor("James", "", "222223", "",
                                        "Math and Engineering", 36100.00);
        course1.setInstructor(prof2);
        
        //methods
        course1.addStudent(s1);
        System.out.println(course1.printStudents());
        course1.removeStudent("638005");
        System.out.println(course1.printStudents());
        System.out.println(course1.printSeating());
        course1.assignSeating(s1, 2, 3);
        System.out.println(course1.printSeating());
        course1.removeSeating("638005");
        System.out.println(course1.printSeating());
        course1.assignSeating(s1, 0, 1);
        System.out.println(course1.printSeating());
        course1.removeSeating(0, 1);
        System.out.println(course1.printSeating());
        course1.assignSeating(s1, 0, 0);
        course1.assignSeating(s2, 0, 1);
        course1.assignSeating(s3, 0, 2);
        System.out.println(course1.printSeating());
        System.out.println(course1.toString());
        
        System.out.println("\nFind testing.");
        Course course2 = new Course("XXX", "Testing", prof1, 0);
        for(int i = 0; i<20; i++){
            Student sx = new Student(Integer.toString(i), "",
                                     Integer.toString(i), "", 0, 0,
                                     "");
            course2.addStudent(sx);
        }
        System.out.println("\nSmall data.");
        System.out.println("\nBeginning");
        course2.find("3");
        System.out.println(course2.getSearchCompares());
        course2.setSearchCompares(0);
        System.out.println("\nMiddle");
        course2.find("10");
        System.out.println(course2.getSearchCompares());
        course2.setSearchCompares(0);
        System.out.println("\nEnd");
        course2.find("18");
        System.out.println(course2.getSearchCompares());
        course2.setSearchCompares(0);
        
        for(int i = 20; i<200; i++){
            Student sx = new Student(Integer.toString(i), "",
                                     Integer.toString(i), "", 0, 0,
                                     "");
            course2.addStudent(sx);
        }
        System.out.println("\nMedium data.");
        System.out.println("\nBeginning");
        course2.find("3");
        System.out.println(course2.getSearchCompares());
        course2.setSearchCompares(0);
        System.out.println("\nMiddle");
        course2.find("100");
        System.out.println(course2.getSearchCompares());
        course2.setSearchCompares(0);
        System.out.println("\nEnd");
        course2.find("197");
        System.out.println(course2.getSearchCompares());
        course2.setSearchCompares(0);
        
        for(int i = 200; i<1000; i++){
            Student sx = new Student(Integer.toString(i), "",
                                     Integer.toString(i), "", 0, 0,
                                     "");
            course2.addStudent(sx);
        }
        System.out.println("\nLarge data.");
        System.out.println("\nBeginning");
        course2.find("3");
        System.out.println(course2.getSearchCompares());
        course2.setSearchCompares(0);
        System.out.println("\nMiddle");
        course2.find("500");
        System.out.println(course2.getSearchCompares());
        course2.setSearchCompares(0);
        System.out.println("\nEnd");
        course2.find("999");
        System.out.println(course2.getSearchCompares());
        
        System.out.println("\nSort testing.");
        Course course3 = new Course("XXX", "Testing", prof1, 0);
        for(int i = 0; i<20; i++){
            Student sx = new Student(Integer.toString(i), "",
                                     Integer.toString(i), "", 0, 0,
                                     "");
            course3.addStudent(sx);
        }
        
        System.out.println("\nSmall data in order.");
        course3.sort();
        System.out.println(course3.getSortCompares());
        System.out.println(course3.getSortMoves());
        course3.setSortCompares(0);
        course3.setSortMoves(0);
        
        for(int i = 20; i<200; i++){
            Student sx = new Student(Integer.toString(i), "",
                                     Integer.toString(i), "", 0, 0,
                                     "");
            course3.addStudent(sx);
        }
        
        System.out.println("\nMedium data in order.");
        course3.sort();
        System.out.println(course3.getSortCompares());
        System.out.println(course3.getSortMoves());
        course3.setSortCompares(0);
        course3.setSortMoves(0);
        
        for(int i = 200; i<1000; i++){
            Student sx = new Student(Integer.toString(i), "",
                                     Integer.toString(i), "", 0, 0,
                                     "");
            course3.addStudent(sx);
        }
        
        System.out.println("\nLarge data in order.");
        course3.sort();
        System.out.println(course3.getSortCompares());
        System.out.println(course3.getSortMoves());
        
        Course course4 = new Course("XXX", "Testing", prof1, 0);
        for(int i = 19; i>=0; i--){
            Student sx = new Student(Integer.toString(i), "",
                                     Integer.toString(i), "", 0, 0,
                                     "");
            course4.addStudent(sx);
        }
        System.out.println("\nSmall data in reverse.");
        System.out.println("\nSmall data in reverse:");
        System.out.println(course4.printStudents());
        course4.sort();
        System.out.println("\nSmall data after sort:");
        System.out.println(course4.printStudents());
        System.out.println(course4.getSortCompares());
        System.out.println(course4.getSortMoves());
    }
}