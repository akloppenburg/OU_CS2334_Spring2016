import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import javax.swing.JOptionPane;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * Project #1 CS 2334, Section 010 February 22, 2017
 * <P>
 * This class provided helper methods to interact with the user.
 * </P>
 * <P>
 * Note that all methods in this class are static because we don't need to make
 * several <code>UserInterface</code> objects and have them maintain their own
 * data. Instead, we simply need a collection of useful methods to create
 * windows that pop up one at a time, are used, and then are discarded.
 * </P>
 * 
 * @author Dean Hougen
 * @version 1.0
 *
 */

//TODO finish writing class
//TODO write and edit Javadoc
//TODO check against Dr. Hougen's javadoc and UML
class UserInterface {
	
	public static String queryMediaType() throws IOException{
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Search newspapers, TV news, or both (n, t, or b)?");
		String mediaTypeChoice = input.readLine();
		
		while(!(mediaTypeChoice.equalsIgnoreCase("n") || mediaTypeChoice.equalsIgnoreCase("t") ||
				mediaTypeChoice.equalsIgnoreCase("b"))){
			
				System.err.println("Please enter either n, t , or b.");
				System.out.println("Search newspapers, TV news, or both (n, t, or b)?");
				mediaTypeChoice = input.readLine();
				
		}
		return mediaTypeChoice;
	}
	
	public static String queryMatchType() throws IOException{
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Search for newsmakers by exact or partial matches (e or p)?");
		String matchTypeChoice = input.readLine();
		
		while(!(matchTypeChoice.equalsIgnoreCase("e") || matchTypeChoice.equalsIgnoreCase("p"))){
			
			System.err.println("Please enter either e or p.");
			System.out.println("Search for newsmakers by exact or partial matches (e or p)?");
			matchTypeChoice = input.readLine();
			
		}
		return matchTypeChoice;
	}

	/**
	 * This method asks the user for the name of a news maker using a
	 * <code>JOptionPane</code> and returns it.
	 * 
	 * @return The name provided by the user (or "None" if none provided).
	 */
	public static String queryNewsMakerName(String matchType) throws IOException{
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		if(matchType.equalsIgnoreCase("e")){
			
			System.out.println("Newsmaker (exact)?");
			String newsMakerName = input.readLine();
			return newsMakerName;
			
		}
		if(matchType.equalsIgnoreCase("p")){
			
			System.out.println("Newsmaker (partial)?");
			String newsMakerName = input.readLine();
			return newsMakerName;
			
		}
		else{
			return null;  //Useful for debugging this method
		}
		
	}
	
	public static String querySortCriterion(String sortCriterion) throws IOException{
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		if(sortCriterion.length() == 0){
			
			System.out.println("Primary sort criterion is source, topic, or length (s, t, or l)?");
			return input.readLine();
			
		}
		
		else if(sortCriterion.length() == 1){
			
			if(sortCriterion.equalsIgnoreCase("s")){
				
				System.out.println("Secondary sort criterion is topic or length (t or l)?");
				return sortCriterion + input.readLine();
				
			}
			else if(sortCriterion.equalsIgnoreCase("t")){
				
				System.out.println("Secondary sort criterion is source or length (s or l)?");
				return sortCriterion + input.readLine();
				
			}
			else{
				
				System.out.println("Secondary sort criterion is source or topic (s or t)?");
				return sortCriterion + input.readLine();
				
			}
		}
		
		else if(sortCriterion.length() == 2){
			
			if(sortCriterion.contains("s")){
				
				if(sortCriterion.contains("t")){
					return sortCriterion + "l";
				}
				else{
					return sortCriterion + "t";
				}
				
			}
			
			else if(sortCriterion.contains("t")){
				
				if(sortCriterion.contains("s")){
					return sortCriterion + "l";
				}
				else{
					return sortCriterion + "s";
				}
				
			}
			
			else{
				
				if(sortCriterion.contains("s")){
					return sortCriterion + "t";
				}
				else{
					return sortCriterion + "s";
				}
				
			}
			
		}
		
		else{
			return null;  //Useful when debugging this method
		}
		
	}
	
	public static String queryFileName(String message) throws IOException{
		
		System.out.println(message);
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String filename = input.readLine();
		return filename;
		
	}
	
	public static boolean queryBoolean(String message) throws IOException{
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print(message);
		String output = input.readLine();
		while(true){
			
			output = input.readLine();
			
			if(output == "y"){
				return true;
			}
			else if(output == "y"){
				return false;
			}
			else{
				System.out.print(message);
			}
			
		}
		
	}

