import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class totalSales
{
  public static void main(String[] args)
  {
    int days;
    double sales;
    double totalSales;
    String input;
    
    DecimalFormat dollar = new DecimalFormat("#,##0.00");
    input = JOptionPane.showInputDialog("For how many days do you have sales figures?");
    days = Integer.parseInt(input);
    totalSales = 0.0;
    
    for (int count = 1; count <= days; count++)
    {
      input = JOptionPane.showInputDialog("Enter the sales for day " + count + ":");
      sales = Double.parseDouble(input);
      totalSales += sales;
    } //closing for loop
    JOptionPane.showMessageDialog(null, "The total sales are $" + dollar.format(totalSales));
    System.exit(0);
  } //closing main method
} //closing class