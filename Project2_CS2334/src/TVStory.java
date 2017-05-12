import java.time.LocalDate;
import Nooz.*;

/**
 * This class allows for the creation and manipulation of objects associated with a particular TV story.  It contains all
 * relevant data about the story.
 * @author Alex
 * @version 2.0
 * @date 2/21/17 11:53 AM
 */
public class TVStory {
	
	/**
	 * A LocalDate object containing the month, day, and year on which the story was published.
	 */
	private LocalDate date;
	
	/**
	 * A String containing the name of the show the story aired on.
	 */
	private String showName;
	
	/**
	 * An integer representing the length of the broadcast the story was on in seconds.
	 */
	private int durationSeconds;
	
	/**
	 * A NewsMaker object representing the relevant newsmaker in the story.
	 */
	private NewsMaker newsMaker;
	
	/**
	 * A constructor to create a TVStory object with parameters for all the relevant data about the story.
	 * @param date The month, day, and year on which the story was published.
	 * @param showName The name of the show the story aired on.
	 * @param durationSeconds The length of the broadcast the story was on in seconds.
	 * @param newsMaker The relevant newsmaker in the story.
	 */
	public TVStory(LocalDate date, String showName, int durationSeconds, NewsMaker newsMaker){
		
	}
	
	/**
	 * Returns a LocalDate object containing the month, day, and year on which the story was published.
	 * @return date The month, day, and year on which the story was published.
	 */
	public LocalDate getBroadcastDate(){
		return null;
	}
	
	/**
	 * Returns a String containing the name of the show the story aired on.
	 * @return showName
	 */
	public String getTVShow(){
		return null;
	}
	
	/**
	 * Returns an integer representing the length of the broadcast the story was on in seconds.
	 * @return durationSeconds
	 */
	public int getDurationSeconds(){
		return 0;
	}
	
	/**
	 * Returns a NewsMaker object representing the relevant newsmaker in the story.
	 * @return newsMaker The relevant newsmaker in the story.
	 */
	public NewsMaker getNewsMaker(){
		return null;
	}
	
}
