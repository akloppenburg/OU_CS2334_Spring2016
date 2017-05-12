import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Map;

/**
 * Project 2, CS 2334, Section 010, February 22, 2017
 * <P>
 * This class provides helper methods to read a Nooz-style data file and turn it
 * into <code>NewsStory</code> and <code>NewsMaker</code> objects.
 * </P>
 * <P>
 * Note that the field <code>newsMakers</code> and all methods in this class are
 * static because we don't need to make several <code>NoozFileProcessor</code>
 * objects and have them maintain their own lists of news makers. Instead, we
 * simply need a collection of useful methods to create a list and return it to
 * the calling method that will keep track of it.
 * </P>
 * 
 * @author Dean Hougen
 * @version 2.0
 * 
 */
class NoozFileProcessor {
	/** The list of news makers. */
	private static NewsMakerList newsMakers = new NewsMakerList();

	/**
	 * The primary method for reading the Nooz-style data file.
	 * <P>
	 * It opens the file, reads through it line by line until it reaches the
	 * end, and closes the file. Each line is passed to <code>processLine</code>
	 * to parse and turn into data that is actually added to the list.
	 * </P>
	 * <P>
	 * Note that this program doesn't attempt to deal with I/O errors. This is
	 * allowable at this point to keep this project relatively simple and
	 * because we haven't covered this topic yet. However, this is something to
	 * be refined in the future.
	 * </P>
	 * 
	 * @param fileName
	 *            The name of the Nooz style data file to read.
	 * @return The list of news makers created.
	 * @throws IOException
	 *             If there is an I/O problem reading the data file.
	 */
	public static NewsMakerList readNoozFile(String fileName, Map<String, String> sourceMap, 
			Map<String, String> topicMap, Map<String, String> subjectMap) throws IOException {
		// TODO Handle possible I/O errors (Eventually)
		FileReader fr = new FileReader(fileName);
		BufferedReader br = new BufferedReader(fr);
		String nextLine = br.readLine(); // First line is header info. Ignore.
		nextLine = br.readLine();
		while (nextLine != null) {
			processLine(nextLine, sourceMap, topicMap, subjectMap);
			nextLine = br.readLine();
		}
		br.close();

		return newsMakers;
	}

	/**
	 * This method takes an already formatted list of news stories as a string
	 * and writes it to a file with the given file name.
	 * <P>
	 * Note that this program doesn't attempt to deal with I/O errors. This is
	 * allowable at this point to keep this project relatively simple and
	 * because we haven't covered this topic yet. However, this is something to
	 * be refined in the future.
	 * </P>
	 * 
	 * @param outputFileName
	 *            The name of the file to which to write the story list.
	 * @param listOfStories
	 *            The list of stories to write to the file (already formatted
	 *            for output).
	 * @throws IOException
	 *             If there is an I/O problem writing the data file.
	 */
	public static void writeNewsStoriesFile(String fileName, String listOfStories) throws IOException {
		FileWriter outfile = new FileWriter(fileName);
		BufferedWriter bw = new BufferedWriter(outfile);
		bw.write(listOfStories);
		bw.newLine();
		bw.close();
	}

