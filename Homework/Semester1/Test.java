import java.util.Scanner;
import java.io.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import static java.lang.Math.*;
import java.text.DecimalFormat;
                                      // import libraries


public class fuelpurch // creates the class fuelpurch
{
  static final double GST = 1.05;
  static final double COSTOIL = 1.27;
  static final double COSTGAS = 1.07;
  static final double LITRESCASE = 12;
  static final double GASDISCOUNT = 0.90;
  static final double OILDISCOUNT = 0.90;
  static final double DCGAS = 4000;
  static final double DCOIL = 8;
                                              // declaring constants
  
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    char fueltype;
    int gasvolume=0;
    int oilCases=0;
    DecimalFormat nf = new DecimalFormat("###,##0.00");
                                                          // declaring variables
    
    SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM-dd-yyyy");
    Date date = new Date();
    System.out.println();
                             //creates the date
    
    System.out.println(dateFormat.format(date)); //displays the date
    System.out.println();
    System.out.print("Please enter 'G' for gas, or 'O' for oil: "); //asks the user to enter oil or gas
    fueltype = sc.next().toUpperCase().charAt(0); //incorporates the users input into the variable fueltype
    
    fuelpurchaseOutFile outfile = new fuelpurchaseOutFile("c:\\java08\\module4\\fuelpurchase.rpt"); //creates an outfile instance
    outfile.openFile(); //opens the outfile
    
    switch(fueltype) //to determine either case g or case o
    {
    
      case 'G': //for when the user inputs the value g for gas
      {
        System.out.println();
        System.out.print("Please enter the volume of gas you will purchase in litres: "); // asks the user to input the volume of gas
        gasvolume = sc.nextInt();
        
        if (gasvolume <= DCGAS) //for amounts that do not qualify for the discount
        {
          double gasPrice = gasvolume * COSTGAS; //calculates price before GST
          double gasPriceGST = gasPrice * GST; //calculates price after GST
          System.out.println();
          System.out.println("You have purchased " + gasvolume + " litres of gas for $" + nf.format(gasPrice) + " before GST.\nThe final cost after GST is $" + nf.format(gasPriceGST) + ".");
          outfile.writeLineToFile("\nYou have purchased " + gasvolume + " litres of gas for $" + nf.format(gasPrice) + " before GST.\nThe final cost after GST is $" + nf.format(gasPriceGST) + ".");
          System.out.println("Unfortunately, you did not qualify for a discount.\n\nGoodbye!");
          outfile.writeLineToFile("\nUnfortunately, you did not qualify for a discount.\n\nGoodbye!");
        }
        
        else //for amounts that qualify for the discount
        {
          double gasPrice = gasvolume * COSTGAS; //calculates the price before discount
          double discountGasPrice = gasPrice * GASDISCOUNT; //calculates the price with discount
          double discountGasPriceGST = discountGasPrice * GST; //calculates the price with discount and GST
          System.out.println();
          System.out.println("You have purchased " + gasvolume + " litre(s) of gas for $" + nf.format(gasPrice) + ".\nThe price of your gas purchase after the discount is $" + nf.format(discountGasPrice) + ".\nThe final price of your gas purchase after GST is $" + nf.format(discountGasPriceGST) + ".\n\nGoodbye!.");
          outfile.writeLineToFile("\nYou have purchased " + gasvolume + " litre(s) of gas for $" + nf.format(gasPrice) + ".\nThe price of your gas purchase after the discount is $" + nf.format(discountGasPrice) + ". \n The final price of your gas purchase after GST is $" + nf.format(discountGasPriceGST) + ".\n\nGoodbye!.");
        }
      break; //ends the case
      }
      case 'O': //for when the user inputs o for oil
      {
        System.out.println();
        System.out.print("Please enter the number of oil cases you will purchase: "); //asks the user to enter the amount of oil
        oilCases = sc.nextInt();
        double oilVolume = oilCases * LITRESCASE; //converts oil cases to volume of oil in litres
        
        if (oilCases <= DCOIL) //for amounts that do not qualify for a discount
        {
          double oilPrice = oilVolume * COSTOIL; // calculates the cost of oil before GST
          double oilPriceGST = oilPrice * GST; //calculates the cost of oil after GST
          System.out.println();
          System.out.println("You have purchased " + oilCases + " case(s) of oil for $" + nf.format(oilPrice) + " before GST.\nThe final cost after GST is $" + nf.format(oilPriceGST) + ".");
          outfile.writeLineToFile("\nYou have purchased " + oilCases + " case(s) of oil for $" + nf.format(oilPrice) + " before GST.\nThe final cost after GST is $" + nf.format(oilPriceGST) + ".");
          System.out.println("Unfortunately, you did not qualify for a discount.\n\nGoodbye!");
          outfile.writeLineToFile("Unfortunately, you did not qualify for a discount.\n\nGoodbye!");
        }
        
        else //for amounts that qualify for a discount
        {
          double oilPrice = oilVolume * COSTOIL; //calculates the cost of oil before the discount
          double discountOilPrice = oilPrice * OILDISCOUNT; //calculates the cost of oil with the discount
          double discountOilPriceGST = discountOilPrice * GST; //calculates the cost of oil after the discount with GST
          System.out.println();
          System.out.println("You have purchased " + oilCases + " cases of oil for $" + nf.format(oilPrice) + ".\nThe price of your oil purchase after the discount is $" + nf.format(discountOilPrice) + ".\nThe final price of your oil purchase after GST is $" + nf.format(discountOilPriceGST) + ".\n\nGoodbye!.");
          outfile.writeLineToFile("\nYou have purchased " + oilCases + " cases of oil for $" + nf.format(oilPrice) + ".\nThe price of your oil purchase after the discount is $" + nf.format(discountOilPrice) + ".\nThe final price of your oil purchase after GST is $" + nf.format(discountOilPriceGST) + ". \n\nGoodbye!.");
        }
      break; //ends the case
      }
      default: //error checking
        {
          System.out.println();
          System.out.println("Error, invalid choice.\n\nGoodbye!");
        }
      
     outfile.closeFile(); //closes the outfile
    }
  }
} 