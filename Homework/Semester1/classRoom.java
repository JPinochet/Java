/*  Jorge Pinochet
    Sept 9,08
    classrm.java
*/

import java.util.Scanner;
public class classRoom
{
  static Scanner sc = new Scanner(System.in);
  static final int GROUP=3;
  
  public static void main(String[] args)
  {
    int classrm;
    int group;
    int balance;
    int totalStudents=0;
    int totalGroups=0;
    int totalLeft=0;
    
    System.out.print("Enter then number of students in class 1: ");
    classrm = sc.nextInt();
    group = classrm/GROUP;
    balance = classrm%GROUP;
    totalLeft = totalLeft+balance;
    totalStudents = totalStudents + classrm;
    totalGroups = totalGroups+ group;
    System.out.println("The number of groups in class 1 is: " + group);
    System.out.println("The number of students left in class 1 is: " + balance);
    
    System.out.print("Enter then number of students in class 2: ");
    classrm = sc.nextInt();
    group = classrm/GROUP;
    balance = classrm%GROUP;
    totalLeft = totalLeft+balance;
    totalStudents = totalStudents + classrm;
    totalGroups = totalGroups+ group;
    System.out.println("The number of groups in class 2 is: " + group);
    System.out.println("The number of students left in class 2 is: " + balance);
    
    System.out.print("Enter then number of students in class 3: ");
    classrm = sc.nextInt();
    group = classrm/GROUP;
    balance = classrm%GROUP;
    totalLeft = totalLeft+balance;
    totalStudents = totalStudents + classrm;
    totalGroups = totalGroups+ group;
    System.out.println("The number of groups in class 3 is: " + group);
    System.out.println("The number of students left in class 3 is: " + balance);
    
    System.out.print("Enter then number of students in class 4: ");
    classrm = sc.nextInt();
    group = classrm/GROUP;
    balance = classrm%GROUP;
    totalLeft = totalLeft+balance;
    totalStudents = totalStudents + classrm;
    totalGroups = totalGroups+ group;
    System.out.println("The number of groups in class 4 is: " + group);
    System.out.println("The number of students left in class 4 is: " + balance);
    
    System.out.print("Enter then number of students in class 5: ");
    classrm = sc.nextInt();
    group = classrm/GROUP;
    balance = classrm%GROUP;
    totalLeft = totalLeft+balance;
    totalStudents = totalStudents + classrm;
    totalGroups = totalGroups+ group;
    System.out.println("The number of groups in class 5 is: " + group);
    System.out.println("The number of students left in class 5 is: " + balance);
    
    System.out.print("Enter then number of students in class 6: ");
    classrm = sc.nextInt();
    group = classrm/GROUP;
    balance = classrm%GROUP;
    totalLeft = totalLeft+balance;
    totalStudents = totalStudents + classrm;
    totalGroups = totalGroups+ group;
    System.out.println("The number of groups in class 6 is: " + group);
    System.out.println("The number of students left in class 6 is: " + balance);
    
    System.out.println("The number of students left from all classrooms" + totalLeft);
    group = totalLeft/GROUP;
    balance = totalLeft%GROUP;
    totalGroups=totalGroups+group;
    
    System.out.println("The total number of students is " +totalStudents);
    System.out.println("The total number of groups is " +totalGroups);
    System.out.println("The total number of students left after all groups have been formed is " + balance);
    
    
  }
}