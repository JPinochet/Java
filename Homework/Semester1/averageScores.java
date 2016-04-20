/* Jorge Pinochet
   Assignement 1
   Sept 11, 2008
   Analysis:
Functionality: There program will take 3 grades from the user, as integers. The program will report back the grades to the user. 
Then the program will then calculate the average of these as a real number and then display this answer in the next line.
Inputs:    the three test scores.    -Int markOne, 
                                     -Int markTwo,
                                     -Int markThree
Outputs:                             -Int markOne, 
                                     -Int markTwo,
                                     -Int markThree,
                                     -Real (double) averageMark.
Constant:                            -NUMDIVISOR
Formulas:  averageMark(markOne+markTwo+markThree) / NUMDIVISOR

*/

import java.util.Scanner;
import java.text.DecimalFormat;
import static java.lang.Math.pow;                                              //input functions from different files/library.

public class averageScores
{
  static Scanner scn = new Scanner(System.in);                                 //introducing the Scanner class.
  static final int NUMDIVISOR=3;
  public static void main(String[] args)
  {
    System.out.println("This program was written by Jorge Pinochet.");
    System.out.println();
    
    System.out.print("Enter the first Grade Please : ");                       //Prompting for the grades from 
    int firstMark = scn.nextInt();
    
    System.out.print("Enter the second Grade Please: ");
    int secondMark = scn.nextInt();
    
    System.out.print("Enter the third Grade Please: ");
    int thirdMark = scn.nextInt();
    
    System.out.println("These are you marks: " + "\t" + firstMark + "," + "\t" + secondMark + ",  " + "\t" + thirdMark+".");   //Display Marks.
    System.out.println();                                                                                           //Space
    double averageMark = ((double)firstMark + (double)secondMark + (double)thirdMark)/NUMDIVISOR;    //Calculating averages for the grades.
    DecimalFormat nf = new DecimalFormat("#,###,##0.00");                                                   //Decimal place assignment.
    System.out.println("This is your average: " + nf.format(averageMark));
   }
 }