/*
  Jorge Pinochet
  Oct 2, 08
  fuelTypeInfile.java
  gas / oil using infile
*/
import java.util.Scanner;
import java.io.*;
import static java.lang.Math.*;

public class fuelTypeInfile
{
  static final double GST = 1.05;
  static final int LITRESPERCASE = 12;
  static final double COSTOIL = 1.27;
  static final double COSTGAS = 1.07;
  static final double DISCGAS = 0.90;
  static final double DISCOIL = 0.90;
  
  static final int GASDISTHRESH = 4000;
  static final int OILDISCTHRESH = 8;
  
  public static void main(String[] args) throws IOException
  {
    char purchType;
    int volume;
    double costNoGstNoDisc;
    double costNoGstWithDisc;
    double costWithGst;
    
    gasPurchaseOutFile outfile = new gasPurchaseOutFile("c:\\java08\\module5\\gas.rpt");  //new instance of outfile
    outfile.openFile(); //opening outfile to use
    String name = outfile.printName();   // not sure what happens here
    outfile.writeLineToFile(name); //writing to outfile
    System.out.println(name); //printing name to command prompt
    String date = outfile.printDate(); // inporting date from outfie
    outfile.writeLineToFile(date);   //writing date to outfile
    System.out.println(date); //display date
    
    System.out.println(); //space in the program
    File file = new File("c:\\java08\\module5\\gasOilText.txt"); //new instance of infile
    if (!file.exists()) //error check for infile
    {
      System.out.println("Cannot find infile");
      System.exit(0);
    } //closing if statement
    Scanner inputFile = new Scanner(file); //scanning from the infile instead of keyboard
    
    while (inputFile.hasNext()) // scanning each line from infile
    {
      purchType = inputFile.next().toUpperCase().charAt(0);
      switch (purchType)
      {
        case 'G':
        {
          volume = inputFile.nextInt();
          if (volume > GASDISTHRESH)
          {
            costNoGstNoDisc = volume * COSTGAS;
            costNoGstWithDisc = costNoGstNoDisc * DISCGAS;
            costWithGst = costNoGstWithDisc * GST;
            
            System.out.printf("You purchased %d litres \n",volume);
            System.out.printf("The cost of the %c before discount is $%.2f. \n",purchType,costNoGstNoDisc);
            System.out.printf("The cost of the %c after discount is $%.2f. \n",purchType,costNoGstWithDisc);
            System.out.printf("The cost of the %c after discount and GST is $%.2f. \n",purchType,costWithGst);
            System.out.println();
            
            outfile.writeLineToFile("You purchased %d litres \n", volume);
            outfile.writeLineToFile("The cost of the %c before discount is $%.2f. \n",purchType,costNoGstNoDisc);
            outfile.writeLineToFile("The cost of the %c after discount is $%.2f. \n",purchType,costNoGstWithDisc);
            outfile.writeLineToFile("The cost of the %c after discount and GST is $%.2f. \n",purchType,costWithGst);
          } //closing if claus, w/ discount
          else
          {
            costNoGstNoDisc = volume * COSTGAS;
            costWithGst = costNoGstNoDisc * GST;
            
            System.out.printf("You purchased %d litres \n",volume);
            System.out.printf("The cost of the %c is $%.2f. \n",purchType,costNoGstNoDisc);
            System.out.printf("The cost of the %c with GST is $%.2f. \n",purchType,costWithGst);
            System.out.println("You did not purchase enough gasoline to qualify for a discount");
            System.out.println();
            
            outfile.writeLineToFile("You purchased %d litres \n", volume);
            outfile.writeLineToFile("The cost of the %c is $%.2f. \n",purchType,costNoGstNoDisc);
            outfile.writeLineToFile("The cost of the %c with GST is $%.2f. \n",purchType,costWithGst);
            outfile.writeLineToFile("You did not purchase enough gasoline to qualify for a discount");
          } //closing else claus, no discount
          break;
        } // closing Gas switch method
        case 'O':
        {
          volume = inputFile.nextInt();
          if (volume > OILDISCTHRESH)
          {
            volume = volume * LITRESPERCASE;
            costNoGstNoDisc = volume * COSTOIL;
            costNoGstWithDisc = costNoGstNoDisc * DISCOIL;
            costWithGst = costNoGstWithDisc * GST;
            
            System.out.printf("You purchased %d litres \n", volume);
            System.out.printf("The cost of the %c before discount is $%.2f. \n",purchType,costNoGstNoDisc);
            System.out.printf("The cost of the %c after discount is $%.2f. \n",purchType,costNoGstWithDisc);
            System.out.printf("The cost of the %c after discount and with GST is $%.2f. \n",purchType,costWithGst);
            System.out.println();
            
            outfile.writeLineToFile("You purchased %d litres \n", volume);
            outfile.writeLineToFile("The cost of the %c before discount is $%.2f. \n", purchType,costNoGstNoDisc);
            outfile.writeLineToFile("The cost of the %c after discount is $%.2f. \n", purchType,costNoGstWithDisc);
            outfile.writeLineToFile("The cost of the %c after discount and with GST is $%.2f. \n",purchType,costWithGst);
          }//closing in claus, w/ discount
          else 
          {
            volume = volume * LITRESPERCASE;
            costNoGstNoDisc = volume * COSTOIL;
            costWithGst = costNoGstNoDisc * GST;
            
            System.out.printf("You purchased %d litres \n", volume);
            System.out.printf("The cost of the %c before discount is $%.2f. \n", purchType,costNoGstNoDisc);
            System.out.printf("The cost of the %c with GST is $%.2f. \n", purchType,costWithGst);
            System.out.println("You did not purchase enough oil to qualify for a discount");
            System.out.println();
            
            outfile.writeLineToFile("You purchased %d litres \n", volume);
            outfile.writeLineToFile("The cost of the %c before discount is $%.2f. \n", purchType,costNoGstNoDisc);
            outfile.writeLineToFile("The cost of the %c with GST is $%.2f. \n", purchType,costWithGst);
            outfile.writeLineToFile("You did not purchase enough oil to qualify for a discount");
          } //closing else claus, no discount
          break;
        }//closing oil switch method
        default:
        {
          System.out.println("Error, invalid choice");
        } //end error check
      } //closing switch
    } //closing loop
    inputFile.close();
    outfile.closeFile();
  } //closing main method
} //closing class