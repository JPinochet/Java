/**
 * Jan 27, 2009
 */
package moviesGames;
import java.util.*;
import java.io.*;

import fileHandling.FileInput;

/**
 * @author 432873
 * Jorge Pinochet
 */
/**
 * @author 432873
 *
 */
public class RentalManager
{
	//Attributes
	private ArrayList<RentalItem>						rentalList;
	public char 										functionSelection;
	public char 										rentalType;
	
	//Attributes to read in from keyboard
	Scanner sc = new Scanner(System.in); 				//got to get user input somehow
	
	//Attributes for Infile and Outfile
	FileOutputStream out;
    PrintStream outfile;

	/**
	 *  Default Constructor
	 */
	public RentalManager()
	{
		rentalList = new ArrayList<RentalItem>();
	}
   
	/**
	 *  fills array method call then Menu method call
	 */
	public void functionCallsRentalManager()
	{
		fillArrayListWithRentals();
		optionMenu();
	}
	
	/**
	 * Menu method that calls other functions as necessary
	 */
	public void optionMenu()
	{
		   System.out.println("What would you like to do?");
		   System.out.println("a) Print all items");
		   System.out.println("b) Add an item");
		   System.out.println("c) Delete an item");
		   System.out.println("d) Search for an item by type and then subcategory");
		   System.out.println("e) Exit program");
		   rentalType = sc.next().toLowerCase().charAt(0);
		   
		   while(rentalType != 'e')   //Loop to the menu until the user selects quit
		   {
			   switch(rentalType)   //Options to do something! Made as per assignment done
			   {
			   case 'a':
				   System.out.println("Would you like to print all (m)movies or (g)games.");
				   functionSelection = sc.next().toLowerCase().charAt(0);
				   switch(functionSelection)
				   {
				   case 'm':
					   DisplayMovies();
					   break;
				   case 'g':
					   DisplayGames();
					   break;
				   default:
					   System.out.println("Invalid display option");
				   }//end switch method
				   	break;
			   case 'b':
				   AddRentalItems();
			   		break;
			   case 'c':
				   DeleteRentalItems();
				   	break;
			   case 'd':
				   SearchRentalItems();
				   	break;
			   default:
					System.out.println("Invalide Choice!");
			   		System.exit(1);
			   } //end switch statement
			   
			   System.out.println("What would you like to do?");
			   System.out.println("a) Print all items");
			   System.out.println("b) Add an item");
			   System.out.println("c) Delete an item");
			   System.out.println("d) Search for an item by type and then subcategory");
			   System.out.println("e) Exit program");
			   rentalType = sc.next().toLowerCase().charAt(0);
			   
		   }//end whileLoop
		   System.exit(1);
	}
	
	/*
	 * function to movies items from the arraylist
	 */
	public void DisplayMovies()
	{
		fillMovieArrayList();
		
		Iterator<RentalItem> itrX = rentalList.iterator();   //define Iterator and attach to rentallist
		 
		while(itrX.hasNext()) //loop through items while there are items to loop through.
		{         
		 
		Object element = itrX.next(); 
		System.out.print(element + " ");   // print out element
		 
		} 

	}
	
	//function to displaygames items from the arraylist
	public void DisplayGames()
	{
		fillGameArrayList();
		
		Iterator<RentalItem> itrX = rentalList.iterator();   //define Iterator and attach to mylist
		 
		while(itrX.hasNext()) {         //loop through items while there are items to loop through.
		 
		Object element = itrX.next(); 
		System.out.print(element + " ");   // print out element
		 
		} 

	}
	
	/*
	 * function to search items from the arraylist
	 */
	public void SearchRentalItems()
	{
		System.out.println("Would you like to search for a (m)movie or (g)game?: ");
		functionSelection = sc.next().toLowerCase().charAt(0);
		
		switch(functionSelection)
		{
		case 'm':
			System.out.println("Which movie would you like to search for? (Please input ID): ");
			int movieSearch = sc.nextInt();
			
			fillMovieArrayList();
			
			Iterator<RentalItem> itrX = rentalList.iterator();   //define Iterator and attach to rentallist
			 
			while(itrX.hasNext()) //loop through items while there are items to loop through.
			{         
				if(itrX.equals(movieSearch))
				{
					Object element = itrX.next(); 
					System.out.print(element + " ");   // print out element
				}
			} 
			
			break;
		case 'g':
			System.out.println("Which game would you like to search for? (Please input ID): ");
			int gameSearch = sc.nextInt();
			
			fillGameArrayList();
			Iterator<RentalItem> itrXTwo = rentalList.iterator();   //define Iterator and attach to rentallist
			 
			while(itrXTwo.hasNext()) //loop through items while there are items to loop through.
			{         
				if(itrXTwo.equals(gameSearch))
				{
					Object element = itrXTwo.next(); 
					System.out.print(element + " ");   // print out element
				}
			} 
			
			break;
		default:
			System.out.println("Invalid search selection.");
		}
	}
	
