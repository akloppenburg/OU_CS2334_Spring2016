package Nooz;
/**
 *The newspaperStory class allows for the creation of and interaction with objects containing information about 
 *each individual news story
 *
 * @version 1.0
 * @author Alex Kloppenburg
 */
public class newspaperStory {
	
	/**A string containing the date the story was published.*/
	private String date;
	/**A String containing the name of the newspaper that published the story.*/
	private String sourceName;
	/**An integer that represents the number of words in the story.*/
	private int numWords;
	/**A String containing the topic of the story.*/
	private String topicName;
	/**A String containing the first person the story is about.*/
	private String firstNewsmaker;
	/**A String containing the second person the story is about.*/
	private String secondNewsmaker;
	
	/**
	 * Takes in values for each parameter, creates a new NewspaperStory object, turns the codes for the source 
	 * and topic from ints into Strings, and assigns values to the appropriate fields.
	 * 
	 * @param date A string containing the date the story was published.
	 * @param sourceCode An integer corresponding to the newspaper that published the story.
	 * @param numWords An integer that represents the number of words in the story.
	 * @param topicCode An integer corresponding to the topic of the story.
	 * @param firstNewsmaker A String containing the first person the story is about.
	 * @param secondNewsmaker A String containing the second person the story is about.
	 */
	public newspaperStory(String date, int sourceCode, int numWords, int topicCode, String firstNewsmaker, 
			String secondNewsmaker){
		
	}
	
	/**
	 * Returns the date of the current newspaperStory object in MM/DD/YYYY format.
	 * @return null
	 */
	public String getDate(){
		return null;
		
	}
	
	/**
	 * Helper function that takes in the integer representing the newspaper that published the story and returns the
	 * newspaper's name as a String.
	 * @param sourceCodeNum An integer corresponding to the newspaper that published the story.
	 * @return null
	 */
	protected String getSourceFromCode(int sourceCodeNum){
		return null;
	}
	
	/**
	 * Returns the name of the newspaper that published the story as a String.
	 * @return null
	 */
	public String getSourceCode(){
		return null;
	}
	
	/**
	 * Returns an integer representing the number of words in the story.
	 * @return 0
	 */
	public int getNumWords(){
		return 0;
	}
	
	/**
	 * Helper function that takes in the integer representing the topic of the story and returns the
	 * topic as a String.
	 * @param topicCodeNum An integer corresponding to the topic of the story.
	 * @return null
	 */
	protected String getTopicFromCode(int topicCodeNum){
		return null;
	}
	
	/**
	 * Returns the story's topic as a String.
	 * @return null
	 */
	public String getTopic(){
		return null;
	}
	
	/**
	 * Returns the name of the first person that the story is about, or "none" if there is no first person.
	 * @return null
	 */
	public String getFirstNewsmaker(){
		return null;
		
	}
	
	/**
	 * Returns the name of the second person that the story is about, or "none" if there is no second person.
	 * @return null
	 */
	public String getSecondNewsmaker(){
		return null;
	}
	
	public String toString(){
		return null;
	}

}
