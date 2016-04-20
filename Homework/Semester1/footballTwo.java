import java.util.Scanner;
import java.util.Date;
import java.text .SimpleDateFormat;
import java.io.*;
import static java.lang.Math.*;

public class footballTwo
{
  static final double COST_WHITE = 10.00;
  static final double COST_RED = 15.00;
  static final double COST_BLUE = 20.00;
  static final double GST = 1.05;
  static Scanner sc = new Scanner(System.in);
  
  public static void main(String[] args)
  {
    int numTickets = 0;
    int totalWhite = 0;
    int totalRed = 0;
    int totalBlue = 0;
    int totalTickets = 0;
    double totalRev = 0;
    double cost = 0;
    int enterkey = 10;
    char ch;
    char color;
    
    SimpleDateFormat jorgeDateFormat = new SimpleDateFormat("dd-MMMM-yyyy");
    Date date = new Date();
    System.out.println();
    System.out.println(jorgeDateFormat.format(date));
    System.out.println();
    
    System.out.println("Welcome to Flaggers AA football");
    System.out.println("White  10.00");
    System.out.println("Red = 15.00");
    System.out.println("Blue = 20.00");
    System.out.println("Press x to quit");
    System.out.print("Please enter the colour of ticket you will be purchasing: ");
    color = sc.next().toUpperCase().charAt(0);
    
    while (color != 'X')
    {
      switch (color)
      {
        case 'W':
        {
          System.out.print("Please enter the number of tickets you will be purchasing: ");
          numTickets = sc.nextInt();
          cost = numTickets*COST_WHITE*GST;
          System.out.printf("You are purchasing %d tickets in the %c section and the cost is $%.2f \n",numTickets, color, cost);
          
          totalWhite = totalWhite + numTickets;
          totalRev = totalRev + cost;
          System.out.println("Press enter to continue=>");
          try
          {
            while((ch = (char) System.in.read()) != enterkey)
            {
              System.out.print(ch);
            }
          }
          catch (IOException e)
          {
            System.err.println("Unexpected exception: " + e);
          }
          break;
        }
        case 'R':
        {
          System.out.println("Please enter the number of tickets you will be purchasing: ");
          numTickets = sc.nextInt();
          cost = numTickets*COST_RED*GST;
          System.out.printf("You are purchasing %d tickets in the %c section and the cost i $%.2f /n",numTickets, color, cost);
          
          totalRed = totalRed + numTickets;
          totalRev = totalRev + cost;
          System.out.print("Press enter to continue=>");
          try
          {
            while ((ch = (char) System.in.read()) != enterkey)
            {
              System.out.print(ch);
            }
          }
          catch (IOException e)
          {
            System.err.println("Unexpected exception: " + e);
          }
          break;
        }
        case 'B':
        {
          System.out.print("Please enter the number of tickets you will be purchasing: ");
          numTickets = sc.nextInt();
          cost = numTickets*COST_BLUE*GST;
          System.out.printf("You are purchasing %d tickets in the %c section and the cost is $%.2f \n",numTickets, color, cost);
          
          totalBlue = totalBlue + numTickets;
          totalRev = totalRev + cost;
          System.out.println("Press enter to continue=>");
          try
          {
            while((ch = (char) System.in.read()) != enterkey)
            {
              System.out.print(ch);
            }
          }
          catch (IOException e)
          {
            System.err.println("Unexpected exception: " + e);
          }
          break;
        }
        default:
        {
          System.out.println("Error, invalid choice, please select again");
          break;
        }
      }
      System.out.println("White = 10.00");
      System.out.println("Red = 15.00");
      System.out.println("Blue = 20.00");
      System.out.println("Press x to quit");
      System.out.print("Please enter the color of ticket you will be purchasing: ");
      color = sc.next().toUpperCase().charAt(0);
    }
    totalTickets = totalWhite + totalRed + totalBlue;
    
    System.out.printf("The total white tickets sold is %d \n",totalWhite);
    System.out.printf("The total red tickets sold is %d \n",totalRed);
    System.out.printf("The total blue tickets sold is %d \n",totalBlue);
    System.out.printf("The total tickets sold is %d \n",totalTickets);
    System.out.printf("The total revenue is $%.2f \n",totalRev);
    System.out.println("\n TOTAL WHITE \t TOTAL RED \t TOTAL BLUE \t TOTAL ALL \t TOTAL REVENUE");
    System.out.printf("%8d %12d %18d %14d \t $%8.2f \n", totalWhite, totalRed, totalBlue, totalTickets, totalRev);
  }
}