	/**
	 * The method for turning each line from a Nooz-style file into data and
	 * saving that data.
	 * <P>
	 * This method breaks the line into parts, passes the parts to appropriate
	 * helper methods that decode them and return data of appropriate types for
	 * the components of news stories and news makers, puts these components
	 * together into a news story of the proper type (newspaper story or TV news
	 * story) and two news makers, and adds these to lists of news stories and
	 * news makers, respectively.
	 * </P>
	 * 
	 * @param line
	 *            The line to process.
	 */
	private static void processLine(String line, Map<String, String> sourceMap, Map<String, String> topicMap, 
			Map<String, String> subjectMap) {
		/* The parts the line created by splitting the line at each comma. */
		String[] parts = line.split(",");

		/* The local date from part zero of the line. */
		LocalDate date = decodeDate(parts[0]);

		/* The source from part one of the line. */
		String sourceCode = parts[1];
		String source = sourceMap.get(sourceCode);

		/* The word count from part two of the line. */
		int wordCount = decodeLength(parts[2]);

		/* The topic from part three of the line. */
		String topic = topicMap.get(parts[3]);
		
		/**/
		String subject = subjectMap.get(parts[4]);

		/*
		 * The first news maker name, which might come from just part four or
		 * from parts four and five, depending on whether it contains a comma.
		 */
		String newsMakerName1 = decodeNewsmakerName(parts, 5);

		/*
		 * The second news maker name, which might start with part five or part
		 * six, depending on the first news maker name.
		 */
		String newsMakerName2;
		if (newsMakerName1.contains(",")) {
			newsMakerName2 = decodeNewsmakerName(parts, 7);
		} else {
			newsMakerName2 = decodeNewsmakerName(parts, 6);
		}
		
		/*
		 * The first news maker is constructed based on the first news maker
		 * name read.
		 */
		NewsMaker newsMaker1 = new NewsMaker(newsMakerName1);
		// If the news maker is on the list, use the copy already on the list
		if (newsMakers.contains(newsMaker1)) {
			newsMaker1 = newsMakers.get(newsMaker1);
		}
		// Otherwise, add the new news maker to the list
		else {
			newsMakers.add(newsMaker1);
		}

		/*
		 * The second news maker is constructed based on the second news maker
		 * name read.
		 */
		NewsMaker newsMaker2 = new NewsMaker(newsMakerName2);
		// If the news maker is on the list, use the copy already on the list
		if (newsMakers.contains(newsMaker2)) {
			newsMaker2 = newsMakers.get(newsMaker2);
		}
		// Otherwise, add the new news maker to the list
		else {
			newsMakers.add(newsMaker2);
		}
		
		int sourceNum = 0;
		try {
			sourceNum = Integer.parseInt(sourceCode);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("Non-integer as source code: " + sourceCode);
		}
		PartOfDay partOfDay = null;
		//Lastly, decode partOfDay if there is one
		if(sourceNum >= 200){
			partOfDay = decodePartOfDay(parts[parts.length - 1]);
		}

		/*
		 * The news story, which is constructed from the relevant data.
		 */

		NewsStory newsStory = null;
		if (sourceNum < 200) {
			newsStory = new NewspaperStory(date, source, wordCount, topic, subject, newsMaker1, newsMaker2);
		}
		// Only two possibilities at this time
		else if (sourceNum >= 200 && sourceNum <= 222){
			newsStory = new OnlineNewsStory(date, source, wordCount, topic, subject, partOfDay, newsMaker1, newsMaker2);
		}
		else{
			newsStory = new TVNewsStory(date, source, wordCount, topic, subject,partOfDay, newsMaker1, newsMaker2);
		}

		// The news story is added to each news maker
		newsMaker1.addNewsStory(newsStory);
		newsMaker2.addNewsStory(newsStory);
	}

	/**
	 * This method decodes the date, which is encoded in the file as YYYYMMDD.
	 * <P>
	 * This method catches <code>NumberFormatExceptions</code> and deals with
	 * them locally by printing messages to the error stream. In later
	 * assignments, we'll cover better alternatives for handling exceptions.
	 * </P>
	 * 
	 * @param dateString
	 *            The encoded date.
	 * @return The decoded date or <code>null</code> if the date cannot be
	 *         decoded.
	 */
	private static LocalDate decodeDate(String dateString) {

		/* The year portion of the date string. */
		String yearString = dateString.substring(0, 4);

		/* The month portion of the date string. */
		String monthString = dateString.substring(4, 6);

		/* The day portion of the date string. */
		String dayOfMonthString = dateString.substring(6, 8);

		/* The year as an integer (hopefully). */
		int year = 0;
		try {
			year = Integer.parseInt(yearString);
		} catch (NumberFormatException e) {
			System.err.println("Wrong argument provided. Argument (" + year + ") is not an integer.");
			return null;
		}

		/* The month as an integer (hopefully). */
		int month = 0;
		try {
			month = Integer.parseInt(monthString);
		} catch (NumberFormatException e) {
			System.err.println("Wrong argument provided. Argument (" + month + ") is not an integer.");
			return null;
		}

		/* The month as an integer (hopefully). */
		int dayOfMonth = 0;
		try {
			dayOfMonth = Integer.parseInt(dayOfMonthString);
		} catch (NumberFormatException e) {
			System.err.println("Wrong argument provided. Argument (" + dayOfMonth + ") is not an integer.");
			return null;
		}

		/*
		 * The date constructed from the year, month, and dayOfMonth integers.
		 */
		LocalDate date = LocalDate.of(year, month, dayOfMonth);
		return date;
	}

