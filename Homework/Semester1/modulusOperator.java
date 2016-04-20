/*  Jorge Pinochet
    Sept 17, 08
    modulusOperator
    
    Functionality: Create a program that will have the user input 6 different integer values for inductive cabling and then divide that measurement of
    cable by a constant value, finding the resting measure of cord and then adding them together and finding out how many total cuts of the wire there 
    are and how much is remaining after all is said and done. All these values (resting, total cuts, etc.) are to be displayed afterwards at the end of 
    the program.
    Input:     int cutThis;
               int leftOver;
               int balance;
               int totalLength=0;
               int totalGroupsCut=0;
               int totalLeftOverCuts=0;
    Output:    int leftOver;
               int balance;
               int totalCuts=0;
               int totalGroupsCut=0;
               int totalLeftOverCuts=0;
    Constants: CUT = 48;
    Formulas:  balance = cutThis/CUT;
               leftOver= cutThis%CUT;
               totalLength = totalLength + cutThis;
               
              
    Algorithm: Prompt&Get first value                         int cutThis;
               Calculate the rest and groups cut.             int leftOver, balance, totalCuts, totalGroupCuts, totalLeftOverCuts;
               Display the rest and the amount of groups cut. int leftOver, balance, totalCuts, totalGroupCuts, totalLeftOverCuts;
               
               Prompt&Get second value                         int cutThis;
               Calculate the rest and groups cut.             int leftOver, balance, totalCuts, totalGroupCuts, totalLeftOverCuts;
               Display the rest and the amount of groups cut. int leftOver, balance, totalCuts, totalGroupCuts, totalLeftOverCuts;
               
               Prompt&Get third value                         int cutThis;
               Calculate the rest and groups cut.             int leftOver, balance, totalCuts, totalGroupCuts, totalLeftOverCuts;
               Display the rest and the amount of groups cut. int leftOver, balance, totalCuts, totalGroupCuts, totalLeftOverCuts;
               
               Prompt&Get fourth value                         int cutThis;
               Calculate the rest and groups cut.             int leftOver, balance, totalCuts, totalGroupCuts, totalLeftOverCuts;
               Display the rest and the amount of groups cut. int leftOver, balance, totalCuts, totalGroupCuts, totalLeftOverCuts;
               
               Prompt&Get fifth value                         int cutThis;
               Calculate the rest and groups cut.             int leftOver, balance, totalCuts, totalGroupCuts, totalLeftOverCuts;
               Display the rest and the amount of groups cut. int leftOver, balance, totalCuts, totalGroupCuts, totalLeftOverCuts;
               
               Prompt&Get sixth value                         int cutThis;
               Calculate the rest and groups cut.             int leftOver, balance, totalCuts, totalGroupCuts, totalLeftOverCuts;
               Display the rest and the amount of groups cut. int leftOver, balance, totalCuts, totalGroupCuts, totalLeftOverCuts;
*/               

import java.util.Scanner;
import java.util.*;
import java.text.SimpleDateFormat;
import java.io.*;

public class modulusOperator
{
  static Scanner sc = new Scanner(System.in);
  static final int CUT= 48 ;
  static final int SHORTCUT= 10 ;
  
