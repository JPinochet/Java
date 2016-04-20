import java.util.Scanner;
import java.io.*;

public class fileWriteDemo
{
  public static void main(String[] args) throws IOException
  {
    String filename;
    String friendName;
    int numFriends;
    
    Scanner keyboard = new Scanner(System.in); //create a Scanner object for keyboard input
    System.out.print("How many friends do you have? "); //get the number of friends
    numFriends = keyboard.nextInt();
    keyboard.nextLine(); //consume the remaining newline character
    System.out.print("Enter the filename: "); //get the filename
    filename = keyboard.nextLine();
    PrintWriter outputFile = new PrintWriter(filename);  //open the file (filename)
    
    for (int i = 1; i <= numFriends; i++) //get data write to file.
    {
      System.out.print("Enter the name of friend number " + i + ": ");
      friendName = keyboard.nextLine();
      outputFile.println(friendName);
    } // ending for loop
    outputFile.close();
    System.out.println("Data written to the file.");
  } //closing main method
} // closing class