	/**
	 * This method decodes the source name, which is represented by a numeral in
	 * the data file.
	 * <P>
	 * Note that hard-coding the names is generally bad practice. It would be
	 * better to keep the mapping from numeral to source name in a separate file
	 * that could be read and used at runtime, so that the list of numerals and
	 * corresponding names could be updated without modifying the code. However,
	 * to keep this project relatively simple, we went with this "quick and
	 * dirty" approach.
	 * </P>
	 * 
	 * @param sourceCode
	 *            The numeral specifying the news source.
	 * @return The name of the news source.
	 */
	/*private static String decodeSource(String sourceCode) {
		String sourceName = null;

		switch (sourceCode) {
		case "1":
			sourceName = "New York Times";
			break;
		case "2":
			sourceName = "Washington Post";
			break;
		case "3":
			sourceName = "Wall Street Journal";
			break;
		case "4":
			sourceName = "USA Today";
			break;
		case "13":
			sourceName = "Los Angeles Times";
			break;
		case "117":
			sourceName = "Denver Post";
			break;
		case "118":
			sourceName = "Houston Chronicle";
			break;
		case "119":
			sourceName = "Orlando Sentinel";
			break;
		case "120":
			sourceName = "Traverse City Record";
			break;
		case "121":
			sourceName = "Daily Herald (Everett, WA)";
			break;
		case "122":
			sourceName = "Eagle Tribune (MA)";
			break;
		case "401":
			sourceName = "ABC Good Morning America";
			break;
		case "402":
			sourceName = "ABC World News Tonight";
			break;
		case "421":
			sourceName = "NBC Today";
			break;
		case "422":
			sourceName = "NBC Nightly News";
			break;
		case "441":
			sourceName = "CBS The Early Show";
			break;
		case "442":
			sourceName = "CBS Evening News";
			break;
		case "461":
			sourceName = "PBS NewsHour, 1st half hour";
			break;
		case "462":
			sourceName = "PBS NewsHour, 2nd half hour";
			break;
		case "500":
			sourceName = "CNN unspecified show";
			break;
		case "501":
			sourceName = "CNN Daytime";
			break;
		case "502":
			sourceName = "CNN Situation Room";
			break;
		case "504":
			sourceName = "CNN Anderson Cooper 360";
			break;
		case "511":
			sourceName = "CNN John King, USA";
			break;
		case "514":
			sourceName = "CNN Erin Burnett Outfront";
			break;
		case "520":
			sourceName = "MSNBC unspecified show";
			break;
		case "521":
			sourceName = "MSNBC Daytime";
			break;
		case "522":
			sourceName = "MSNBC Hardball with Chris Matthews";
			break;
		case "528":
			sourceName = "MSNBC Rachel Maddow Show";
			break;
		case "530":
			sourceName = "MSNBC The Ed Show";
			break;
		case "532":
			sourceName = "MSNBC PoliticsNation";
			break;
		case "540":
			sourceName = "Fox News unspecified show";
			break;
		case "541":
			sourceName = "Fox News Daytime";
			break;
		case "543":
			sourceName = "Fox News O'Reilly Factor";
			break;
		case "545":
			sourceName = "Fox News Fox Report with Shepard Smith";
			break;
		case "547":
			sourceName = "Fox News Hannity";
			break;
		case "548":
			sourceName = "Fox News Special Report with Bret Baier";
			break;
		default:
			throw new IllegalArgumentException("Invalid news source code: " + sourceCode);
		}

		return sourceName;
	}*/

	/**
	 * This method decodes the length, which is encoded in the file as numeral
	 * string.
	 * <P>
	 * This method catches <code>NumberFormatExceptions</code> and deals with
	 * them locally by printing messages to the error stream. In later
	 * assignments, we'll cover better alternatives for handling exceptions.
	 * </P>
	 * 
	 * @param lengthString
	 *            The length as a String.
	 * @return The length as an int.
	 */
	private static int decodeLength(String lengthString) {
		int length = 0;

		try {
			length = Integer.parseInt(lengthString);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("Non-integer as length: " + lengthString);
		}

		return length;
	}

