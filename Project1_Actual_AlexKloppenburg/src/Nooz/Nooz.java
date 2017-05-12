//TODO add javadoc
package Nooz;
import javax.swing.JOptionPane;

public class Nooz {
	
	//Empty constructor to appease mimir
	private Nooz(){
		
	}
	
	//List of newsmakers to read/search from
	private static NewsMakerList newsMakers = new NewsMakerList();
	
	public static void main(String[] args){
		
		//Reads in stories, assigns them to newsmakers and assigns those newsmakers to the list
		newsMakers = NoozFileProcessor.readNoozFile(args[0]);
		
		//Gets joptionpane input from the user
		String queriedName = UserInterface.queryNewsMakerName();
		
		//Changes input to "None" format to work better with list format
		try{
			if(queriedName.equals("")){
				queriedName = "None";
			}
			else{
			}
		}
		//Keeps "cancel" button on joptionpane from throwing an error
		catch(NullPointerException n){
			JOptionPane.showMessageDialog(null, "Thank you for searching!");
		}
		
		//Newsmaker to search for
		NewsMaker key = new NewsMaker(queriedName);
		
		//Writes list of stores and their relevant data to a joptionpane window for the given newsmaker
		try{
			String listOfStories = UserInterface.createListOfNewspaperStoriesForNewsmaker(key);
			
			UserInterface.presentNewspaperStories(listOfStories, queriedName);
		}
		//Catches exception if no stories are found
		catch(NullPointerException n){
			UserInterface.reportNewsmakerNotFound(key);
		}
	}
}
