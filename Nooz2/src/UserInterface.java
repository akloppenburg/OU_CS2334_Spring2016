import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;

/**
 * Project 2, CS 2334, Section 010, February 22, 2017
 * <P>
 * This class provides helper methods to interact with the user.
 * </P>
 * <P>
 * Note that all methods in this class are static because we don't need to make
 * several <code>UserInterface</code> objects and have them maintain their own
 * data. Instead, we simply need a collection of useful methods to create
 * windows that pop up one at a time, are used, and then are discarded.
 * </P>
 * 
 * @author Dean Hougen
 * @version 2.0
 *
 */
class UserInterface {
	
	public static String querySingleChoice(String message, String[] options) throws IOException{
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(message);
		
		String userChoice = input.readLine();
		while(true){
			
			for(int i = 0; i < options.length; ++i){
				if(userChoice.equalsIgnoreCase(options[i])){
					return userChoice;
				}
			}
			System.out.println("Please enter a valid choice from the list of options.");
			userChoice = input.readLine();
		}
		
	}
	
	public static String queryMultipleChoices(String message, String[] options) throws IOException{
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(message);
		
		while(true){
			
			String userChoice = input.readLine();
			
			for(int i = 0; i < options.length; ++i){
				if(userChoice.contains(options[i])){
					return userChoice;
				}
			}
			System.out.println("Please enter a valid choice from the list of options.");
		}
		
	}

	/**
	 * This method asks the user for the name of a news maker using console
	 * input and returns it. It will ask for an exact or partial match,
	 * depending on the parameter <code>matchType</code>, which has "e" and "p"
	 * as its two valid options.
	 * 
	 * @param matchType
	 *            Whether the name match will be exact (e) or partial (p).
	 * @return The name provided by the user (or "None" if none provided).
	 * @throws IOException
	 *             If something goes wrong reading a line from the console.
	 */
	public static String queryNewsMakerName(String matchType) throws IOException {
		BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
		if (matchType.equals("e")) {
			System.out.print("Newsmaker (exact)? ");
		}
		// The only options are exact and partial
		else {
			System.out.print("Newsmaker (partial)? ");
		}
		String newsMakerName = inputReader.readLine();

		// If String returned is empty (""), news maker is "None" (a special
		// value).
		if (newsMakerName.equals("")) {
			newsMakerName = "None";
		}
		return newsMakerName;
	}