	/*
	 * function to add items from the arraylist
	 */
	public void AddRentalItems()
	{
		System.out.println("Would you like to add a (m)movie or (g)game?: ");
		functionSelection = sc.next().toLowerCase().charAt(0);
		
		switch(functionSelection)
		{
			case 'm':
				
				System.out.println("Which movie would you like to add?: ");
				int movieAddition = sc.nextInt();
				
				if((movieAddition>=0000)&&(movieAddition<=9999))
				{

					fillMovieArrayList();
					
					String movieTitle, movieCategory, movieDirector, movieLeadingActor, movieSupportingActors, movieRating;
					int runningTime, releaseDate;
					
					System.out.println("Please enter the movie Title: ");
					movieTitle = sc.next();
					System.out.println("Please enter the movie Category: ");
					movieCategory = sc.next();
					System.out.println("Please enter the movie Rating: ");
					movieRating = sc.next();
					System.out.println("Please enter the movie release date: ");
					releaseDate = sc.nextInt();
					System.out.println("Please enter the movie's Director: ");
					movieDirector = sc.next();
					System.out.println("Please enter the movie's Leading Actor(s): ");
					movieLeadingActor = sc.next();
					System.out.println("Please enter the movie's Supporting Actor(s): ");
					movieSupportingActors = sc.next();
					System.out.println("Please enter the movie's Running Time: ");
					runningTime = sc.nextInt();
					
					RentalItem rental = new Movie(movieAddition, 
											movieTitle, 
											movieCategory,
											movieRating,
											releaseDate,
											movieDirector,
											movieLeadingActor,
											movieSupportingActors,
											runningTime);
					rentalList.add(rental);
					try
				    {
				      out = new FileOutputStream("res/movies.txt");
				      outfile = new PrintStream( out);
				      for(int i=0; i<rentalList.size(); i++)
				      {
					      outfile.println(rentalList.get(i));
					      outfile.close();
				      } //end outer for loop
				     } //end try
				     catch(Exception e)
				     {
				      System.err.println("Error writing to outfile");
				      System.exit(1);
				     }
				}
				else
				{
					System.out.println("Invalid movie addition.");
					System.exit(1);
				}
					break;
			case 'g':
				System.out.println("Which game would you like to add?");
				int gameAddition = sc.nextInt();
				
				if((gameAddition>=0000)&&(gameAddition<=9999))
				{

					fillGameArrayList();
					
					String gameTitle, gameCategory, gameDeveloper, gamePlatform, gameRating;
					int releaseDate;
					
					System.out.println("Please enter the game Title: ");
					gameTitle = sc.next();
					System.out.println("Please enter the game Category: ");
					gameCategory = sc.next();
					System.out.println("Please enter the game Rating: ");
					gameRating = sc.next();
					System.out.println("Please enter the game release date: ");
					releaseDate = sc.nextInt();
					System.out.println("Please enter the game's Developer: ");
					gameDeveloper = sc.next();
					System.out.println("Please enter the game's Platform: ");
					gamePlatform = sc.next();
					
					RentalItem rental = new Game(gameAddition,
							gameTitle,
							gameCategory,
							gameRating,
							releaseDate,
							gameDeveloper,
							gamePlatform);
					rentalList.add(rental);
					try
				    {
				      out = new FileOutputStream("res/games.txt");
				      outfile = new PrintStream( out);
				      for(int i=0; i<rentalList.size(); i++)
				      {
					      outfile.println(rentalList.get(i));
					      outfile.close();
				      } //end outer for loop
				     } //end try
				     catch(Exception e)
				     {
				      System.err.println("Error writing to outfile");
				      System.exit(1);
				     }
				}
				else
				{
					System.out.println("Invalid game addition.");
					System.exit(1);
				}
					break;
			default:
			{
				System.out.println("Invalid item addition");
				System.exit(1);
			}
			
		}
	}
	