  public static void main(String[] args)
  {
    int cutThis;
    int balance;
    int leftOver;
    int totalCuts=0;
    int totalLength=0;
    int totalLeftOverUncut=0;
    
    out= new FileOutputStream("c:\\java08\\module3DecisionStatementsFileIO\\modulusOperator.rpt");
      
    outfile = new PrintWriter(out);

    
    try
    {
      SimpleDateFormat jorgeDateFormat = new SimpleDateFormat("dd-MMMM-yyyy");
      Date date = new Date();
      
      System.out.println();
      System.out.println("This program was written by Jorge Pinochet on the: ");
      System.out.println(jorgeDateFormat.format(date));
      System.out.println();
      
      FileOutputStream out;          //Outfile stream start.
      PrintWriter outfile;
      
      System.out.print("Enter then number of centimeters in the first inductance coil: ");
      cutThis = sc.nextInt();
      balance = cutThis/CUT;       //How many 48cm coils are there from this piece of inductive coil.
      leftOver = cutThis%CUT;      //How much is left over.
      totalLeftOverUncut = totalLeftOverUncut + leftOver;   //Counter for left overs.
      totalLength = totalLength + cutThis;                  //Total length calculated.
      totalCuts = totalCuts + balance;                      //Counter for total 48cm cuts made.
      System.out.println("The number of coils from the first inductance coil is: " + balance);
      System.out.println("The length leftover from the first inductance coil is: " + leftOver + "cm.");
      
      System.out.print("Enter then number of centimeters in the second inductance coil: ");
      cutThis = sc.nextInt();
      balance = cutThis/CUT;       //How many 48cm coils are there from this piece of inductive coil.
      leftOver = cutThis%CUT;      //How much is left over.
      totalLeftOverUncut = totalLeftOverUncut + leftOver;   //Counter for left overs.
      totalLength = totalLength + cutThis;                  //Total length calculated.
      totalCuts = totalCuts + balance;                      //Counter for total 48cm cuts made.
      System.out.println("The number of coils from the second inductance coil is: " + balance);
      System.out.println("The length leftover from the second inductance coil is: " + leftOver + "cm.");
      
      System.out.print("Enter then number of centimeters in the third inductance coil: ");
      cutThis = sc.nextInt();
      balance = cutThis/CUT;       //How many 48cm coils are there from this piece of inductive coil.
      leftOver = cutThis%CUT;      //How much is left over.
      totalLeftOverUncut = totalLeftOverUncut + leftOver;   //Counter for left overs.
      totalLength = totalLength + cutThis;                  //Total length calculated.
      totalCuts = totalCuts + balance;                      //Counter for total 48cm cuts made.
      System.out.println("The number of coils from the third inductance coil is: " + balance);
      System.out.println("The length leftover from the third inductance coil is: " + leftOver + "cm.");
      
      System.out.print("Enter then number of centimeters in the fourth inductance coil: ");
      cutThis = sc.nextInt();
      balance = cutThis/CUT;       //How many 48cm coils are there from this piece of inductive coil.
      leftOver = cutThis%CUT;      //How much is left over.
      totalLeftOverUncut = totalLeftOverUncut + leftOver;   //Counter for left overs.
      totalLength = totalLength + cutThis;                  //Total length calculated.
      totalCuts = totalCuts + balance;                      //Counter for total 48cm cuts made.
      System.out.println("The number of coils from the fourth inductance coil is: " + balance);
      System.out.println("The length leftover from the fourth inductance coil is: " + leftOver + "cm.");
      
      System.out.print("Enter then number of centimeters in the fifth inductance coil: ");
      cutThis = sc.nextInt();
      balance = cutThis/CUT;       //How many 48cm coils are there from this piece of inductive coil.
      leftOver = cutThis%CUT;      //How much is left over.
      totalLeftOverUncut = totalLeftOverUncut + leftOver;   //Counter for left overs.
      totalLength = totalLength + cutThis;                  //Total length calculated.
      totalCuts = totalCuts + balance;                      //Counter for total 48cm cuts made.
      System.out.println("The number of coils from the fifth inductance coil is: " + balance);
      System.out.println("The length leftover from the fifth inductance coil is: " + leftOver + "cm.");
      
      System.out.print("Enter then number of centimeters in the sixth inductance coil: ");
      cutThis = sc.nextInt();
      balance = cutThis/CUT;       //How many 48cm coils are there from this piece of inductive coil.
      leftOver = cutThis%CUT;      //How much is left over.
      totalLeftOverUncut = totalLeftOverUncut + leftOver;   //Counter for left overs.
      totalLength = totalLength + cutThis;                  //Total length calculated.
      totalCuts = totalCuts + balance;                      //Counter for total 48cm cuts made.
      System.out.println("The number of coils from the sixth inductance coil is: " + balance);
      System.out.println("The length leftover from the sixth inductance coil is: " + leftOver + "cm.");
      
      balance = totalLeftOverUncut/CUT;
      leftOver = totalLeftOverUncut%CUT;
      totalCuts = totalCuts + balance;
    
          
      System.out.println("The total length of all the inductance coils before being cut is: " + totalLength);
      System.out.println("The total number of 48cm coil cuts are: " + totalCuts);
    
      balance = leftOver/SHORTCUT;                //10 cm cuts calculated
      leftOver = leftOver%SHORTCUT;               //Real leftover after 10 cm cut(s)
    
      System.out.println("The total number of 10cm coil cuts are: " + balance);
      System.out.println("The amount of coil left over is: " + leftOver + "cm.");
      outfile.println("Goodbye");
      outfile.close();
    } 
    catch(Exception e)
    {
      System.err.println("Error reading output file");
      System.exit(1);
    }
  }
}