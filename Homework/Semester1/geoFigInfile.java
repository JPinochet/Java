/*
  Jorge Pinochet
  Oct 2, 08
  geoFigInfile
  geofig but with inputs from a file!
*/

import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.io.*;
import static java.lang.Math.*;

public class geoFigInfile
{
  public static void main(String[] args) throws IOException //error checking
  {
    char figType;
    double radius;
    double length;
    double width;
    double length1;
    double length2;
    double height;
    double area;
    
    SimpleDateFormat jorgeDateFormat = new SimpleDateFormat("dd-MMMM-yyyy");
    Date date = new Date();
    System.out.println();
    System.out.println(jorgeDateFormat.format(date));
    System.out.println();
    
    geoFigOutFile outfile = new geoFigOutFile("c:\\java08\\module5\\figType.rpt"); //new instance of class geofigoutfile.
    outfile.openFile(); //opens  outfile for geofig
    
    File file = new File("c:\\java08\\module5\\figTypeText.txt"); //infile for input, should already be created.
    
    if (!file.exists()) //error check for infile
    {
      System.out.println("Error, canot open infile");
      System.exit(0);
    } //closing if statement
    Scanner inputFile = new Scanner(file);
    
    while (inputFile.hasNext())
    {
      figType = inputFile.next().toUpperCase().charAt(0);
      switch(figType)
      {
        case 'C':
        {
          radius = inputFile.nextDouble();
          area = pow(radius,2)*PI;
          System.out.printf("The radius of the %c is %.2f and the area is %.2f.\n", figType, radius,area);
          outfile.writeLineToFile("The radius of the %c is %.2f and the area is %.2f. \n",figType, radius, area);
          break;
        } //closing case C (circle)
        case 'R':
        {
          length = inputFile.nextDouble();
          width = inputFile.nextDouble();
          area = length*width;
          System.out.printf("The length of the %c is %.2f, the width is %.2f and the area is %.2f.\n", figType, length, width, area);
          outfile.writeLineToFile("The length of the %c is %.2f, the width is %.2f and the area is %.2f. \n", figType, length, width, area);
          break;
        } // closing R (rectangle)
        case 'T':
        {
          length1 = inputFile.nextDouble();
          length2 = inputFile.nextDouble();
          height = inputFile.nextDouble();
          area = height/2*(length1+length2);
          System.out.printf("The length of the first side, the length of the second side and the height of the %c is %.2f, %.2f, %.2f and the area is %.2f.\n",figType, length1, length2, height, area);
          outfile.writeLineToFile("The length of the first side, the length of the second side and the height of the %c is %.2f, %.2f, %.2f and the area is %.2f.\n",figType, length1, length2, height, area);
          break;
        } // closing T (trapezoid)
        default:
        {
          System.out.println("Error, invalid choice");
        } //default closing error check etc..
      } //closng switch
    } //closing while loop
    inputFile.close();
    outfile.closeFile();
  } //closing main method
} //closing class