/*    Jorge Pinochet
      Sept 15, 2008
      Practise : tempConvertOutfile
*/

import java.util.*;
import java.text.SimpleDateFormat;
import java.io.*;

public class tempConvertOutfile
{
  public static void main(String[] args)
  {
    double fahr=0;
    double cels=0;
    Scanner sc = new Scanner(System.in);
    SimpleDateFormat jorgeDateFormat = new SimpleDateFormat("MMMM-dd-yyyy");
    Date date = new Date();
    System.out.println();
    
    System.out.println(jorgeDateFormat.format(date));
    System.out.println();
    
    FileOutputStream out; 
    PrintWriter outfile;
    System.out.print("Please enter the temperature in fahrenheit: ");
    fahr = sc.nextDouble();
    cels = 5.0/9*(fahr-32);
    System.out.println("Temperature fahrenheit is "+fahr+" and temp celcius is "+cels);
    try
    {
      out= new FileOutputStream("c:\\java08\\module3DecisionStatementsFileIO\\fahr2.rpt");
      
      outfile=new PrintWriter(out);
      
      
      outfile.println("Temperature fahrenheit is "+fahr+"and temp celcius is "+cels);
      outfile.println("Goodbye");
      outfile.close();
    } 
    catch(Exception e)
    {
      System.err.println("Error reading output file");
      System.exit(1);
    }
    System.out.println("Goodbye");
  }
}