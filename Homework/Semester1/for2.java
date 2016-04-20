public class for2
{
  public static void main(String[] args)
  {
    int sum =0;
    double quotient;
    System.out.printf("\nCounter\t\tSum\t\tQuotient\n");
    int counter;
    for(counter=1;counter<=10;counter++)
    {
      sum = sum + counter;
      quotient = (float)sum/counter;
      System.out.printf("\n%3d\t\t%3d\t\t%5.2f\n", counter, sum, quotient);
    }
    System.out.printf("\nEnd of run\n");
  }
}