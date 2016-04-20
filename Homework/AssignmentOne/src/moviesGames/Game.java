/**
 * Jan 27, 2009
 */
package moviesGames;

/**
 * @author 432873
 *
 */
public class Game extends RentalItem
{
	//Attributes
	private String developer;
	private String gamePlatform;

	/**
	 * 
	 */
	public Game()
	{
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param itemID
	 * @param title
	 * @param category
	 * @param rating
	 * @param releaseDate
	 * @param developer
	 * @param gamePlatform
	 */
	public Game(int itemID, String title, String category, String rating,
			int releaseDate, String developer, String gamePlatform)
	{
		super(itemID, title, category, rating, releaseDate);
		this.developer = developer;
		this.gamePlatform = gamePlatform;
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the developer
	 */
	public String getDeveloper()
	{
		return developer;
	}

	/**
	 * @param developer the developer to set
	 */
	public void setDeveloper(String developer)
	{
		this.developer = developer;
	}

	/**
	 * @return the gamePlatform
	 */
	public String getGamePlatform()
	{
		return gamePlatform;
	}

	/**
	 * @param gamePlatform the gamePlatform to set
	 */
	public void setGamePlatform(String gamePlatform)
	{
		this.gamePlatform = gamePlatform;
	}
	
	public String toString()
	{
		return super.toString()+";"+developer+"; "+gamePlatform;
	}
}
