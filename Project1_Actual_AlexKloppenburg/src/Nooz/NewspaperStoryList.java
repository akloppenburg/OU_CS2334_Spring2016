package Nooz;

import java.util.ArrayList;

public class NewspaperStoryList {
	
	//A list of newspaperstory objects
	private ArrayList<NewspaperStory> newspaperStories = new ArrayList<NewspaperStory>();
	
	//Adds a newspaperstory to the list
	public void add(NewspaperStory newspaperStory){
		this.newspaperStories.add(newspaperStory);
	}
	
	//Returns the size of the list
	public int size(){
		return this.newspaperStories.size();
	}
	
	//Gets a newspaperstory from the list
	public NewspaperStory get(int index){
		return newspaperStories.get(index);
	}
	
}
