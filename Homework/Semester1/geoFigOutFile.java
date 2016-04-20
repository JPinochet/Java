/* 
  Jorge Pinochet 
  Sept 23, 2008
  geoFigOtFile
*/

import java.io.*;

public class gasPurchaseOutFile
{
  private String filename;
  private PrintWriter rptfile;
  
  public gasPurchaseOutFile(String filename)
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