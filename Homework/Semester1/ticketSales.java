/*
  Jorge Pinochet
  ticketType
  Sept 22, 08
*/ 

import java.util.Scanner;

public class ticketSales
{
  static final double RED = 10.00;
  static final double BLUE = 15.0;
  static final double WHITE = 20.00;
  static final double GST = 1.05;
  
  pulic static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    char color;
    int numTickets;
    double costTickets;
    System.out.print("Enter the color of seats you require: ");
    color = sc.next().toUpperCase().charAt(0);
    
    switch(color)
    {
      case 'R':
      {
        System.out.print("Enter the number of tickets: ")
        numTickets = sc.nextlnt();
        costTickets = numTickets*RED*GST;
        System.out.printf("Number of tickets is %d, and the cost is $%6.2f\n", numTickets, costTickets);
        System.out.println("Number of tickets is " + numTickets + " and the cost is " + costTickets);
        break;
      }
      case 'B':
      {
        System.out.print("Enter the number of tickets: ");
        numTickets = sc.nextInt();
        costTickets = numTickets*BLUE*GST;
        System.out.printf("Number of tickets is %d, and the cost is $%6.2f\n", numTickets, costTickets);
        break;
      }
      case 'W':
      {
        System.out.print("Enter the number of tickets: ");
        numTickets = sc.nextInt();
        costTickets = numTickets*WHITE*GST;
        System.out.printf("Number of tickets is %d, and the cost is $%6.2f\n", numTickets, costTickets);
        break;
      }
      default:
      {
        System.out.println("Error, invalid choice");
      }
    }
  }
}