/* Jorge Pinochet
Sept 8, 2008
tempChange 

Functionality: The program shall receive a temperature in fahrenheit and then calculate the 
temperature in Celcius, at which point the program will display both temperatures.
Inputs:  Temperature in Fahrenheit.   tempFhar
Outputs: Temperature in Fahrenheit.   tempFhar
         Temperature in Celcius.      tempCelc
Constants:                            None (not aloud)
Formula:                              Tc (tempCelc) = (Tf(tempFhar)-32)*5/9
                                      Where 5/9 is the conversion factor
Algorithm:                            Prompt and Get themFhar
                                      Calculate: TempCelc
                                      Display: TempCelc TempFhar
Test data: input:32 output: 0, 32
Implementation:                                        */

import java.util.Scanner;            
import static java.lang.Math.pow;                 //importing the scanner class for basic input and math function in case it's necessary.

public class tempConvert                          //opening block for the code.
{
  static Scanner scn = new Scanner(System.in);    //inserting new variable for the Scanner class.
  public static void main(String[] args)        
  {
    System.out.print("Please input temperature in Fhareinheit: ");                   //Prompt function, hope the user knows what this program is for.
    double tempFhar = scn.nextInt();                                                //Get function, input temp in Fhar.
    double tempCelc = ((5/9)*(tempFhar-32));                                        //Calculate temp. in Celcius.
    System.out.println("The temp you entered is " + tempFhar + " in F, and the temperature in Celcius is: " + tempCelc);   //Print results to user.
  } 
}