import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Project 2, CS 2334, Section 010, February 22, 2017
 * <P>
 * Nooz is the driver class for Nooz, a simple newspaper story data system.
 * Because user interaction with the date is focused on news makers, the primary
 * data structure used by the driver is a <code>NewsMakerList</code>, which is
 * used within <code>main</code>.
 * </P>
 *
 * @author Dean Hougen
 */
class Nooz {
	/** The list of news makers. */
	private static NewsMakerList newsMakers = new NewsMakerList();
	
	private static Map<String, String> sourceMap = new HashMap<String, String>();
	private static Map<String, String> topicMap = new HashMap<String, String>();
	private static Map<String, String> subjectMap = new HashMap<String, String>();

	/**
	 * The main method creates the objects necessary to do the work, then lets
	 * them do it.
	 * <P>
	 * Reads a data file specified by the user at the console prompt; this loads
	 * in all data used by the program.
	 * </P>
	 * <P>
	 * Once the data is read in, it enters a user interaction loop, asking for
	 * the type of stories to search, the name of a news maker, etc., then
	 * displaying the stories about that news maker or reporting that the news
	 * maker is not found in the data, as appropriate. The loop continues until
	 * the user enters "n" to a "Continue (y/n)?" prompt.
	 * </P>
	 * <P>
	 * Note that this program doesn't attempt to deal with I/O errors. This is
	 * allowable at this point to keep this project relatively simple and
	 * because we haven't covered this topic yet. However, this is something to
	 * be refined in the future.
	 * </P>
	 * 
	 * @param args
	 *            The program arguments are not used in this program.
	 * @throws IOException
	 *             If there is an I/O problem reading the data file.
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// There should be no program arguments supplied
		if (args.length != 0) {
			// If the calling process specifies the wrong number of program
			// arguments, give an error message and exit with non-zero exit code
			System.err.println("Usage error. Program arguments are not used by this program.");
			System.exit(1);
		}
		
		loadData();
		
		String[] yesNo = {"y", "n"};
		String binarySave = UserInterface.querySingleChoice("Save data in binary format (y/n)?", yesNo);
		if(binarySave.equals(yesNo[0])){
			String filename = UserInterface.queryFileName("Enter the name of the file to write news story "
					+ "binary data: ", false);
			FileOutputStream fo = new FileOutputStream(new File(filename));
			ObjectOutputStream oo = new ObjectOutputStream(fo);
			oo.writeObject(newsMakers);
			oo.close();
		}
		
		loopForUserQueries();
		
	}
	
	private static void loadData() throws IOException, ClassNotFoundException{
		
		String[] inputOptions = {"t", "b"};
		String loadChoice = UserInterface.querySingleChoice("Read text or binary data (t or b)?", inputOptions);
		
		if(loadChoice.equals("t")){
			
			// Prompt user for name of data files.
			String sourceFileName = UserInterface.queryFileName("Please enter the name of the news source data file: ", true);
			String topicFileName = UserInterface.queryFileName("Please enter the name of the news topic data file: ", true);
			String subjectFileName = UserInterface.queryFileName("Please enter the name of the news subject data file: ", true);
			String storiesFileName = UserInterface.queryFileName("Please enter the name of the news story data file: ", true);
			
			//Process sources, topics, and subjects into their respective maps
			sourceMap = CodeFileProcessor.readCodeFile(sourceFileName);
			topicMap = CodeFileProcessor.readCodeFile(topicFileName);
			subjectMap = CodeFileProcessor.readCodeFile(subjectFileName);
			
			// Read file putting NewsMakers in the NewsMakerList
			// TODO Handle possible I/O errors (Eventually)
			newsMakers = NoozFileProcessor.readNoozFile(storiesFileName, sourceMap, topicMap, subjectMap);
			
			// Sort the news makers
			newsMakers.sort();
		}
		else if(loadChoice.equals("b")){
			
			String binaryFileName = UserInterface.queryFileName("Please enter the name of the news story data file: ", 
					true);
			FileInputStream fi = new FileInputStream(binaryFileName);
			ObjectInputStream oi = new ObjectInputStream(fi);
			newsMakers = (NewsMakerList)oi.readObject();
			oi.close();
			
		}
		else{
			System.out.println("Please enter either t or b.");
		}
		
	}
	
	private static void loopForUserQueries() throws ClassNotFoundException, IOException{
		
		boolean loop = true;
		String[] mediaChoices = {"n", "t", "o"};
		String[] matchChoices = {"e", "p"};
		String[] displayChoices = {"t", "g"};
		String[] sortCriteria = {"", "", "", ""};
		NewsMaker newsMaker = null;
		
		while(loop){
			
			//Finds out what kinds of stories the user would like displayed
			String mediaChoice = UserInterface.queryMultipleChoices("Search newspapers, TV news, and/or online news"
					+ " sources n, t, and/or o)?", mediaChoices);
			//Do something with their search choice here
			
			//Asks for exact or partial name matches
			String matchType = UserInterface.querySingleChoice("Search news makers by exact or partial matches (e or p)?",
					matchChoices);
			
			//Gets the name of the newsmaker
			String newsmakerName = UserInterface.queryNewsMakerName(matchType);
			
			/*If exact, runs an exact search, and if partial runs a partial search.  Creates a NewsMaker object 
				w/that name*/
			if(matchType == "e"){
				newsMaker = newsMakers.getExactMatch(newsmakerName);
			}
			else{
				newsMaker = newsMakers.getPartialMatch(newsmakerName);
			}
			
			//Asks for display type so that sort criterion can be established
			String displayType = UserInterface.querySingleChoice("Display text or graph (t or g)?", displayChoices);
			
			//Runs querySortCriteria 4 times to get the string array full of sort criteria necessary
			sortCriteria[0] = UserInterface.querySortCriterion(sortCriteria);
			sortCriteria[1] = UserInterface.querySortCriterion(sortCriteria);
			sortCriteria[2] = UserInterface.querySortCriterion(sortCriteria);
			sortCriteria[3] = UserInterface.querySortCriterion(sortCriteria);
			
			if(displayType.equals("t")){
				String listOfStories = UserInterface.createListOfNewsStoriesForNewsmaker(newsMaker, mediaChoice, 
						sortCriteria);
				UserInterface.presentNewspaperStories(listOfStories, newsmakerName);
			}
			else{
				//prepare data and display graphically somehow
			}
		}
		
		System.out.println("Thanks for using Nooz.");
		System.exit(0);
		
		
	}
}
