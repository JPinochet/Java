package gizmoInventory;

import java.util.StringTokenizer;

import fileHandling.FileInput;

public class ArrayManagedInventory
{
	//Attributes
	private Gizmo[]	gizmoList;
	private int 		count;
	
	public ArrayManagedInventory()
	{
		gizmoList = new Gizmo[42];
	}
	
	public void loadArrayManagedInventory()
	{
		FileInput fin = new FileInput("res/gizmo.txt");
		String line = fin.readLine();
		
		while(line != null)
		{
			StringTokenizer st = new StringTokenizer (line,";");
			
			Gizmo giz = new Gizmo(Integer.parseInt(st.nextToken()),
								(st.nextToken()),
								Integer.parseInt(st.nextToken()),
								Double.parseDouble(st.nextToken()));
			
			gizmoList[count++]=giz;
			line = fin.readLine();
		}
		fin.closeInputFile();
	}
	public void printInventoryArray()
	{
		for (int i=0; i<count; i++)
		{
			System.out.println(gizmoList[i]);
		}
	}
}
