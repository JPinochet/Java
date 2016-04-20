/* 
  Jorge Pinochet 
  Sept 23, 2008
  geoFigOtFile
*/

import java.io.*;
import java.text.DecimalFormat;    
import java.util.Date;
import java.text.SimpleDateFormat;

public class universalOutFile
{
  private String filename;
  private PrintWriter rptfile;
  
  public String printName()
  {
    return new String ("This program was written by Jorge Pinochet on October 12, 08.\n");
  }
  public String printDate()
  {
     SimpleDateFormat jorgeDateFormat = new SimpleDateFormat("MMMM-dd-yyyy");
     Date date = new Date();
     return new String("Date is " + jorgeDateFormat.format(date) + "\n");
  }
  public universalOutFile(String filename)
  {
    this.filename = filename;
  }
  public void openFile()
  {
    try
    {
      FileWriter fw = new FileWriter(filename);
      rptfile = new PrintWriter(fw);
    }
    catch (IOException ioE)
    {
      System.out.println("Filename incorrect -run again");
      System.exit(-1);
    }
    catch(Exception e)
    {
      System.out.println("Error."+ e.getMessage());
      System.exit(-1);
    }
  }
  public void writeLineToFile(String str, Object... args)
  {
    rptfile.printf(str, args);
    rptfile.flush();
  }
  public void closeFile()
  {
    rptfile.close();
  }
}