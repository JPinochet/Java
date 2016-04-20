import java.util.Scanner;

public class petFood
{
  public static void main(String[] args)
  {
    String input;
    char foodGrade;
    
    Scanner keyboard = new Scanner(System.in);
    System.out.println("Our pet food is availablle in three grades: ");
    System.out.print("A, B, and C. Which do you want pricing for? ");
    input = keyboard.nextLine();
    foodGrade = input.charAt(0);
    
    switch (foodGrade)
    {
      case 'a':
      case 'A':
        System.out.println("30 cents per lb.");
        break;
      case 'b':
      case 'B':
        System.out.println("20 cents pet lb.");
        break;
      case 'c':
      case 'C':
        System.out.println("15 cents per lb.");
        break;
      default:
        System.out.println("Invalid choice.");
    }
  }
}