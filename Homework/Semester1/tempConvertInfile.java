/*
  Jorge Pinochet  
  Oct 2, 08
  tempConvertInfile.java
  Converts a temperature using an infile for data input
*/

import java.util.Scanner;
import java.io.*;

public class tempConvertInfile
{
  public static void main (String[] args) throws IOException
  {
    double fahr;
    double cels;
    char tempType;
    File file = new File("c:\\java08\\module5\\tempConvertInfile.txt");
    if (!file.exists())
    {
      System.out.println("Cannot find infile");
      System.exit(0);
    } //closing if file
    Scanner inputFile = new Scanner(file);
    while(inputFile.hasNext())
    {
      tempType = inputFile.next().toUpperCase().charAt(0);
      switch(tempType)
      {
        case 'F':
        {
          fahr = inputFile.nextDouble();
          cels = 5.0/9*(fahr-32);
          System.out.printf("Temperature fahrenheit is %.2f and in celsius is %.2f \n", fahr, cels);
          break;
        } //closing case F
        case 'C':
        {
          cels = inputFile.nextDouble();
          fahr = (9.0/5)*cels+32;
          System.out.printf("Temperature celsius is %.2f and in fahr is %.2f \n",cels, fahr);
          break;
        } //closing case C
        default:
        {
          System.out.println("invalid type");
          break;
        } //closing error check default
      } //closing switch statement
    } //cosing loop
  } //closing main method
} //closing class