/*
  Jorge Pinochet
  Sept 25, 2008
  gasPurchase assignment
  Analysis
  Functionality:  The user will enter the type of purchase. User inputs quantity of purchase. The program calculates the cost with or without discounts and including gst. The program will print and display volume, type of purchase, cost before gst, cost after disc w/o gst, cost after gst, if no discount prints statement.

Inputs: 
Char fuelType;
Int oilCases;
Int gasVolume;

Outputs:         
  Double volumePurch;
	Char itemPurch;
	Double costBeforeDiscount;
	Double costAfterDiscount;
	Double costAfterGst;
	
Constants:      
 GST: 1.05
	LITRESCASE: 12
COSTOIL: 1.27
	DCOIL: 8
DISCOIL: 0.90 
	DISCGAS: 0.90
	COSTGAS: 1.07
	DCGAS: 4000
Formula: 
 -Oil:
-More then or equal to 8 cases:
oilVolume = oilCases*LITRESCASE;
costBeforeDiscount = oilVolume*COSTOIL;
costAfterDiscount= costBeforeDiscount*DCOIL;
costAfterGst=costAfterDiscount*GST;
-Less then to 8 cases:
oilVolume=oilCase*LITRESCASE;
costBeforeDiscount=oilVolume*COSTOIL;
costAfterGst=costAfterDiscount*GST;
-Gas:
	-More then or equal 4000 litres:
		costBeforeDiscount=gasVolume*COSTGAS;
		costAfterDiscount=costBeforeDiscount*DCGAS;
		costAfterGst=costAfterDiscount*GST;
	-Less then to 8 cases:
		costBeforeDiscount=gasVolume*COSTGAS;
		costAfterGst=costBeforeDiscount*GST;
*/

import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.io.*;
import static java.lang.Math.*;
import java.text.DecimalFormat;

public class gasPurchase
{
  static final double GST = 1.05;
	static final double COSTOIL = 1.27;
	static final int LITRESCASE = 12;
	static final double DISC_GAS = 0.9;
	static final double DISC_OIL = 0.9;
	static final double COSTGAS = 1.07;
  static final int DC_OIL = 8;
	static final int DC_GAS = 4000;

  public static void main(String[] args)
  {
      Scanner sc = new Scanner(System.in);
      char typePurch;
      int gasVolume;
      int oilCases;
      double oilVolume;
      double gasPrice;
      double gasPriceGST;
      double discountGasPrice;
      double discountGasPriceGST;
      double oilPrice;
      double oilPriceGST;
      double discountOilPrice;
      double discountOilPriceGST;
      
      
      SimpleDateFormat jorgeDateFormat = new SimpleDateFormat("MMMM-dd-yyyy");
      Date date = new Date();
      System.out.println();
      
      System.out.print(jorgeDateFormat.format(date));
      System.out.println();
      
      System.out.print("Please enter the please enter the type of fuel you are purchasing: ");
      typePurch = sc.next().toUpperCase().charAt(0);
      
      gasPurchaseOutfile outfile = new gasPurchaseOutfile("c:\\java08\\module4\\assignment2.rpt");
      outfile.openFile();
      
      DecimalFormat nf = new DecimalFormat("#,##0.00"); //note for 2 decimal places
      
      switch(typePurch)
      {
          case 'G':
          {   
          
              System.out.print("Please enter the quantity in litres(L): ");
              gasVolume = sc.nextInt();
              
              if (gasVolume <= DC_GAS) //calulate without discount
              {
                  gasPrice = gasVolume * COSTGAS;
                  gasPriceGST = gasPrice * GST;
                  
                  System.out.println("Fuel Type: GAS");
                  System.out.println("Volume Purchased: $" + nf.format(gasVolume));
                  System.out.println("Base Price: $" + nf.format(gasPrice));
                  System.out.println("Your Price, including GST: $" + nf.format(gasPriceGST));
                  System.out.println("Sorry, you do not qualify for a discount. Good Day!");
              }
              
                     
              else //calculate with discount included
              {
                  gasPrice = gasVolume * COSTGAS;
                  discountGasPrice = gasPrice * DISC_GAS;
                  discountGasPriceGST = discountGasPrice * GST;
                  
                  System.out.println("Fuel Type: GAS");
                  System.out.println("Volume Purchased: " + nf.format(gasVolume));
                  System.out.println("Base Price: $" + nf.format(gasPrice));
                  System.out.println("Price including discount: $" + nf.format(discountGasPrice));
                  System.out.println("Your Price including discounts and GST: $" + nf.format(discountGasPriceGST));
                  System.out.println("Thank you, Good Day!");
                  
              }
          
              break;//closing of the 'G' case 
           }
          
          case 'O':
          {
              System.out.print("Please enter the quantity in cases: ");
              oilCases = sc.nextInt();
              
              if (oilCases <= DC_OIL) //calulate without discount
              {
                oilVolume = oilCases*LITRESCASE;
                oilPrice = oilVolume * COSTOIL;
                oilPriceGST = oilPrice * GST;
                  
                System.out.println("Fuel Type: OIL");
                System.out.println("Volume Purchased: " + nf.format(oilVolume));
                System.out.println("Base Price: $" + nf.format(oilPrice));
                System.out.println("Your Price, including GST: $" + nf.format(oilPriceGST));
                System.out.println("Sorry, you do not qualify for a discount. Good Day!");                  
                  
              }
              
              else
              {
                  oilVolume = oilCases*LITRESCASE;
                  oilPrice = oilVolume * COSTOIL;
                  discountOilPrice = oilPrice * DISC_OIL;
                  discountOilPriceGST = discountOilPrice * GST;
                  
                  System.out.println("Fuel Type: OIL");
                  System.out.println("Volume Purchased: " + nf.format(oilVolume));
                  System.out.println("Base Price: $" + nf.format(oilPrice));
                  System.out.println("Price including discount: $" + nf.format(discountOilPrice));
                  System.out.println("Your Price including discounts and GST: $" + nf.format(discountOilPriceGST));
                  System.out.println("Thank you, Good Day!");
                  
              }
           }
           break;//close the 'O' case
           default: 
           {
            System.out.println("Input error.\nGoodbye");
           }
    }
  } 
}