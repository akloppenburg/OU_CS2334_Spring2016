package Nooz;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;

/**
 * thee storyList class allows for the collection of and interaction with a list of newspaperStory objects.
 * 
 * @author Alex Kloppenburg
 * @version 1.0
 */
public class storyList {
	
	/**
	 * A list of newspaperStory objects.
	 */
	private ArrayList<newspaperStory> storyList;
	
	/**
	 * An empty constructor.
	 */
	public storyList(){
		
	}
	/**
	 * Searches the list of news stories for stories about a certain newsmaker.
	 * @param newsmaker The person that a newspaper story is about that you would like to search the database for.
	 * @return null
	 */
	public ArrayList<newspaperStory> search(String newsmaker){
		return null;
	}
	
	/**
	 * Fills up your array list with newspaperStory objects that are populated with data taken from the given file.
	 * @param filename The CSV file containing the newspaper stories you're concerned with
	 */
	public void populateList(String filename){
		
	}
}