	/**
	 * This method decodes the news story topic, which is represented by a
	 * numeral in the data file.
	 * <P>
	 * Note that hard-coding the topics is generally bad practice. It would be
	 * better to keep the mapping from numeral to topic in a separate file that
	 * could be read and used at runtime, so that the list of numerals and
	 * corresponding topics could be updated without modifying the code.
	 * However, to keep this project relatively simple, we went with this "quick
	 * and dirty" approach.
	 * </P>
	 * 
	 * @param topicCode
	 *            The numeral specifying the topic.
	 * @return The topic written out as a String.
	 */
	/*private static String decodeTopic(String topicCode) {
		String topic = null;

		switch (topicCode) {
		case "1":
			topic = "Government Agencies/Legislatures";
			break;
		case "2":
			topic = "Campaigns/Elections/Politics";
			break;
		case "3":
			topic = "Defense/Military (Domestic)";
			break;
		case "4":
			topic = "Court/Legal System";
			break;
		case "5":
			topic = "Crime";
			break;
		case "6":
			topic = "Domestic Terrorism";
			break;
		case "7":
			topic = "Business";
			break;
		case "8":
			topic = "Economy/Economics";
			break;
		case "9":
			topic = "Environment";
			break;
		case "10":
			topic = "Development/Sprawl";
			break;
		case "11":
			topic = "Transportation";
			break;
		case "12":
			topic = "Education";
			break;
		case "13":
			topic = "Religion";
			break;
		case "14":
			topic = "Health/Medicine";
			break;
		case "15":
			topic = "Science and Technology";
			break;
		case "16":
			topic = "Race/Gender/Gay Issues";
			break;
		case "17":
			topic = "Immigration";
			break;
		case "18":
			topic = "Additional Domestic Affairs";
			break;
		case "19":
			topic = "Disasters/Accidents";
			break;
		case "20":
			topic = "Celebrity/Entertainment";
			break;
		case "21":
			topic = "Lifestyle";
			break;
		case "22":
			topic = "Sports";
			break;
		case "23":
			topic = "Media";
			break;
		case "24":
			topic = "U.S. Miscellaneous";
			break;
		case "25":
			topic = "U.S. Foreign Affairs";
			break;
		case "26":
			topic = "Foreign (non-U.S.)";
			break;
		default:
			throw new IllegalArgumentException("Invalid topic code: " + topicCode);
		}

		return topic;
	}*/

	/**
	 * This method decodes a news maker name from one or more the parts of the
	 * input line.
	 * <P>
	 * Note that there are three distinctly different cases that need to be
	 * dealt with by this method.
	 * </P>
	 * <ul>
	 * <li>First, the special code "99" in the file corresponds to the case when
	 * the story is not primarily focused on two named news makers. In these
	 * cases, the code "99" may be used for one or both of the news maker
	 * fields. We decode this as a news maker with the name "None" and allow the
	 * user to explicitly or implicitly search for this news maker.</li>
	 * <li>Second, there may be a news maker with a quoted name containing no
	 * commas. ("Obama Administration" is one example.) In this case, the line
	 * parsed on commas will include this news maker name in a single line
	 * part.</li>
	 * <li>Third, there may be a news maker with a quoted name containing one
	 * comma. ("Romney, Mitt" is one example.) In this case, the line parsed on
	 * commas will include this news maker name in two line parts. These parts
	 * must be put together to create the news maker name.</li>
	 * </ul>
	 * 
	 * @param parts
	 *            The array of all of the parts of the line, which was separated
	 *            based on commas.
	 * @param startingIndex
	 *            The starting index for the news maker name to decode. This can
	 *            vary for the second news maker based on whether the first news
	 *            maker name contained a comma.
	 * @return The decoded news maker name.
	 */
	private static String decodeNewsmakerName(String[] parts, int startingIndex) {
		String nameString = "";

		// Check for special code 99
		if ("99".equals(parts[startingIndex])) {
			nameString = "None";
		}
		// If the starting part of the name ends with a quotation mark, then the
		// name takes up only one part
		else if (parts[startingIndex].endsWith("\"")) {
			nameString = parts[startingIndex].replaceAll("\"", "");
		}
		// The other option is that the name takes up two parts, which must be
		// put together.
		else {
			nameString = (parts[startingIndex] + "," + parts[startingIndex + 1]).replaceAll("\"", "");
		}

		return nameString;
	}
	
	public static PartOfDay decodePartOfDay(String partOfDayCode){
		
		PartOfDay[] timesOfTheDay = PartOfDay.values();
		
		int index = Integer.parseInt(partOfDayCode);
		
		return timesOfTheDay[index-1];
		
	}
}