	/**
	 * This method takes a news maker and turns its list of newspaper stories
	 * into a string formated for display to the user. At the end it includes
	 * line summarizing the number of stories found, the number of different
	 * newspapers in which these stories were published, the total number of
	 * words in these articles, and the number of different topics found.
	 * 
	 * @param newsMaker
	 *            The news maker for which to create the story list as a string
	 * @return The list of stories as one (potentially very large) string
	 */
	public static String createListOfNewsStoriesForNewsmaker(NewsMaker newsMaker, String mediaType, String[] sortCriteria) {
		/* The list of stories as a String */
		String listOfStories = "";

		/*
		 * Lists to keep track of the distinct newspaper names and topics found
		 * (for the summary line).
		 */
		Set<String> distinctSourceNames = new HashSet<String>();
		Set<String> distinctTopics = new HashSet<String>();

		/* The running total of the words in the stories. */
		int totalWords = 0;

		/*
		 * A local reference to the story list so that we don't have use the
		 * accessor method repeatedly (wasting time), as well as instances of
		 *  the comparators we'll need down the line.
		 */
		NewsStoryList newsStoryList = newsMaker.getNewsStories();
		LengthComparator LENGTH_COMPARATOR = new LengthComparator();
		SourceComparator SOURCE_COMPARATOR = new SourceComparator();
		
		ArrayList<NewsStory> storyList = new ArrayList<NewsStory>();
		for(int i = 0; i < storyList.size(); ++i){
		
			if(mediaType.equalsIgnoreCase("b")){
				
				if(storyList.get(i) instanceof NewsStory){
					storyList.add(newsStoryList.get(i));
				}
				
			}
			
			else if(mediaType.equalsIgnoreCase("n")){
				
				if(newsStoryList.get(i) instanceof NewspaperStory){
					storyList.add(newsStoryList.get(i));
				}
				
			}
			
			else if(mediaType.equalsIgnoreCase("t")){
				
				if(newsStoryList.get(i) instanceof TVNewsStory){
					storyList.add(newsStoryList.get(i));
				}
				
			}
			
			else{}
			
		}
		
		for(int i = 0; i < 3; ++i){
			
			if(sortCriteria[i].equalsIgnoreCase("t")){
				Collections.sort(storyList);
			}
			else if(sortCriteria[i].equalsIgnoreCase("s")){
				Collections.sort(storyList, SOURCE_COMPARATOR);
			}
			else if(sortCriteria[i].equalsIgnoreCase("l")){
				Collections.sort(storyList, LENGTH_COMPARATOR);
			}
			
		}

		for(NewsStory newsStory: storyList){
			
			// Add any new newspaper name encountered to the list of names
			String sourceName = newsStory.getSource();
			if (!distinctSourceNames.contains(sourceName)) {
				distinctSourceNames.add(sourceName);
			}

			// Add any new topic encountered to the list of topics
			String topic = newsStory.getTopic();
			if (!distinctTopics.contains(topic)) {
				distinctTopics.add(topic);
			}

						
			// Add to the running total of words
			totalWords += newsStory.getLength();
	
			// Convert the story to the display format and add it to the end of
			// the list
			listOfStories += convertToOutputFormat(newsStory, mediaType) + "\n";
			
		}

		// Construct the summary line
		listOfStories += "Number of Stories: " + newsStoryList.size() + "; Number of Newspapers: "
				+ distinctSourceNames.size() + "; Number of Words: " + totalWords + "; Number of Topics: "
				+ distinctTopics.size();

		return listOfStories;
	}

	/**
	 * This method converts an individual story to the desired display format.
	 * 
	 * @param newspaperStory
	 *            The story to convert to the display format.
	 * @return The story in the display format.
	 */
	private static String convertToOutputFormat(NewsStory newsStory, String mediaType) {
		String storyString = "";
		LocalDate date = newsStory.getDate();
		storyString += date.getMonth().getDisplayName(TextStyle.FULL, Locale.US) + " " + date.getDayOfMonth() + ", "
				+ date.getYear() + "; " + newsStory.getNewspaperName() + "; " + newsStory.getWordCount()
				+ " words; " + newsStory.getTopic();
		return storyString;
	}

	/**
	 * This method displays the list of newspaper stories to the user using a
	 * <code>JOptionPane</code>.
	 * <P>
	 * Note that a <code>JOptionPane</code> works fine for small messages but
	 * isn't suitable for large messages, such as those that can be generated
	 * for news makers for whom there are many stories. However, to keep this
	 * project relatively simple, we have gone with a <code>JOptionPane</code>
	 * here. We'll learn how to develop more suitable graphical user interfaces
	 * in later assignments.
	 * </P>
	 * 
	 * @param listOfStories
	 *            The list of stories to display, all as one (potentially very
	 *            large) String.
	 * @param newsMakerName
	 *            The name of the news maker (which is put into the title of the
	 *            JOptionPane).
	 */
	public static void presentNewsStories(String listOfStories, String newsMakerName) {
		System.out.print("News stories for " + newsMakerName + "\n" + listOfStories);
	}

	public static void reportNewsmakerNotFound(NewsMaker queriedNewsMaker) {
		System.out.print("There are no newspaper stories about " + queriedNewsMaker.getName() + " in this database.");
	}
}
