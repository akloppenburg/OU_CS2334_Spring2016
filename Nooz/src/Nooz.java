import java.io.IOException;

/**
 * Project #1 CS 2334, Section 010 February 22, 2017
 * <P>
 * Nooz is the driver class for Nooz, a simple newspaper story data system.
 * Because user interaction with the date is focused on news makers, the primary
 * data structure used by the driver is a <code>NewsMakerList</code>, which is
 * used within <code>main</code>.
 * </P>
 *
 * @author Dean Hougen
 */

//TODO finish writing class
//TODO write and edit Javadoc
//TODO check against Dr. Hougen's javadoc and UML
class Nooz {
	/** The list of news makers. */
	private static NewsMakerList newsMakers = new NewsMakerList();

	/**
	 * The main method creates the objects necessary to do the work, then lets
	 * them do it.
	 * <P>
	 * Reads a data file specified by a program argument passed in by the
	 * calling process; this loads in all data used by the program.
	 * </P>
	 * <P>
	 * Once the data is read in, it enters a user interaction loop, asking for
	 * the name of a news maker, then displaying the stories about that news
	 * maker or reporting that the news maker is not found in the data, as
	 * appropriate. The loop continues until the user enters "Cancel" rather
	 * than entering a name.
	 * </P>
	 * <P>
	 * Note that this program doesn't attempt to deal with I/O errors. This is
	 * allowable at this point to keep this project relatively simple and
	 * because we haven't covered this topic yet. However, this is something to
	 * be refined in the future.
	 * </P>
	 * 
	 * @param args
	 *            The program arguments passed in by the calling process.
	 * @throws IOException
	 *             If there is an I/O problem reading the data file.
	 */
	public static void main(String[] args) throws IOException {
		// Get the name of the file to read using program arguments
		if (args.length != 1) {
			// If the calling process specifies the wrong number of program
			// arguments, give an error message and exit with non-zero exit code
			System.err.println("Usage error. Must provide one program argument (name of data file to read).");
			System.exit(1);
		}

		// Read file putting NewsMakers in the NewsMakerList
		// TODO Handle possible I/O errors (Eventually)
		newsMakers = NoozFileProcessor.readNoozFile(args[0]);

		// Enter GUI loop
		while (true) { // "Cancel" -> null name to exit

			// Get the name of the news maker from the user
			String newsMakerName = UserInterface.queryNewsMakerName();

			// If the name is null, the user hit "Cancel" to quit
			if (newsMakerName == null) {
				// Print pleasant exit message and exit with code zero
				System.out.println("Thanks for using Nooz.");
				System.exit(0);
			}

			// Use the name to create a news maker
			NewsMaker queriedNewsMaker = new NewsMaker(newsMakerName);

			// Get the news maker from the list of news makers
			NewsMaker foundNewsMaker = newsMakers.get(queriedNewsMaker);

			// If no news maker with that name found, tell user
			if (foundNewsMaker == null) {
				UserInterface.reportNewsmakerNotFound(queriedNewsMaker);
			}

			else {
				// Otherwise, get list of stories as a String from news maker
				String listOfStories = UserInterface.createListOfNewspaperStoriesForNewsmaker(foundNewsMaker);

				// And show the list of stories to the user
				UserInterface.presentNewspaperStories(listOfStories, newsMakerName);
			}
		}
	}
}
