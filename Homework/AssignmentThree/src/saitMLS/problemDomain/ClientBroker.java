/**
 * Mar 12, 2009
 */
package saitMLS.problemDomain;

import saitMLS.persistance.*;
import java.io.*;
import java.util.*;
import saitMLS.exceptions.*;
import saitMLS.exceptions.InvalidPhoneNumberException;
import saitMLS.exceptions.InvalidPostalCodeException;
import java.lang.*;



/**
 * @author 432873
 *
 */
public class ClientBroker extends RandomAccessFile implements Broker
{
	//Constants
	private static final String					BINARY_FILE = "res/clients.bin";
	private static final String					TEXT_FILE = "res/clients.txt";
	private static final String					MODE = "rw";
	
	//Attributes
	private static ClientBroker                cBroker;
	
	//Default Constructor
	/**
	 * Method that calls the parent class and gives it the text file and the mode that the binary 
	 * file should be set to. Throws a FileNotFoundException if the text file is not found.
	 * @exception FileNotFoundException
	 */
	private ClientBroker() throws FileNotFoundException
	{
		super(TEXT_FILE, MODE);
	}
	
	//Operational methods
	
	/**
	 *  Creates a static reference to itself, ensuring that the the binary file is not being used, or an instance 
	 *  not being created and/or used. Otherwise it opens the clientbroker and loads in the binary file, or at least 
	 *  calls the loadBinary method. If the text file is not found, then the method throws the FileNotFound exception
	 *  @exception FileNotFoundException
	 */
	public static ClientBroker getClientBroker()
	{
		File file = new File(BINARY_FILE);
		try
		{
			if(file.exists())
			{
				if(cBroker == null)
				{
					cBroker = new ClientBroker();
				}
			}
			else 
			{
				if(cBroker == null)
				{
					cBroker = new ClientBroker();
					cBroker.loadBinaryFile();
				}
			}
		} 
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		return cBroker;
	}
	
	/**
	 * Method that reads in a text file, adds an ID to each record, and then writes it to a binary file. Prints 
	 * out confirmation that the binary file was written. Throws an IOException if the text file is not found.
	 * @exception IOException
	 */
	public void loadBinaryFile()
	{
		FileInput fin = new FileInput(TEXT_FILE);
		
		long id = 1;
		String line = fin.readLine();
		
		
		while(line != null)
		{
			line = id++ +";"+ line; //adds the id + a ; to the line, and then attaches it to the line to write
			
			Client c = new Client(line);
			
			try
			{
				writeRecord(c);
				
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
	
	/**
	 *  Method used for testing purposes at console level only. Also checks that the boolean added to the binary 
	 *  file functions. Throws the IOException if the binary file does not exist or is not found.
	 *  @exception IOException
	 */
	public void printClient()
	{
		try
		{
			seek(0L);
			
			long count = length()/Client.SIZE;
			
			for(int i=0; i<count; i++)
			{
				Client c = readRecord();
				
				if(c.isActiveStatus());
				{
					System.out.println(c);
				}
				System.out.println("byte count = "+getFilePointer());
			}
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	/* (non-Javadoc)
	 * @see saitMLS.persistance.Broker#closeBroker()
	 */
	@Override
	public void closeBroker()
	{
		try
		{
			cBroker.close();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see saitMLS.persistance.Broker#persist(java.lang.Object)
	 */
	@Override
	public boolean persist(Object o)
	{
		try
		{
			o = new Client();
			seek(length());
			writeRecord(readRecord());
		} 
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see saitMLS.persistance.Broker#remove(java.lang.Object)
	 */
	@Override
	public boolean remove(Object o)
	{
		Client c = new Client();
		
		try
		{
			long offset = searchClient(c.getId());
			if(offset != -1L)
			{
				seek(offset);
				writeBoolean(false);
				
			}
		} 
		catch (IOException e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see saitMLS.persistance.Broker#search(java.lang.String, java.lang.String)
	 */
	@Override
	public List search(String item, String type)
	{
		
		try
		{
			seek(0L);
			
			for(long i = 0L; i < length(); i +=Client.SIZE)
			{
				Client c  = readRecord();
				
				if((c.getFirstName() == item) || (c.getClientType() == type.charAt(0)))
						{
					
						}
			}
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		
		
		return null;
	}

	/* (non-Javadoc)
	 * @see saitMLS.persistance.Broker#validate(java.lang.Object)
	 */
	@Override
	public void validate(Object o) throws Exception
	{
		if ((String)o != "000-000-0000")
		{
			System.out.println("Invalid phone number.");
		}
		else if ((String)o != "000-000")
		{
			System.out.println("Invalid postal code");
		}
		
	}
	
	/**********************************PRIVATE METHODS********************************************/
	
	
	private Client readRecord() throws IOException
	{
		Client c = new Client();
		
		c.setActiveStatus(readBoolean());
		c.setId(readLong());
		c.setFirstName(readUTF().trim());
		c.setLastName(readUTF().trim());
		c.setAddress(readUTF().trim());
		c.setPostalCode(readUTF().trim());
		c.setPhoneNumber(readUTF().trim());
		c.setClientType(readChar());
		
		return c;
	}
	
	private void writeRecord(Client c)throws IOException
	{
		writeBoolean(c.isActiveStatus());     					//1
		writeLong(c.getId());									//8
		writeUTF(Column.leftJustify(c.getFirstName(),20));		//22
		writeUTF(Column.leftJustify(c.getLastName(),20));		//22
		writeUTF(Column.leftJustify(c.getAddress(),50));		//52
		writeUTF(Column.leftJustify(c.getPostalCode(),7));		//9
		writeUTF(Column.leftJustify(c.getPhoneNumber(),14));	//16
		writeChar(c.getClientType());							//2
	}
	
	private long searchClient(long id)
	{
		try
		{
			seek(0L);
			
			for(long i = 0L; i < length(); i +=Client.SIZE)
			{
				Client c  = readRecord();
				
				if(c.getId() == id)
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
