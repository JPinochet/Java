/*
  Jorge Pinochet
  Sept 24, 08
  String Practice
*/

public class stringPrac
{
  public static void main (String[] args)
  {
    int x = 0;
    int y = 5;
    int z = 21;
    int a = 32;
    int b = 38;
    int c = 49;
    String history = "Fred Stimson went to London for Queen Victoria's Jubilee";
    System.out.println("Fred Stimson went to London for Queen Victoria's Jubilee");
    int strSize = history.length();
    System.out.println("The info contains " + strSize + " characters");
    String history1 = history.toUpperCase();
    System.out.println("The info is now all now uppercase " + history1);
    String history2 = history.toLowerCase();
    System.out.println("The info is now all now uppercase " + history2);
    char ltr1 = history2.charAt(x);
    System.out.println("The letter is " + ltr1);
    char ltr2 = history2.charAt(y);
    System.out.println("The letter is " + ltr2);
    char ltr3 = history2.charAt(z);
    System.out.println("The letter is " + ltr3);
    char ltr4 = history2.charAt(a);
    System.out.println("The letter is " + ltr4);
    char ltr5 = history2.charAt(b);
    System.out.println("The letter is " + ltr5);
    char ltr6 = history2.charAt(c);
    System.out.println("The letter is " + ltr6);
  }
}