	/**
	 * This method asks the user (at the console) for a sort criterion. If
	 * called with an empty <code>String</code> (""), it will ask about the
	 * primary sort criterion. If called with a non-empty <code>String</code>,
	 * it will ask for a secondary sort criterion that isn't the sort criterion
	 * passed in as a parameter. The method loops until a valid answer in given.
	 * 
	 * @param sortCriterion
	 *            The primary sort criterion already specified by the user (if
	 *            any).
	 * @return The sort criterion specified by the user.
	 * @throws IOException
	 *             If something goes wrong reading a line from the console.
	 */
	public static String querySortCriterion(String[] sortCriteria) throws IOException {
		
		//Two string arrays because the querySingleChoice needs an array as input
		String[] options = {"s", "t", "l", "d"};
		String[] words = {"source", "topic", "length", "date/time"};
		
		//Two arrayLists because the remove function makes seconary/tertiary/quaternary sorting easier
		ArrayList<String> optionsList = new ArrayList<String>();
		ArrayList<String> wordsList = new ArrayList<String>();
		
		//Load values from string arrays into arrayLists to be used in later sorts
		optionsList.add(options[0]);
		optionsList.add(options[1]);
		optionsList.add(options[2]);
		optionsList.add(options[3]);
		wordsList.add(words[0]);
		wordsList.add(words[1]);
		wordsList.add(words[2]);
		wordsList.add(words[3]);
		
		if(sortCriteria[0].equals("")){
			String message = "Primary sort criterion is: " + words[0] + ", " + words[1] + ", " + words[2] + ", " + 
					words[3] + " (" + options[0] + ", " + options[1] + ", " + options[2]  + ", or " + options[3] + ")?";
			return UserInterface.querySingleChoice(message, options);
			
		}
		else if(sortCriteria[1].equals("")){
			
			if(sortCriteria[0].equals(options[0])){
				optionsList.remove(options[0]);
				wordsList.remove(words[0]);
			}
			else if(sortCriteria[0].equals(options[1])){
				optionsList.remove(options[1]);
				wordsList.remove(words[1]);
			}
			else if(sortCriteria[0].equals(options[2])){
				optionsList.remove(options[2]);
				wordsList.remove(words[2]);
			}
			else{
				optionsList.remove(options[3]);
				wordsList.remove(words[3]);
			}
			
			String[] options2 = {optionsList.get(0), optionsList.get(1), optionsList.get(2)};
			String[] words2 = {wordsList.get(0), wordsList.get(1), wordsList.get(2)};
			
			String message2 = "Secondary sort criterion is: " + words2[0] + ", " + words2[1] + ", " + words2[2] + " ("
			+ options2[0] + ", " + options2[1] + ", or " + options2[2]  + ")?";
			
			return UserInterface.querySingleChoice(message2, options2);
			
			
		}
		else if(sortCriteria[2] == ""){
			
			if(sortCriteria[0].equals(options[0]) && sortCriteria[1].equals(options[1])){
				optionsList.remove(options[0]);
				wordsList.remove(words[0]);
				optionsList.remove(options[1]);
				wordsList.remove(words[1]);
			}
			else if(sortCriteria[0].equals(options[0]) && sortCriteria[1].equals(options[2])){
				optionsList.remove(options[0]);
				wordsList.remove(words[0]);
				optionsList.remove(options[2]);
				wordsList.remove(words[2]);
			}
			else if(sortCriteria[0].equals(options[0]) && sortCriteria[1].equals(options[3])){
				optionsList.remove(options[0]);
				wordsList.remove(words[0]);
				optionsList.remove(options[3]);
				wordsList.remove(words[3]);
			}
			else if(sortCriteria[0].equals(options[1]) && sortCriteria[1].equals(options[0])){
				optionsList.remove(options[1]);
				wordsList.remove(words[1]);
				optionsList.remove(options[0]);
				wordsList.remove(words[0]);
			}
			else if(sortCriteria[0].equals(options[1]) && sortCriteria[1].equals(options[2])){
				optionsList.remove(options[1]);
				wordsList.remove(words[1]);
				optionsList.remove(options[2]);
				wordsList.remove(words[2]);
			}
			else if(sortCriteria[0].equals(options[1]) && sortCriteria[1].equals(options[3])){
				optionsList.remove(options[1]);
				wordsList.remove(words[1]);
				optionsList.remove(options[3]);
				wordsList.remove(words[3]);
			}
			else if(sortCriteria[0].equals(options[2]) && sortCriteria[1].equals(options[0])){
				optionsList.remove(options[2]);
				wordsList.remove(words[2]);
				optionsList.remove(options[0]);
				wordsList.remove(words[0]);
			}
			else if(sortCriteria[0].equals(options[2]) && sortCriteria[1].equals(options[1])){
				optionsList.remove(options[2]);
				wordsList.remove(words[2]);
				optionsList.remove(options[1]);
				wordsList.remove(words[1]);
			}
			else if(sortCriteria[0].equals(options[2]) && sortCriteria[1].equals(options[3])){
				optionsList.remove(options[2]);
				wordsList.remove(words[2]);
				optionsList.remove(options[3]);
				wordsList.remove(words[3]);
			}
			else if(sortCriteria[0].equals(options[3]) && sortCriteria[1].equals(options[0])){
				optionsList.remove(options[3]);
				wordsList.remove(words[3]);
				optionsList.remove(options[0]);
				wordsList.remove(words[0]);
			}
			else if(sortCriteria[0].equals(options[3]) && sortCriteria[1].equals(options[1])){
				optionsList.remove(options[3]);
				wordsList.remove(words[3]);
				optionsList.remove(options[1]);
				wordsList.remove(words[1]);
			}
			else{
				optionsList.remove(options[3]);
				wordsList.remove(words[3]);
				optionsList.remove(options[2]);
				wordsList.remove(words[2]);
			}
			
			String[] options3 = {optionsList.get(0), optionsList.get(1)};
			String[] words3 = {wordsList.get(0), wordsList.get(1)};
			
			String message3 = "Tertiary sort criterion is: " + words3[0] + ", " + words3[1] + " ("
			+ options3[0] + " or " + options3[1] + ")?";
			
			return UserInterface.querySingleChoice(message3, options3);
			
		}
		else{
			optionsList.remove(sortCriteria[0]);
			optionsList.remove(sortCriteria[1]);
			optionsList.remove(sortCriteria[2]);
			
			return optionsList.get(0);
		}
		
		
		
	}

