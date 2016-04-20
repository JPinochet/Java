package saitMLS.persistance;

import java.util.List;

import saitMLS.exceptions.*;

public interface Broker
{
	/**
	 * Method to release resources allocated to the broker and save all modified data. 
	 * NOTE if this method is not called data may be lost. 
	 */
	public void closeBroker();
	
	/**
	 * Abstract generic method to call data persist method from a back end 
	 * database structure of some type and brokers the information on to the back end 
	 * so the information can be permanently written to the database. 
	 * The Graphical User Interface defined as the front end confirms that the information 
	 * has been added correctly. 
	 * 
	 * @param o an Object containing the object information to be written. 
	 * @return a boolean confirming to the GUI that the data has been added correctly
	 */
	public boolean persist(Object o);
	
	
	/**
	 * Abstract generic method to call data removal method from a back end database 
	 * structure of some type and brokers the information on to the back end so the information 
	 * can be logically deleted from the database. The Graphical User Interface defined as the front 
	 * end confirms that the information has been logically deleted. 
	 * 
	 * @param o an Object containing the object information to be removed.
	 * @return a boolean confirming to the GUI that the data has been deleted.
	 */
	public boolean remove(Object o);
	
	
	/**
	 * Abstract generic method to call search method from a back end database structure of some type 
	 * and brokers the information on to the Graphical User Interface defined as the front end. 
	 * 
	 * @param item a String containing the value of the item to search for.
	 * @param type a String containing the type of search to be performed. 
	 * @return a List of objects matching the search criteria.
	 */
	public List search(String item, String type);
	
	
	/**
	 * Abstract generic method to validate data for a Customer object. This method should validate 
	 * the postal code and phone number for each Customer object before the object is submitted to the 
	 * RandomAccessFile. If the data for the postal code or phone number is not formatted properly an 
	 * exception is thrown for the particular formatting error. 
	 * 
	 * @param o an Object containing the object information to be validated. 
	 * @throws java.lang.Exception Exception of the type determined by the class implementing this Broker. 
	 */
	public void validate(Object o) throws java.lang.Exception;
}
