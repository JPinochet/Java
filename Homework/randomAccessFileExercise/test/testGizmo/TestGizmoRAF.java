/**
 * Mar 4, 2009
 */
package testGizmo;

import java.io.FileNotFoundException;
import java.io.IOException;

import gizmoRAF.*;

/**
 * @author 432873
 *
 */
public class TestGizmoRAF
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		try
		{
			GizmoRAF graf = GizmoRAF.getGizmoRAF();
			//graf.loadBinaryFile();
			System.out.println("File size = "+graf.length());
			//graf.printGizmos();
			//graf.findAndPrintRecords4and24();
			graf.findandPrintRecord(4);
			graf.findandPrintRecord(24);
			//graf.addGizmo(new Gizmo("1041;Wiff Knickers;82;4.96"));
			Gizmo g = new Gizmo("1041;Wiff Knickers;82;4.96");
			graf.deleteGizmo(g);
			graf.printGizmos();
			graf.close();
		} 
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