	/**
	 * This method prompts the user (at the console) with whatever message is
	 * passed in through the parameter <code>message</code>. This message is
	 * intended to ask for filenames but does no checks on the
	 * <code>String</code> returned so it could be used to ask any question that
	 * takes a <code>String</code> as a response.
	 * 
	 * @param message
	 *            The message with which to prompt the user.
	 * @return The filename as a String.
	 * @throws IOException
	 *             If something goes wrong reading a line from the console.
	 */
	public static String queryFileName(String message, boolean mustExist) throws IOException {
		BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print(message);
		String filename = inputReader.readLine();
		
		while(true){
			if(mustExist){
				File checkFile = new File(filename);
				
				if(checkFile.exists()){
					return filename;
				}
				else{
					System.out.println("A file with the name " + filename + " does not exist or is not readable.  "
							+ "Please try again.");
					filename = inputReader.readLine();
				}
			}
			else{
				return filename;
			}
		}
	}

	/**
	 * This method takes a news maker and turns its list of news stories into a
	 * <code>String</code> formated for display to the user. At the end it
	 * includes a line summarizing the number of stories found, the number of
	 * different news sources in which these stories were published, the total
	 * length of these stories, and the number of different topics found.
	 * <P>
	 * The summary line will have a slightly different format depending on media
	 * type specified.
	 * </P>
	 * <dl>
	 * <dt>Newspapers:</dt>
	 * <dd>Number of Stories: <i>n1</i>; Number of Sources: <i>n2</i>; Number of
	 * Words: <i>n3</i>; Number of Topics: <i>n4</i></dd>
	 * <dt>TV News:</dt>
	 * <dd>Number of Stories: <i>n1</i>; Number of Sources: <i>n2</i>; Seconds:
	 * <i>n3</i>; Number of Topics: <i>n4</i></dd>
	 * <dt>Both:</dt>
	 * <dd>Number of Stories: <i>n1</i>; Number of Sources: <i>n2</i>; Number of
	 * Word Equivalents: <i>n3</i>; Number of Topics: <i>n4</i></dd>
	 * </dl>
	 * 
	 * @param newsMaker
	 *            The news maker for which to create the story list as a string.
	 * @param mediaType
	 *            The type of media (newspaper, TV news, or both, given as n, t,
	 *            or b) that should be included in the list.
	 * @param sortCriteria
	 *            The primary, secondary, and tertiary sort criteria to use
	 *            (source, topic or length, given as s, t, or l), in an array
	 *            where element 0 corresponds to primary, 1 to secondary, and 2
	 *            to tertiary.
	 * @return The list of stories as one (potentially very large) string
	 */
	public static String createListOfNewsStoriesForNewsmaker(NewsMaker newsMaker, String mediaType,
			String[] sortCriteria) {
		/* The list of stories as a String */
		String listOfStories = "";

		/*
		 * Sets to keep track of the distinct news source names and topics found
		 * (for the summary line).
		 */
		Set<String> distinctNewsSourceNames = new TreeSet<String>();
		Set<String> distinctTopics = new TreeSet<String>();
		Set<String> distinctSubjects = new TreeSet<String>();

		/* The running total of the words in the stories. */
		int totalLength = 0;

		/*
		 * A local reference to the story list so that we don't have use the
		 * accessor method repeatedly (wasting time).
		 */
		NewsStoryList newsStoryList = newsMaker.getNewsStories();

		// Make our own copy of the data so that we can sort it.
		List<NewsStory> newsStories = new ArrayList<NewsStory>(newsStoryList.size());

		// If the user asked for just newspaper stories, just add those.
		if (mediaType.equals("n")) {
			for (int i = 0; i < newsStoryList.size(); i++) {
				NewsStory newsStory = newsStoryList.get(i);
				if (newsStory instanceof NewspaperStory) {
					newsStories.add(newsStory);
				}
			}
		}
		// If the user asked for just TV news stories, just add those.
		else if (mediaType.equals("t")) {
			for (int i = 0; i < newsStoryList.size(); i++) {
				NewsStory newsStory = newsStoryList.get(i);
				if (newsStory instanceof TVNewsStory) {
					newsStories.add(newsStory);
				}
			}
		}
		//If the user asked for just online news stories, just add those.
		else if (mediaType.equals("o")) {
			for (int i = 0; i < newsStoryList.size(); i++) {
				NewsStory newsStory = newsStoryList.get(i);
				if (newsStory instanceof OnlineNewsStory) {
					newsStories.add(newsStory);
				}
			}
		}
		//If the user asks for both newspaper and TV news stories, add those
		else if (mediaType.equals("nt") || mediaType.equals("tn")) {
			for (int i = 0; i < newsStoryList.size(); i++) {
				NewsStory newsStory = newsStoryList.get(i);
				if (newsStory instanceof TVNewsStory || newsStory instanceof NewspaperStory) {
					newsStories.add(newsStory);
				}
			}
		}
		//If the user asks for both newspaper and online news stories, add those
		else if (mediaType.equals("no") || mediaType.equals("on")) {
			for (int i = 0; i < newsStoryList.size(); i++) {
				NewsStory newsStory = newsStoryList.get(i);
				if (newsStory instanceof TVNewsStory || newsStory instanceof OnlineNewsStory) {
					newsStories.add(newsStory);
				}
			}
		}
		//If the user asks for both tv  and online news stories, add those
		else if (mediaType.equals("to") || mediaType.equals("ot")) {
			for (int i = 0; i < newsStoryList.size(); i++) {
				NewsStory newsStory = newsStoryList.get(i);
				if (newsStory instanceof TVNewsStory || newsStory instanceof OnlineNewsStory) {
					newsStories.add(newsStory);
				}
			}
		}
		// Otherwise, add them all.
		else {
			for (int i = 0; i < newsStoryList.size(); i++) {
				newsStories.add(newsStoryList.get(i));
			}
		}

		// Sort the list based on the user's sort criteria
		// Start with quaternary sort criterion and work to primary
		for (int i = 3; i >= 0; i--) {
			if (sortCriteria[i].equals("t")) {
				Collections.sort(newsStories);
			}
			else if (sortCriteria[i].equals("l")) {
				Collections.sort(newsStories, LengthComparator.LENGTH_COMPARATOR);
			}
			else if(sortCriteria[i].equals("s")){
				Collections.sort(newsStories, SourceComparator.SOURCE_COMPARATOR);
			}
			else{
				Collections.sort(newsStories, DateComparator.DATE_COMPARATOR);
			}
		}

		// Cycle through the stories one at a time
		for (NewsStory newsStory : newsStories) {

			// Add any new source name encountered to the set of names
			// Since sets exclude duplicates, we don't need to check
			distinctNewsSourceNames.add(newsStory.getSource());

			// Add any new topic encountered to the set of topics
			// Since sets exclude duplicates, we don't need to check
			distinctTopics.add(newsStory.getTopic());
			
			// Add any new subject name encountered to the set of subjects
			// Since sets exclude duplicates, we don't need to check
			distinctSubjects.add(newsStory.getSubject());

			// Add to the running total for length
			// If the type is TV news, use seconds (from length)
			if (mediaType.equals("t")) {
				totalLength += newsStory.getLength();
			}
			// If the type is newspaper or online, use words
			// If the type is mixed, use words as common unit
			else {
				totalLength += newsStory.getLengthInWords();
			}

			// Convert the story to the display format and add it to the end of
			// the list
			listOfStories += convertToOutputFormat(newsStory, mediaType) + "\n";
		}

		// Construct the summary line
		// If the type is newspaper or online, use words
		if (mediaType.equals("n") || mediaType.equals("o")) {
			listOfStories += "Number of Stories: " + newsStories.size() + "; Number of Sources: "
					+ distinctNewsSourceNames.size() + "; Number of Words: " + totalLength + "; Number of Topics: "
					+ distinctTopics.size() + "; Number of Subjects: " + distinctSubjects.size();
		}
		// If the type is TV news, use seconds (from length)
		else if (mediaType.equals("t")) {
			listOfStories += "Number of Stories: " + newsStories.size() + "; Number of Sources: "
					+ distinctNewsSourceNames.size() + "; Seconds: " + totalLength + "; Number of Topics: "
					+ distinctTopics.size() + "; Number of Subjects: " + distinctSubjects.size();
		}
		// If the type is mixed, use words as common unit
		else {
			listOfStories += "Number of Stories: " + newsStories.size() + "; Number of Sources: "
					+ distinctNewsSourceNames.size() + "; Number of Word Equivalents: " + totalLength
					+ "; Number of Topics: " + distinctTopics.size() + "; Number of Subjects: " + distinctSubjects.size();
		}
		return listOfStories;
	}

