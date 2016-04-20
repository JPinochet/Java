/*  Jorge Pinochet
    Sept 16, 2008
    grossPay, exercise for if/else.
*/

import java.util.*;
import java.text.SimpleDateFormat;
import java.io.*;

public class grossPayPractice
{
  static Scanner sc = new Scanner(System.in);
  static final double REG = 40.0;
  static final double DBLEHRS = 60.0;
  static final double OT = 1.5;
  static final double DBLEOT = 2.0;
  
  public static void main(String[] args)
  {
    long empId;
    double wage;
    double hours;
    double grossPay = 0;
    
    SimpleDateFormat jorgeDateFormat = new SimpleDateFormat("MMMM-dd-yyyy");
    Date date = new Date();
    System.out.println();
    System.out.println(jorgeDateFormat.format(date));
    System.out.println();
    
    FileOutputStream out;
    PrintStream outfile;
    System.out.print("Please enter the employee's ID number: ");
    empId = sc.nextLong();
    System.out.print("Please enter the hours worked: ");
    hours = sc.nextDouble();
    System.out.print("Please enter hourly wage: ");
    wage = sc.nextDouble();
    
    if (hours<=0)
    {
      System.out.println("You do not qualify for a pay cheque this week!");
    }
    else if (hours<=REG)
    {
      grossPay = hours*wage;
    }
    else if (hours<=DBLEHRS)
    {
      grossPay = (REG*wage)+ (hours-REG)*(OT*wage);
    }
    else
    {
      grossPay = (REG*wage) + (DBLEHRS - REG)*wage*OT + (hours - DBLEHRS)*wage*DBLEOT;
    }
    try
    {
      out = new FileOutputStream("C:\\java08\\module3DecisionStatementsFileIO\\salary.rpt");
      outfile = new PrintStream( out);
      outfile.println(jorgeDateFormat.format(date));
      
      System.out.println("The employee ID is " + empId);
      outfile.println("The employee ID is " + empId);
      
      System.out.println("The hours worked is " + hours);
      outfile.println("The hours worked is " + hours);
      
      System.out.println("The hourly wage is " + wage);
      outfile.println("The hourly wage is " + wage);
      
      System.out.println("The gross pay is " + grossPay);
      outfile.println("The gross pay is " + grossPay);
      outfile.close();
     }
     catch(Exception e)
     {
      System.err.println("Error writing to outfile");
      System.exit(1);
     }
  }
}