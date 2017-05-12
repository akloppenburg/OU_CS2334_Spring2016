package Nooz;
//TODO add javadoc

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class NoozFileProcessor {
	
	//List of Newsmakers to read from
	private static NewsMakerList newsMakers = new NewsMakerList();
	
	//Reads in a file and converts CSV values to newsmaker objects, then adds them to a list
	public static NewsMakerList readNoozFile(String filename){
		
		//Various try catch statements catch errors if the filename is wrong or if it cannor be read
		FileReader fr = null;
		try {
			fr = new FileReader(filename);
		} 
		catch (FileNotFoundException e) {
			System.err.println("Usage error. File not found (" + filename + ").");
			System.exit(1);
		}
		BufferedReader br = new BufferedReader(fr);
		
		String nextLine = null;
		try {
			br.readLine();
			nextLine = br.readLine();
		} 
		catch (IOException e) {
			System.err.println("IO Exception while reading " + filename + ".");
			System.exit(1);
		}
		while (nextLine != null) {
			processLine(nextLine);
			try {
				nextLine = br.readLine();
			} 
			catch (IOException e) {
				System.err.println("IO Exception while reading " + filename + ".");
				System.exit(1);
			}
		}
		try {
			br.close();
		} 
		catch (IOException e) {
			System.err.println("IO Exception while closing " + filename + ".");
			System.exit(1);
		}

		return newsMakers;
		
	}
	
	private static void processLine(String line){
		
		//Splits line into an array, first by quotes and then by commas
		String[] parts = line.split(",");
		String[] finalParts = new String[6];
		
		//Returns a different string array based on the number of "99"s present in the data
		if(parts.length == 8){
			parts[4] = parts[4].substring(1, parts[4].length());
			parts[5] = parts[5].substring(0, parts[5].length() - 1);
			
			parts[6] = parts[6].substring(1, parts[6].length());
			parts[7] = parts[7].substring(0, parts[7].length() - 1);
			finalParts[0] = parts[0];
			finalParts[1] = parts[1];
			finalParts[2] = parts[2];
			finalParts[3] = parts[3];
			finalParts[4] = parts[4] + "," + parts[5]; 
			finalParts[5] = parts[6] + "," + parts[7];
		}
		else if(parts.length == 7){
			parts[5] = parts[5].substring(1, parts[5].length());
			parts[6] = parts[6].substring(0, parts[6].length() - 1);
			
			finalParts[0] = parts[0];
			finalParts[1] = parts[1];
			finalParts[2] = parts[2];
			finalParts[3] = parts[3];
			finalParts[4] = parts[4]; 
			finalParts[5] = parts[5] + "," + parts[6];
		}
		else{
			finalParts[0] = parts[0];
			finalParts[1] = parts[1];
			finalParts[2] = parts[2];
			finalParts[3] = parts[3];
			finalParts[4] = parts[4]; 
			finalParts[5] = parts[5];
		}
		
		//Checks usability of the year
		int year = 0;
		try {
			year = Integer.parseInt(parts[0]);
		} 
		catch (NumberFormatException e) {
			System.err.println("Error in input file. Year is not a number.");
			return;
		}
		
		//Empty objects to be filled in during the next if statement 
		NewsMaker newsMaker1 = new NewsMaker();
		NewsMaker newsMaker2 = new NewsMaker();
		NewspaperStory story = null;
		//Runs program, creating newspaperstory objects for each story
		try{
			if (finalParts.length == 6) {
				
				newsMaker1 = new NewsMaker(decodeNewsmakerName(finalParts, 4));
				newsMaker2 = new NewsMaker(decodeNewsmakerName(finalParts, 5));
					
				story = new NewspaperStory(decodeDate(finalParts[0]), decodeNewspaper(finalParts[1]), 
					decodeWordCount(finalParts[2]), decodeTopic(finalParts[3]), newsMaker1, newsMaker2);
			} 
			//Checks length
			else{
				System.err.println("Error in input file. Line either too long or too short.");
			}
		}
		catch(NullPointerException n){
			System.err.println("error");
		}
		
		//Once all appropriate variables are made, the program checks the list of newsmakers and then adds stories to 
		//the relevant newsmaker
		try{
			if(!(newsMakers.contains(newsMaker1))){
				newsMakers.add(newsMaker1);
				newsMakers.get(newsMaker1).addNewspaperStory(story);
			}
			else{
				newsMakers.get(newsMaker1).addNewspaperStory(story);
			}
			
			if(!(newsMakers.contains(newsMaker2))){
				newsMakers.add(newsMaker2);
				newsMakers.get(newsMaker2).addNewspaperStory(story);
			}
			else{
				newsMakers.get(newsMaker2).addNewspaperStory(story);
			}
		}
		catch(NullPointerException n){
			System.err.println("error");
		}
	}
	
	//Changes date format to LocalDate
	private static LocalDate decodeDate(String dateString){
		
		int year = Integer.parseInt(dateString.substring(0, 4));
		int month = Integer.parseInt(dateString.substring(4, 6));
		int day = Integer.parseInt(dateString.substring(6, 8));
		
		LocalDate date = LocalDate.of(year, month, day);
		
		return date;
	}
	
	//Changes date format to string
	public static String decodeNewspaper(String newspaperCode){
		
		String newspaperName = "";
		switch(newspaperCode){
			case "1": newspaperName = "New York Times";
					break;
			case "2": newspaperName = "Washington Post";
					break;
			case "3": newspaperName = "Wall Street Journal";
					break;
			case "4": newspaperName = "USA Today";
					break;
			case "13": newspaperName = "Los Angeles Times";
					break;
			case "117": newspaperName = "Denver Post";
					break;
			case "118": newspaperName = "Houston Chronicle";
					break;
			case "119": newspaperName = "Orlando Sentinel";
					break;
			case "120": newspaperName = "Traverse City Record";
					break;
			case "121": newspaperName = "Daily Herald (Everett, WA)";
					break;
			case "122": newspaperName = "Eagle Tribune (MA)";
					break;
		}
		
		return newspaperName;
	}
	
	//Changes wordcount format to int
	public static int decodeWordCount(String wordCountString){
		
		int wordCount = Integer.parseInt(wordCountString);
		return wordCount;
		
	}
	
	//Changes topic from a code to a topic
	public static String decodeTopic(String topicCode){
		String topic = "";
		
		switch(topicCode){
			case "1": topic = "Government Agencies/Legislatures";
					break;
			case "2": topic = "Campaigns/Elections/Politics";
					break;
			case "3": topic = "Defense/Military (Domestic)";
					break;
			case "4": topic = "Court/Legal System";
					break;
			case "5": topic = "Crime";
					break;
			case "6": topic = "Domestic Terrorism";
					break;
			case "7": topic = "Business";
					break;
			case "8": topic = "Economy/Economics";
					break;
			case "9": topic = "Environment";
					break;
			case "10": topic = "Development/Sprawl";
					break;
			case "11": topic = "Transportation";
					break;
			case "12": topic = "Education";
					break;
			case "13": topic = "Religion";
					break;
			case "14": topic = "Health/Medicine";
					break;
			case "15": topic = "Science and Technology";
					break;
			case "16": topic = "Race/Gender/Gay Issues";
					break;
			case "17": topic = "Immigration";
					break;
			case "18": topic = "Additional Domestic Affairs";
					break;
			case "19": topic = "Disasters/Accidents";
					break;
			case "20": topic = "Celebrity/Entertainment";
					break;
			case "21": topic = "Lifestyle";
					break;
			case "22": topic = "Sports";
					break;
			case "23": topic = "Media";
					break;
			case "24": topic = "U.S. Miscellaneous";
					break;
			case "25": topic = "U.S. Foreign Affairs";
					break;
			case "26": topic = "Foreign (non-U.S.)";
					break;
		}
		
		return topic;
	}
	
	//Deals with newspaper names, creating different names based on whether or not they are empty
	public static String decodeNewsmakerName(String[] parts, int startingIndex){
		
		String newsMakerName;
		
		if(parts[4] == "99" && parts[5] == "99"){
			newsMakerName = "None";
		}
		else if(parts[4] == "99" || parts[5] == "99"){
			newsMakerName = "";
		}
		else{
			newsMakerName = parts[startingIndex];
		}
		
		return newsMakerName;
	}
	
}
