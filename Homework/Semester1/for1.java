public class for1
{
  public static void main(String[] args)
  {
    int sum=0;
    double quotient;
    System.out.printf("\nCounter\t\tSum\tQuotient\n");
    
    int counter =1;
    while(counter<=10)
    {
      sum = sum + counter;
      quotient = (float)sum/counter;
      
      System.out.printf("\n%3d\t\t%3d\t\t%5.2f\n", counter, sum, quotient);
      ++counter;
    } //end while loop
  } //end main
} //end class