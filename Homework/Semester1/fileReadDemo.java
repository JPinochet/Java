import java.util.Scanner;
import java.io.*;

public class fileReadDemo
{
  public static void main(String[] args) throws IOException
  {
    Scanner keyboard = new Scanner(System.in);
    System.out.print("Enter the filename: ");
    String filename = keyboard.nextLine();
    double sum = 0.0;
    File file = new File("Numbers.txt");
    Scanner inputFile = new Scanner(file);
    
    while (inputFile.hasNext())
    {
      double number = inputFile.nextDouble();
      sum = sum + number;
    }
    inputFile.close();
    System.out.println("The sum of the numbers in Numbers.txt is " + sum);
  }
}