	/**
	 * This method converts an individual story to the desired display format.
	 * <P>
	 * The returned line will have a slightly different format depending on
	 * media type specified.
	 * </P>
	 * <dl>
	 * <dt>Newspapers:</dt>
	 * <dd><i>date</i>; <i>source</i>; <i>number</i> words; <i>topic</i></dd>
	 * <dt>TV News:</dt>
	 * <dd><i>date</i>; <i>source</i>; <i>number</i> seconds; <i>topic</i></dd>
	 * <dt>Both:</dt>
	 * <dd><i>date</i>; <i>source</i>; <i>number</i> word equivalents;
	 * <i>topic</i></dd>
	 * </dl>
	 * 
	 * @param newsStory
	 *            The story to convert to the display format.
	 * @param mediaType
	 *            The type of media (newspaper, TV news, or both, given as n, t,
	 *            or b) that will be included in the list.
	 * @return The story in the display format.
	 */
	private static String convertToOutputFormat(NewsStory newsStory, String mediaType) {
		String storyString = "";
		LocalDate date = newsStory.getDate();
		if(mediaType.length() == 1){
			// If the type is newspaper, use words
			if (mediaType.equals("n")) {
				storyString += date.getMonth().getDisplayName(TextStyle.FULL, Locale.US) + " " + date.getDayOfMonth() + ", "
						+ date.getYear() + "; " + newsStory.getSource() + "; " + newsStory.getLength() + " words; "
						+ newsStory.getTopic() + newsStory.getSubject();
			}
			// If the type is TV news, use seconds (from length)
			else if (mediaType.equals("t")) {
				String partOfDayString = "";
				if(newsStory instanceof TVNewsStory){
					TVNewsStory tvNewsStory = (TVNewsStory)newsStory;
					partOfDayString = tvNewsStory.getPartOfDay().toString();
					storyString += date.getMonth().getDisplayName(TextStyle.FULL, Locale.US) + " " + date.getDayOfMonth()
						+ ", "+ date.getYear() + "; " + newsStory.getSource() + "; " + newsStory.getLength() +
						" seconds; " + newsStory.getTopic() + newsStory.getSubject()+ partOfDayString;
				}
				else{
					storyString += date.getMonth().getDisplayName(TextStyle.FULL, Locale.US) + " " + date.getDayOfMonth() + ", "
						+ date.getYear() + "; " + newsStory.getSource() + "; " + newsStory.getLength() + " seconds; "
						+ newsStory.getTopic() + newsStory.getSubject();
				}
			}
			//If the type is online news, use words
			else if(mediaType.equals("o")){
				String partOfDayString = "";
				if(newsStory instanceof OnlineNewsStory){
					OnlineNewsStory onlineNewsStory = (OnlineNewsStory)newsStory;
					partOfDayString = onlineNewsStory.getPartOfDay().toString();
					storyString += date.getMonth().getDisplayName(TextStyle.FULL, Locale.US) + " " + date.getDayOfMonth()
						+ ", "+ date.getYear() + "; " + newsStory.getSource() + "; " + newsStory.getLength() +
						" seconds; " + newsStory.getTopic() + newsStory.getSubject()+ partOfDayString;
				}
				else{
					storyString += date.getMonth().getDisplayName(TextStyle.FULL, Locale.US) + " " + date.getDayOfMonth() + ", "
						+ date.getYear() + "; " + newsStory.getSource() + "; " + newsStory.getLength() + " seconds; "
						+ newsStory.getTopic() + newsStory.getSubject();
				}
			}
			// If the type is mixed, use words as common unit
			else {
				String partOfDayString = "";
				if(newsStory instanceof OnlineNewsStory){
					OnlineNewsStory onlineNewsStory = (OnlineNewsStory)newsStory;
					partOfDayString = onlineNewsStory.getPartOfDay().toString();
					storyString += date.getMonth().getDisplayName(TextStyle.FULL, Locale.US) + " " + date.getDayOfMonth() 
							+ ", " + date.getYear() + "; " + newsStory.getSource() + "; " + newsStory.getLength() + " seconds; "
							+ newsStory.getTopic() + newsStory.getSubject() + partOfDayString;
				}
				else if(newsStory instanceof TVNewsStory){
					TVNewsStory tvNewsStory = (TVNewsStory)newsStory;
					partOfDayString = tvNewsStory.getPartOfDay().toString();
					storyString += date.getMonth().getDisplayName(TextStyle.FULL, Locale.US) + " " + date.getDayOfMonth() 
							+ ", " + date.getYear() + "; " + newsStory.getSource() + "; " + newsStory.getLength() + " seconds; "
							+ newsStory.getTopic() + newsStory.getSubject() + partOfDayString;
				}
				else{
					storyString += date.getMonth().getDisplayName(TextStyle.FULL, Locale.US) + " " + date.getDayOfMonth() + ", "
							+ date.getYear() + "; " + newsStory.getSource() + "; " + newsStory.getLength() + " seconds; "
							+ newsStory.getTopic() + newsStory.getSubject();
				}
			}
		}
		
		//Works if the user gives 2 or 3 media types
		else{
			if (mediaType.contains("n") && mediaType.contains("t") && mediaType.contains("o")) {
				storyString += date.getMonth().getDisplayName(TextStyle.FULL, Locale.US) + " " + date.getDayOfMonth() + ", "
					+ date.getYear() + "; " + newsStory.getSource() + "; " + newsStory.getLength() + " words; "
					+ newsStory.getTopic() + newsStory.getSubject();
			}
			if (mediaType.contains("n") && mediaType.contains("t")) {
				storyString += date.getMonth().getDisplayName(TextStyle.FULL, Locale.US) + " " + date.getDayOfMonth() + ", "
					+ date.getYear() + "; " + newsStory.getSource() + "; " + newsStory.getLength() + " words; "
					+ newsStory.getTopic() + newsStory.getSubject();
			}
			if (mediaType.contains("n") && mediaType.contains("o")) {
				storyString += date.getMonth().getDisplayName(TextStyle.FULL, Locale.US) + " " + date.getDayOfMonth() + ", "
					+ date.getYear() + "; " + newsStory.getSource() + "; " + newsStory.getLength() + " words; "
					+ newsStory.getTopic() + newsStory.getSubject();
			}
			if (mediaType.contains("t") && mediaType.contains("o")) {
				
				PartOfDay partOfDay = null;
				storyString += date.getMonth().getDisplayName(TextStyle.FULL, Locale.US) + " " + date.getDayOfMonth() + ", "
					+ date.getYear() + "; " + newsStory.getSource() + "; " + newsStory.getLength() + " words; "
					+ newsStory.getTopic() + newsStory.getSubject() + partOfDay;
			}
		}
		
		return storyString;
	}

	/**
	 * This method displays the list of news stories to the user at the console.
	 * 
	 * @param listOfStories
	 *            The list of stories to display, all as one (potentially very
	 *            large) String.
	 * @param newsMakerName
	 *            The name of the news maker (which is put into the title of the
	 *            JOptionPane).
	 */
	public static void presentNewspaperStories(String listOfStories, String newsMakerName) {
		System.out.println("News stories for " + newsMakerName);
		System.out.println(listOfStories);
	}

	/**
	 * This method reports at the console that there were no relevant stories
	 * found.
	 * <P>
	 * "There are no relevant stories about <i>news maker</i> in this database."
	 * </P>
	 * 
	 * @param queriedNewsMaker
	 *            The news maker the user searched for.
	 */
	public static void reportNewsmakerNotFound(NewsMaker queriedNewsMaker) {
		System.out.println("There are no relevant stories about " + queriedNewsMaker.getName() + " in this database.");
	}
	
	public static void displayPieChartForNewsMaker(NewsMaker newsMaker, String mediaType, 
			String content, String measure){
		
	}

}
