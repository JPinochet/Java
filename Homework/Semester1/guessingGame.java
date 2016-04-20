import java.io.*;
import java.util.Scanner;
import java.util.Random;

public class guessingGame
{
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    Random randomNum = new Random();
    int numGuess;
    long num;
    //guessingGameOutFile outfile = new guessingGameOutFile("c:\\java08\\module7\\guess.rpt");
    //outfile.openFile();
    System.out.println("Please enter a guess from 0 to 100 inclusive.");
    num = sc.nextInt();
    int myRand = randomNum.nextInt(100);
    System.out.println("num is "+myRand);
    for(numGuess=1;num!=myRand;numGuess++)
    {
      if(num<myRand)
      {
        System.out.println("Guess is too low\n");
      }
      if(num>myRand)
      {
        System.out.println("Guess is too high\n");
      }
      System.out.println("Please enter a guess: ");
      num = sc.nextInt();
    }
    System.out.printf("Great job! You took %d guesses to get it right!", numGuess);
    //outfile.writeLineToFile("\nGreat job! You took %d guesses to get it right!", numGuess);
    //outfile.closeFile();
  }
}