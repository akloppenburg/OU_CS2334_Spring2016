//TODO add javadoc
package Nooz;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class UserInterface {
	
	//Creates a Joptionpane asking for user input
	public static String queryNewsMakerName(){
		
		String query = JOptionPane.showInputDialog("Please enter the name of the newsmaker you'd like to search for");
		
		return query;
	}
	
	//Creates a single string containing all data relevant to the given NewsMaker's stories
	public static String createListOfNewspaperStoriesForNewsmaker(NewsMaker newsMaker){
		
		NewspaperStoryList stories = newsMaker.getNewspaperStories();
		
		String allStories = convertToOutputFormat(stories.get(0));
		
		for(int i = 1; i < stories.size(); ++i){
			allStories = allStories + "\n" + convertToOutputFormat(stories.get(i));
		}
		
		return allStories;
	}
	
	//Changes a newspaperStory object to a string containing all relevant data
	private static String convertToOutputFormat(NewspaperStory newspaperStory){
		
		//Turning date into Month, day year format
		LocalDate date = newspaperStory.getDate();
		int monthNum = date.getMonthValue();
		String month = "";
		switch(monthNum){
			case 1: month = "January ";
				break;
			case 2: month = "February ";
				break;
			case 3: month = "March ";
				break;
			case 4: month = "April ";
				break;
			case 5: month = "May ";
				break;
			case 6: month = "June ";
				break;
			case 7: month = "July ";
				break;
			case 8: month = "August ";
				break;
			case 9: month = "September ";
				break;
			case 10: month = "October ";
				break;
			case 11: month = "November ";
				break;
			case 12: month = "December ";
				break;
		}
		int day = date.getDayOfMonth();
		int year = date.getYear();
		
		//Gets names of newsmakers
		String newsmakerName1 = newspaperStory.getNewsMaker1().getName();
		String newsmakerName2 = newspaperStory.getNewsMaker2().getName();
		
		//Gets newspaper name, word count, and topic
		String paperName = newspaperStory.getNewspaperName();
		int wordsNum = newspaperStory.getWordCount();
		String topic = newspaperStory.getTopic();
		
		//Concatenates all relevant data into one string
		String output = month + day + ", " + year + "; " + paperName + "; " + wordsNum + " words; " + topic;
		
		return output;
	}
	
	//Creates a string with the newsmaker's name on top and their stories below
	public static void presentNewspaperStories(String listOfStories, String newsMakerName){
		
		JOptionPane.showMessageDialog(null, newsMakerName + "\n\n" + listOfStories);
		
	}
	
	//Creates a joptionpane "error message" if no newsmaker is found
	public static void reportNewsmakerNotFound(NewsMaker queriedNewsMaker){
		
		JOptionPane.showMessageDialog(null, "The newsmaker you entered has no stories associated with them.  "
				+ "Please exit this window and search again.");
		
	}
	
}
