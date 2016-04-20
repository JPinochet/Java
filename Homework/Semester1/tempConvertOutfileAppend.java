/*    Jorge Pinochet
      Sept 15, 08
      Practise outfiles. tempConvertOutfileappend.java
*/

import java.util.Scanner;
import java.util.*;
import java.text.SimpleDateFormat;
import java.io.*;

public class tempConvertOutfileAppend
{
  public static void main(String[] args)
  {
    double fahr=0;
    double cels=0;
    Scanner sc= new Scanner(System.in);
    
    System.out.print("Please enter the temperature in fahrenheit: ");
    fahr=sc.nextDouble();
    cels=5.0/9*(fahr-32);
    System.out.println("Temperature fahrenheit is "+fahr+" and temp celcius is "+cels);
    try
    {
      FileWriter fwriter=new FileWriter("c:\\java08\\module3DecisionStatementsFileIO\\fahr2.rpt",true);
      PrintWriter outputFile= new PrintWriter(fwriter);
      outputFile.println("Temperature fahrenheit is "+fahr+" and temp celcius is "+cels);
      outputFile.println("Goodbye");
      outputFile.close();
    } 
    catch(Exception e)
    {
      System.err.println("Error reading output file");
      System.exit(1);
    }
    System.out.println("Goodbye");
  }
}