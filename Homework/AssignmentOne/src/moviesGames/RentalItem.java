/**
 * Jan 26, 2009
 */
package moviesGames;

/**
 * @author 432873
 * Jorge Pinochet
 */
public abstract class RentalItem
{
	//Attributes 
	private int 		itemID; 			//common
	private String 		title;				//common
	private String 		category;			//common
	private String 		rating; 			//common
	private int 		releaseDate;  		//common
	
	/**
	 * Default Constructors
	 */
	
	public RentalItem()
	{
	}
	
	/**
	 * @param itemID 		The rental items ID
	 * @param title	 		The title of the rented item
	 * @param category 		hat category is the rental item
	 * @param rating 		What rating the movie/game has
	 * @param releaseDate	When the game/movie was released
	 */
	public RentalItem(int itemID, String title, String category, String rating, int releaseDate)
	{
		this.itemID = itemID;
		this.title = title;
		this.category = category;
		this.rating = rating;
		this.releaseDate = releaseDate;
	}
	/**
	 * @return the itemID
	 */
	public int getItemID()
	{
		return itemID;
	}
	/**
	 * @param itemID the itemID to set
	 */
	public void setItemID(int itemID)
	{
		this.itemID = itemID;
	}
	/**
	 * @return the title
	 */
	public String getTitle()
	{
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title)
	{
		this.title = title;
	}
	/**
	 * @return the category
	 */
	public String getCategory()
	{
		return category;
	}
	/**
	 * @param category the category to set
	 */
	public void setCategory(String category)
	{
		this.category = category;
	}
	
	public String getRating()
	{
		return rating;
	}
	/**
	 * @param rating the rating to set
	 */
	public void setRating(String rating)
	{
		this.rating = rating;
	}
	/**
	 * @return the releaseDate
	 */
	public int getReleaseDate()
	{
		return releaseDate;
	}
	/**
	 * @param releaseDate the releaseDate to set
	 */
	public void setReleaseDate(int releaseDate)
	{
		this.releaseDate = releaseDate;
	}
	
	public String toString()
	{
		return itemID+" "+title+" "+category+" "+rating+" "+releaseDate;
	}
}
