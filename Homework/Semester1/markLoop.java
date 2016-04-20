import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.*;

public class markLoop
{
  public static void main(String[] args)
  {
    final int FAIL = 50;
    Scanner sc = new Scanner(System.in);
    int marksCounter;
    int numAssign;
    int numStudlnClass=0;
    int studCounter;
    
    double markValue;
    double totalValueOfMarks=0;
    double highMark=0;
    double lowMark;
    double avgMark=0;
    
    long id;
    long highId=0;
    long lowId=0;
    
    SimpleDateFormat jorgeDateFormat = new SimpleDateFormat("dd-MMMM-yyyy");
    Date date = new Date();
    System.out.println();
    System.out.println(jorgeDateFormat.format(date));
    System.out.println();
    
    markLoopOutFile outfile = new markLoopOutFile("c:\\java08\\module6\\markLoop.rpt");
    outfile.openFile();
    
    highMark = 0.0;
    lowMark = 1000.0;
    System.out.print("Please enter the number of students in the class, enter -1 to quit: ");
    numStudlnClass = sc.nextInt();
    if (numStudlnClass == -1)
    {
      System.exit(-1);
    } //end if statement
    studCounter =0;
    while (studCounter<numStudlnClass)
    {
      System.out.println("\nPlease enter the student id: ");
      id = sc.nextInt();
      System.out.println("\nPlease enter the number of marks to be entered: ");
      numAssign = sc.nextInt();
      System.out.println(numAssign);
      marksCounter=0;
      markValue=0;
      while (marksCounter<numAssign)
      {
        System.out.print("Please enter the marks: ");
        markValue=sc.nextDouble();
        totalValueOfMarks=totalValueOfMarks + markValue;
        System.out.println(totalValueOfMarks);
        marksCounter=marksCounter+1;
      } //end inner loop
      if(marksCounter!=0)
      {
        avgMark = totalValueOfMarks/numAssign;
        System.out.printf("The average mark for %d is %.2f", id, avgMark);
        System.out.println();
      } //end second if 
      totalValueOfMarks=0;
      
      outfile.writeLineToFile("\nThe average mark for "+id+" is"+avgMark);
      
      if (avgMark<FAIL)
      {
        System.out.printf("\n%d must repeat course\n", id);
        outfile.writeLineToFile("\n" + id + " must repeat course \n");
      } //end fourth if statement
      if (avgMark>FAIL)
      {
        highMark=avgMark;
        highId=id;
      } // end fifth statement
      if(avgMark<lowMark)
      {
        lowMark=avgMark;
        lowId = id;
      } //end sixth if
      studCounter = studCounter + 1;
      System.out.printf("Number of students completed is %d \n", studCounter);
    }//end loop
    System.out.printf("\nThe highest average belongs to %d and is %.2f\n", highId, highMark);
    System.out.printf("\nThe lowest average belongs to %d at %.2f \n\n", lowId, lowMark);
    outfile.writeLineToFile("\nThe highest average belongs to %d at %.2f\n", highId, highMark);
    outfile.writeLineToFile("\nThe lowest average belongs to %d at %.2f\n\n", lowId, lowMark);
    outfile.closeFile();
  } //end main method
} //end class markLoop