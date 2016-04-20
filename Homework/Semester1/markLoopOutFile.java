/*
  Jorge Pinochet
  Oct 6, 08
  markLoopOutFile
*/

import java.io.*;
public class markLoopOutFile
{
  private String filename;
  private PrintWriter rptfile;
  public markLoopOutFile(String filename)
  //Output outfile = new Output("c\\java08\\module6\\markLoop.rpt");
  {
    this.filename = filename;
  } // end 
  public void openFile() // User defined methods, open file - makes connection with disk file
  {
    try
    {
      FileWriter fw = new FileWriter(filename); // makes a connectio  to the file and puts data in file
      rptfile = new PrintWriter(fw); //prints the output to the filewriter
    } //end try
    catch (IOException ioE)
    {
      // what to do if this exception is found
      System.out.println("Filename incorrect -run again");
      System.exit(-1);
    } //end catch error check
    catch (Exception e) //a catcher for all exceptions over and above an input/output exception
    {
       System.out.println("Error: " + e.getMessage());
       System.exit(-1);
    } // second error check close
  } //main method
  
  //write line to the output file
  
  public void writeLineToFile(String str, Object... args)
  {
    rptfile.printf(str, args);
    rptfile.flush();
  } // end main method
  public void closeFile()
  {
    rptfile.close();
  }
} //end class markLoopOutFile