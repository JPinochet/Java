/**
 * Mar 4, 2009
 */
package gizmoRAF;

import java.io.*;

import fileHandling.*;
import formatColumns.*;

/**
 * @author 432873
 * Ownz.
 */
public class GizmoRAF extends RandomAccessFile
{
	//Constants
	private static final String					BINARY_FILE = "res/gizmos.bin";
	private static final String					TEXT_FILE = "res/gizmos.txt";
	private static final String					MODE = "rw";
	
	//Attributes
	private static GizmoRAF						graf;
	
	//Constructors
	private GizmoRAF() throws FileNotFoundException
	{
		super(BINARY_FILE,MODE);
	}
	
	//Operational Methods
	public static GizmoRAF getGizmoRAF()
	{
		File file = new File(BINARY_FILE);
		try
		{
			if(file.exists())
			{
				if(graf == null)
				{
					graf = new GizmoRAF();
				}
			}
			else 
			{
				if(graf == null)
				{
					graf = new GizmoRAF();
					graf.loadBinaryFile();
				}
			}
		} 
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return graf;
	}
	
	
	public void loadBinaryFile()
	{
		FileInput fin = new FileInput(TEXT_FILE);
		
		String line = fin.readLine();
		
		while(line != null)
		{
			Gizmo g = new Gizmo(line);
			
			try
			{
				writeRecord(g);
				
			} 
			catch (IOException e)
			{
				e.printStackTrace();
			}
		line = fin.readLine();
		}
		System.out.println("created binary file");
		fin.closeInputFile();
	}
	
	public void printGizmos()
	{
		try
		{
			seek(0L);
			
			long count = length()/Gizmo.SIZE;
			
			for(int i=0; i<count; i++)
			{
				Gizmo g = readRecord();
				
				if(g.isActive());
				{
					System.out.println(g);
				}
				System.out.println("byte count = "+getFilePointer());
			}
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void findandPrintRecord(long f)
	{
		try
		{
			seek((f-1)*Gizmo.SIZE);
			System.out.println(readRecord());
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void findAndPrintRecords4and24()
	{
		try
		{
			seek((4 - 1)*Gizmo.SIZE);
			System.out.println(readRecord());
			
			seek((24 - 1)*Gizmo.SIZE);
			System.out.println(readRecord());
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public boolean addGizmo(Gizmo g)
	{
		try
		{
			seek(length());
			writeRecord(g);
		} 
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean deleteGizmo(Gizmo g)
	{
		
		try
		{
			long offset = searchGizmo(g.getItem());
			if(offset != -1L)
			{
				seek(offset);
				writeBoolean(false);
				
			}
		} 
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/****************************************PRIVATE METHODS*****************************************/
	
	private Gizmo readRecord() throws IOException
	{
		Gizmo g = new Gizmo();
		
		g.setActive(readBoolean());
		g.setItem(readInt());
		g.setDescription(readUTF().trim());
		g.setQuantity(readInt());
		g.setPrice(readDouble());
		
		return g;
	}
	
	private void writeRecord(Gizmo g)throws IOException
	{
		writeBoolean(g.isActive());
		writeInt(g.getItem());
		writeUTF(Column.leftJustify(g.getDescription(),21));
		//writeUTF(String.format("%21s", g.getDescription()));
		writeInt(g.getQuantity());
		writeDouble(g.getPrice());
	}
	
	private long searchGizmo(long id)
	{
		try
		{
			seek(0L);
			
			for(long i = 0L; i < length(); i +=Gizmo.SIZE)
			{
				Gizmo g  = readRecord();
				
				if(g.getItem() == id)
				{
					System.out.println("Found at: "+i);
					return i;
				}
			}
		} 
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1L;
		}
		return -1L;
	}
}
