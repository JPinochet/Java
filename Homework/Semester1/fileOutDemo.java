/*  Jorge Pinochet
    Sept 17, 08
    fileOutDemo
*/

import java.util.Scanner;
import java.io.*;

public class fileOutDemo
{
  public static void main(String[] args) throws IOException
  {
    String filename;
    String friendname;
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter filename: ");
    filename = sc.nextLine();
    PrintWriter outFile = new PrintWriter(filename);
    System.out.print("Enter friend name: ");
    friendname = sc.nextLine();
    outFile.println(friendname);
    outFile.close();
    System.out.println("Date written to file");
  }
}