	/*
	 * function to delete items from the arraylist
	 */
	public void DeleteRentalItems()
	{
		System.out.println("Would you like to delete?(m)movie or (g)game?: ");
		functionSelection = sc.next().toLowerCase().charAt(0);
		
		switch(functionSelection)
		{
		case 'm':
			System.out.println("Which movie would you like to delete? (Please input ID): ");
			int movieSearch = sc.nextInt();
			
			fillMovieArrayList();
			
			Iterator<RentalItem> itrX = rentalList.iterator();   //define Iterator and attach to rentalList
			 
			while(itrX.hasNext()) //loop through items while there are items to loop through.
			{         
				if(itrX.equals(movieSearch))
				{
					itrX.remove();
					fillMovieArrayList();
				}
			} 
			
			break;
		case 'g':
			System.out.println("Which game would you like to search for? (Please input ID): ");
			int gameSearch = sc.nextInt();
			
			fillGameArrayList();
			
			Iterator<RentalItem> itrXTwo = rentalList.iterator();   //define Iterator and attach to rentalList
			
			
			while(itrXTwo.hasNext()) //loop through items while there are items to loop through.
			{         
				if(itrXTwo.equals(gameSearch)) //Check for the item to be deleted
				{
					itrXTwo.remove();
					fillGameArrayList();
				}
			} 
			
			break;
		default:
			System.out.println("Invalid item ID.");
		}
	}
	
	/****************************PRIVATE METHODS ************************************/
	
	//filling in the arraylist with the game and movie selection
	private void fillArrayListWithRentals()
	{
		FileInput fin = new FileInput ("res/movie-games.txt");
		
		String line = fin.readLine();
		
		while(line != null)
		{
			int firstDigit = Integer.parseInt(line.charAt(3)+"");
			StringTokenizer st = new StringTokenizer(line,";");
			
			switch(firstDigit)
			{
				case 0:
				case 1:
				case 2:
				case 3:
				case 4:
					RentalItem rental = new Movie(Integer.parseInt(st.nextToken()),
													st.nextToken(),
													st.nextToken(),
													st.nextToken(),
													Integer.parseInt(st.nextToken()),
													st.nextToken(),
													st.nextToken(),
													st.nextToken(),
													Integer.parseInt(st.nextToken()));
					
					rentalList.add(rental);
					try
				    {
				      out = new FileOutputStream("res/movies.txt");
				      outfile = new PrintStream( out);
				      for(int i=0; i<rentalList.size(); i++)
				      {
					      outfile.println(rentalList.get(i));
					      outfile.close();
				      } //end outer for loop
				     } //end try
				     catch(Exception e)
				     {
				      System.err.println("Error writing to outfile");
				      System.exit(1);
				     }
					break;
				case 5:
				case 6:
				case 7:
				case 8:
				case 9:
					rental = new Game((Integer.parseInt(st.nextToken())),
													st.nextToken(),
													st.nextToken(),
													st.nextToken(),
													Integer.parseInt(st.nextToken()),
													st.nextToken(),
													st.nextToken());
					rentalList.add(rental);
					try
				    {
				      out = new FileOutputStream("res/games.txt");
				      outfile = new PrintStream( out);
				      for(int i=0; i<rentalList.size(); i++)
				      {
					      outfile.println(rentalList.get(i));
					      outfile.close();
				      } //end outer for loop
				     } //end try
				     catch(Exception e)
				     {
				      System.err.println("Error writing to outfile");
				      System.exit(1);
				     }
					break;
				default:
					System.out.println("No such item type!");
			} //end switch
			line =  fin.readLine();
		} //end while loop
		fin.closeInputFile();
	} //end fillArrayListWithRentals
	
	//seperate arrays to print to outfile
	private void fillMovieArrayList()
	{
		FileInput fin = new FileInput ("res/movies.txt");
		
		String line = fin.readLine();
		
		while(line != null)
		{
			StringTokenizer st = new StringTokenizer(line, ";");
			RentalItem rental = new Movie(Integer.parseInt(st.nextToken()),
						st.nextToken(),
						st.nextToken(),
						st.nextToken(),
						Integer.parseInt(st.nextToken()),
						st.nextToken(),
						st.nextToken(),
						st.nextToken(),
						Integer.parseInt(st.nextToken()));

			rentalList.add(rental);
		}
	}
	
	//seperate arraylist to add/delete without originally destroying movie-games.txt
	private void fillGameArrayList()
	{
		FileInput fin = new FileInput ("res/games.txt");
		
		String line = fin.readLine();
			
		while(line != null)
		{
			StringTokenizer st = new StringTokenizer(line, ";");
			RentalItem rental = new Game(Integer.parseInt(st.nextToken()),
						st.nextToken(),
						st.nextToken(),
						st.nextToken(),
						Integer.parseInt(st.nextToken()),
						st.nextToken(),
						st.nextToken());

			rentalList.add(rental);
		}
	}
}
