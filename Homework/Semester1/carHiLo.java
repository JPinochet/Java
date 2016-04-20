/*
  Jorge Pinochet
  Oct 6, 08
  carHiLo
*/

import java.io.*;
import java.util.Scanner;

public class carHiLo
{
  static Scanner sc = new Scanner(System.in);
  public static void main(String[] args)
  {
    //Scanner scn = new Scanner(System.in);
    char type;
    char highType = 0;
    char lowType = 0;
    double high = 0.0; //start very low
    double low = 100000.00; //start REALLY high
    double cost = 0;
    
    int numPasses = 0; //initialize loop variable
    while (numPasses < 4)
    {
      System.out.print("Enter the cost of the car: ");
      cost = sc.nextDouble();
      System.out.print("Enter the type of car: ");
      type = sc.next().toUpperCase().charAt(0);
      if (cost!=0)
      {
        if(cost>high)
        {
          high = cost;
          highType = type;
        } //end high
        if(cost<low)
        {
          low = cost;
          lowType = type;
        } //end low
      } //closing if statement
      numPasses = numPasses + 1;
    } // loop ends
    System.out.printf("\n The most expensive care is $%8.2f and is a %c. \n", high, highType);
    System.out.printf("The least expensive car is $%8.2f and is a %c. \n\n", low, lowType);
  } //ending main method
} //ending class carHiLo