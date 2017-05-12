package Nooz;

import java.time.LocalDate;

public class NewspaperStory {
	
	//All data imported from the CSV table
	private LocalDate date;
	private String newspaperName;
	private int wordCount;
	private String topic;
	private NewsMaker newsMaker1;
	private NewsMaker newsMaker2;
	
	//Constructs an object containing all the relvant data imported from the CSV table
	public NewspaperStory(LocalDate date, String newspaperName, int wordCount, String topic, NewsMaker newsMaker1, 
			NewsMaker newsMaker2){
		
		this.date = date;
		this.newspaperName = newspaperName;
		this.wordCount = wordCount;
		this.topic = topic;
		this.newsMaker1 = newsMaker1;
		this.newsMaker1 = newsMaker2;
		
	}
	
	//Returns the object's date as a LocalDate object
	public LocalDate getDate(){
		return this.date;
	}
	
	//Returns the name
	public String getNewspaperName(){
		return this.newspaperName;
	}
	
	//Returns the wordcount as an int
	public int getWordCount(){
		return this.wordCount;
	}
	
	//Returns the topic as a string
	public String getTopic(){
		return this.topic;
	}
	
	//Returns the first newsmaker
	public NewsMaker getNewsMaker1(){
		return this.newsMaker1;
	}
	
	//Returns the second newsmaker
	public NewsMaker getNewsMaker2(){
		return this.newsMaker2;
	}

}
