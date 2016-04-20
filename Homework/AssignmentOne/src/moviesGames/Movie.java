/**
 * Jan 27, 2009
 */
package moviesGames;

/**
 * @author 432873
 *
 */
public class Movie extends RentalItem
{
	//Attributes
	private String director;
	private String leadingActor;
	private String supportingActors;
	private int runningTime;
	/**
	 * 
	 */
	public Movie()
	{
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param itemID
	 * @param title
	 * @param category
	 * @param rating
	 * @param releaseDate
	 * @param director
	 * @param leadingActor
	 * @param supportingActors
	 * @param runningTime
	 */
	public Movie(int itemID, String title, String category, String rating,
			int releaseDate, String director, String leadingActor, String supportingActors, int runningTime)
	{
		super(itemID, title, category, rating, releaseDate);
		this.director = director;
		this.leadingActor = leadingActor;
		this.supportingActors = supportingActors;
		this.runningTime = runningTime;
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the director
	 */
	public String getDirector()
	{
		return director;
	}

	/**
	 * @param director the director to set
	 */
	public void setDirector(String director)
	{
		this.director = director;
	}

	/**
	 * @return the leadingActor
	 */
	public String getLeadingActor()
	{
		return leadingActor;
	}

	/**
	 * @param leadingActor the leadingActor to set
	 */
	public void setLeadingActor(String leadingActor)
	{
		this.leadingActor = leadingActor;
	}

	/**
	 * @return the supportingActors
	 */
	public String getSupportingActors()
	{
		return supportingActors;
	}

	/**
	 * @param supportingActors the supportingActors to set
	 */
	public void setSupportingActors(String supportingActors)
	{
		this.supportingActors = supportingActors;
	}

	/**
	 * @return the runningTime
	 */
	public int getRunningTime()
	{
		return runningTime;
	}

	/**
	 * @param runningTime the runningTime to set
	 */
	public void setRunningTime(int runningTime)
	{
		this.runningTime = runningTime;
	}
	
	public String toString()
	{
		return super.toString()+"; "+director+"; "+leadingActor+"; "+supportingActors+"; "+runningTime;
	}
}
