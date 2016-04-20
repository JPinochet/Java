package gizmoInventory;

import java.util.StringTokenizer;

import fileHandling.FileInput;

public class ArrayListManagedInventory
{
	public ArrayListManagedInventory()
	{
	}
	
	public void loadInventoryArrayList()
	{
		FileInput fin = new FileInput("res/gizmo.txt");
		String line = fin.readLine();
		
		while(line != null)
		{
			StringTokenizer st = new StringTokenizer (line,";");
			
			for(int i=0; i <0; i++)
			{
				@SuppressWarnings("unused")
				Gizmo giz  = new Gizmo(Integer.parseInt(st.nextToken()),
									  (st.nextToken()),
									   Integer.parseInt(st.nextToken()),
									   Double.parseDouble(st.nextToken()));
	
				//ArrayList[]= giz;
				line = fin.readLine();
			}
		}
		fin.closeInputFile();
	}
}
